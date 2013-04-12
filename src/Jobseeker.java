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
    private final JobSeekerSavedForLaterJobRepository jobSeekerSavedJobsRepository;
    private final ApplicationRepository applicationRepository;

    public JobSeeker(Resume resume, JobRepository jobRepository, JobSeekerSavedForLaterJobRepository jobSeekerSavedJobsRepository, ApplicationRepository applicationRepository) {
        this.resume = resume;
        this.jobRepository = jobRepository;
        this.jobSeekerSavedJobsRepository = jobSeekerSavedJobsRepository;
        this.applicationRepository = applicationRepository;
    }

    public void save(Job job) {
        jobSeekerSavedJobsRepository.save(new JobSeekerSavedForLaterJob(this, job));
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

        applicationRepository.save(application);
    }

    public Collection<Job> listSavedJobs() {
        Query jobSeekerQuery = new WasThisTheJobSeeker(this);
        return jobRepository.find(jobSeekerQuery);
    }

    public Collection<Job> listAppliedJobs() {
        Query jobSeekerQuery = new WasThisTheJobSeeker(this);
        return jobRepository.find(jobSeekerQuery);
    }

    public String toString() {
        return resume.toString();
    }
}
