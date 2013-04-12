import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

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
        JobSeeker jobSeeker_A = new JobSeeker(new Resume(), new Name("job seeker a"));
        JobSeeker jobSeeker_B = new JobSeeker(new Resume(), new Name("job seeker b"));
        Recruiter recruiter = new Recruiter(new Name("recruiter"));
        Job job_a = new JReq(recruiter, new Title("job a"));
        Job job_b = new JReq(recruiter, new Title("job b"));
        TheLadders theLadders = new TheLadders();
        Writer writer = new StringWriter();

        jobSeeker_A.apply(job_a, applicationRepository);
        jobSeeker_B.apply(job_b, applicationRepository);

        theLadders.displayJobSeekersWhoHaveAppliedToJobsOn(writer, LocalDate.now(), applicationRepository);

        Assert.assertEquals("job seeker a\njob seeker b\n", writer.toString());
    }
}
