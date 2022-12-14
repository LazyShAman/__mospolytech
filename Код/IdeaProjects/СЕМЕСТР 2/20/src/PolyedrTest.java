import java.util.*;

//Тест для полиэдра.
public class PolyedrTest{
    public static void main(String[] args) throws Exception{
        //Исключительная ситуация возникает при ошибках
        //чтения или преобразования данных из файла.

        //IntelliJ IDEA: Add Configuration... -> Templates -> Application -> Program arguments -> [Файл]
        //Polyedr p = new Polyedr(args[0]); //args -- массив аргументов командной строки

        int mk = 0;

        Polyedr p = new Polyedr("C:\\Users\\Asus\\IdeaProjects\\g1\\cube.geom");

        System.out.print("Возможные типы изображения полиэдра:\n" +
                "0) без удаления невидимых частей ребер - 0;\n" +
                "1) с удалением невидимых частей ребер - 1.\n" +
                "Выберите тип изображения (от 0 до 1) -> ");

        Scanner in = new Scanner(System.in);
        int type = in.nextInt();

        while(true){
            R3Vector pr = new R3Vector();

            System.out.print("Угол поворота в плоскости проекции (в градусах) -> ");
            double angle = in.nextDouble();

            switch(type){
                case 0:
                    SimpleDrawer d = new SimpleDrawer(p, pr, Math.toRadians(angle));
                    d.draw();
                    System.out.println(d.Sch());
                    break;
                case 1:
                    ShadowDrawer sd = new ShadowDrawer(p, pr, Math.toRadians(angle));
                    sd.draw();
                    System.out.println(sd.Sch());
                    break;
                default:
                    System.out.println("Неверный тип изображения.");
            }

            //Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        }
    }
}
