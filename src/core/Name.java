package core;

import util.MyWriter;

import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public void display(Writer writer) {
        MyWriter.write(writer, name);
    }
}
