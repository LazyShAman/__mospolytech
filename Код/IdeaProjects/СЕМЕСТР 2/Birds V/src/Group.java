import java.awt.*;
import java.util.ArrayList;

public class Group extends ArrayList<Bird> {
    //ArrayList<Bird> array;
    //private ArrayList<Bird> array;
    public Group(){
        ArrayList<Bird> array = new ArrayList<Bird>();
        //ArrayList<Bird> array;
        //group.add(new Parrot());
        //group.add(new Parrot());
        //group.add(new Penguin());
    }

    public void add(Bird bird){
        this.add(bird);
    }

    public void union(Group group){
        for(int i = 0; i < group.this.size(); i++){
            this.add(group.this.get(i));
        }
    }

    public void fly(){
        for(int i = 0; i < this.size(); i++){
            this.get(i).fly();
        }
    }
    public void draw(Graphics graphics){
        for(int i = 0; i < this.size(); i++){
            this.get(i).draw(graphics);
            this.get(i).borderline(graphics);
        }
    }
}
