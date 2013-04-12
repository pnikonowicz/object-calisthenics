package core;

import org.joda.time.LocalDate;

import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class JReq implements Job {
    private final Title title;
    private final Recruiter recruiter;

    public JReq(Recruiter recruiter, Title title) {
        this.recruiter = recruiter;
        this.title = title;
    }

    @Override
    public String toString() {
        return title.toString();
    }

    public Application apply(JobSeeker jobSeeker, ApplicationNumber applicationNumber, Resume resume) {
        return new Application(LocalDate.now(), this, jobSeeker, applicationNumber, resume);
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
