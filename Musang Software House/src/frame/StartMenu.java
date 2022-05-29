package frame;

import components.Users;
import functions.InsertMenuFunction;
import visible.VisibleClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {
    JLabel labelPT;
    JButton insertNewMenu, manageMenu;
    JPanel panelFrameUpper, panelFrameCenter, pnlButtonInsertNewMenu, pnlButtonManageMenu;
    Users user;
    public StartMenu(Users user){
    this.user = user;
    initComponent();
    run();
    getContentPane().add(panelFrameUpper, BorderLayout.NORTH);
    getContentPane().add(panelFrameCenter, BorderLayout.CENTER);
    }

    void initComponent(){
        StartMenu frame = this;
        pnlButtonInsertNewMenu = new JPanel(new GridLayout(1,1));
        insertNewMenu = new JButton("Insert New Menu");
        insertNewMenu.setFont(new Font("Comic Sans MS", Font.PLAIN,24));
        insertNewMenu.setBackground(new Color(253,153,157));
        insertNewMenu.setFocusable(false);
//        insertNewMenu.setBorder(BorderFactory.createEtchedBorder());
        insertNewMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisibleClass.navigateToInsertNewMenuForm(frame);
            }
        });
        pnlButtonInsertNewMenu.add(insertNewMenu);
        pnlButtonManageMenu = new JPanel(new GridLayout(1,1));
        manageMenu = new JButton("Manage New Menu");
        manageMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        manageMenu.setBackground(new Color(253,153,157));
        manageMenu.setFocusable(false);
//        manageMenu.setBorder(BorderFactory.createEtchedBorder());
        manageMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisibleClass.navigateToManageMenuForm(frame,user);
            }
        });
        pnlButtonManageMenu.add(manageMenu);


        labelPT = new JLabel("~ PT. Pudding ~");
        labelPT.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 50)); // Curlz MT

        panelFrameUpper = new JPanel(new GridLayout(1,1));
        panelFrameUpper.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        panelFrameUpper.setBackground(new Color(255,189,189));
        panelFrameUpper.add(labelPT);
        labelPT.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        panelFrameCenter = new JPanel(new GridLayout(1,2));
        panelFrameCenter.add(pnlButtonInsertNewMenu);
        panelFrameCenter.add(pnlButtonManageMenu);
    }

    void run(){
        this.setTitle("PT. Pudding");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

}
