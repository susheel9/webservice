package web.service.webservice.annotations;

import org.springframework.stereotype.Component;
import web.service.webservice.model.UserTreadLocal;

@Component
public class AuthenticateOperateImpl {
    public boolean authorize() {
        if(UserTreadLocal.getThreadLocal().get().getName().equals("Susheel")) {
            return true;
        }
        return false;
    }
}
