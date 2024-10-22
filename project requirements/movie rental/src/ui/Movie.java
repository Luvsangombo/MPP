package ui;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Movie {

    JFrame bframe;
    DefaultTableModel model;
    private JTextField titletf;
    private JTextField formattf;
    private JTextField genretf;
    private JTextField pricetf;
    private JTextField quantitytf;
    private JCheckBox availablitycb;
    private JTextField actorstf;
    private JTextField directorstf;
    private JTable table;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Movie window = new Movie();
                    window.bframe.setVisible(true);
                    window.bframe.setTitle("Movie Window");


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Movie() {
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

        JLabel TitleLabel = new JLabel("Title");
        TitleLabel.setBounds(6, 7, 125, 27);
        panel.add(TitleLabel);

        JLabel FormatLabel = new JLabel("Format");
        FormatLabel.setBounds(6, 47, 125, 27);
        panel.add(FormatLabel);

        JLabel GenreLabel = new JLabel("Genre");
        GenreLabel.setBounds(6, 87, 120, 16);
        panel.add(GenreLabel);

        JLabel PriceLabel = new JLabel("Price");
        PriceLabel.setBounds(6, 127, 120, 16);
        panel.add(PriceLabel);

        JLabel QuantityLabel = new JLabel("Quantity");
        QuantityLabel.setBounds(6, 167, 120, 16);
        panel.add(QuantityLabel);

        JLabel AvailabilityLabel = new JLabel("Availability");
        AvailabilityLabel.setBounds(6, 207, 120, 16);
        panel.add(AvailabilityLabel);

        JLabel ActorsLabel = new JLabel("Actors");
        ActorsLabel.setBounds(6, 247, 120, 16);
        panel.add(ActorsLabel);

        JLabel DirectorsLabel = new JLabel("Directors");
        DirectorsLabel.setBounds(6, 287, 120, 16);
        panel.add(DirectorsLabel);

        titletf = new JTextField();
        titletf.setBounds(129, 7, 161, 26);
        panel.add(titletf);
        titletf.setColumns(10);

        formattf = new JTextField();
        formattf.setBounds(129, 47, 161, 26);
        panel.add(formattf);
        formattf.setColumns(10);

        genretf = new JTextField();
        genretf.setBounds(129, 87, 161, 26);
        panel.add(genretf);
        genretf.setColumns(10);

        pricetf = new JTextField();
        pricetf.setBounds(129, 127, 161, 26);
        panel.add(pricetf);
        pricetf.setColumns(10);

        quantitytf = new JTextField();
        quantitytf.setBounds(129, 167, 160, 26);
        panel.add(quantitytf);
        quantitytf.setColumns(10);

        availablitycb = new JCheckBox();
        availablitycb.setBounds(129, 207, 160, 26);
        panel.add(availablitycb);
        availablitycb.setSelected(true);

        actorstf = new JTextField();
        actorstf.setBounds(129, 247, 662, 26);
        panel.add(actorstf);
        actorstf.setColumns(10);

        directorstf = new JTextField();
        directorstf.setBounds(129, 287, 662, 26);
        panel.add(directorstf);
        directorstf.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 340, 782, 287);
        panel.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                formattf.setText(model.getValueAt(r, 0).toString());
                genretf.setText(model.getValueAt(r, 1).toString());
                pricetf.setText(model.getValueAt(r, 2).toString());
                quantitytf.setText(model.getValueAt(r, 3).toString());
                availablitycb.setText(model.getValueAt(r, 4).toString());
                actorstf.setText(model.getValueAt(r, 5).toString());
                directorstf.setText(model.getValueAt(r, 6).toString());

            }
        });
        table.setBackground(new Color(255, 240, 245));
        model = new DefaultTableModel();
        String[] column = {"Title", "Format","Genre","Price","Quantity","Availability","Actors","Directors"};
        String[] row = new String[8];
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);

        JButton btnadd = new JButton("Add");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(titletf.getText().equals("")||formattf.getText().equals("")||genretf.getText().equals("")||pricetf.getText().equals("")
                        ||quantitytf.getText().equals("")||availablitycb.getText().equals("")
                        ||actorstf.getText().equals("")||directorstf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                else {
                    // add the entered inputs to the table
                    row[0] = titletf.getText();
                    row[1] = formattf.getText();
                    row[2] = genretf.getText();
                    row[3] = pricetf.getText();
                    row[4] = quantitytf.getText();
                    row[5] = availablitycb.getText();
                    row[6] = actorstf.getText();
                    row[7] = directorstf.getText();
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    // clear all the text fields
                    titletf.setText("");
                    formattf.setText("");
                    genretf.setText("");
                    pricetf.setText("");
                    quantitytf.setText("");
                    availablitycb.setText("");
                    actorstf.setText("");
                    directorstf.setText("");
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
                    model.setValueAt(titletf.getText(), r, 0);
                    model.setValueAt(formattf.getText(), r, 1);
                    model.setValueAt(genretf.getText(), r, 2);
                    model.setValueAt(pricetf.getText(), r, 3);
                    model.setValueAt(quantitytf.getText(), r, 4);
                    model.setValueAt(availablitycb.getText(), r, 5);
                    model.setValueAt(actorstf.getText(), r, 6);
                    model.setValueAt(directorstf.getText(), r, 7);
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
                titletf.setText("");
                formattf.setText("");
                genretf.setText("");
                pricetf.setText("");
                quantitytf.setText("");
                availablitycb.setText("");
                actorstf.setText("");
                directorstf.setText("");
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
