import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeekerSavedForLaterJobRepository {
    Collection<JobSeekerSavedForLaterJob> jobs;
    public void save(JobSeekerSavedForLaterJob job) {
        jobs.add(job);
    }

    public Collection<JobSeeker> find(Query query) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
