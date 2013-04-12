package predicate;

import com.google.common.base.Predicate;
import core.Job;
import core.Recruiter;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasThisTheRecruiterForThisJob implements Predicate<Job> {
    private Recruiter recruiter;

    public WasThisTheRecruiterForThisJob(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    @Override
    public boolean apply(Job job) {
        return job.is(recruiter);
    }
}
