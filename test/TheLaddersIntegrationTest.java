import core.*;
import data.ApplicationRepository;
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
        Job job_a = new JReq(recruiter, mock(Title.class));
        Job job_b = new JReq(recruiter, mock(Title.class));
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
        JobSeeker jobSeeker_A = new JobSeeker(mock(Resume.class), mock(Name.class));
        JobSeeker jobSeeker_B = new JobSeeker(mock(Resume.class), mock(Name.class));
        Recruiter recruiter_A = mock(Recruiter.class);
        Recruiter recruiter_B = mock(Recruiter.class);
        Job job_a = new JReq(recruiter_A, mock(Title.class));
        Job job_b = new JReq(recruiter_B, mock(Title.class));
        Job job_c = new JReq(recruiter_A, mock(Title.class));
        TheLadders theLadders = new TheLadders();
        Writer writer = new StringWriter();

        jobSeeker_A.apply(job_a, applicationRepository, new ApplicationNumber(1));
        jobSeeker_B.apply(job_b, applicationRepository, new ApplicationNumber(2));
        jobSeeker_A.apply(job_b, applicationRepository, new ApplicationNumber(3));
        jobSeeker_B.apply(job_a, applicationRepository, new ApplicationNumber(4));
        jobSeeker_A.apply(job_c, applicationRepository, new ApplicationNumber(5));

        theLadders.displayJobApplicationNumbersForThisRecruiterAndJob(writer, job_a, recruiter_A, applicationRepository);

        Assert.assertEquals("1\n4\n", writer.toString());
    }
}
