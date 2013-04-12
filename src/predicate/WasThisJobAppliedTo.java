package predicate;

import com.google.common.base.Predicate;
import core.Application;
import core.Job;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasThisJobAppliedTo implements Predicate<Application> {
    private Job job;

    public WasThisJobAppliedTo(Job job) {
        this.job = job;
    }

    @Override
    public boolean apply(Application application) {
        return application.is(job);
    }
}
