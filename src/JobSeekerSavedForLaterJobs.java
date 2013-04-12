import java.io.Writer;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeekerSavedForLaterJobs {
    private Collection<JobSeekerSavedForLaterJob> savedJobs;

    public JobSeekerSavedForLaterJobs(Collection<JobSeekerSavedForLaterJob> savedJobs) {
        this.savedJobs = savedJobs;
    }

    public void displayTitle(Writer writer) {
        for(JobSeekerSavedForLaterJob savedJob : savedJobs) {
            savedJob.displayTitle(writer);
            MyWriter.write(writer, "\n");
        }
    }
}
