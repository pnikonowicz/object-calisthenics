import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeekerIntegrationTest {
    @Test
    public void JobSeekersCanSaveJobsOnSiteForLaterViewing() {
        Resume resume = new Resume();
        JobRepository jobRepository = new JobRepository();
        JobSeekerSavedForLaterJobRepository jobSeekerSavedJobsRepository = new JobSeekerSavedForLaterJobRepository();
        ApplicationRepository applicationRepository = new ApplicationRepository();
        JobSeeker jobSeeker = new JobSeeker(resume, jobRepository, jobSeekerSavedJobsRepository, applicationRepository);
        Job job = Mockito.mock(Job.class);

        jobSeeker.save(job);
    }

}
