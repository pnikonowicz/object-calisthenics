package core;

import util.MyWriter;

import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Title {
    private final String name;

    public Title(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void display(Writer writer) {
        MyWriter.write(writer, name);
    }
}
