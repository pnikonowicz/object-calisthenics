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
    private JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository;

    @Before
    public void setUp() {
        resume = new Resume();
        jobRepository = new JobRepository();
        jobSeekerSavedForLaterJobRepository = new JobSeekerSavedForLaterJobRepository();
        applicationRepository = new ApplicationRepository();
        jobSeeker = new JobSeeker(resume, new Name("job seeker"));
    }

    @Test
    public void JobSeekersCanSaveJobsOnSiteForLaterViewing() {
        Job job = mock(Job.class);

        jobSeeker.save(job, jobSeekerSavedForLaterJobRepository);
    }

    @Test
    public void JobSeekersCanApplyToJobsPostedByRecruiters() {
        Recruiter recruiter = new Recruiter(mock(Name.class));
        Job job = new ATS(recruiter, mock(Title.class));

        recruiter.post(job, jobRepository);

        jobSeeker.apply(job, applicationRepository);
    }

    @Test
    public void JReqJobsRequireResumeToApplyToThem() {
        Recruiter recruiter = new Recruiter(mock(Name.class));
        Job job = new JReq(recruiter, mock(Title.class));

        recruiter.post(job, jobRepository);

        jobSeeker.apply(job, applicationRepository);
    }

    @Test(expected = DuplicateResumeException.class)
    public void JobSeekersCanNotApplyToJobWithSomeoneElseResume() {
        Recruiter recruiter = new Recruiter(mock(Name.class));
        Job job = new JReq(recruiter, mock(Title.class));
        JobSeeker jobSeekerWithSomeoneElsesResume = new JobSeeker(resume, mock(Name.class));

        recruiter.post(job, jobRepository);
        jobSeeker.apply(job, applicationRepository);

        jobSeekerWithSomeoneElsesResume.apply(job, applicationRepository);
    }

    @Test
    public void JobSeekersShouldBeAbleToSeeListingOfJobsTheyHaveSavedForLaterViewing() {
        Recruiter recruiter = new Recruiter(mock(Name.class));
        Job job_a = new ATS(recruiter, new Title("job A"));
        Job job_b = new ATS(recruiter, new Title("job B"));
        StringWriter stringWriter = new StringWriter();

        jobSeeker.save(job_a, jobSeekerSavedForLaterJobRepository);
        jobSeeker.save(job_b, jobSeekerSavedForLaterJobRepository);

        jobSeeker.displaySavedJobs(stringWriter, jobSeekerSavedForLaterJobRepository);

        Assert.assertEquals("job A\njob B\n", stringWriter.toString());
    }

    @Test
    public void JobSeekersShouldBeAbleToSeeListingOfTheJobsForWhichTheyHaveApplied() {
        Recruiter recruiter = new Recruiter(mock(Name.class));
        Job job_a = new ATS(recruiter, new Title("job A"));
        Job job_b = new ATS(recruiter, new Title("job B"));
        Writer stringWriter = new StringWriter();

        jobSeeker.apply(job_a, applicationRepository);
        jobSeeker.apply(job_b, applicationRepository);

        jobSeeker.displayAppliedJobs(stringWriter, jobRepository);
    }

    @Test
    public void jobSeekersWhenDisplayedShouldBeDisplayedByTheirName() {
        Writer writer = new StringWriter();

        jobSeeker.display(writer);

        Assert.assertEquals("job seeker", writer.toString());
    }
}
