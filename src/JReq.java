import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class JReq implements Job {
    private Title title;

    public JReq(Resume resume) {

    }

    @Override
    public String toString() {
        return title.toString();
    }

    public Application apply(Resume resume) {
        return new Application(new Date(), this);
    }
}
