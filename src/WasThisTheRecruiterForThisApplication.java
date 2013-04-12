import com.google.common.base.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasThisTheRecruiterForThisApplication implements Predicate<Application> {
    private Recruiter recruiter;

    public WasThisTheRecruiterForThisApplication(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    @Override
    public boolean apply(Application application) {
        return application.is(recruiter);
    }
}
