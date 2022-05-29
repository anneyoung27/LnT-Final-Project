package implement;

import access.UsersInterface;
import com.mysql.jdbc.JDBC4ResultSet;
import components.Users;
import frame.LoginForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserImpl implements UsersInterface {
    private Connection conn;

    //database query
    private String findByUserNameAndPassword = "SELECT * FROM users WHERE userName = ? AND userPassword = ?";

    public UserImpl(Connection connection){
        this.conn = connection;
    }

    @Override
    public List<Users> getAll() {
        return null;
    }

    // Reference : http://tutorials.jenkov.com/jdbc/resultset.html
    @Override
    public Users findByUserNameAndPassword(String userName, String password, LoginForm views) {
        PreparedStatement statement = null;
        Users user = null;

        try{
            statement = (PreparedStatement) conn.prepareStatement(findByUserNameAndPassword);
            statement.setString(1, userName);
            statement.setString(2, password);
            JDBC4ResultSet rs = (JDBC4ResultSet) statement.executeQuery();
            while(rs.next()){
                String uID = rs.getString("userID");
                String uUserName = rs.getString("userName");
                String uUserPassword = rs.getString("userPassword");
                user = new Users(uID,uUserName, uUserPassword);
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
