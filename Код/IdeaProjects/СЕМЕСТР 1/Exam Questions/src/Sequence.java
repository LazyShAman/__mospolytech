/* Реализация поиска наименьшего общего кратного (НОК) через алгоритм Евклида */

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Sequence {
    // length of the sequence
    private final int len;
    private final int[] Sequence;

    // constructor
    public Sequence() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the sequence: ");
        String line = in.nextLine();
        String[] data = line.split(" ");
        this.len = data.length;
        this.Sequence = new int[len];

        for (int element = 0; element < len; element++) {
            Sequence[element] = Integer.parseInt(data[element]);
        }
    }

    public Sequence(String line) {
        String[] data = line.split(" ");
        this.len = data.length;
        this.Sequence = new int[len];

        for (int element = 0; element < len; element++) {
            Sequence[element] = Integer.parseInt(data[element]);
        }
    }

    // deep copy
    public Sequence(Sequence data) {
        this.len = data.len;
        this.Sequence = new int[len];

        for (int element = 0; element < len; element++) {
            Sequence[element] = data.getElement(element);
        }
    }

    public int getElement(int element) {
        return this.Sequence[element];
    }

    public void setElement(int element, int newElement) {
        this.Sequence[element] = newElement;
    }

    public void sortSequence() {
        boolean flag = false;
        int t;

        while (!flag) {
            flag = true;
            for (int i = 0; i < len - 1; i++) {
                if (this.getElement(i) > this.getElement(i + 1)) {
                    flag = false;

                    t = this.getElement(i);
                    this.setElement(i, this.getElement(i + 1));
                    this.setElement(i + 1, t);
                }
            }
        }
    }

    public void printSequence() {
        System.out.print("The sequence is:");
        for (int element = 0; element < len; element++) {
            System.out.printf("%4s", this.Sequence[element]);
        }
    }

    // Least Common Multiply
    public static int LCMs(int A, int B) {
        return A * B / GCDs(A, B);
    }

    // Greatest Common Divisor
    public static int GCDs(int A, int B) {
        // II. НОД(A, 0) = A для любого ненулевого A (так как 0 делится на любое целое число)
        if (B == 0)
            return A;
        else
            // I. Пусть A = Bn + d, тогда НОД (A, B) = НОД (B, d)
            // A = Bn + d, d = A % B
            return GCDs(B, A % B);
    }

    public static int lcmForSequences(Sequence seq) {
        int result = seq.getElement(0);
        if (seq.len > 1) {
            for (int element = 1; element < seq.len; element++) {
                result = LCMs(result, seq.getElement(element));
            }

        }
        System.out.print("The least common multiply of this sequence is " + result);
        return result;
    }

    public static void toEqualize(Sequence data) {
        int subSum = 0, sum = 0, storage = 0;
        Sequence temp = new Sequence(data);
        temp.sortSequence();

        // sum all elements of the sequence
        for (int element = 0; element < temp.len; element++) {
            sum += temp.getElement(element);
        }

        // reduce half-sum per element and store the subtrahend
        sum = sum / 2;
        for (int element = temp.len - 1; element > -1; element--) {
            if (sum >= temp.getElement(element)) {
                sum -= temp.getElement(element);
                storage += temp.getElement(element);
                temp.setElement(element, 0);
            } else
                subSum += temp.getElement(element);
        }

        // if variable sum is not empty, the equalisation is impossible
        if (sum != 0) {
            System.out.println("It is impossible");
        } else {
            if (subSum == storage)
                System.out.println("It is possible");
            else
                System.out.println("It is impossible");
        }
    }

    public static Sequence closestPoint(Sequence xSeq, Sequence ySeq) {
        int i = 0;
        double dist = -1, tempDist = 0;
        for (int pair = 0; pair < xSeq.len; pair++) {
            for (int term = 0; term < xSeq.len; term++) {
                tempDist += sqrt(pow(xSeq.getElement(pair) - xSeq.getElement(term), 2)
                        + pow(ySeq.getElement(pair) - ySeq.getElement(term), 2));
            }
            //System.out.println(tempDist);
            if (dist == -1 || dist > tempDist) {
                dist = tempDist;
                i = pair;
            }
            tempDist = 0;
        }

        String point = xSeq.getElement(i) + " " + ySeq.getElement(i);
        return new Sequence(point);
    }

    public void oddEqualsEven() {
        boolean equals = false;

        for (int even = 0; even < len; even += 2) {
            for (int odd = 1; odd < len; odd += 2) {
                if (this.getElement(even) == this.getElement(odd)) {
                    equals = true;
                    break;
                }
            }
        }

        if (equals)
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    public Sequence maxNonIncreasing() {
        String sub = Integer.toString(this.getElement(0));
        String subSeq = "";
        for (int element = 1; element < len; element++) {
            if (this.getElement(element - 1) >= this.getElement(element)) {
                sub += " " + this.getElement(element);
            } else {
                if (subSeq.split(" ").length < sub.split(" ").length)
                    subSeq = sub;
                sub = Integer.toString(this.getElement(element));
            }
        }
        if (subSeq.split(" ").length < sub.split(" ").length)
            subSeq = sub;

        return new Sequence(subSeq);
    }

    public Sequence maxMonotone() {
        String sub = Integer.toString(this.getElement(0));
        String subSeq = "";
        for (int element = 1; element < len; element++) {
            if (this.getElement(element - 1) == this.getElement(element)) {
                sub += " " + this.getElement(element);
            } else {
                if (subSeq.split(" ").length < sub.split(" ").length)
                    subSeq = sub;
                sub = Integer.toString(this.getElement(element));
            }
        }
        if (subSeq.split(" ").length < sub.split(" ").length)
            subSeq = sub;

        return new Sequence(subSeq);
    }

    public Sequence twoSubSeqs() {
        boolean flag = false;
        int subLen = 0, maxSame = 0, d = 0;
        String subSeq = "", st = "";

        for (int i = 0; i < len; i++) {
            for (int k = i + 1; k < len; k++) {
                if (this.getElement(i) == this.getElement(k)) {
                    flag = true;
                }

                if (flag) {
                    if (this.getElement(k - (1 + d)) == this.getElement(k)) {
                        st += this.getElement(k) + " ";
                        subLen++;
                    } else {
                        if (maxSame < subLen) {
                            maxSame = subLen;
                            subSeq = st;
                        }
                        subLen = 0;
                        st = "";
                        flag = false;
                        d = k - (i + 1);
                    }
                } else
                    d++;
            }
            flag = false;
            d = 0;
        }

        if (!subSeq.equals(""))
            return new Sequence(subSeq);
        else
            return new Sequence("-1");
    }

    public Sequence twoMirroredSeqs() {
        boolean flag = false;
        int subLen = 0, maxSame = 0;
        String subSeq = "", st = "";

        for (int i = 0; i < len; i++) {
            int t = i;
            for (int k = len - 1; k >= i; k--) {
                if (this.getElement(i) == this.getElement(k)) {
                    flag = true;
                }

                if (flag) {
                    if (this.getElement(t) == this.getElement(k)) {
                        st += this.getElement(k) + " ";
                        subLen++;
                        t++;
                    } else {
                        if (maxSame < subLen) {
                            maxSame = subLen;
                            subSeq = st;
                        }
                        subLen = 0;
                        st = "";
                        flag = false;
                    }
                } else {
                    if (maxSame < subLen) {
                        maxSame = subLen;
                        subSeq = st;
                    }
                    subLen = 0;
                    st = "";
                    t = i;
                }
            }
            flag = false;
        }

        if (!subSeq.equals(""))
            return new Sequence(subSeq);
        else
            return new Sequence("-1");
    }
}
