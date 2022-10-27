import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


public class MyButton extends JButton implements Observer {
    private Counter counter;
    private MyPanel panel;


    public MyButton(Counter counter, MyPanel panel, char c) {
        if (c == '+') {
            this.setText("+");
            MyButtonListener listener = new MyButtonListener();//создаем наблюдателя
            this.addActionListener(listener);//закрепляем наблюдателя за кнопкой
            this.counter = counter;
            this.panel = panel;
        }

        if (c == '-') {
            this.setText("-");
            MyButtonListener1 listener1 = new MyButtonListener1();
            this.addActionListener(listener1);//закрепляем наблюдателя за кнопкой
            this.counter = counter;
            this.panel = panel;
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        counter = (Counter) o;
        panel.setStr(counter.getCounter());
        panel.repaint();

    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter.increment();
        }
    }

    private class MyButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter.decrement();
        }
    }
}

