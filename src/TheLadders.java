import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.joda.time.LocalDate;

import java.io.Writer;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheLadders {
    public Collection<Application> whoAppliedToJobOn(LocalDate date, ApplicationRepository applicationRepository) {
        Predicate<Application> dateQuery = new WasJobAppliedToOnThisDate(date);
        return applicationRepository.find(dateQuery);
    }

    public Collection<Application> list(Job job, Recruiter recruiter, ApplicationRepository applicationRepository) {
        Predicate jobQuery = new WasThisJobAppliedTo(job);
        Predicate recruiterQuery = new WasThisTheRecruiterForThisApplication(recruiter);
        Predicate conjunctionQuery = Predicates.and(jobQuery, recruiterQuery);
        return applicationRepository.find(conjunctionQuery);
    }

    public void displayJobSeekersWhoHaveAppliedToJobsOn(Writer writer, LocalDate date, ApplicationRepository applicationRepository) {
        Collection<Application> applications = whoAppliedToJobOn(date, applicationRepository);

        for(Application application : applications) {
            application.displayJobSeeker(writer);
            MyWriter.write(writer, "\n");
        }
    }
}
