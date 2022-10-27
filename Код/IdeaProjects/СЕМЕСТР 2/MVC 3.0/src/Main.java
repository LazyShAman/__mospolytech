import javax.swing.*;
import java.awt.*;

// PropertyChangeListener
// PropertyChangeSupport
public class Main extends JFrame {
    public Main() {
        this.setTitle("MVC");
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(2, 1));

        JPanel j = new JPanel();
        Container c = j;
        c.setLayout(new GridLayout(1,2));
        pane.add(j);

        Counter counter = new Counter(); // model
        MyPanel panel = new MyPanel(counter); // viewer
        MyButton plus = new MyButton(counter, panel, '+'); // controller
        MyButton minus = new MyButton(counter, panel, '-');

        pane.add(panel);
        pane.add(plus);
        pane.add(minus);

        this.setVisible(true);
        counter.addObserver(plus);
        counter.addObserver(minus);
    }

    public static void main(String[] args) {
        new Main();
    }
}
