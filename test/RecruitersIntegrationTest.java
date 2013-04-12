import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.StringWriter;
import java.util.Collection;
import java.util.Date;

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
        Job job = mock(Job.class);

        Mockito.when(job.is(recruiter)).thenReturn(true);

        recruiter.post(job, jobRepository);
        Collection<Job> jobsRecruitersPosted = recruiter.listJobsThatIHavePosted(jobRepository);

        Assert.assertEquals(1, jobsRecruitersPosted.size());
        Assert.assertTrue(jobsRecruitersPosted.contains(job));
    }

    @Test
    public void recruitersShouldBeAbleToSeeJobSeekersWhoHaveAppliedToTheirJobsByBothJobAndDay() {
        Job job = new ATS(recruiter, mock(Title.class));
        LocalDate date = LocalDate.now();
        final JobSeeker jobSeeker = new JobSeeker(new Resume());

        recruiter.post(job, jobRepository);
        jobSeeker.apply(job, applicationRepository);

        Collection<Application> applications = recruiter.whoAppliedToJobOnDate(job, date, applicationRepository);

        Assert.assertEquals(1, applications.size());
        Assert.assertEquals(1, Collections2.filter(applications, new Predicate<Application>() {
            @Override
            public boolean apply(Application application) {
                return application.is(jobSeeker);
            }
        }).size());
    }

    @Test
    public void recruitersShouldBeDisplayedByTheirName() {
        StringWriter stringWriter = new StringWriter();

        recruiter.display(stringWriter);

        Assert.assertEquals("name", stringWriter.toString());
    }
}
