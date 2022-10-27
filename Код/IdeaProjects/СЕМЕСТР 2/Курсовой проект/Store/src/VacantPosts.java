import java.util.Observable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacantPosts extends Observable {
    private Connection connection;
    private List<VacantPost> posts;

    public VacantPosts(DBConnection connection){
        this.connection = connection.getConnection();
        posts = new ArrayList<>();
    }

    public void select(){
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, name, short_name FROM posts WHERE id NOT IN (SELECT post_id FROM staff)";
            ResultSet result = statement.executeQuery(query);

            posts.clear();
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String short_name = result.getString("short_name");

                //Переход от реляционной модели к объектной!
                posts.add(new VacantPost(id, name, short_name));

                System.out.print("Vacant post: ");
                System.out.print("id = " + id);
                System.out.print(", name = \"" + name + "\"");
                System.out.println(", short name = \"" + short_name + "\".");
            }
            System.out.println("--------");

            //connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        this.setChanged();
        this.notifyObservers(); //this.notifyObservers(obj);
    }

    public List<VacantPost> getAll(){
        return posts;
    }
}