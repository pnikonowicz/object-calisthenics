import com.google.common.base.Predicate;
import com.sun.xml.internal.ws.util.StringUtils;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeeker {

    private Resume resume;
    private final JobRepository jobRepository;
    private final JobSeekerSavedForLaterJobRepository jobSeekerSavedJobsRepository;
    private final ApplicationRepository applicationRepository;

    public JobSeeker(Resume resume, JobRepository jobRepository, JobSeekerSavedForLaterJobRepository jobSeekerSavedJobsRepository, ApplicationRepository applicationRepository) {
        this.resume = resume;
        this.jobRepository = jobRepository;
        this.jobSeekerSavedJobsRepository = jobSeekerSavedJobsRepository;
        this.applicationRepository = applicationRepository;
    }

    public void save(Job job) {
        jobSeekerSavedJobsRepository.save(new JobSeekerSavedForLaterJob(this, job));
    }

    public void apply(Job job) {
        Application application = null;
        if(job instanceof JReq) {
            applicationRepository.assertUniqueResume(resume);
            application = ((JReq) job).apply(this, resume);
        }

        if(job instanceof ATS) {
            application = ((ATS)job).apply(this);
        }

        if(application == null) throw new UnsupportedOperationException("I don't know how to apply to this job: " + job);


        applicationRepository.save(application);
    }

    public String toString() {
        return resume.toString();
    }

    public void displaySavedJobs(Writer writer) {
        Collection<JobSeekerSavedForLaterJob> savedJobs = listSavedJobs();

        for(JobSeekerSavedForLaterJob savedJob : savedJobs) {
            savedJob.displayTitle(writer);
            MyWriter.write(writer, "\n");
        }
    }

    public void displayAppliedJobs(Writer writer) {
        Collection<Job> appliedJobs = listAppliedJobs();

        for(Job appliedJob : appliedJobs) {
            appliedJob.displayTitle(writer);
            MyWriter.write(writer, "\n");
        }
    }

    private Collection<Job> listAppliedJobs() {
        Predicate jobSeekerQuery = new WasThisTheJobSeeker(this);
        return jobRepository.find(jobSeekerQuery);
    }

    private Collection<JobSeekerSavedForLaterJob> listSavedJobs() {
        Predicate jobSeekerQuery = new WasThisTheJobSeeker(this);
        return jobSeekerSavedJobsRepository.find(jobSeekerQuery);
    }
}
