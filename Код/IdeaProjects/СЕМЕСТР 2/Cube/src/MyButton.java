import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MyButton extends JButton implements Observer {
    private Cube _cube;
    private final Screen _screen;

    public MyButton(Cube cube, Screen screen, int number) {
        this._cube = cube;
        this._screen = screen;
        if (number == 1)
            this.setText("Transparent");

        if (number == 2)
            this.setText("Orthogonal");

        if (number == 3)
            this.setText("Perspective");

        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);
    }

    public void update(Observable o, Object arg) {
        _cube = (Cube) o;
        _screen.repaint();
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { }
    }
}
