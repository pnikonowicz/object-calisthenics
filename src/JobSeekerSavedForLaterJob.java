import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeekerSavedForLaterJob {
    private final JobSeeker jobSeeker;
    private final Job job;

    public JobSeekerSavedForLaterJob(JobSeeker jobSeeker, Job job) {
        this.jobSeeker = jobSeeker;
        this.job = job;
    }

    public boolean is(JobSeeker jobSeeker) {
        return jobSeeker.equals(this.jobSeeker);
    }

    public void displayTitle(Writer writer) {
        job.displayTitle(writer);
    }
}
