/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasThisTheRecruiter implements Query<Application> {
    private Recruiter recruiter;

    public WasThisTheRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    @Override
    public boolean assertTrue(Application application) {
        return application.is(recruiter);
    }
}
