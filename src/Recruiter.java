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
    private Name name;

    public Recruiter(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void post(Job job) {
         jobRepository.add(job);
    }

    public Collection<Job> list() {
        return jobRepository.all();
    }

    public Collection<JobSeeker> whoAppliedToJobOnDate(Job job, Date date) {
        Query dateQuery = new WasJobAppliedToOnThisDate(date);
        Query jobQuery  = new WasThisJobAppliedTo(job);
        Query query     = new Conjunction(jobQuery, dateQuery);
        return jobRepository.find(query);
    }

    public String toString() {
        return name.toString();
    }
}
