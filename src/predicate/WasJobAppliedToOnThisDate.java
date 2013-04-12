package predicate;

import com.google.common.base.Predicate;
import core.Application;
import org.joda.time.LocalDate;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class WasJobAppliedToOnThisDate implements Predicate<Application> {
    private LocalDate date;

    public WasJobAppliedToOnThisDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean apply(Application application) {
        return application.is(date);
    }
}
