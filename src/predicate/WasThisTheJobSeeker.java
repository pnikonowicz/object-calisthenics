package predicate;

import com.google.common.base.Predicate;
import core.JobSeeker;
import core.JobSeekerSavedForLaterJob;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasThisTheJobSeeker implements Predicate<JobSeekerSavedForLaterJob> {
    private JobSeeker jobSeeker;

    public WasThisTheJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public boolean apply(JobSeekerSavedForLaterJob jobSeekerSavedForLaterJob) {
        return jobSeekerSavedForLaterJob.is(jobSeeker);
    }
}
