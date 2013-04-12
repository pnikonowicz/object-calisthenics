import org.joda.time.LocalDate;

import java.io.Writer;
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

    public ATS(Recruiter recruiter, Title title) {
        this.recruiter = recruiter;
        this.title = title;
    }

    public Application apply(JobSeeker jobSeeker, ApplicationNumber applicationNumber) {
        return new Application(LocalDate.now(), this, jobSeeker, applicationNumber);
    }

    @Override
    public String toString() {
        return title.toString();
    }

    @Override
    public boolean is(Recruiter recruiter) {
        return recruiter.equals(this.recruiter);
    }

    @Override
    public void displayTitle(Writer writer) {
        title.display(writer);
    }
}
