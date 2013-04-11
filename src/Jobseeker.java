import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Jobseeker {
    public void save(Job job) {

    }

    public void apply(Job job) {
        job.apply();
    }

    public Collection<Job> listSavedJobs() {
        return null;
    }

    public Collection<Job> listAppliedJobs() {
        return null;
    }
}
