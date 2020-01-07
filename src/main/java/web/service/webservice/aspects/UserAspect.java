package web.service.webservice.aspects;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import web.service.webservice.annotations.AuthenticateOperateImpl;

import javax.servlet.http.HttpServletRequest;

@EnableAspectJAutoProxy
@Component
public class UserAspect {
    @Pointcut("@annotation(web.service.webservice.annotations.AuthenticateOperate)")
    private void customSecurityAnnotation() {}

        @Autowired
        AuthenticateOperateImpl authBean;

        @Before("@annotation(web.service.webservice.annotations.AuthenticateOperate) && args(request,..)")
        public  void before(HttpServletRequest request){
            if (!(request instanceof HttpServletRequest)) {
                throw
                        new RuntimeException("request should be HttpServletRequesttype");
            }

            if(authBean.authorize()) {
                request.setAttribute(
                        "userSession",
                        "session information which cannot be accessed in controller"
                );
            }else {
                throw new RuntimeException("auth error..!!!");
            }
    }
}
