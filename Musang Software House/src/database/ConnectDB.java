package database;

import java.sql.SQLException;

import access.MenuInterface;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import access.UsersInterface;
import implement.MenuInterfaceImpl;
import implement.UserImpl;

public class ConnectDB {
    private static Connection con;
    private static UsersInterface users;
    private static MenuInterface menus;


    public static Connection getCon() throws SQLException {
        final String USERNAME = "root";
        final String PASSWORD = "";
        final String DATABASE = "pudding";
        final String HOST = "localhost:3306";
        final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);

        if (con == null) {
            // Reference : https://www.tabnine.com/code/java/classes/com.mysql.jdbc.jdbc2.optional.MysqlDataSource
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL(CONNECTION);
            datasource.setUser(USERNAME);
            datasource.setPassword(PASSWORD);
            con = (Connection) datasource.getConnection();
        }
        return con;
    }

    public static UsersInterface getUser() throws SQLException  {
        if (users == null) {
            users = new UserImpl(getCon());
        }
        return users;
    }

    public static MenuInterface getMenu() throws SQLException{
        if(menus == null){
            menus = new MenuInterfaceImpl(getCon());
        }
        return menus;
    }


}