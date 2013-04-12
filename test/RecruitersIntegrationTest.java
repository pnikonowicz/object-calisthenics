import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecruitersIntegrationTest {
    Recruiter testedObject;

    @Before
    public void setUp() {
        JobRepository jobRepository = new JobRepository();
        ApplicationRepository applicationRepository = new ApplicationRepository();
        testedObject = new Recruiter(jobRepository, applicationRepository);
    }

    @Test
    public void canPostJobs() {
        Job job = Mockito.mock(Job.class);

        testedObject.post(job);
    }

    @Test
    public void shouldBeAbleToSeeAListingOfTheJobsTheyHavePosted() {
        Job job = Mockito.mock(Job.class);

        Mockito.when(job.is(testedObject)).thenReturn(true);

        testedObject.post(job);
        Collection<Job> jobsRecruitersPosted = testedObject.listJobsThatIHavePosted();

        Assert.assertEquals(1, jobsRecruitersPosted.size());
        Assert.assertTrue(jobsRecruitersPosted.contains(job));
    }
}
