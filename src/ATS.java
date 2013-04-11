import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ATS implements Job  {
    private Title title;
    private Recruiter recruiter;

    public ATS(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public Application apply() {
        return new Application(new Date(), this);
    }

    @Override
    public String toString() {
        return title.toString();
    }

    @Override
    public boolean is(Recruiter recruiter) {
        return recruiter.equals(this.recruiter);
    }
}
