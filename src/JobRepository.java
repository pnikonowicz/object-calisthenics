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

    public void save(Job job) {
        allJobs.add(job);
    }

    public Collection<Job> find(Query query) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
