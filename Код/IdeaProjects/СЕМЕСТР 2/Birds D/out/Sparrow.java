import java.awt.*;
public class Sparrow extends Bird{
    private static int min_x = MyFrame.width_work;
    private static int max_x = MyFrame.width_work * -1;
    private static int min_y = MyFrame.height_work;
    private static int max_y = MyFrame.width_work * -1;
    private static int num = 0;
    private static int call = 0;
    public Sparrow()
    {
        size = 6;
        color = Color.gray;

        this.num++;
        System.out.println("Я воробей! Нас уже "+ num + "шт.");
    }
    @Override
    public void cage(Graphics g){
        g.setColor(Color.RED);
        this.call++;
        //System.out.println(this.num);
        if(this.num > 1) {
            if(p.get_x() > this.max_x){
                this.max_x = p.get_x();
            }
            if (this.min_x > p.get_x()){
                this.min_x = p.get_x();
            }
            if(p.get_y() > this.max_y){
                this.max_y = p.get_y();
            }
            if(p.get_y() < this.min_y){
                this.min_y = p.get_y();
            }
            if(this.call == this.num) {
                g.drawRect(this.min_x, this.min_y, this.max_x - this.min_x + this.size, this.max_y - this.min_y + this.size);
            }
        }
        else
            g.drawRect(p.get_x(), p.get_y(), this.size, this.size);
    }
}
