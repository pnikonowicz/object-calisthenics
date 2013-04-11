import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Jobseeker {
    private Name name;
    private Resume resume;
    Collection<Job> savedJobs = Collections.emptyList();
    Collection<Job> appliedJobs = Collections.emptyList();

    public void save(Job job) {
        savedJobs.add(job);
    }

    public void apply(Job job) {
        if(job instanceof JReq) {
            ((JReq) job).apply(resume);
        }

        if(job instanceof ATS) {
            ((ATS)job).apply();
        }
    }

    public Collection<Job> listSavedJobs() {
        return savedJobs;
    }

    public Collection<Job> listAppliedJobs() {
        return appliedJobs;
    }

    public String toString() {
        return name.toString();
    }
}
