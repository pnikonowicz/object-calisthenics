package util;

import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyWriter {
    public static void write(Writer writer, String text) {
        try {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
