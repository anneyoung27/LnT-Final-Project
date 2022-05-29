package visible;

import components.Users;
import frame.InsertMenuForm;
import frame.ManageMenu;
import frame.StartMenu;

import javax.swing.*;

public class VisibleClass {
     public static void navigateToStartMenu(JFrame view, Users user){
         StartMenu sMenu = new StartMenu(user);
         sMenu.setLocationRelativeTo(null);
         sMenu.setVisible(true);
         view.setVisible(false);
     }

     public static void navigateToStartMenu(JFrame view){
         Users user = new Users();
         StartMenu startMenu = new StartMenu(user);
         startMenu.setLocationRelativeTo(null);
         startMenu.setVisible(true);
         view.setVisible(false);
     }

     public static void navigateToInsertNewMenuForm(JFrame view){
         InsertMenuForm sInsertMenu = new InsertMenuForm();
         sInsertMenu.setLocationRelativeTo(null);
         sInsertMenu.setVisible(true);
         view.setVisible(false);
     }

     public static void navigateToManageMenuForm(JFrame view, Users user){
         ManageMenu sManageMenu = new ManageMenu();
         sManageMenu.setLocationRelativeTo(null);
         sManageMenu.setVisible(true);
         view.setVisible(false);
     }
}
