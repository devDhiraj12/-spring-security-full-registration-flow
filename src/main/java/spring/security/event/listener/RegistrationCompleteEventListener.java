package spring.security.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import spring.security.entity.User;
import spring.security.event.RegistrationCompleteEvent;
import spring.security.service.UserService;

import java.util.UUID;
@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
//create the verification token for the user  with link
User user = event.getUser();
String token = UUID.randomUUID().toString();
userService.saveVerificationTokenForUser(user , token);
        //send mail to user
        String url =
                event.getApplicationUrl() + "/api/verifyRegistration?token="+ token;
        //sendVerificationEmail()
        log.info("click the link to verify your account: {}",url);
    }
}
