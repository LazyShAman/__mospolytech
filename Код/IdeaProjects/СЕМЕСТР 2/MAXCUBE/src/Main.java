import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Main extends JFrame {

    private static Cube cube;
    private static Screen screen;
    public static int function = 2;
    public static boolean click = true;


    public static JToggleButton buttonTransparent = new JToggleButton("Transparent", false);
    public static JToggleButton buttonOrthogonal = new JToggleButton("Orthogonal", true);
    public static JToggleButton buttonPerspective = new JToggleButton("Perspective", false);

    public static void main(String[] args) {
        cube = new Cube();
        cube.translate(-0.5, -0.5, -0.5);
        cube.scale(80);
        //cube.rotate(45, 45, 45);
        screen = new Screen(cube); //model

        Main controller = new Main(cube, screen);
    }

    public Main(Cube cube, Screen screen){

        this.cube = cube;
        this.screen = screen;

        this.setTitle("Cube");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        JPanel pane1 = new JPanel();
        pane1.setLayout(new GridLayout(1, 3));
        JPanel pane2 = new JPanel();
        pane2.setLayout(new GridLayout(1, 1));

//        JToggleButton buttonTransparent = new JToggleButton("Transparent", true);
//        JToggleButton buttonOrthogonal = new JToggleButton("Orthogonal", false);
//        JToggleButton buttonPerspective = new JToggleButton("Perspective", false);

//        Transparent buttonTransparent = new Transparent(cube, screen);
//        Orthogonal buttonOrthogonal = new Orthogonal(cube, screen);
//        Perspective buttonPerspective = new Perspective(cube, screen);// controller

        pane.add(pane1, BorderLayout.NORTH);
        pane1.add(buttonTransparent);
        pane1.add(buttonOrthogonal);
        pane1.add(buttonPerspective);
        pane.add(pane2, BorderLayout.CENTER);
        pane2.add(screen);

        //screen.addObserver(buttonTransparent);

        this.setVisible(true);
        screen.setFocusable(true);
        screen.requestFocusInWindow();

        screen.addKeyListener(new KeyListener(){
            //Клавиша нажата и отпущена.
            public void keyTyped(KeyEvent ke) { ;}

            //Клавиша отпущена.
            public void keyReleased(KeyEvent e) {;}

            //Клавиша нажата, но не отпущена.
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                switch(keyCode) {
                    case KeyEvent.VK_UP:
                        cube.rotate(-3, 0, 0);
                        screen.update(screen.getGraphics());
                        break;
                    case KeyEvent.VK_DOWN:
                        cube.rotate(3, 0, 0);
                        screen.update(screen.getGraphics());
                        break;
                    case KeyEvent.VK_LEFT:
                        cube.rotate(0, 3, 0);
                        screen.update(screen.getGraphics());
                        break;
                    case KeyEvent.VK_RIGHT:
                        cube.rotate(0, -3, 0);
                        screen.update(screen.getGraphics());
                        break;
                }
            }
        });

        TransparentListener listener1 = new TransparentListener();
        buttonTransparent.addActionListener(listener1);

        OrthogonalListener listener2 = new OrthogonalListener();
        buttonOrthogonal.addActionListener(listener2);

        PerspectiveListener listener3 = new PerspectiveListener();
        buttonPerspective.addActionListener(listener3);

    }


//    JToggleButton buttonTransparent = new JToggleButton("Transparent", true);
//    JToggleButton buttonOrthogonal = new JToggleButton("Orthogonal", false);
//    JToggleButton buttonPerspective = new JToggleButton("Perspective", false);


    private class TransparentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(buttonOrthogonal.isSelected()) {
                function = 2;
                screen.repaint();
                screen.requestFocusInWindow();
            }
            if(buttonPerspective.isSelected()) {
                function = 3;
                screen.repaint();
                screen.requestFocusInWindow();
            }
        }
    }

    private class OrthogonalListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click) {
                click = false;
                function = 2;
                if(!buttonOrthogonal.isSelected()) {
                    buttonOrthogonal.doClick();
                }
                if(buttonPerspective.isSelected()) {
                    buttonPerspective.doClick();
                }
                screen.repaint();
                screen.requestFocusInWindow();
                click = true;
            }
        }
    }

    private class PerspectiveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(click) {
                click = false;
                function = 3;
                if(!buttonPerspective.isSelected()) {
                    buttonPerspective.doClick();
                }
                if(buttonOrthogonal.isSelected()) {
                    buttonOrthogonal.doClick();
                }
                screen.repaint();
                screen.requestFocusInWindow();
                click = true;
            }
        }
    }

}
