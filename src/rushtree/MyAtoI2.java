
package rushtree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rushtree.MyAtoI;

public class MyAtoI2 {

    public int myAtoi(String str) {
        String trim = str.trim();
        if (trim.length() == 0)
            return 0;
        String reg = "^([-+]{0,1}[0-9]{1,})[^0-9]{0,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(trim);
        char first = trim.charAt(0);
        if (matcher.find()) {
            String result = matcher.group(1);
            try {
                return Integer.parseInt(result);
            } catch (NumberFormatException e) {
                if (first == '-')
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
        }
        return 0;

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
