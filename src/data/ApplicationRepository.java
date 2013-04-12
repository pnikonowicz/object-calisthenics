package data;

import collection.Applications;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import core.Application;
import core.Job;
import core.Resume;
import exception.DuplicateResumeException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationRepository {
    Collection<Application> applications = new ArrayList<Application>();

    public void save(Application application) {
        applications.add(application);
    }

    public Applications find(Predicate<Application> query) {
        return new Applications(Collections2.filter(applications, query));
    }

    public void assertUniqueResume(Job job, Resume resume) {
        for(Application application : applications) {
            if(application.is(resume) && application.is(job)) throw new DuplicateResumeException();
        }
    }
}
