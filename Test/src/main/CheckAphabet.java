package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lho on 11/28/15.
 */
public class CheckAphabet {

    public static void main(String[] args) {
        String test="abbadasekwqjkskdjjqwekcbbcbb";
        List<String> aphabet = new ArrayList<String>();
        for(int i=97;i<=122;i++)
        {
            aphabet.add(Character.toString((char)i));
        }
        for (int i=0;i< aphabet.size();i++)
        {
            System.out.println(aphabet.get(i));
        }
        //test.contains()
    }
}
