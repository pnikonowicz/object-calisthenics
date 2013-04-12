import com.google.common.base.Predicate;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasJobAppliedToOnThisDate implements Predicate<Application> {
    private Date date;

    public WasJobAppliedToOnThisDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean apply(Application application) {
        return application.is(date);
    }
}
