import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class TheLaddersIntegrationTest {
    @Test
    public void recruitersCanPostJobs() {
        JobRepository jobRepository = new JobRepository();
        ApplicationRepository applicationRepository = new ApplicationRepository();
        Recruiter recruiter = new Recruiter(jobRepository, applicationRepository);
        Job job = Mockito.mock(Job.class);

        recruiter.post(job);
    }


}
