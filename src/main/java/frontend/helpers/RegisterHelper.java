package frontend.helpers;

import frontend.models.User;
import io.github.cdimascio.dotenv.Dotenv;

public class RegisterHelper {

    static Dotenv dotenv = Dotenv.load();
    public static User registerWithValidCredentials(){

        // Ideally, this method should use the registration API to create a new user
        // and then use the same credentials to perform login.
        // However, since the API is not available right now, a temporary solution is used:
        // Returning static test data from environment variables instead of dynamically registering a user.

        return User.builder()
                .email(dotenv.get("EMAIL_TEST"))
                .password(dotenv.get("PASSWORD_TEST"))
                .build();
    }
}
