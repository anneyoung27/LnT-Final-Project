package functions;

import access.MenuInterface;
import components.Menu;
import components.Users;
import database.ConnectDB;
import frame.InsertMenuForm;
import visible.VisibleClass;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Random;

public class InsertMenuFunction {
    public void insertMenu(InsertMenuForm view) {
        String id = view.getKodeMenu().getText();
        String namaMenu = view.getNamaMenu().getText();
        String hargaMenu = view.getHargaMenu().getText();
        String stokMenu = view.getStok().getValue().toString();

        if (namaMenu.length() < 5 || namaMenu.length() > 30) {
            JOptionPane.showMessageDialog(view, "Menu name must between 5 and 30 characters.");
        }else{
            try{
                Menu menu = new Menu();
                Users user = new Users();
                menu.setMenuID(id);
                menu.setNamaMenu(namaMenu);
                menu.setHargaMenu(Integer.parseInt(hargaMenu)); // <- kalau ada error pas insert, perbaiki ini.
                menu.setStokMenu(Integer.parseInt(stokMenu));

                if(!uniqueMenuName(namaMenu)){
                    JOptionPane.showMessageDialog(view, "Menu is already inserted, please input another menu!");
                    return;
                }

                if(isConfirmed("Are you sure want to insert new menu?")){
                    MenuInterface menuInterface = ConnectDB.getMenu();
                    menuInterface.insertMenu(menu);
                    view.resetMenuInput();
                    JOptionPane.showMessageDialog(view, "New menu is saved successfully!");
                    VisibleClass.navigateToStartMenu(view, user);
                }
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    private boolean uniqueMenuName(String menuName){
        try{
            MenuInterface menuInterface = ConnectDB.getMenu();
            int count = menuInterface.countByMenu(menuName);
            if(count < 1) return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getMenuId() throws SQLException{ // jika ada masalah generate id, perbaiki ini!
        Random rdm = new Random();
        MenuInterface menuInterface = ConnectDB.getMenu();
        int lastId = menuInterface.countMenu();
        int newId = rdm.nextInt(100) + lastId;
        return newId < 10 ? "PD00" + newId : newId < 100 ? "PD0" + newId : String.valueOf(newId);
    }

    public boolean isConfirmed(String message){
        int option = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION);
        if(option == 0) return true;
        return false;
    }

}
