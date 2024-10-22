package ui;

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

public class Member {

    JFrame bframe;
    DefaultTableModel model;
    private JTextField idtf;
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

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        bframe = new JFrame();
        bframe.getContentPane().setForeground(new Color(255, 255, 255));
        bframe.setBounds(100, 100, 800, 700);
        bframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bframe.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(233, 150, 122));
        panel.setBounds(0, 6, 794, 666);
        panel.setLayout(null);
        bframe.getContentPane().add(panel);

        JLabel idLabel = new JLabel("Member ID");
        idLabel.setBounds(6, 20, 100, 16);
        panel.add(idLabel);

        JLabel firstNameLabel = new JLabel("Member First Name");
        firstNameLabel.setBounds(6, 48, 125, 27);
        panel.add(firstNameLabel);

        JLabel LastNameLabel = new JLabel("Member Last Name");
        LastNameLabel.setBounds(6, 87, 120, 16);
        panel.add(LastNameLabel);

        JLabel PhoneLabel = new JLabel("Member Phone");
        PhoneLabel.setBounds(6, 127, 120, 16);
        panel.add(PhoneLabel);

        JLabel AddressLabel = new JLabel("Member Address");
        AddressLabel.setBounds(6, 167, 120, 16);
        panel.add(AddressLabel);

        idtf = new JTextField();
        idtf.setBounds(129, 15, 161, 26);
        panel.add(idtf);
        idtf.setColumns(10);

        firstnametf = new JTextField();
        firstnametf.setBounds(129, 48, 161, 26);
        panel.add(firstnametf);
        firstnametf.setColumns(10);

        lastnametf = new JTextField();
        lastnametf.setBounds(129, 87, 161, 26);
        panel.add(lastnametf);
        lastnametf.setColumns(10);

        phonetf = new JTextField();
        phonetf.setBounds(129, 127, 161, 26);
        panel.add(phonetf);
        phonetf.setColumns(10);

        addresstf = new JTextField();
        addresstf.setBounds(129, 167, 300, 26);
        panel.add(addresstf);
        addresstf.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 254, 782, 287);
        panel.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                idtf.setText(model.getValueAt(r, 0).toString());
                firstnametf.setText(model.getValueAt(r, 1).toString());
                lastnametf.setText(model.getValueAt(r, 2).toString());

            }
        });
        table.setBackground(new Color(255, 240, 245));
        model = new DefaultTableModel();
        String[] column = {"ID","First Name","Last Name","Phone","Address"};
        String[] row = new String[5];
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);

        JButton btnadd = new JButton("Add");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(idtf.getText().equals("")||firstnametf.getText().equals("")||lastnametf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                else {
                    // add the entered inputs to the table
                    row[0] = idtf.getText();
                    row[1] = firstnametf.getText();
                    row[2] = lastnametf.getText();
                    row[3] = phonetf.getText();
                    row[4] = addresstf.getText();
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    // clear all the text fields
                    idtf.setText("");
                    firstnametf.setText("");
                    lastnametf.setText("");
                }

            }
        });
        btnadd.setBounds(450, 15, 117, 29);
        panel.add(btnadd);

        JButton btndel = new JButton("Delete");
        btndel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
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
                    model.setValueAt(idtf.getText(), r, 0);
                    model.setValueAt(firstnametf.getText(), r, 1);
                    model.setValueAt(lastnametf.getText(), r, 2);
                    model.setValueAt(phonetf.getText(), r, 3);
                    model.setValueAt(addresstf.getText(), r, 4);
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
                idtf.setText("");
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
//                MainWindow mWindow = new MainWindow();
//
//                mWindow.mframe.setVisible(true);
            }
        });
        btnback.setBounds(510, 107, 117, 29);
        panel.add(btnback);


    }
}
