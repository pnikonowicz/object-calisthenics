import org.junit.Before;
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
    private JobSeeker jobSeeker;
    private JobRepository jobRepository;
    private ApplicationRepository applicationRepository;

    @Before
    public void setUp() {
        Resume resume = new Resume();
        jobRepository = new JobRepository();
        JobSeekerSavedForLaterJobRepository jobSeekerSavedJobsRepository = new JobSeekerSavedForLaterJobRepository();
        applicationRepository = new ApplicationRepository();
        jobSeeker = new JobSeeker(resume, jobRepository, jobSeekerSavedJobsRepository, applicationRepository);
    }

    @Test
    public void JobSeekersCanSaveJobsOnSiteForLaterViewing() {
        Job job = Mockito.mock(Job.class);

        jobSeeker.save(job);
    }

    @Test
    public void JobSeekersCanApplyToJobsPostedByRecruiters() {
        Recruiter recruiter = new Recruiter(jobRepository, applicationRepository, Mockito.mock(Name.class));
        Job job = new ATS(recruiter);

        recruiter.post(job);

        jobSeeker.apply(job);
    }
}
