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

    public Collection<ApplicationNumber> find(Query query) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
