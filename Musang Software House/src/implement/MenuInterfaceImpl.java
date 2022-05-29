package implement;

import access.MenuInterface;
import com.mysql.jdbc.JDBC4ResultSet;
import components.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class MenuInterfaceImpl implements MenuInterface {
    private Connection conn;

    // database query
    private String getAll = "SELECT * FROM menu";
    private String insertMenu = "INSERT INTO menu (menuID, namaMenu, hargaMenu, stokMenu) VALUES(?,?,?,?)";
    private String countByMenu= "SELECT COUNT(*) FROM menu WHERE namaMenu = ?";
    private String countMenu = "SELECT COUNT(*) FROM menu";
    private String findById = "SELECT * FROM menu WHERE menuID = ?";
    private String updateMenu = "UPDATE menu SET namaMenu = ?, hargaMenu = ?, stokMenu = ? WHERE menuID = ?";
    private String deleteMenu = "DELETE FROM menu WHERE menuID = ?";
    public MenuInterfaceImpl(Connection connection){
        this.conn = connection;
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> result = new ArrayList<Menu>();
        PreparedStatement statement = null;

        Menu menu = null;
        try{
            statement = (PreparedStatement) conn.prepareStatement(getAll);
            JDBC4ResultSet rs = (JDBC4ResultSet) statement.executeQuery();
            while(rs.next()){
                String menuID = rs.getString("menuID");
                String namaMenu = rs.getString("namaMenu");
                int hargaMenu = rs.getInt("hargaMenu");
                int stockMenu = rs.getInt("stokMenu");

                menu = new Menu();
                menu.setMenuID(menuID);
                menu.setNamaMenu(namaMenu);
                menu.setHargaMenu(hargaMenu);
                menu.setStokMenu(stockMenu);

                result.add(menu);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void insertMenu(Menu menu) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) conn.prepareStatement(insertMenu);
            statement.setString(1, menu.getMenuID());
            statement.setString(2, menu.getNamaMenu());
            statement.setInt(3, menu.getHargaMenu());
            statement.setInt(4, menu.getStokMenu());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) conn.prepareStatement(deleteMenu);
            statement.setString(1, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Menu menu) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) conn.prepareStatement(updateMenu);
            statement.setString(1, menu.getNamaMenu());
            statement.setInt(2, menu.getHargaMenu());
            statement.setInt(3, menu.getStokMenu());
            statement.setString(4, menu.getMenuID());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int countMenu() {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) conn.prepareStatement(countMenu);
            JDBC4ResultSet rs = (JDBC4ResultSet) statement.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public int countByMenu(String menuName) {
        PreparedStatement statement = null;
        try{
            statement = (PreparedStatement) conn.prepareStatement(countByMenu);
            statement.setString(1, menuName);
            JDBC4ResultSet rs = (JDBC4ResultSet) statement.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null){
                try{
                    statement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public Menu findById(String id) {
        PreparedStatement statement = null;
        Menu menu = null;
        try{
            statement = (PreparedStatement) conn.prepareStatement(findById);
            statement.setString(1, id);
            JDBC4ResultSet rs = (JDBC4ResultSet) statement.executeQuery();
            while (rs.next()){
                String namaMenu = rs.getString("namaMenu");
                int hargaMenu = rs.getInt("hargaMenu");
                int stok = rs.getInt("stokMenu");

                menu = new Menu();
                menu.setMenuID(id);
                menu.setNamaMenu(namaMenu);
                menu.setHargaMenu(hargaMenu);
                menu.setStokMenu(stok);
            }
            return menu;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null){
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
