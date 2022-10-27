import java.awt.geom.Line2D;
import java.util.*;
import java.io.*;

//Тест для полиэдра.
public class PolyedrTest{
    public static void main(String[] args) throws Exception{ //Аргумент args - массив аргументов командной строки.
        //Исключительная ситуация возникает при ошибках
        //чтения или преобразования данных из файла.

        //IntelliJ IDEA: Add Configuration.. -> Templates -> Application -> Program arguments -> [Файл]
        //Polyedr p = new Polyedr(args[0]);
        Polyedr p = new Polyedr("C:\\Users\\NovacJunior\\IdeaProjects\\Cow\\src\\Новая папка\\cube.geom");
        System.out.print("Возможные типы изображения полиэдра;\n" +
                "0) без удаления невидимых линий - 0,\n" +
                "1) с удалением невидимых ребер - 1.\n" +
                "Выберите тип изображения (от 0 до 1) -> ");

        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        System.out.print("\n");

        System.out.println(Line2D.linesIntersect(1,1 ,1,5,1,1,1,5));
        System.out.println(
                Arrays.toString(ShadowDrawer.findIntersection(1,1 ,1,5,1,1,1,5)));

        while(true){
            R3Vector pr = new R3Vector();

            System.out.print("Угол поворота в плоскости проекции (в градусах) -> ");
            double angle = in.nextDouble();
            System.out.print("\n");

            switch(type){
                case 0:
                    SimpleDrawer d = new SimpleDrawer(p, pr, Math.toRadians(angle));
                    d.draw();
                    break;
                case 1:
                ShadowDrawer sd = new ShadowDrawer(p, pr, Math.toRadians(angle));
                //sd.draw();
                    sd.contour();
                break;
                default:
                    System.out.println("Неверный тип изображения.");
            }

            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        }
    }
}
