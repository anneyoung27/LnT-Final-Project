package access;

import components.Users;
import frame.LoginForm;

import java.util.List;

public interface UsersInterface {
    public List<Users> getAll();

    public Users findByUserNameAndPassword(String userName, String password, LoginForm views);
}
