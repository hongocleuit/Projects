package main;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by lho on 11/28/15.
 */
public class readFromString {

    public static void main(String[] args) throws IOException {

        String test = "1111111100000000000111";
        StringReader reader = new StringReader(test);
        for(int i=0; i<test.length();i++)
            System.out.println(reader.read());


    }
}
