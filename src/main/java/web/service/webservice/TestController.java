package web.service.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.webservice.annotations.AuthenticateOperate;
import web.service.webservice.model.UserTreadLocal;

@Controller
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @AuthenticateOperate
    @GetMapping("/display")
    public String displayMessage() {
        logger.info("Test Logging {}", UserTreadLocal.getThreadLocal().get().getName());
        return "Test Logging " + UserTreadLocal.getThreadLocal().get().getName();
        }

}
