public class RecursCompf {
    private static final int DEFSIZE = 255;
    private char[] str;
    private int index; //Число обработанных символов.
    private boolean flag = true;

    public void RecursCompf() {
        str = new char[DEFSIZE];
    }

    private void compileF() { // - компиляция формулы
        compileT();

        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            while (index < str.length) {
                if (str[index] == '+') {
                    flag = false;
                    index++;
                    compileT();
                    System.out.print(" +");
                    continue;
                }

                if (str[index] == '-') {
                    flag = false;
                    index++;
                    compileT();
                    System.out.print(" -");
                } else
                    return;
            }
    }

    private void compileT() { // - терм
        compileM();

        if (index < str.length && (str[index] == '*' || str[index] == '/'))
            while (index < str.length) {
                if (str[index] == '*') {
                    flag = false;
                    index++;
                    compileM();
                    System.out.print(" *");
                    continue;
                }

                if (str[index] == '/') {
                    flag = false;
                    index++;
                    compileM();
                    System.out.print(" /");
                } else
                    return;
            }
    }

    private void compileM() { // - множитель
        if (str[index] == '(' || str[index] == '{' || str[index] == '[') {
            index++;
            compileF();
            index++;
        } else if (str[index] == '+') {
            index++;
            compileM();
        } else if (str[index] == '-') {
            index++;
            compileM();
            System.out.print(" 0 -");
        } else {
            while (index < str.length && Character.toString(str[index]).matches("[A-Za-z]*"))
                compileV();
        }
    }

    private void compileV() {
        if (flag)
            System.out.print("" + str[index++] + "");
        else
            System.out.print(" " + str[index++] + "");
        flag = true;
    }

    public void compile(char[] str) {
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
}