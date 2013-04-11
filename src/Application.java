import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Application {
    private final Date date;
    private final Job job;

    public Application(Date date, Job job) {
        this.date = date;
        this.job = job;
    }

    public boolean is(Job job) {
        return job.equals(this.job);
    }

    public boolean is(Date date) {
        return date.equals(this.date);
    }
}
