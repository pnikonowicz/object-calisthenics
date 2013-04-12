import core.*;
import data.ApplicationRepository;
import data.JobRepository;
import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecruitersIntegrationTest {
    Recruiter recruiter;
    private JobRepository jobRepository;
    private ApplicationRepository applicationRepository;
    private Name name;

    @Before
    public void setUp() {
        jobRepository = new JobRepository();
        applicationRepository = new ApplicationRepository();
        name = new Name("name");

        recruiter = new Recruiter(name);
    }

    @Test
    public void canPostJobs() {
        Job job = mock(Job.class);

        recruiter.post(job, jobRepository);
    }

    @Test
    public void shouldBeAbleToSeeAListingOfTheJobsTheyHavePosted() {
        Job job_A = new ATS(recruiter, new Title("job a"));
        Job job_B = new ATS(recruiter, new Title("job b"));
        Writer writer = new StringWriter();

        recruiter.post(job_A, jobRepository);
        recruiter.post(job_B, jobRepository);

        recruiter.displayJobsThatIHavePosted(writer, jobRepository);

        Assert.assertEquals("job a\njob b\n", writer.toString());

    }

    @Test
    public void recruitersShouldBeAbleToSeeJobSeekersWhoHaveAppliedToTheirJobsByBothJobAndDay() {
        Job job = new ATS(recruiter, mock(Title.class));
        LocalDate date = LocalDate.now();
        final JobSeeker jobSeeker_A = new JobSeeker(mock(Resume.class), new Name("job seeker a"));
        final JobSeeker jobSeeker_B = new JobSeeker(mock(Resume.class), new Name("job seeker b"));
        Writer writer = new StringWriter();

        recruiter.post(job, jobRepository);
        jobSeeker_A.apply(job, applicationRepository, mock(ApplicationNumber.class));
        jobSeeker_B.apply(job, applicationRepository, mock(ApplicationNumber.class));

        recruiter.displayJobSeekersWhoAppliedToJobOnDate(writer, job, date, applicationRepository);

        Assert.assertEquals("job seeker a\njob seeker b\n", writer.toString());
    }

    @Test
    public void recruitersShouldBeDisplayedByTheirName() {
        StringWriter stringWriter = new StringWriter();

        recruiter.display(stringWriter);

        Assert.assertEquals("name", stringWriter.toString());
    }
}
