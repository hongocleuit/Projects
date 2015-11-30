package main;


import java.util.HashSet;
import java.util.Set;

public class CoutSubString {

    public static int countSubString(String str, boolean countSingleChar)
    {
        Set<String> subString = new HashSet<String>();
        int left;
        int right;
        int exleft;
        int exright;
        for(int middle = 0; middle< str.length(); middle++)
        {
            System.out.println("Round " +middle);
            left = middle+1;
            right = middle-1;
            if(left>str.length()-1) break;
            if(str.charAt(middle) == str.charAt(left))
            {
                //checkLeftRight();
                exleft = left+1;
                exright = middle-1;
                System.out.println(str.substring(middle,left+1));
                subString.add(str.substring(middle,left+1));
                while(exright >= 0 && exleft < str.length() && str.charAt(exleft)==str.charAt(exright))
                {
                    System.out.println(str.substring(exright,exleft+1));
                    subString.add(str.substring(exright, exleft + 1));
                    exleft++;
                    exright--;
                }
            }

            while(right>=0 && left<str.length() && str.charAt(left)==str.charAt(right))
            {
                System.out.println(str.substring(right, left + 1));
                subString.add(str.substring(right,left+1));
                left++;
                right--;
            }
        }

        if(countSingleChar)
        {
            for(char ch : str.toCharArray())
            {
                subString.add(Character.toString(ch));
            }
        }
        return subString.size();
    }

    public static void main(String[] args) {
        String test="abbadasekwqjkskdjjqwekcbbcbb";

        System.out.println(countSubString(test,true));
    }
}
