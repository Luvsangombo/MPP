package ui;

import business.Actor;
import business.CheckoutRecord;
import business.MemberUser;
import business.Movie;
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
import java.util.Optional;
import java.util.stream.Collectors;

public class CheckOut {
    private MemberUser member;
    private CheckoutRecord record;
    JFrame bframe;
    DefaultTableModel modelCheckout;
    DefaultTableModel modelMovie;
    private JTextField searchtf;
    private JTable tableCheckout;
    private JTable tableMovie;
    private JScrollPane scrollPaneCheckout;
    private JScrollPane scrollPaneMovie;

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
    public CheckOut() {
        initialize();
    }

    public CheckOut(String memberId) {
        MemberUser mu = (MemberUser) FileStorageUtil.getObject(memberId, FileStorageUtil.StorageType.MEMBERS);
        this.member = mu;
//        List<CheckoutRecord> crlist = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.CHECKOUTRECORD);
//        Optional<CheckoutRecord> cr = crlist.stream().filter(x->x.getMember() == mu).findAny();
//        if (cr.isPresent()) {
//            record = cr.get();
//        } else {
//            CheckoutRecord newCr = new CheckoutRecord(mu);
//            FileStorageUtil.saveObject(, newCr, FileStorageUtil.StorageType.CHECKOUTRECORD);
//            record = newCr;
//        }

        initialize();
    }

    private void getMovieData(DefaultTableModel model, String[] row) {
        List<business.Movie> movies = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.MOVIES);
        for (business.Movie movie : movies) {
            row[0] = movie.getId();
            row[1] = String.valueOf(movie.getTitle());
            row[2] = movie.getFormat();
            row[3] = movie.getGenre();
            row[4] = String.valueOf(movie.getPrice());
            row[5] = String.valueOf(movie.getQuantity());
            row[6] = movie.isAvailable() ? "Yes" : "No";
            String actors = movie.getActors().stream()
                            .map(x -> x.getFullName())
                            .collect(Collectors.joining(", "));
            row[7] = actors;
            row[8] = movie.getDirector().toString();
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

        JLabel searchMovieTitleLabel = new JLabel("Search Movie Title");
        searchMovieTitleLabel.setBounds(6, 365, 150, 16);
        panel.add(searchMovieTitleLabel);

        searchtf = new JTextField();
        searchtf.setBounds(129, 360, 161, 26);
        panel.add(searchtf);
        searchtf.setColumns(10);

        // Checkout Table
        scrollPaneCheckout = new JScrollPane();
        scrollPaneCheckout.setBounds(6, 56, 782, 267);
        panel.add(scrollPaneCheckout);

        tableCheckout = new JTable();
        tableCheckout.setDefaultEditor(Object.class, null);
        tableCheckout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = tableCheckout.getSelectedRow();
//                idtf.setText(model.getValueAt(r, 0).toString());
//                firstnametf.setText(model.getValueAt(r, 1).toString());
//                lastnametf.setText(model.getValueAt(r, 2).toString());

            }
        });
        tableCheckout.setBackground(new Color(255, 240, 245));
        modelCheckout = new DefaultTableModel();
        String[] column = {"Movie", "Checkout Date", "Due Date", "Total Amount"};
        String[] row = new String[4];
        modelCheckout.setColumnIdentifiers(column);
        tableCheckout.setModel(modelCheckout);
        scrollPaneCheckout.setViewportView(tableCheckout);

        if (member != null) {
            JLabel memberNameLabel = new JLabel(member.getFullName());
            memberNameLabel.setBounds(500, 20, 150, 16);
            panel.add(memberNameLabel);
        }

        // Movie Table
        scrollPaneMovie = new JScrollPane();
        scrollPaneMovie.setBounds(6, 390, 782, 267);
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
        String[] columnMovie = {"ID", "Title", "Format","Genre","Price","Quantity","Availability","Actors","Directors"};
        String[] rowMovie = new String[9];
        modelMovie.setColumnIdentifiers(columnMovie);
        tableMovie.setModel(modelMovie);
        scrollPaneMovie.setViewportView(tableMovie);

        // Retreive all data;
        getMovieData(modelMovie, rowMovie);


        JButton btnadd = new JButton("Checkout");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = tableMovie.getSelectedRow();
                if(r>=0 && member != null) {
                    String id = modelMovie.getValueAt(r, 0).toString();
                    Movie movie = FileStorageUtil.getObject(id, FileStorageUtil.StorageType.MOVIES);
//
//                    bframe.setVisible(false);
//                    CheckOut checkoutWindow = new CheckOut(id);
//                    checkoutWindow.bframe.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select the Movie.");
                }
            }
        });
        btnadd.setBounds(6, 15, 117, 29);
        panel.add(btnadd);

        JButton btndel = new JButton("Delete");
        btndel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = tableCheckout.getSelectedRow();
                if(r>=0) {
                    modelCheckout.removeRow(r);
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");

                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select a row");
                }
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
                    rowMovie[2] = movie.getFormat();
                    rowMovie[3] = movie.getGenre();
                    rowMovie[4] = String.valueOf(movie.getPrice());
                    rowMovie[5] = String.valueOf(movie.getQuantity());
                    rowMovie[6] = movie.isAvailable() ? "Yes" : "No";
                    String actors = movie.getActors().stream()
                            .map(x -> x.getFullName())
                            .collect(Collectors.joining(", "));
                    rowMovie[7] = actors;
                    rowMovie[8] = movie.getDirector().toString();

                    modelMovie.addRow(rowMovie);
                }
            }
        });
        btnsearch.setBounds(300, 360, 161, 26);
        panel.add(btnsearch);
    }
}
