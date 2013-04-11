import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobRepository {
    Collection<Job> allJobs;
    Collection<JobSeekerSavedForLaterJob> jobSeekerSavedJobs;
    Collection<Application> appliedJobs;

    public void save(Job job) {
        allJobs.add(job);
    }

    public void save(JobSeekerSavedForLaterJob savedJob) {
        jobSeekerSavedJobs.add(savedJob);
    }

    public void save(Application application) {
        appliedJobs.add(application);
    }

    public Collection<Job> all() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public Collection<Job> allSavedJobsFor(JobSeeker jobSeeker) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public Collection<Job> allAppliedJobsFor(JobSeeker jobSeeker) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public Collection<JobSeeker> findJobSeekers(Query query) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public Collection<ApplicationNumber> findApplicationNumbers(Query query) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
