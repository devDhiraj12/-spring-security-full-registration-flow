package spring.security.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import spring.security.entity.User;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;
    public RegistrationCompleteEvent(User user , String applicationUrl) {
        super(user);
        this.applicationUrl = applicationUrl;
        this.user = user;
    }
}
