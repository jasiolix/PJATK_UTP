package Task4.zad1;

import javax.swing.*;

/*
Complete the missing elements of the program so that
clicking on the button, hovering over the button, or exiting the button would display the message “OK”.
 */
class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                ()-> {
                    JFrame f = new JFrame();
                    JButton b = new JButton("Mouse click");
                    b.addMouseListener (
                        (MousePressListener) e -> System.out.println("ok")
                    );
                    f.add(b);
                    f.pack();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setVisible(true);
                }
        );
    }
}