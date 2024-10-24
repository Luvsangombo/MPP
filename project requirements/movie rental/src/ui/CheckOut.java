package ui;

import business.*;
import business.Movie;
import dataaccess.FileStorageUtil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CheckOut {
    private MemberUser member;
    private CheckoutRecord record;
    JFrame bframe;
    DefaultTableModel modelCheckout;
    DefaultTableModel modelMovie;
    DefaultTableModel modelEntry;
    private JTextField searchtf;
    private JTable tableCheckout;
    private JTable tableMovie;
    private JTable tableEntries;
    private JScrollPane scrollPaneCheckout;
    private JScrollPane scrollPaneMovie;
    private JScrollPane scrollPaneEntries;
    private JTextField totalPrice = new JTextField("0.0");
    private List<CheckoutEntry> checkoutRecord =  new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOut window = new CheckOut();
                    window.bframe.setVisible(true);
                    window.bframe.setTitle("Check Out Window");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public void add(){
        int r = tableMovie.getSelectedRow();
        if(r>=0) {
            double total = Double.valueOf(totalPrice.getText());
            String id = modelMovie.getValueAt(r, 0).toString();
            String title = modelMovie.getValueAt(r, 1).toString();
            String quantity = modelMovie.getValueAt(r, 2).toString();
            if(Integer.valueOf(quantity) == 0 ){
                JOptionPane.showMessageDialog(bframe, "Not available");
                return;
            }
            String newQuantity = String.valueOf(Integer.valueOf(quantity)-1);
            modelMovie.setValueAt(newQuantity,r,2);
            String price = modelMovie.getValueAt(r, 3).toString();
            LocalDate date = LocalDate.now();
            LocalDate dueDate = date.plusDays(7);
            String[] row = {id, title,price, date.toString(), dueDate.toString()};
            modelEntry.addRow(row);
            total += Double.valueOf(price);
            totalPrice.setText(String.format("%.2f",total));
            Movie movie = FileStorageUtil.getObject(id, FileStorageUtil.StorageType.MOVIES);
            CheckoutEntry entry = new CheckoutEntry(movie,date,dueDate);
            checkoutRecord.add(entry);
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select the Movie.");
        }


    }

    public void initCheckoutRecord() {
        emptyRecord();
        List<CheckoutRecord> list = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.CHECKOUTRECORD);
        for(CheckoutRecord record : list) {
            if (record.getMember().equals(member)) {
                String[] row = new String[6];
                String row1 = "";
                row[0] = record.getId();
                for (CheckoutEntry entry : record.getCheckoutEntries()) {
                    row1 += entry.getMovieTitle() + ",";
                    row[2] = entry.getCheckoutDate().toString();
                    row[3] = entry.getDueDate().toString();
                }
                row[1] = row1;
                row[4] = String.valueOf(record.getPrice());
                row[5] = record.isReturned ? "Yes" : "No";
                modelCheckout.addRow(row);
            }
        }
    }

    private void emptyRecord() {
        modelCheckout.setRowCount(0);
    }
    private void emptyEntires(){
        modelEntry.setRowCount(0);
    }
    private void checkout(){
        if(checkoutRecord.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select the Checkout Record.");
            return;
        }
        CheckoutRecord c = new CheckoutRecord(FileStorageUtil.getId(FileStorageUtil.StorageType.CHECKOUTRECORD),member, checkoutRecord);
        c.setPrice(Double.valueOf(totalPrice.getText()));
        FileStorageUtil.saveObject(c.getId(),c,FileStorageUtil.StorageType.CHECKOUTRECORD);
        c.decreaseQuantity();
        totalPrice.setText("0.0");
        initCheckoutRecord();
        emptyEntires();

    }

    private void checkIn() {
        int r = tableCheckout.getSelectedRow();
        if(r>=0) {
            String id = modelCheckout.getValueAt(r, 0).toString();
            CheckoutRecord record =  FileStorageUtil.getObject(id, FileStorageUtil.StorageType.CHECKOUTRECORD);
            if(record.isReturned) {
                JOptionPane.showMessageDialog(null, "Book is returned.");
                return;
            }
            record.checking();
            FileStorageUtil.saveObject(record.getId(),record,FileStorageUtil.StorageType.CHECKOUTRECORD);
            initCheckoutRecord();
            JOptionPane.showMessageDialog(null, "Successfully");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select the Movie.");
        }
    }

    public CheckOut() {
        initialize();
    }

    public CheckOut(String memberId) {
        MemberUser mu = FileStorageUtil.getObject(memberId, FileStorageUtil.StorageType.MEMBERS);
        this.member = mu;
        initialize();
    }

    private void getMovieData(DefaultTableModel model, String[] row) {
        List<business.Movie> movies = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.MOVIES);
        for (business.Movie movie : movies) {
            row[0] = movie.getId();
            row[1] = String.valueOf(movie.getTitle());
            row[2] = String.valueOf(movie.getQuantity());
            row[3] = String.valueOf(movie.getPrice());
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

        JPanel panel = new JPanel();
        panel.setBackground(new Color(233, 150, 122));
        panel.setBounds(0, 6, 794, 666);
        panel.setLayout(null);
        bframe.getContentPane().add(panel);



        searchtf = new JTextField();
        searchtf.setBounds(6, 360, 161, 26);
        panel.add(searchtf);
        searchtf.setColumns(10);

        // Checkout Table
        scrollPaneCheckout = new JScrollPane();
        scrollPaneCheckout.setBounds(6, 56, 782, 267);
        panel.add(scrollPaneCheckout);

        tableCheckout = new JTable();
        tableCheckout.setDefaultEditor(Object.class, null);

        tableCheckout.setBackground(new Color(255, 240, 245));
        modelCheckout = new DefaultTableModel();
        String[] column = {"ID", "Movies", "Checkout Date", "Due Date", "Total Price", "Is returned"};
        modelCheckout.setColumnIdentifiers(column);
        tableCheckout.setModel(modelCheckout);
        initCheckoutRecord();
        scrollPaneCheckout.setViewportView(tableCheckout);

        if (member != null) {
            JLabel memberNameLabel = new JLabel(member.getFullName());
            memberNameLabel.setBounds(500, 20, 150, 16);
            panel.add(memberNameLabel);
        }

        // Movie Table
        scrollPaneMovie = new JScrollPane();
        scrollPaneMovie.setBounds(6, 390, 360, 200);
        panel.add(scrollPaneMovie);

        tableMovie = new JTable();
        tableMovie.setDefaultEditor(Object.class, null);
        tableMovie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = tableMovie.getSelectedRow();
//                idtf.setText(model.getValueAt(r, 0).toString());
//                firstnametf.setText(model.getValueAt(r, 1).toString());
//                lastnametf.setText(model.getValueAt(r, 2).toString());

            }
        });
        tableMovie.setBackground(new Color(255, 240, 245));
        modelMovie = new DefaultTableModel();
        String[] columnMovie = {"ID", "Title","Quantity", "Price"};
        String[] rowMovie = new String[9];
        modelMovie.setColumnIdentifiers(columnMovie);
        tableMovie.setModel(modelMovie);
        scrollPaneMovie.setViewportView(tableMovie);

        // Retreive all data;
        getMovieData(modelMovie, rowMovie);



        scrollPaneEntries = new JScrollPane();
        scrollPaneEntries.setBounds(420, 390, 350, 200);
        panel.add(scrollPaneEntries);
        tableEntries = new JTable();

        String[] columnEntries = {"Movie Id", "Title", "Price","Date", "Due Date"};
        modelEntry = new DefaultTableModel();
        modelEntry.setColumnIdentifiers(columnEntries);
        tableEntries.setModel(modelEntry);
        scrollPaneEntries.setViewportView(tableEntries);




        JButton btnadd = new JButton("Checkout");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });
        btnadd.setBounds(6, 15, 117, 29);
        panel.add(btnadd);

        JButton btndel = new JButton("Checkin");
        btndel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             checkIn();
            }
        });
        btndel.setBounds(156, 15, 117, 29);
        panel.add(btndel);

        JButton btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bframe.setVisible(false);
                Member mWindow = new Member();

                mWindow.bframe.setVisible(true);
            }
        });
        btnback.setBounds(306, 15, 117, 29);
        panel.add(btnback);

        JButton btnsearch = new JButton("Search");
        btnsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = searchtf.getText();
                List<business.Movie> result = FileStorageUtil.searchMovieByTitle(searchText);

                if (modelMovie.getRowCount() > 0) {
                    for (int i = modelMovie.getRowCount() - 1; i > -1; i--) {
                        modelMovie.removeRow(i);
                    }
                }

                for (business.Movie movie : result) {
                    rowMovie[0] = movie.getId();
                    rowMovie[1] = String.valueOf(movie.getTitle());
                    rowMovie[2] = String.valueOf(movie.getQuantity());
                    rowMovie[3] = String.valueOf(movie.getPrice());
                    modelMovie.addRow(rowMovie);
                }
            }
        });
        btnsearch.setBounds(170, 360, 161, 26);
        panel.add(btnsearch);


        JButton btnAdd = new JButton("add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               add();

            }
        });
        btnAdd.setBounds(450, 360, 161, 26);
        panel.add(btnAdd);

        totalPrice.setBounds(650, 360, 50, 26);
        panel.add(totalPrice);
    }
}
