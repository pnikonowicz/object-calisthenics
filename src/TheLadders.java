import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.joda.time.LocalDate;

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
    private final JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository;
    private final ApplicationRepository applicationRepository;

    public TheLadders(ApplicationRepository applicationRepository, JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository) {
        this.applicationRepository = applicationRepository;
        this.jobSeekerSavedForLaterJobRepository = jobSeekerSavedForLaterJobRepository;
    }

    public Collection<JobSeekerSavedForLaterJob> whoAppliedToJobOn(LocalDate date) {
        Predicate dateQuery = new WasJobAppliedToOnThisDate(date);
        return jobSeekerSavedForLaterJobRepository.find(dateQuery);
    }

    public Collection<Application> list(Job job, Recruiter recruiter) {
        Predicate jobQuery = new WasThisJobAppliedTo(job);
        Predicate recruiterQuery = new WasThisTheRecruiterForThisApplication(recruiter);
        Predicate conjunctionQuery = Predicates.and(jobQuery, recruiterQuery);
        return applicationRepository.find(conjunctionQuery);
    }
}
