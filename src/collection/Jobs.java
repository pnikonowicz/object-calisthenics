package collection;

import core.Job;
import util.MyWriter;

import java.io.Writer;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Jobs {
    private Collection<Job> jobs;

    public Jobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }

    public void displayTitle(Writer writer) {
        for(Job appliedJob : jobs) {
            appliedJob.displayTitle(writer);
            MyWriter.write(writer, "\n");
        }
    }
}
