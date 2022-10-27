//Калькулятор арифметических формул.
public class Calc extends Compf {
    private final StackDouble s;
    public Calc() {
        s = new StackDouble();
    }

    private static double char2double(char c) {
        return (double) c - (double) '0';
    }

    @Override
    protected int symOther(char c) {
        if ((c < '0' || c > '9') && c != '.') {
//            System.out.println("Invalid character: " + c);
            stop = true;
            stopChar = "Invalid character: " + c;
//            System.exit(0);
            return SYM_STOP;
        }

        return SYM_OTHER;
    }

    @Override
    protected void nextOper(char c) {
        double second = s.pop();
        double first;
        if (isNegative) {
            first = 0;
            k -= 2;
        } else
            first = s.pop();

        switch (c) {
            case '+':
                s.push(first + second);
                break;
            case '-':
                s.push(first - second);
                break;
            case '*':
                s.push(first * second);
                break;
            case '/':
                s.push(first / second);
                break;
            case '^':
                s.push((int) Math.pow(first, second));
                break;
        }
    }

    @Override
    protected void nextOther(char c) {
        if (flag)
            if (isDouble) {
                s.push(s.pop() + char2double(c) / Math.pow(10, n));
                n++;
            } else
                s.push(s.pop() * 10 + char2double(c));
        else
            s.push(char2double(c));
    }

    public final String compile(char[] str) {
        super.compile(str);

//        System.out.println("" + s.top());

        if (stop) {
            return stopChar;
        } else {
            return "Answer is " + s.top();
        }
    }
}
