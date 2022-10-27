import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        this.setTitle("STAFF");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container basic_pane = this.getContentPane();
        basic_pane.setLayout(new BoxLayout(basic_pane, BoxLayout.Y_AXIS));

        DBConnection connection = new DBConnection();
        VacantPosts posts = new VacantPosts(connection); //Model
        VacantPostsTable posts_table = new VacantPostsTable(posts); //View
        VacantPostsButton posts_button = new VacantPostsButton(posts, posts_table); //Controller

        basic_pane.add(posts_table);
        basic_pane.add(posts_button);
        posts_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.pack();
        this.setVisible(true);

        posts.addObserver(posts_button);
    }

    public static void main(String[] args){
        new Main();
    }
}