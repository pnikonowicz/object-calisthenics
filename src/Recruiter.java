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
    private String name;
    private Collection<Job> jobs = Collections.emptyList();

    public void post(Job job) {
         jobs.add(job);
    }

    public Collection<Job> list() {
        return jobs;
    }

    public Collection<Jobseeker> whoAppliedToJobOnDate(Job job, Date date) {
        return null;
    }

    public String toString() {
        return name;
    }
}
