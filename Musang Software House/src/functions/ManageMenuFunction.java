package functions;

import access.MenuInterface;
import components.Menu;
import database.ConnectDB;
import frame.ManageMenu;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManageMenuFunction {

    public void updateMenu(ManageMenu view){
        String kodeMenu = view.getTxtKodeMenu().getText();
        String namaMenu = view.getTxtNamaMenu().getText();
        String hargaMenu = view.getTxtHargaMenu().getText();
        String stokMenu = view.getStockMenu().getValue().toString();

        if(namaMenu.length() < 5 || namaMenu.length() > 30){
            JOptionPane.showMessageDialog(view, "Menu name must between 5 and 30 characters.");
        }else{
            try{
                MenuInterface menuInterface = ConnectDB.getMenu();
                Menu menu = menuInterface.findById(kodeMenu);

                if(menu == null){
                    JOptionPane.showMessageDialog(view, "Menu with given ID is not found!");
                    return;
                }
                if(isConfirmed("Are you sure want to update menu?")){
                    menu.setNamaMenu(namaMenu);
                    menu.setHargaMenu(Integer.parseInt(hargaMenu));
                    menu.setStokMenu(Integer.parseInt(stokMenu));
                    menuInterface.update(menu);

                    view.resetMenuInput();
                    view.refreshTable();
                    JOptionPane.showMessageDialog(view, "Successfully Updated!");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(view, "Update menu failed");
            }

        }
    }

    public void deleteMenu(ManageMenu view){
        String id = view.getTxtKodeMenu().getText();

        if(id.equals("")){
            JOptionPane.showMessageDialog(view, "Please fill the menu id");
        }else{
            try{
                MenuInterface menuInterface = ConnectDB.getMenu();
                Menu menu = menuInterface.findById(id);

                if(menu == null){
                    JOptionPane.showMessageDialog(view, "Menu with given ID is not found");
                    return;
                }
                if(isConfirmed("Are you sure want to delete menu?")){
                    menuInterface.delete(id);
                    view.resetMenuInput();
                    view.refreshTable();
                    JOptionPane.showMessageDialog(view,"Successfully Deleted!");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(view, "Delete game failed");
            }
        }
    }

    public void addStockMenu(ManageMenu view){
        String id = view.getTxtKodeMenu().getText();
        String newStok = view.getInAddStock().getValue().toString();

        if(id.equals("")){
            JOptionPane.showMessageDialog(view, "Please fill the menu id!");
        }else if((!isNumeric(newStok)) || Double.parseDouble(newStok) < 1){
            JOptionPane.showMessageDialog(view, "Add stock must more than 0 and numeric!");
        }else{
            try{
                MenuInterface menuInterface = ConnectDB.getMenu();
                Menu menu = menuInterface.findById(id);

                if(menu == null){
                    JOptionPane.showMessageDialog(view, "Menu with given ID is not found!");
                    return;
                }

                if(isConfirmed("Are you sure want to add menu stock?")){
                    int allStock = menu.getStokMenu() + Integer.parseInt(newStok);
                    menu.setStokMenu(allStock);
                    menuInterface.update(menu);

                    view.resetMenuInput();
                    view.refreshTable();
                    JOptionPane.showMessageDialog(view, "Stock Successfully added!");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(view, "Add stock failed!");
            }
        }
    }

    public List<Menu> getAllMenu(){
        try{
            MenuInterface menuInterface = ConnectDB.getMenu();
            return menuInterface.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean isConfirmed(String message){
        int option = JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION);
        if (option == 0) return true;
        return false;
    }

    public static boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public String getNewID() throws SQLException{
        Random rdm = new Random();
        MenuInterface menuInterface = ConnectDB.getMenu();
        int lastId = menuInterface.countMenu();
        int newId = rdm.nextInt(100) + lastId;
        return newId < 10 ? "PD00" + newId : newId < 100 ? "PD0" + newId : String.valueOf(newId);
    }
}
