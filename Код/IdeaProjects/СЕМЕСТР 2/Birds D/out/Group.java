import java.awt.*;
import java.util.ArrayList;

public class Group extends ArrayList<Bird> {
    //private ArrayList<Bird> array;
    public Group(){
        //array = new ArrayList<>();
        //group.add(new Parrot());
        //group.add(new Parrot());
        //group.add(new Penguin());
    }

    /*public void draw(){
        for (int i =0;i<group.size();i++){
            ;
        }
    }*/
    /*public void add(Bird b){
        this.add(b);
    }*/
    public void union(Group g){
        for(int i = 0; i < g.size();i++){
            this.add(g.get(i));
        }
    }


    public void fly(){
       for(int i = 0; i < this.size();i++){
            this.get(i).fly();
        }
    }
    public void draw(Graphics g){
        for(int i = 0; i < this.size();i++){
            this.get(i).draw(g);
            this.get(i).cage(g);
        }
    }
}
