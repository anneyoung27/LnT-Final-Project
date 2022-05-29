package functions;

import access.UsersInterface;
import components.Users;
import database.ConnectDB;
import frame.LoginForm;
import visible.VisibleClass;

import javax.swing.*;

public class LoginFunction {
    public void login(LoginForm view){
        String userName = view.getUserNameField().getText();
        String password = String.valueOf(view.getPasswordField().getPassword());

        if(userName.equals("")){
            JOptionPane.showMessageDialog(view, "Tolong pastikan username tidak boleh kosong.");
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(view,"Tolong pastikan password tidak boleh kosong");
        }else{
            try{
                UsersInterface usersInterface = ConnectDB.getUser();
                Users user = usersInterface.findByUserNameAndPassword(userName, password, view);

                if(user == null){
                    JOptionPane.showMessageDialog(view, "Username dan Kata sandi salah!");
                    return;
                    // to start menu
                }else{
                    VisibleClass.navigateToStartMenu(view, user);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
