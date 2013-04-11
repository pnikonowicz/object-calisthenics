/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasThisTheJobSeeker implements Query<JobSeekerSavedForLaterJob> {
    private JobSeeker jobSeeker;

    public WasThisTheJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public boolean assertTrue(JobSeekerSavedForLaterJob jobSeekerSavedForLaterJob) {
        return jobSeekerSavedForLaterJob.is(jobSeeker);
    }
}
