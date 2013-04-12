import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobRepository {
    private final Collection<Job> allJobs = new ArrayList<Job>();

    public void save(Job job) {
        allJobs.add(job);
    }

    public Collection<Job> find(Predicate<Job> query) {
        return Collections2.filter(allJobs, query);
    }
}
