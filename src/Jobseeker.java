import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeeker {

    private Resume resume;
    private final JobRepository jobRepository;

    public JobSeeker(Resume resume, JobRepository jobRepository) {
        this.resume = resume;
        this.jobRepository = jobRepository;
    }

    public void save(Job job) {
        jobRepository.saveJobFor(this, job);
    }

    public void apply(Job job) {
        Application application = null;
        if(job instanceof JReq) {
             application = ((JReq) job).apply(resume);
        }

        if(job instanceof ATS) {
            application = ((ATS)job).apply();
        }

        if(application == null) throw new UnsupportedOperationException("I don't know how to apply to this job: " + job);

        jobRepository.saveApplication(application);
    }

    public Collection<Job> listSavedJobs() {
        return jobRepository.allSavedJobsFor(this);
    }

    public Collection<Job> listAppliedJobs() {
        return jobRepository.allAppliedJobsFor(this);
    }

    public String toString() {
        return resume.toString();
    }
}
