package frame;

import functions.LoginFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    LoginFunction loginFunc;
    JPanel newPanel;
    JLabel lblTitle, lblBackground, lblUserName,lblPassword;
    JTextField txtEmail;
    JPasswordField inPassword;
    JButton btnLogin;
    ImageIcon backGroundLogin;

    public LoginForm(){
        inItComponent();
        run();
    }
    public JTextField getUserNameField(){
        return txtEmail;
    }

    public JPasswordField getPasswordField(){
        return inPassword;
    }

    void inItComponent(){
        LoginForm frame = this;
        loginFunc = new LoginFunction();

        // set components
        newPanel = new JPanel();
        newPanel.setLayout(null);

//        newPanel.setBackground(new Color(255,189,189));
        // title
        lblTitle = new JLabel("Login Form");
        lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN,35));
        lblTitle.setBounds(180,3,250,60);
        newPanel.add(lblTitle);

        // user name
        lblUserName = new JLabel("Username");
        lblUserName.setFont(new Font("Comic Sans MS", Font.PLAIN,15));
        lblUserName.setBounds(120,75,90,20);
        newPanel.add(lblUserName);

        // password
        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        lblPassword.setBounds(121,125,90,20);
        newPanel.add(lblPassword);

        // txtUserName
        txtEmail = new JTextField();
        txtEmail.setBounds(250,75,200,26);
        newPanel.add(txtEmail);

        // password
        inPassword = new JPasswordField();
        inPassword.setBounds(250,125,200,26);
        newPanel.add(inPassword);

        // btn login
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Comic Sans MS",Font.PLAIN,11));
//        btnLogin.setBorder(BorderFactory.createEtchedBorder());
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFunc.login(frame);
            }
        });
        btnLogin.setBounds(225,160,80,20);
        newPanel.add(btnLogin);

//        newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Login Form",
//                2,2,new Font("Curlz MT", Font.PLAIN,35)));

        backGroundLogin = new ImageIcon("pudding.jpg");
        lblBackground = new JLabel(backGroundLogin);
        lblBackground.setSize(600,270);
        newPanel.add(lblBackground);

        // add to panel

        this.add(newPanel);
    }

    void run(){
        this.setTitle("PT. Pudding Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550,270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
