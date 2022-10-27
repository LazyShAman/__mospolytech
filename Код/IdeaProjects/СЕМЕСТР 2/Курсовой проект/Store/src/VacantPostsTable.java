import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VacantPostsTable extends JPanel {
    private VacantPosts posts;
    private JScrollPane pane;
    private JTable table;
    private DefaultTableModel model;

    public VacantPostsTable(VacantPosts vacant_posts){
        this.posts = vacant_posts;
        model = new DefaultTableModel(new String[]{"Id", "Name", "Short name"}, 0);
        table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        pane = new JScrollPane(table);
        this.add(pane);
    }

    public void setModel(VacantPosts posts){
        model = new DefaultTableModel(new String[]{"Id", "Name", "Short name"}, 0);
        List<VacantPost> p = posts.getAll();
        for(int i = 0; i < p.size(); i++){
            model.addRow(new String[]{String.valueOf(p.get(i).getId()),
                    p.get(i).getName(), p.get(i).getShortName()});
        }
        table.setModel(model);
    }
}