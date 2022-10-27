import java.awt.*;

public class Sparrow extends Bird {

    private static int xx = MyFrame.width_work;
    private static int XX = MyFrame.width_work * -1;
    private static int yy = MyFrame.height_work;
    private static int YY = MyFrame.width_work * -1;
    private static int num = 0;
    private static int count = 0;

    public Sparrow(){
        size = 8;
        color = Color.gray;

        num++;
        System.out.println("Я воробей! Нас уже " + num + " шт.");
    }
    @Override
    public void borderline(Graphics graphics){
        graphics.setColor(Color.lightGray);
        count++;
        //------------------------------------ Не трогай убьет ------------------------------
        if(num > 1) {
            //System.out.println("x = " + x);
            //System.out.println("y = " + y);
            if(_p.getx() > XX)
                XX = _p.getx();
            if (xx > _p.getx())
                xx = _p.getx();
            if(_p.gety() > YY)
                YY = _p.gety();
            if(_p.gety() < yy)
                yy = _p.gety();

            if(count == num) {
                graphics.drawRect(xx, yy, XX - xx + size, YY - yy + size);
            }
            //else graphics.drawLine(x, y, x, y);
        }
        else
            graphics.drawRect(_p.getx(), _p.gety(), size, size);
    }
}