

package rushtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class StrongPasswordChecker {

    public int strongPasswordChecker(String s) {

        int len = s.length();

        List<String> triples=getTriples(s);
        int  digit=containsDigit(s);
        int  lower=containsLower(s);
        int  upper=containsUpper(s);
        int count=digit+lower+upper;

        if (len > 5 && len < 21 && count==3 && triples.isEmpty())
            return 0;
        //替换大于新增大于减少

        if(len<6)
        {
            if(triples.size()==0)
            {
                return Math.max(6-len,3-count);
            }
            int triLen=triples.get(0).length();
            if(triLen==5)
            {
               return  Math.max(2,3-count);
            }

            return Math.max(6-len,3-count);
        }

        PriorityQueue<Triples> queue=new PriorityQueue<Triples>();
        for(String item:triples)
        {
           Triples triple=new Triples(item.length(),item.length()%3);
           triple.setString(item);
           queue.add(triple);

        }
        while(len>20 && !queue.isEmpty())
        {
            Triples a=queue.poll();
            int delta=Math.min(a.remainder+1,len-20);
            if(a.len>delta)
            {
                len-=delta;
                queue.add(new Triples(a.len-delta,2));
            }
        }
        int changeCnt=0;
        while(!queue.isEmpty())
        {
            Triples a=queue.poll();
            changeCnt+=a.len/3;
        }

        int delteCnt=Math.max(s.length()-20,0);
        return delteCnt+Math.max(changeCnt,3-count);


    }

    public class Triples implements Comparable<Triples> {
        int len;
        int remainder;
        String string;

        public void setString(String string) {
            this.string = string;
        }

        public Triples(int len, int remainder) {
            this.len = len;
            this.remainder = remainder;
        }

        @Override
        public int compareTo(Triples o) {
            return this.remainder - o.remainder;
        }


        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public int getRemainder() {
            return remainder;
        }

        public void setRemainder(int remainder) {
            this.remainder = remainder;
        }
    }

    private int containsLower(String s) {
        if(s.length()==0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                return 1;
        }
        return 0;

    }

    private int containsUpper(String s) {
        if(s.length()==0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                return 1;
        }
        return 0;

    }

    private int containsDigit(String s) {
        if(s.length()==0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                return 1;
        }
        return 0;

    }

    public List getTriples(String s) {
        if(s.length()==0)
            return Collections.emptyList();
        int count = 0;
        int start = 0;
        int end = 0;
        List<String> result = new ArrayList<>();

        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                count++;
                end++;
                last = s.charAt(i);
            } else {
                if (count > 1) {
                    result.add(s.substring(start, end + 1));
                }
                count = 0;
                start = i;
                end = i;
                last = s.charAt(i);
            }
        }
        if (count > 1) {
            result.add(s.substring(start, end + 1));
        }
        return result;

    }

    public static void main(String[] args) {
        StrongPasswordChecker strongPasswordChecker = new StrongPasswordChecker();
        List<String> result = strongPasswordChecker.getTriples("aaaaaaaAAAAAA6666bbbbaaaaaaABBC");
        System.out.println(result);
       System.out.println(strongPasswordChecker.strongPasswordChecker("aaaaaaaAAAAAA6666bbbbaaaaaaABBC"));
    }

}
