package spring.security.service;

import spring.security.entity.User;
import spring.security.entity.VerificationToken;
import spring.security.model.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);


    void saveVerificationTokenForUser(User user, String token);

    String validateRegistrationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
