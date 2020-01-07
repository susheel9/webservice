package web.service.webservice.filter;

import org.springframework.stereotype.Component;
import web.service.webservice.model.User;
import web.service.webservice.model.UserTreadLocal;

import javax.servlet.*;
import java.io.IOException;

@Component
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User user = new User();
        user.setName("Susheel");
        UserTreadLocal.getThreadLocal().set(user);
        servletRequest.setAttribute("key", "value");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
