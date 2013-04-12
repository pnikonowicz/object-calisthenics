import org.joda.time.LocalDate;

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
    private Recruiter recruiter;

    public JReq(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    @Override
    public String toString() {
        return title.toString();
    }

    public Application apply(JobSeeker jobSeeker, Resume resume) {
        return new Application(LocalDate.now(), this, jobSeeker, resume);
    }

    @Override
    public boolean is(Recruiter recruiter) {
        return recruiter.equals(this.recruiter);
    }
}
