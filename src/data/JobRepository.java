package data;

import collection.Jobs;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import core.Job;

import java.util.ArrayList;
import java.util.Collection;

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

    public Jobs find(Predicate<Job> query) {
        return new Jobs(Collections2.filter(allJobs, query));
    }
}
