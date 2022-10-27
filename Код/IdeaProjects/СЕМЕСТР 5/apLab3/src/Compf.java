// Стековый компилятор формул.
public class Compf extends Stack {
    // Типы символов (скобки, знаки операций, иное).
    protected final static int SYM_LEFT = 0,
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3,
            SYM_DOT = 4,
            SYM_STOP = 5;
    public static boolean flag = false;
    public static boolean isDouble = false;
    public static int n = 0;
    public static boolean isNegative = true;
    public static int k = 0;
    public static String stopChar;
    public static boolean stop;

    private int symType(char c) {
        switch (c) {
            case '(':
            case '[':
            case '{':
                return SYM_LEFT;
            case ')':
            case ']':
            case '}':
                return SYM_RIGHT;
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return SYM_OPER;
            case '.':
                isDouble = true;
                n = 1;
                return SYM_DOT;
            default:
                return symOther(c);
        }
    }

    private void processSymbol(char c) {
        switch (symType(c)) {
            case SYM_LEFT:
                flag = false;
                isDouble = false;
                push(c);
                break;
            case SYM_RIGHT:
                if (flag && k > 1) isNegative = true;

                flag = false;
                isDouble = false;
                processSuspendedSymbols(c);
                pop();

                isNegative = false;
                k = 0;
                break;
            case SYM_OPER:
                if (flag && k > 1) isNegative = true;

                flag = false;
                isDouble = false;
                processSuspendedSymbols(c);
                push(c);
                isNegative = true;
                k++;
                break;
            case SYM_OTHER:
                isNegative = false;
                if (k < 2) k = 0;
                nextOther(c);
                flag = true;
                break;
            case SYM_DOT:
            case SYM_STOP:
                break;
        }
    }

    private void processSuspendedSymbols(char c) {
        while (precedes(top(), c))
            nextOper(pop());
    }

    // определяет приоритет операции
    private int priority(char c) {
        if (c == '^')
                return 3;
        return c == '+' || c == '-' ? 1 : 2;
    }

    private boolean precedes(char a, char b) {
        if (symType(a) == SYM_LEFT) return false;
        if (symType(b) == SYM_RIGHT) return true;

        return priority(a) >= priority(b);
    }

    protected int symOther(char c) {
        if (c < 'a' || c > 'z') {
            System.out.println("Invalid character: " + c);
            System.exit(0);
        }

        return SYM_OTHER;
    }

    protected void nextOper(char c) {
        System.out.print("" + c + " ");
    }

    protected void nextOther(char c) {
        nextOper(c);
    }

    public String compile(char[] str) {
        k = 1;

        processSymbol('(');

        for (int i = 0; i < str.length; i++)
            if (stop) break;
            else processSymbol(str[i]);

        if (!stop) processSymbol(')');

        System.out.print("\n");

        return "";
    }
}