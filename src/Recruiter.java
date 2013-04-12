import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

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
    private Name name;

    public Recruiter(JobRepository jobRepository, ApplicationRepository applicationRepository) {
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
    }

    public void post(Job job) {
         jobRepository.save(job);
    }

    public Collection<Job> list() {
        Predicate recruiterQuery = new WasThisTheRecruiter(this);
        return jobRepository.find(recruiterQuery);
    }

    public Collection<Application> whoAppliedToJobOnDate(Job job, Date date) {
        Predicate dateQuery = new WasJobAppliedToOnThisDate(date);
        Predicate jobQuery  = new WasThisJobAppliedTo(job);
        Predicate query     = Predicates.and(dateQuery, jobQuery);
        return applicationRepository.find(query);
    }

    public String toString() {
        return name.toString();
    }
}
