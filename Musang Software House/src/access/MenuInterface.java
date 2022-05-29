package access;

import components.Menu;

import java.util.List;

public interface MenuInterface {
    public List<Menu> getAll();

    public void insertMenu(Menu menu);

    public void delete(String id);

    public void update(Menu menu);

    public int countMenu();

    public int countByMenu(String menuName);

    public Menu findById(String id);

}
