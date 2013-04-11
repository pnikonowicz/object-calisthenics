import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasJobAppliedToOnThisDate implements Query<Application> {
    private Date date;

    public WasJobAppliedToOnThisDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean assertTrue(Application application) {
        return application.is(date);
    }
}
