package core;

import util.MyWriter;

import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationNumber {
    private final int number;

    public ApplicationNumber(int number) {
        this.number = number;
    }

    public void display(Writer writer) {
        MyWriter.write(writer, number + "");
    }
}
