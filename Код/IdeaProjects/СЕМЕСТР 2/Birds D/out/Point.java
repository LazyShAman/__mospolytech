public class Point {
    private int x = 50;
    private int y = 50;
    public Point(int x,int y)
    {
        this.x = x;
        this.y = y;
        //x = (int)(Math.random() * (MyFrame.width_work)) - MyFrame.width_work/2;
        //y = (int)(Math.random() * (MyFrame.height_work)) - MyFrame.height_work/2;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
}
