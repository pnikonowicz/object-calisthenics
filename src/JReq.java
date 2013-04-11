/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class JReq implements Job {
    private String title;

    public JReq(Resume resume) {

    }

    @Override
    public String toString() {
        return title;
    }

    public void apply(Resume resume) {
    }
}
