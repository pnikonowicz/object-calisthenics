import java.io.IOException;
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
        try {
            writer.write(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
