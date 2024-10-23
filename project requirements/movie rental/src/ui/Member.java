package ui;

import business.Administrator;
import business.MemberUser;
import dataaccess.FileStorageUtil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Member {

    JFrame bframe;
    DefaultTableModel model;
    private JTextField firstnametf;
    private JTextField lastnametf;
    private JTextField phonetf;
    private JTextField addresstf;
    private JTable table;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Member window = new Member();
                    window.bframe.setVisible(true);
                    window.bframe.setTitle("Member Window");


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Member() {
        initialize();
    }

    private void getData(DefaultTableModel model, String[] row) {
        List<MemberUser> allMembers = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.MEMBERS);
        for (MemberUser member : allMembers) {
            row[0] = String.valueOf(member.getId());
            row[1] = member.getFirstName();
            row[2] = member.getLastName();
            row[3] = member.getPhone();
            row[4] = member.getAddress();
            model.addRow(row);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        bframe = new JFrame();
        bframe.getContentPane().setForeground(new Color(255, 255, 255));
        bframe.setBounds(100, 100, 800, 700);
        bframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bframe.getContentPane().setLayout(null);
        bframe.setResizable(false);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(233, 150, 122));
        panel.setBounds(0, 6, 794, 666);
        panel.setLayout(null);
        bframe.getContentPane().add(panel);

        JLabel firstNameLabel = new JLabel("Member First Name");
        firstNameLabel.setBounds(6, 8, 125, 27);
        panel.add(firstNameLabel);

        JLabel LastNameLabel = new JLabel("Member Last Name");
        LastNameLabel.setBounds(6, 47, 120, 16);
        panel.add(LastNameLabel);

        JLabel PhoneLabel = new JLabel("Member Phone");
        PhoneLabel.setBounds(6, 87, 120, 16);
        panel.add(PhoneLabel);

        JLabel AddressLabel = new JLabel("Member Address");
        AddressLabel.setBounds(6, 127, 120, 16);
        panel.add(AddressLabel);

        firstnametf = new JTextField();
        firstnametf.setBounds(129, 8, 161, 26);
        panel.add(firstnametf);
        firstnametf.setColumns(10);

        lastnametf = new JTextField();
        lastnametf.setBounds(129, 47, 161, 26);
        panel.add(lastnametf);
        lastnametf.setColumns(10);

        phonetf = new JTextField();
        phonetf.setBounds(129, 87, 161, 26);
        panel.add(phonetf);
        phonetf.setColumns(10);

        addresstf = new JTextField();
        addresstf.setBounds(129, 127, 300, 26);
        panel.add(addresstf);
        addresstf.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 254, 782, 287);
        panel.add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                firstnametf.setText(model.getValueAt(r, 1).toString());
                lastnametf.setText(model.getValueAt(r, 2).toString());
                phonetf.setText(model.getValueAt(r, 3).toString());
                addresstf.setText(model.getValueAt(r, 4).toString());
            }
        });
        table.setBackground(new Color(255, 240, 245));
        model = new DefaultTableModel();
        String[] column = {"ID","First Name","Last Name","Phone","Address"};
        String[] row = new String[5];
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);

        // Retreive all data;
        getData(model, row);

        JButton btnadd = new JButton("Add");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(firstnametf.getText().equals("")||lastnametf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                else {
                    int AutoGeneratedId = generateUniqueId();

                    // add the entered inputs to the table
                    row[0] = String.valueOf(AutoGeneratedId);
                    row[1] = firstnametf.getText();
                    row[2] = lastnametf.getText();
                    row[3] = phonetf.getText();
                    row[4] = addresstf.getText();
                    model.addRow(row);

                    // Retrieve an Actor object
                    Administrator admin1 = (Administrator) FileStorageUtil.getObject("1",
                            FileStorageUtil.StorageType.ADMINISTRATORS);

                    MemberUser user1 = new MemberUser(AutoGeneratedId, firstnametf.getText(), lastnametf.getText(), phonetf.getText(), addresstf.getText(), admin1);
                    FileStorageUtil.saveObject(String.valueOf(AutoGeneratedId), user1, FileStorageUtil.StorageType.MEMBERS);

                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    // clear all the text fields
                    firstnametf.setText("");
                    lastnametf.setText("");
                    phonetf.setText("");
                    addresstf.setText("");
                }

            }

            private int generateUniqueId() {
                int lastid = 7;
                return lastid++;
            }
        });
        btnadd.setBounds(450, 15, 117, 29);
        panel.add(btnadd);

        JButton btndel = new JButton("Delete");
        btndel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
                    // Delete a MemberUser object
                    String id = model.getValueAt(r, 0).toString();
                    FileStorageUtil.deleteObject(id, FileStorageUtil.StorageType.MEMBERS);
                    model.removeRow(r);
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select a row");
                }
            }
        });
        btndel.setBounds(600, 15, 117, 29);
        panel.add(btndel);

        JButton btnupdate = new JButton("Update");
        btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
                    model.setValueAt(firstnametf.getText(), r, 1);
                    model.setValueAt(lastnametf.getText(), r, 2);
                    model.setValueAt(phonetf.getText(), r, 3);
                    model.setValueAt(addresstf.getText(), r, 4);

                    String id = model.getValueAt(r, 0).toString();

                    MemberUser retrievedUser = (MemberUser) FileStorageUtil.getObject(id, FileStorageUtil.StorageType.MEMBERS);
                    System.out.println("Retrieved MemberUser: " + retrievedUser);
                    // Update a MemberUser object
                    retrievedUser.setFirstName(firstnametf.getText());
                    retrievedUser.setLastName(lastnametf.getText());
                    retrievedUser.setPhone(phonetf.getText());
                    retrievedUser.setAddress(addresstf.getText());
                    FileStorageUtil.saveObject(id, retrievedUser, FileStorageUtil.StorageType.MEMBERS);

                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select a row");
                }
            }
        });
        btnupdate.setBounds(450, 56, 117, 29);
        panel.add(btnupdate);

        JButton btnclear = new JButton("Clear");
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstnametf.setText("");
                lastnametf.setText("");
                phonetf.setText("");
                addresstf.setText("");
            }
        });
        btnclear.setBounds(600, 56, 117, 29);
        panel.add(btnclear);

        JButton btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bframe.setVisible(false);
                MainWindow mWindow = new MainWindow();

                mWindow.mframe.setVisible(true);
            }
        });
        btnback.setBounds(510, 107, 117, 29);
        panel.add(btnback);

        JButton btnCheckout = new JButton("Checkout");
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
                    String id = model.getValueAt(r, 0).toString();

                    bframe.setVisible(false);
                    CheckOut checkoutWindow = new CheckOut(id);
                    checkoutWindow.bframe.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select Member");
                }
            }
        });
        btnCheckout.setBounds(510, 137, 117, 29);
        panel.add(btnCheckout);
    }
}
