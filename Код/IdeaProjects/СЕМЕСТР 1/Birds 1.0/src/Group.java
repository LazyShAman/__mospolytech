import java.awt.*;
import java.util.ArrayList;

public class Group extends ArrayList<Bird> {
    public Group() { ; }

    public void union(Group g) {
        this.addAll(g);
    }

    public void fly() {
        for (Bird bird : this)
            bird.fly();
    }

    public void draw(Graphics g) {
        for (Bird bird : this) {
            bird.draw(g);
            bird.borderline(g);
        }
    }
}
