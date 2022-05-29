package frame;

import functions.ManageMenuFunction;
import components.Menu;
import visible.VisibleClass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ManageMenu extends JFrame {
    JLabel lblKodeMenu, lblNamaMenu, lblHargaMenu, lblStokMenu, lblAddStock;
    JTable jMenuTable;
    DefaultTableModel dtm;
    JScrollPane jMenuTableContainer;
    JTextField txtKodeMenu, txtNamaMenu, txtHargaMenu;
    JSpinner stockMenu, inAddStock;
    JButton btnUpdate, btnDelete, btnAddStock, btnBack;
    JPanel pnlUpper, pnlCenter, pnlBottom, pnlTable, pnlKodeMenu, pnlNamaMenu, pnlHargaMenu, pnlStokMenu,
    pnlTxtKodeMenu, pnlTxtNamaMenu, pnlTxtHargaMenu, pnlSpinnerStockMenu, pnlButtons, pnlButtons2, pnlButtonUpdate, pnlButtonDelete,
    pnlButtonAddStock, pnlLblAddStock, pnlSpinnerStockMenu2, pnlButtonBack;

    ManageMenuFunction manageMenuFunction;
    List<Menu> menus = new ArrayList<>();

    public JTextField getTxtKodeMenu(){
        return txtKodeMenu;
    }

    public JTextField getTxtNamaMenu(){
        return txtNamaMenu;
    }

    public JTextField getTxtHargaMenu(){
        return  txtHargaMenu;
    }

    public JSpinner getStockMenu(){
        return stockMenu;
    }

    public JSpinner getInAddStock(){
        return inAddStock;
    }

    public ManageMenu(){
        manageMenuFunction = new ManageMenuFunction();
        inItComponent();
        initValue();
        run();
        this.getContentPane().add(pnlUpper, BorderLayout.NORTH);
        this.getContentPane().add(pnlCenter, BorderLayout.CENTER);
        this.getContentPane().add(pnlBottom, BorderLayout.SOUTH);
//        getContentPane().setLayout(new GridLayout(3,3));
    }

    public void initValue(){
        initId();
        refreshTable();
    }

    public void refreshTable(){
        menus = manageMenuFunction.getAllMenu();
        dtm.setRowCount(0);
        for (Menu menu : menus){
            Object[] row = new Object[4];
            row[0] = menu.getMenuID();
            row[1] = menu.getNamaMenu();
            row[2] = menu.getHargaMenu();
            row[3] = menu.getStokMenu();
            dtm.addRow(row);
        }
    }

    private void initId(){
        try{
            txtKodeMenu.setText(manageMenuFunction.getNewID());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    void inItComponent(){
        ManageMenu frame = this;
        pnlUpper = new JPanel(new GridLayout(1,1));
        pnlUpper.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "View Menu",
                TitledBorder.CENTER, TitledBorder.TOP));
        pnlCenter = new JPanel(new GridLayout(2,2));
        pnlBottom = new JPanel(new GridLayout(2,2));

        // inisialisasi komponen
        Vector<Object> tableMenuHeader, tableData;

        // table
        tableMenuHeader = new Vector<>();

        tableMenuHeader.add("Kode Menu");
        tableMenuHeader.add("Nama Menu");
        tableMenuHeader.add("Harga Menu");
        tableMenuHeader.add("Stok Menu");

        dtm = new DefaultTableModel(tableMenuHeader, 0);

        pnlTable = new JPanel(new GridLayout(1,1));
        jMenuTable = new JTable(dtm);
        jMenuTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = jMenuTable.getSelectedRow();
                if(i > -1){
                    Menu menu = menus.get(i);
                    txtKodeMenu.setText(menu.getMenuID());
                    txtNamaMenu.setText(menu.getNamaMenu());
                    txtHargaMenu.setText(String.valueOf(menu.getHargaMenu()));
                    stockMenu.setValue(menu.getStokMenu());
                }
            }
        });
        jMenuTableContainer = new JScrollPane(jMenuTable);
        pnlTable.add(jMenuTableContainer);

        // kode menu
        pnlKodeMenu = new JPanel(new FlowLayout(FlowLayout.LEFT,5,10));
        lblKodeMenu = new JLabel("Kode Menu Baru:");
        lblKodeMenu.setFont(new Font("Times New Roman",Font.BOLD,13));
        pnlKodeMenu.setBackground(new Color(255,189,189));
        pnlKodeMenu.add(lblKodeMenu);

        // nama menu
        pnlNamaMenu = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,10));
        lblNamaMenu = new JLabel("Nama Menu Baru:");
        lblNamaMenu.setFont(new Font("Times New Roman", Font.BOLD, 13));
        pnlNamaMenu.setBackground(new Color(255,189,189));
        pnlNamaMenu.add(lblNamaMenu);

        // harga menu
        pnlHargaMenu = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,10));
        lblHargaMenu = new JLabel("Harga Menu Baru:");
        lblHargaMenu.setFont(new Font("Times New Roman", Font.BOLD, 13));
        pnlHargaMenu.setBackground(new Color(255,189,189));
        pnlHargaMenu.add(lblHargaMenu);

        // stok menu
        pnlStokMenu = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,10));
        lblStokMenu = new JLabel("Stok Menu Baru:");
        lblStokMenu.setFont(new Font("Times New Roman", Font.BOLD, 13));
        pnlStokMenu.setBackground(new Color(255,189,189));
        pnlStokMenu.add(lblStokMenu);

        // txt kode menu
        pnlTxtKodeMenu = new JPanel();
        txtKodeMenu = new JTextField();
        txtKodeMenu.setEditable(false);
        txtKodeMenu.setPreferredSize(new Dimension(110,20));
        pnlTxtKodeMenu.setBackground(new Color(255,189,189));
        pnlTxtKodeMenu.add(txtKodeMenu);

        // txt nama menu
        pnlTxtNamaMenu = new JPanel();
        txtNamaMenu = new JTextField();
        txtNamaMenu.setPreferredSize(new Dimension(110,20));
        pnlTxtNamaMenu.setBackground(new Color(255,189,189));
        pnlTxtNamaMenu.add(txtNamaMenu);

        // txt harga menu
        pnlTxtHargaMenu = new JPanel();
        txtHargaMenu = new JTextField();
        txtHargaMenu.setPreferredSize(new Dimension(110,20));
        pnlTxtHargaMenu.setBackground(new Color(255,189,189));
        pnlTxtHargaMenu.add(txtHargaMenu);

        // spinner stok menu
        pnlSpinnerStockMenu = new JPanel();
        stockMenu = new JSpinner();
        stockMenu.setPreferredSize(new Dimension(110,20));
        pnlSpinnerStockMenu.setBackground(new Color(255,189,189));
        pnlSpinnerStockMenu.add(stockMenu);

        // button update
        pnlButtons = new JPanel(new GridLayout(1,1)); // hold 2 buttons

        pnlButtonUpdate = new JPanel();
        btnUpdate = new JButton("Update Menu");
        btnUpdate.setPreferredSize(new Dimension(150,20));
