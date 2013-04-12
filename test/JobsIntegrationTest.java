import core.ATS;
import core.Job;
import core.Recruiter;
import core.Title;
import junit.framework.Assert;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/12/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobsIntegrationTest {
    @Test
    public void jobsWhenDisplayedShouldBeDisplayedWithTitle() {
        Job job = new ATS(mock(Recruiter.class), new Title("title"));
        Writer writer = new StringWriter();

        job.displayTitle(writer);

        Assert.assertEquals("title", writer.toString());
    }
}
