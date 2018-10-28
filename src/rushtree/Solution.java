package rushtree;

class Solution {

    public static final String floatReg1 = "^([-+]?\\d+)(\\.\\d*)$";
    public static final String floatReg2 = "^([-+]?\\d*)(\\.\\d+)$";
    public static final String intReg = "^[-+]?\\d+$";

    public boolean isNumber(String s) {
        if (s == null)
            return false;
        s = s.trim();
        if (s.matches(floatReg1) || s.matches(floatReg2))
            return true;
        if (s.matches(intReg))
            return true;
        String[] e = s.split("[eE]");
        if (e.length != 2)
            return false;
        if(e.length==2&&(s.endsWith("e")||s.endsWith("E")))
            return false;
        if ((e[0].matches(floatReg1) || e[0].matches(floatReg2)||e[0].matches(intReg)) && e[1].matches(intReg))
        return true;
        return false;
    }


    public static void main(String[] args) {

        String st1="7e69e";
        String[] e = st1.split("[eE]");

    }
}
