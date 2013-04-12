package collection;

import core.Application;
import util.MyWriter;

import java.io.Writer;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Applications {
    private Collection<Application> applications;

    public Applications(Collection<Application> applications) {
        this.applications = applications;
    }

    public void displayJobSeekers(Writer writer) {
        for(Application application : applications) {
            application.displayJobSeeker(writer);
            MyWriter.write(writer, "\n");
        }
    }

    public void displayApplicationNumbers(Writer writer) {
        for(Application application : applications) {
            application.displayApplicationNumber(writer);
            MyWriter.write(writer, "\n");
        }
    }
}
