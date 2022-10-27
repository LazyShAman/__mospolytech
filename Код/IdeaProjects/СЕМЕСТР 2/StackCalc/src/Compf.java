//Стековый компилятор формул.
public class Compf extends Stack {
    //Типы символов (скобки, знаки операций, иное).
    protected final static int SYM_LEFT = 0,
                               SYM_RIGHT = 1,
                               SYM_OPER = 2,
                               SYM_OTHER = 3;
    protected static boolean flag = true;
    protected static boolean div = false;
    protected static boolean multi = false;
    protected static boolean divide = false;

    private int symType(char c) {
        switch (c) {
            case '(':
                return SYM_LEFT;
            case ')':
                return SYM_RIGHT;
            case '+':
            case '-':
                if (div) nextOther('1');
                return SYM_OPER;
            case '*':
                multi = true;
                return SYM_OPER;
            case '/':
                divide = true;
                return SYM_OPER;
            default:
                if (c == '1') {
                    if (divide)
                        pop();
                    div = true;
                } else if (divide)
                    nextOther('1');
                return symOther(c);
        }
    }

    private void processSymbol(char c) {
        switch (symType(c)) {
            case SYM_LEFT:
                push(c);
                break;
            case SYM_RIGHT:
                processSuspendedSymbols(c);
                pop();
                break;
            case SYM_OPER:
                flag = false;
                if (!divide && !multi)
                    processSuspendedSymbols(c);
                push(c);
                break;
            case SYM_OTHER:
                if (!div) {
                    nextOther(c);
                    flag = true;
                }
                break;
        }
    }

    private void processSuspendedSymbols(char c) {
        while (precedes(top(), c))
            nextOper(pop());
    }

    private int priority(char c) {
        return c == '+' || c == '-' ? 1 : 2;
    }

    private boolean precedes(char a, char b) {
        if (symType(a) == SYM_LEFT)
            return false;
        if (symType(b) == SYM_RIGHT)
            return true;

        return priority(a) >= priority(b);
    }

    protected int symOther(char c) {
        if ((c < 'a' || c > 'z') && c != '1') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }

        return SYM_OTHER;
    }

    protected void nextOper(char c) {
        if (flag)
            System.out.print("" + c + "");
        else
            System.out.print(" " + c + "");
        flag = false;
    }

    protected void nextOther(char c) {
        nextOper(c);
    }

    public void compile(char[] str) {
        processSymbol('(');

        for (int i = 0; i < str.length; i++)
            processSymbol(str[i]);

        flag = false;
        processSymbol(')');
        flag = true;
        System.out.print("\n");
    }
}