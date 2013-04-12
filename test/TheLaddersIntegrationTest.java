import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheLaddersIntegrationTest {
    @Test
    public void theLaddersShouldBeAbleToSeeJobSeekersWhoHaveAppliedToJobsOnAnyGivenDay() {
        ApplicationRepository applicationRepository = new ApplicationRepository();
        JobSeeker jobSeeker_A = new JobSeeker(mock(Resume.class), new Name("job seeker a"));
        JobSeeker jobSeeker_B = new JobSeeker(mock(Resume.class), new Name("job seeker b"));
        Recruiter recruiter = new Recruiter(new Name("recruiter"));
        Job job_a = new JReq(recruiter, new Title("job a"));
        Job job_b = new JReq(recruiter, new Title("job b"));
        TheLadders theLadders = new TheLadders();
        Writer writer = new StringWriter();

        jobSeeker_A.apply(job_a, applicationRepository, mock(ApplicationNumber.class));
        jobSeeker_B.apply(job_b, applicationRepository, mock(ApplicationNumber.class));

        theLadders.displayJobSeekersWhoHaveAppliedToJobsOn(writer, LocalDate.now(), applicationRepository);

        Assert.assertEquals("job seeker a\njob seeker b\n", writer.toString());
    }

    @Test
    public void theLaddersShouldBeAbleToSeeAggregateJobApplicationNumbersByJobAndRecruiter() {
        ApplicationRepository applicationRepository = new ApplicationRepository();
        JobSeeker jobSeeker_A = new JobSeeker(new Resume(new Name("resume a")), new Name("job seeker a"));
        JobSeeker jobSeeker_B = new JobSeeker(new Resume(new Name("resume b")), new Name("job seeker b"));
        Recruiter recruiter_A = new Recruiter(new Name("recruiter a"));
        Recruiter recruiter_B = new Recruiter(new Name("recruiter b"));
        Job job_a = new JReq(recruiter_A, new Title("job a"));
        Job job_b = new JReq(recruiter_B, new Title("job b"));
        Job job_c = new JReq(recruiter_A, new Title("job c"));
        TheLadders theLadders = new TheLadders();
        Writer writer = new StringWriter();

        jobSeeker_A.apply(job_a, applicationRepository, new ApplicationNumber(1));
        jobSeeker_B.apply(job_b, applicationRepository, new ApplicationNumber(2));
        jobSeeker_A.apply(job_b, applicationRepository, new ApplicationNumber(3));
        jobSeeker_B.apply(job_a, applicationRepository, new ApplicationNumber(4));

        theLadders.displayJobApplicationNumbersForThisRecruiterAndJob(writer, job_a, recruiter_A, applicationRepository);

        Assert.assertEquals("1\n4\n", writer.toString());
    }
}
