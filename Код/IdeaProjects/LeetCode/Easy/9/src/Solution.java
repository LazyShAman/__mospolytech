class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int xReverse = 0;
        while (x > xReverse) {
            xReverse = xReverse * 10 + x % 10;
            x /= 10;
        }

        return x == xReverse || x == xReverse / 10;
    }

    public static boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        int n = str.length();
        boolean flag = true;

        if (n % 2 == 1) {
            str = str.substring(0, n / 2) + str.substring(n / 2 + 1, n);
            n -= 1;
        }
        System.out.println(str);

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int n = String.valueOf(x).length();
        boolean flag = true;

        if (n % 2 == 1) {
            n = n / 2;
            x = (int) ((int) ((int) (x / Math.pow(10, (n + 1))) * Math.pow(10, n)) + x % Math.pow(10, n));
        } else {
            n = n / 2;
        }

        while (x > 0) {
            int a = (int) (x / Math.pow(10, n * 2 - 1));
            int b = x % 10;
            if (a != b) {
                flag = false;
                break;
            }
            x = (int) (x % Math.pow(10, (n * 2 - 1)));
            x = x / 10;
            n = n - 1;
        }

        return flag;
    }
}