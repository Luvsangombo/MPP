package ui;

import business.Actor;
import business.Director;
import dataaccess.FileStorageUtil;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Movie {

    JFrame bframe;
    DefaultTableModel model;
    private JTextField titletf;
    private JTextField formattf;
    private JTextField genretf;
    private JTextField pricetf;
    private JTextField quantitytf;
    private JTextField actorstf;
    private JTextField directorstf;
    private JTextField availablitycb;
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

    private Object[][] getMovies(){
        List<business.Movie> movies = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.MOVIES);
        Object[][] list = new Object[movies.size()][9];
            for(int i = 0; i < movies.size(); i++){
                    list[i] = movies.get(i).asList();
            }
    return list;
    }

    private business.Movie getMovie(){
        if(titletf.getText().equals("")||formattf.getText().equals("")||genretf.getText().equals("")||pricetf.getText().equals("")
                ||quantitytf.getText().equals("")
                ||actorstf.getText().equals("")||directorstf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            return null;
        }
        Pattern pattern = Pattern.compile("[0-9]+");
        if(!pattern.matcher(quantitytf.getText()).matches()){
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity");
            return null;
        }

        try{ Double.parseDouble(pricetf.getText());}
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid price");
            return null;
        };
        String title = titletf.getText();
        String format = formattf.getText();
        String genre = genretf.getText();
        double price = Double.parseDouble(pricetf.getText());
        int quantity = Integer.parseInt(quantitytf.getText());
        List<Actor> actorList = new ArrayList<>();
        String[] actorArr = actorstf.getText().split(",");
        for(String str : actorArr){
            String[] fullname = str.trim().split(" ");
            Actor actor = new Actor(fullname[0],fullname[1]);
            actorList.add(actor);
        }
        String id = FileStorageUtil.getId(FileStorageUtil.StorageType.MOVIES);
        String[] directorArr = directorstf.getText().split(" ");
        Director dir = new Director(directorArr[0], directorArr[1]);
        business.Movie newMovie = new business.Movie(id, title, format, genre,actorList,dir, quantity,price);
        return newMovie;
    }

    private void setModelEmpty() {
        titletf.setText("");
        formattf.setText("");
        genretf.setText("");
        pricetf.setText("");
        quantitytf.setText("");
        actorstf.setText("");
        directorstf.setText("");
    }

    private void addMovie() {
        business.Movie newMovie = getMovie();
        if(newMovie == null) {
            return;
        }
        FileStorageUtil.saveObject(newMovie.getId(),newMovie, FileStorageUtil.StorageType.MOVIES);
        JOptionPane.showMessageDialog(null, "Added Successfully");
        setModelEmpty();
        initializeTable();
    }
    private void updateMovie() {
        int r = table.getSelectedRow();
        if(r>=0) {
            String id = model.getValueAt(r, 0).toString();
            business.Movie newMovie = getMovie();
            newMovie.setId(id);
            FileStorageUtil.saveObject(id, newMovie, FileStorageUtil.StorageType.MOVIES);
            setModelEmpty();
            initializeTable();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        }
    }
    private void initializeTable() {
        String[] column = {"Id", "Title", "Format","Genre","Price","Quantity","Availability","Actors","Directors"};
        Object[][] movies = getMovies();
        model = new DefaultTableModel(movies, column);
        table.setModel(model);
    }
    private void deleteMovie(){

        int r = table.getSelectedRow();
        if(r>=0) {
            String id = model.getValueAt(r, 0).toString();
            FileStorageUtil.deleteObject(id, FileStorageUtil.StorageType.MOVIES);
            initializeTable();
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
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
        bframe.setResizable(false);


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


        actorstf = new JTextField();
        actorstf.setBounds(129, 247, 500, 26);
        panel.add(actorstf);
        actorstf.setColumns(10);

        directorstf = new JTextField();
        directorstf.setBounds(129, 287, 500, 26);
        panel.add(directorstf);
        directorstf.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 340, 750, 287);
        panel.add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                titletf.setText(model.getValueAt(r, 1).toString());
                formattf.setText(model.getValueAt(r, 2).toString());
                genretf.setText(model.getValueAt(r, 3).toString());
                pricetf.setText(model.getValueAt(r, 4).toString());
                quantitytf.setText(model.getValueAt(r, 5).toString());
                actorstf.setText(model.getValueAt(r, 7).toString().replaceAll("[\\[\\]]",""));
                directorstf.setText(model.getValueAt(r, 8).toString());
            }
        });
        table.setBackground(new Color(255, 240, 245));
        initializeTable();
        scrollPane.setViewportView(table);

        JButton btnadd = new JButton("Add");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   addMovie();
            }
        });
        btnadd.setBounds(450, 15, 117, 29);
        panel.add(btnadd);

        JButton btndel = new JButton("Delete");
        btndel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteMovie();

            }
        });
        btndel.setBounds(600, 15, 117, 29);
        panel.add(btndel);

        JButton btnupdate = new JButton("Update");
        btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
                    updateMovie();
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
                MainWindow mWindow = new MainWindow();

                mWindow.mframe.setVisible(true);
            }
        });
        btnback.setBounds(510, 107, 117, 29);
        panel.add(btnback);


    }
}
