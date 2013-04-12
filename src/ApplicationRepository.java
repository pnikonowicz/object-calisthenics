import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationRepository {
    Collection<Application> applications;

    public void save(Application application) {
        applications.add(application);
    }

    public Collection<Application> find(Predicate<Application> query) {
        return Collections2.filter(applications, query);
    }
}
