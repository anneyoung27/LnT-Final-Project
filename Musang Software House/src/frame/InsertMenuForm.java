package frame;

import functions.InsertMenuFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertMenuForm extends JFrame implements ActionListener{
    InsertMenuFunction insertMenuFunction;
    JLabel title, kodeMenu, namaMenu, hargaMenu, stokMenu;
    JTextField txtKodeMenu, txtNamaMenu, txtHargaMenu;
    JButton btnReset, btnSave;
    JSpinner stok;
    JPanel panelUpper, panelCenter, panelBottom, pnlTitle, pnlKodeMenu, pnlNamaMenu, pnlHargaMenu,
    pnlStokMenu, pnlKodeMenu2, pnlNamaMenu2, pnlHargaMenu2, pnlStokMenu2, pnlBtnReset, pnlBtnSave;

    public JTextField getKodeMenu(){
        return txtKodeMenu;
    }

    public JTextField getNamaMenu(){
        return txtNamaMenu;
    }

    public JTextField getHargaMenu(){
        return txtHargaMenu;
    }

    public JSpinner getStok(){
        return stok;
    }

    public InsertMenuForm(){
        insertMenuFunction = new InsertMenuFunction();
        inItComponent();
        try{
            txtKodeMenu.setText(insertMenuFunction.getMenuId());
        }catch (SQLException e){
            e.printStackTrace();
        }
        txtKodeMenu.setEditable(false); // non aktifin text field.
        run();
        getContentPane().add(panelUpper, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);
        getContentPane().add(panelBottom, BorderLayout.SOUTH);

    }

    void inItComponent(){
        panelUpper = new JPanel(new GridLayout(1,1));

        pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title = new JLabel("~ INSERT NEW MENU ~");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        pnlTitle.add(title);
        pnlTitle.setBackground(new Color(255,189,189));

        panelCenter = new JPanel(new GridLayout(4,2));
        panelBottom = new JPanel(new GridLayout(1,2));

        pnlKodeMenu = new JPanel(new FlowLayout(FlowLayout.LEFT,30,5));
        kodeMenu = new JLabel("Kode Menu:");
        kodeMenu.setFont(new Font("Comic Sans MS", Font.PLAIN,25));
        pnlKodeMenu.add(kodeMenu);
        pnlKodeMenu.setBackground(new Color(255,189,189));

        pnlNamaMenu = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,5));
        namaMenu = new JLabel("Nama Menu:");
        namaMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        pnlNamaMenu.add(namaMenu);
        pnlNamaMenu.setBackground(new Color(255,189,189));

        pnlHargaMenu = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,5));
        hargaMenu = new JLabel("Harga Menu:");
        hargaMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        pnlHargaMenu.add(hargaMenu);
        pnlHargaMenu.setBackground(new Color(255,189,189));

        pnlStokMenu = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,5));
        stokMenu = new JLabel("Stok Menu:");
        stokMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        pnlStokMenu.add(stokMenu);
        pnlStokMenu.setBackground(new Color(255,189,189));

        pnlKodeMenu2 = new JPanel();
        txtKodeMenu = new JTextField();
        txtKodeMenu.setPreferredSize(new Dimension(200,30));
        pnlKodeMenu2.add(txtKodeMenu);
        pnlKodeMenu2.setBackground(new Color(255,189,189));

        pnlNamaMenu2 = new JPanel();
        txtNamaMenu = new JTextField();
        txtNamaMenu.setPreferredSize(new Dimension(200,30));
        pnlNamaMenu2.add(txtNamaMenu);
        pnlNamaMenu2.setBackground(new Color(255,189,189));

        pnlHargaMenu2 = new JPanel();
        txtHargaMenu = new JTextField();
        txtHargaMenu.setPreferredSize(new Dimension(200,30));
        pnlHargaMenu2.add(txtHargaMenu);
        pnlHargaMenu2.setBackground(new Color(255,189,189));

        pnlStokMenu2 = new JPanel();
        stok = new JSpinner();
        stok.setPreferredSize(new Dimension(200,30));
        pnlStokMenu2.add(stok);
        pnlStokMenu2.setBackground(new Color(255,189,189));

        pnlBtnReset = new JPanel(new FlowLayout(FlowLayout.LEFT,70,25));
        btnReset = new JButton("Reset");
        btnReset.setPreferredSize(new Dimension(145,25));
        btnReset.setFont(new Font("Comic Sans MS",Font.PLAIN,13));
//        btnReset.setBorder(BorderFactory.createEtchedBorder());
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetMenuInput();
            }
        });
        pnlBtnReset.add(btnReset);
        pnlBtnReset.setBackground(new Color(255,189,189));

        pnlBtnSave = new JPanel(new FlowLayout(FlowLayout.RIGHT, 70,25));
        btnSave = new JButton("Save & Close");
        btnSave.setFont(new Font("Comic Sans MS",Font.PLAIN,13));
        btnSave.setPreferredSize(new Dimension(145,25));
//        btnSave.setBorder(BorderFactory.createEtchedBorder());
        btnSave.addActionListener(this); // action listener
        pnlBtnSave.add(btnSave);
        pnlBtnSave.setBackground(new Color(255,189,189));


        panelUpper.add(pnlTitle);
        panelUpper.setBackground(new Color(255,189,189));

        panelCenter.add(pnlKodeMenu);
        panelCenter.add(pnlKodeMenu2);
        panelCenter.add(pnlNamaMenu);
        panelCenter.add(pnlNamaMenu2);
        panelCenter.add(pnlHargaMenu);
        panelCenter.add(pnlHargaMenu2);
        panelCenter.add(pnlStokMenu);
        panelCenter.add(pnlStokMenu2);
        panelCenter.setBackground(new Color(255,189,189));

        panelBottom.add(pnlBtnReset);
        panelBottom.add(pnlBtnSave);


    }

    void run(){
        this.setTitle("PT. Pudding");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void resetMenuInput(){
        txtNamaMenu.setText("");
        txtHargaMenu.setText("");
        stok.setValue(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSave){
            insertMenuFunction.insertMenu(this);
        }
    }
}
