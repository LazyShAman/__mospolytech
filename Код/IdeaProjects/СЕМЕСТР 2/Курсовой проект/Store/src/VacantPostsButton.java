import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class VacantPostsButton extends JButton implements Observer{
    private VacantPosts posts;
    private VacantPostsTable posts_table;

    public VacantPostsButton(VacantPosts posts, VacantPostsTable posts_table){
        this.setText("Vacant posts");

        VacantPostsButtonListener listener = new VacantPostsButtonListener();
        this.addActionListener(listener);

        this.posts = posts;
        this.posts_table = posts_table;
    }

    public void update(Observable o, Object arg) {
        posts = (VacantPosts) o;
        posts_table.setModel(posts);
        posts_table.repaint();
    }

    private class VacantPostsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            posts.select();
        }
    }
}