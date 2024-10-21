package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

    JFrame mframe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.mframe.setVisible(true);
                    window.mframe.setTitle("Main Window");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        mframe = new JFrame();
        mframe.setBounds(100, 100, 450, 300);
        mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mframe.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBounds(16, 6, 434, 260);
        mframe.getContentPane().add(panel);
        panel.setLayout(null);

        JButton bookBtn = new JButton("Book Window");
        bookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Movie bWindow = new Movie();
                //bframe is a variable property given in design view
                bWindow.bframe.setVisible(true);

                mframe.dispose();
            }
        });
        bookBtn.setBounds(136, 101, 117, 29);
        panel.add(bookBtn);
    }
}