//        btnUpdate.setBorder(BorderFactory.createEtchedBorder());
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageMenuFunction.updateMenu(frame);
            }
        });
        pnlButtonUpdate.setBackground(new Color(255,189,189));
        pnlButtonUpdate.add(btnUpdate);

        // button delete
        pnlButtonDelete = new JPanel();
        btnDelete = new JButton("Delete Menu");
        btnDelete.setPreferredSize(new Dimension(150,20));
//        btnDelete.setBorder(BorderFactory.createEtchedBorder());
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageMenuFunction.deleteMenu(frame);
            }
        });
        pnlButtonDelete.setBackground(new Color(255,189,189));
        pnlButtonDelete.add(btnDelete);

        // button add stock
        pnlButtons2 = new JPanel(new GridLayout(1,1)); // hold stock

        pnlLblAddStock = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        lblAddStock = new JLabel("Tambah Stok:");
        lblAddStock.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblAddStock.setBorder(new EmptyBorder(-1,0,0,0));
        pnlLblAddStock.setBackground(new Color(255,189,189));
        pnlLblAddStock.add(lblAddStock);

        pnlButtonAddStock = new JPanel();
        btnAddStock = new JButton("Add Stock");
        btnAddStock.setPreferredSize(new Dimension(151,20));
//        btnAddStock.setBorder(BorderFactory.createEtchedBorder());
        btnAddStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageMenuFunction.addStockMenu(frame);
            }
        });
        pnlButtonAddStock.setBackground(new Color(255,189,189));
        pnlButtonAddStock.add(btnAddStock);

        // spinner add stock
        pnlSpinnerStockMenu2 = new JPanel();
        inAddStock = new JSpinner();
        inAddStock.setPreferredSize(new Dimension(150,20));
        pnlSpinnerStockMenu2.setBackground(new Color(255,189,189));
        pnlSpinnerStockMenu2.add(inAddStock);

        // button back
        pnlButtonBack = new JPanel();
        btnBack = new JButton("Back to Start Menu");
        btnBack.setPreferredSize(new Dimension(150, 20));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisibleClass.navigateToStartMenu(frame);
            }
        });
        pnlButtonBack.setBackground(new Color(255,189,189));
        pnlButtonBack.add(btnBack);

        // add components into panel
        pnlUpper.add(pnlTable);

        pnlCenter.add(pnlKodeMenu);
        pnlCenter.add(pnlTxtKodeMenu);
        pnlCenter.add(pnlNamaMenu);
        pnlCenter.add(pnlTxtNamaMenu);
        pnlCenter.add(pnlHargaMenu);
        pnlCenter.add(pnlTxtHargaMenu);
        pnlCenter.add(pnlStokMenu);
        pnlCenter.add(pnlSpinnerStockMenu);

        pnlButtons.add(pnlButtonBack);
        pnlButtons.add(pnlButtonUpdate);
        pnlButtons.add(pnlButtonDelete);

        pnlButtons2.add(pnlLblAddStock);
        pnlButtons2.add(pnlSpinnerStockMenu2);
        pnlButtons2.add(pnlButtonAddStock);

        pnlBottom.add(pnlButtons);
        pnlBottom.add(pnlButtons2);

        // color panel
        pnlUpper.setBackground(new Color(255,189,189));
        pnlCenter.setBackground(new Color(255,189,189));
        pnlBottom.setBackground(new Color(255,189,189));

    }
    void run(){
        this.setTitle("PT. Pudding");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void resetMenuInput(){
        txtKodeMenu.setText("");
        txtNamaMenu.setText("");
        txtHargaMenu.setText("");
        stockMenu.setValue(0);
    }

}
