

package rushtree;

public class MyAtoI {

    public int myAtoi(String str) {
        String trim = str.trim();
        int len = trim.length();
        if (len == 0)
            return 0;
        char first = trim.charAt(0);
        if ((first >= '0' && first <= '9') || (first == '-' || first == '+')) {} else {
            return 0;
        }

        int st = 1;

        while (st < len && trim.charAt(st) >= '0' && trim.charAt(st) <= '9')
            st++;
        String subStr = trim.substring(0, st);
        try {
            if (subStr.length() == 1 && (first == '-' || first == '+'))
                return 0;
            return Integer.parseInt(subStr);
        } catch (NumberFormatException e) {
            if (first == '-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }

    }

    public static void main(String[] args) {
        MyAtoI myAtoI = new MyAtoI();
        System.out.println(myAtoI.myAtoi("42"));
        System.out.println(myAtoI.myAtoi("   -42"));
        System.out.println(myAtoI.myAtoi("4193 with words"));
        System.out.println(myAtoI.myAtoi("words and 987"));
        System.out.println(myAtoI.myAtoi("-91283472332"));
        System.out.println(myAtoI.myAtoi("+-2"));
    }

}
