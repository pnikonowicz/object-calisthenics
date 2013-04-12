import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeekerSavedForLaterJobRepository {
    final Collection<JobSeekerSavedForLaterJob> jobs = new ArrayList<JobSeekerSavedForLaterJob>();

    public void save(JobSeekerSavedForLaterJob job) {
        jobs.add(job);
    }

    public Collection<JobSeekerSavedForLaterJob> find(Predicate<JobSeekerSavedForLaterJob> query) {
        return Collections2.filter(jobs, query);
    }
}
