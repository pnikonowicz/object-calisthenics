package core;

import collection.Applications;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import data.ApplicationRepository;
import org.joda.time.LocalDate;
import predicate.WasJobAppliedToOnThisDate;
import predicate.WasThisJobAppliedTo;
import predicate.WasThisTheRecruiterForThisApplication;

import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheLadders {
    public void displayJobSeekersWhoHaveAppliedToJobsOn(Writer writer, LocalDate date, ApplicationRepository applicationRepository) {
        Applications applications = whoAppliedToJobOn(date, applicationRepository);
        applications.displayJobSeekers(writer);
    }

    public void displayJobApplicationNumbersForThisRecruiterAndJob(Writer writer, Job job, Recruiter recruiter, ApplicationRepository applicationRepository) {
        Applications applications = listJobApplicationNumbersForThisRecruiterAndJob(job, recruiter, applicationRepository);
        applications.displayApplicationNumbers(writer);
    }

    private Applications whoAppliedToJobOn(LocalDate date, ApplicationRepository applicationRepository) {
        Predicate<Application> dateQuery = new WasJobAppliedToOnThisDate(date);
        return applicationRepository.find(dateQuery);
    }

    private Applications listJobApplicationNumbersForThisRecruiterAndJob(Job job, Recruiter recruiter, ApplicationRepository applicationRepository) {
        Predicate jobQuery = new WasThisJobAppliedTo(job);
        Predicate recruiterQuery = new WasThisTheRecruiterForThisApplication(recruiter);
        Predicate conjunctionQuery = Predicates.and(jobQuery, recruiterQuery);
        return applicationRepository.find(conjunctionQuery);
    }
}
