import java.util.Collection;
import java.util.Collections;
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
    private String name;

    public Recruiter(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void post(Job job) {
         jobRepository.add(job);
    }

    public Collection<Job> list() {
        return jobRepository.all();
    }

    public Collection<Jobseeker> whoAppliedToJobOnDate(Job job, Date date) {
        return null;
    }

    public String toString() {
        return name;
    }
}
