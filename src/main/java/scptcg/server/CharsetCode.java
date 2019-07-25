package scptcg.server;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharsetCode {

    public static boolean is(String src, String charsetName) {
        try {
            byte[] tmp = new String(src.getBytes(), charsetName).getBytes(charsetName);
            return Arrays.equals(tmp, src.getBytes());
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    public static String to(String src, String before, String after) {
        try {
            return new String(src.getBytes(before), after);
        } catch (UnsupportedEncodingException e) {
            return src;
        }
    }

}
