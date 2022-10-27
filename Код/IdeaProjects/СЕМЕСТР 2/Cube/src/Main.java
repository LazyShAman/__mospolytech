import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {
    private static Cube _cube;
    private static Screen _screen;
    public static int buttontype = 3;
    public static boolean click = true;

    public static JToggleButton Transparent = new JToggleButton("Transparent", false);
    public static JToggleButton Orthogonal = new JToggleButton("Orthogonal", true);
    public static JToggleButton Perspective = new JToggleButton("Perspective", false);

    public Main(Cube cube, Screen screen) {
        _cube = cube;
        _screen = screen;
        this.setTitle("C U B E");
        this.setSize(_screen._width, _screen._height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        JPanel viewer = new JPanel();
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3));
        viewer.setLayout(new GridLayout(1, 1));

        TransparentListener TL = new TransparentListener();
        Transparent.addActionListener(TL);

        OrthogonalListener OL = new OrthogonalListener();
        Orthogonal.addActionListener(OL);

        PerspectiveListener PL = new PerspectiveListener();
        Perspective.addActionListener(PL);


        pane.add(buttons, BorderLayout.NORTH);
        buttons.add(Transparent);
        buttons.add(Orthogonal);
        buttons.add(Perspective);
        pane.add(viewer, BorderLayout.CENTER);
        viewer.add(screen);

        this.setVisible(true);
        screen.setFocusable(true);
        screen.requestFocusInWindow();

        screen.addKeyListener(new KeyListener() {
            //Клавиша нажата и отпущена
            public void keyTyped(KeyEvent ke) {
            }

            //Клавиша отпущена
            public void keyReleased(KeyEvent e) {
            }

            //Клавиша нажата, но не отпущена
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        //System.out.println(keyCode);
                        cube.rotate(-5, 0, 0);
                        screen.update(screen.getGraphics());
                        break;
                    case KeyEvent.VK_DOWN:
                        //System.out.println(keyCode);
                        cube.rotate(5, 0, 0);
                        screen.update(screen.getGraphics());
                        break;
                    case KeyEvent.VK_LEFT:
                        //System.out.println(keyCode);
                        cube.rotate(0, 5, 0);
                        screen.update(screen.getGraphics());
                        break;
                    case KeyEvent.VK_RIGHT:
                        //System.out.println(keyCode);
                        cube.rotate(0, -5, 0);
                        screen.update(screen.getGraphics());
                        break;
                }
            }
        });
    }

    private static class TransparentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Orthogonal.isSelected()) {
                buttontype = 2;
                _screen.repaint();
                _screen.requestFocusInWindow();
            }
            if (Perspective.isSelected()) {
                buttontype = 3;
                _screen.repaint();
                _screen.requestFocusInWindow();
            }
        }
    }

    private static class OrthogonalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (click) {
                click = false;
                buttontype = 2;
                if (!Orthogonal.isSelected()) Orthogonal.doClick();
                if (Perspective.isSelected()) Perspective.doClick();
                _screen.repaint();
                _screen.requestFocusInWindow();
                click = true;
            }
        }
    }

    private static class PerspectiveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (click) {
                click = false;
                buttontype = 3;
                if (!Perspective.isSelected()) Perspective.doClick();
                if (Orthogonal.isSelected()) Orthogonal.doClick();
                _screen.repaint();
                _screen.requestFocusInWindow();
                click = true;
            }
        }
    }

    public static void main(String[] args) {
        _cube = new Cube();
        _cube.translate(-0.5, -0.5, -0.5);
        _cube.scale(80);
        _screen = new Screen(_cube);
        Main controller = new Main(_cube, _screen);
    }
}
