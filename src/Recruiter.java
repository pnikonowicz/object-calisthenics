import com.google.common.base.Predicate;

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
    private JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository;
    private Name name;

    public Recruiter(JobRepository jobRepository, JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository) {
        this.jobRepository = jobRepository;
        this.jobSeekerSavedForLaterJobRepository = jobSeekerSavedForLaterJobRepository;
    }

    public void post(Job job) {
         jobRepository.save(job);
    }

    public Collection<Job> list() {
        Predicate recruiterQuery = new WasThisTheRecruiter(this);
        return jobRepository.find(recruiterQuery);
    }

    public Collection<JobSeeker> whoAppliedToJobOnDate(Job job, Date date) {
        Predicate dateQuery = new WasJobAppliedToOnThisDate(date);
        Predicate jobQuery  = new WasThisJobAppliedTo(job);
        Predicate query     = new Conjunction(jobQuery, dateQuery);
        return jobSeekerSavedForLaterJobRepository.find(query);
    }

    public String toString() {
        return name.toString();
    }
}
