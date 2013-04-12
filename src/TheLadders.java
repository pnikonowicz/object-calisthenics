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
    public void displayJobSeekersWhoHaveAppliedToJobsOn(Writer writer, LocalDate date, ApplicationRepository applicationRepository) {
        Collection<Application> applications = whoAppliedToJobOn(date, applicationRepository);

        for(Application application : applications) {
            application.displayJobSeeker(writer);
            MyWriter.write(writer, "\n");
        }
    }

    public void displayJobApplicationNumbersForThisRecruiterAndJob(Writer writer, Job job, Recruiter recruiter, ApplicationRepository applicationRepository) {
        Collection<Application> applications = listJobApplicationNumbersForThisRecruiterAndJob(job, recruiter, applicationRepository);

        for(Application application : applications) {
            application.displayApplicationNumber(writer);
            MyWriter.write(writer, "\n");
        }
    }

    private Collection<Application> whoAppliedToJobOn(LocalDate date, ApplicationRepository applicationRepository) {
        Predicate<Application> dateQuery = new WasJobAppliedToOnThisDate(date);
        return applicationRepository.find(dateQuery);
    }

    private Collection<Application> listJobApplicationNumbersForThisRecruiterAndJob(Job job, Recruiter recruiter, ApplicationRepository applicationRepository) {
        Predicate jobQuery = new WasThisJobAppliedTo(job);
        Predicate recruiterQuery = new WasThisTheRecruiterForThisApplication(recruiter);
        Predicate conjunctionQuery = Predicates.and(jobQuery, recruiterQuery);
        return applicationRepository.find(conjunctionQuery);
    }
}
