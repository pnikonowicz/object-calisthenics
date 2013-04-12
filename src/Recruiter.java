import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recruiter {
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final Name name;

    public Recruiter(JobRepository jobRepository, ApplicationRepository applicationRepository, Name name) {
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.name = name;
    }

    public void post(Job job) {
         jobRepository.save(job);
    }

    public Collection<Job> listJobsThatIHavePosted() {
        Predicate<Job> recruiterQuery = new WasThisTheRecruiterForThisJob(this);
        return jobRepository.find(recruiterQuery);
    }

    public Collection<Application> whoAppliedToJobOnDate(Job job, LocalDate date) {
        Predicate dateQuery = new WasJobAppliedToOnThisDate(date);
        Predicate jobQuery  = new WasThisJobAppliedTo(job);
        Predicate query     = Predicates.and(dateQuery, jobQuery);
        return applicationRepository.find(query);
    }

    public void display(Writer writer) {
        name.display(writer);
    }
}
