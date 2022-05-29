package components;

public class Menu {
    private String menuID;
    private String namaMenu;
    private int hargaMenu;
    private int stokMenu;

    public Menu(String menuID, String namaMenu, int hargaMenu, int stokMenu) {
        super();
        this.menuID = menuID;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.stokMenu = stokMenu;
    }

    public Menu() {
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }


    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public int getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(int hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public int getStokMenu() {
        return stokMenu;
    }

    public void setStokMenu(int stokMenu) {
        this.stokMenu = stokMenu;
    }
}
