import org.joda.time.LocalDate;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Application {
    private final LocalDate date;
    private final Job job;
    private final JobSeeker jobSeeker;
    private final Resume resume;
    private final ApplicationNumber applicationNumber;

    public Application(LocalDate date, Job job, JobSeeker jobSeeker, ApplicationNumber applicationNumber) {
        this(date, job, jobSeeker, applicationNumber, null);
    }

    public Application(LocalDate date, Job job, JobSeeker jobSeeker, ApplicationNumber applicationNumber, Resume resume) {
        this.date = date;
        this.job = job;
        this.jobSeeker = jobSeeker;
        this.resume = resume;
        this.applicationNumber = applicationNumber;
    }

    public boolean is(Job job) {
        return job.equals(this.job);
    }

    public boolean is(LocalDate date) {
        return this.date.isEqual(date);
    }

    public boolean is(Recruiter recruiter) {
        return job.is(recruiter);
    }

    public boolean is(JobSeeker jobSeeker) {
        return this.jobSeeker.equals(jobSeeker);
    }

    public boolean is(Resume resume) {
        return resume == null || this.resume.equals(resume);
    }

    public void displayJobSeeker(Writer writer) {
        jobSeeker.display(writer);
    }

    public void displayApplicationNumber(Writer writer) {
        applicationNumber.display(writer);
    }
}
