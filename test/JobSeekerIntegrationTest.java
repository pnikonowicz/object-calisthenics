import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.StringWriter;
import java.io.Writer;

import static org.mockito.Mockito.mock;

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
    private Resume resume;
    private JobSeekerSavedForLaterJobRepository jobSeekerSavedJobsRepository;

    @Before
    public void setUp() {
        resume = new Resume();
        jobRepository = new JobRepository();
        jobSeekerSavedJobsRepository = new JobSeekerSavedForLaterJobRepository();
        applicationRepository = new ApplicationRepository();
        jobSeeker = new JobSeeker(resume, jobRepository, jobSeekerSavedJobsRepository, applicationRepository);
    }

    @Test
    public void JobSeekersCanSaveJobsOnSiteForLaterViewing() {
        Job job = mock(Job.class);

        jobSeeker.save(job);
    }

    @Test
    public void JobSeekersCanApplyToJobsPostedByRecruiters() {
        Recruiter recruiter = new Recruiter(jobRepository, applicationRepository, mock(Name.class));
        Job job = new ATS(recruiter, mock(Title.class));

        recruiter.post(job);

        jobSeeker.apply(job);
    }

    @Test
    public void JReqJobsRequireResumeToApplyToThem() {
        Recruiter recruiter = new Recruiter(jobRepository, applicationRepository, mock(Name.class));
        Job job = new JReq(recruiter, mock(Title.class));

        recruiter.post(job);

        jobSeeker.apply(job);
    }

    @Test(expected = DuplicateResumeException.class)
    public void JobSeekersCanNotApplyToJobWithSomeoneElseResume() {
        Recruiter recruiter = new Recruiter(jobRepository, applicationRepository, mock(Name.class));
        Job job = new JReq(recruiter, mock(Title.class));
        JobSeeker jobSeekerWithSomeoneElsesResume = new JobSeeker(resume, jobRepository, jobSeekerSavedJobsRepository, applicationRepository);

        recruiter.post(job);
        jobSeeker.apply(job);

        jobSeekerWithSomeoneElsesResume.apply(job);
    }

    @Test
    public void JobSeekersShouldBeAbleToSeeListingOfJobsTheyHaveSavedForLaterViewing() {
        Recruiter recruiter = new Recruiter(jobRepository, applicationRepository, mock(Name.class));
        Job job_a = new ATS(recruiter, new Title("job A"));
        Job job_b = new ATS(recruiter, new Title("job B"));
        StringWriter stringWriter = new StringWriter();

        jobSeeker.save(job_a);
        jobSeeker.save(job_b);

        jobSeeker.displaySavedJobs(stringWriter);

        Assert.assertEquals("job A\njob B\n", stringWriter.toString());
    }

    @Test
    public void JobSeekersShouldBeAbleToSeeListingOfTheJobsForWhichTheyHaveApplied() {
        Recruiter recruiter = new Recruiter(jobRepository, applicationRepository, mock(Name.class));
        Job job_a = new ATS(recruiter, new Title("job A"));
        Job job_b = new ATS(recruiter, new Title("job B"));
        Writer stringWriter = new StringWriter();

        jobSeeker.apply(job_a);
        jobSeeker.apply(job_b);

        jobSeeker.displayAppliedJobs(stringWriter);
    }
}
