package core;

import collection.JobSeekerSavedForLaterJobs;
import collection.Jobs;
import com.google.common.base.Predicate;
import data.ApplicationRepository;
import data.JobRepository;
import data.JobSeekerSavedForLaterJobRepository;
import predicate.WasThisTheJobSeeker;

import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobSeeker {

    private Resume resume;
    private Name name;

    public JobSeeker(Resume resume, Name name) {
        this.resume = resume;
        this.name = name;
    }

    public void save(Job job, JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository) {
        jobSeekerSavedForLaterJobRepository.save(new JobSeekerSavedForLaterJob(this, job));
    }

    public void apply(Job job, ApplicationRepository applicationRepository, ApplicationNumber applicationNumber) {
        Application application = null;
        if(job instanceof JReq) {
            applicationRepository.assertUniqueResume(job, resume);
            application = ((JReq) job).apply(this, applicationNumber, resume);
        }

        if(job instanceof ATS) {
            application = ((ATS)job).apply(this, applicationNumber);
        }

        if(application == null) throw new UnsupportedOperationException("I don't know how to apply to this job: " + job);


        applicationRepository.save(application);
    }

    public void displaySavedJobs(Writer writer, JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository) {
        JobSeekerSavedForLaterJobs savedJobs = listSavedJobs(jobSeekerSavedForLaterJobRepository);
        savedJobs.displayTitle(writer);

    }

    public void displayAppliedJobs(Writer writer, JobRepository jobRepository) {
        Jobs appliedJobs = listAppliedJobs(jobRepository);
        appliedJobs.displayTitle(writer);
    }

    private Jobs listAppliedJobs(JobRepository jobRepository) {
        Predicate jobSeekerQuery = new WasThisTheJobSeeker(this);
        return jobRepository.find(jobSeekerQuery);
    }

    private JobSeekerSavedForLaterJobs listSavedJobs(JobSeekerSavedForLaterJobRepository jobSeekerSavedForLaterJobRepository) {
        Predicate jobSeekerQuery = new WasThisTheJobSeeker(this);
        return jobSeekerSavedForLaterJobRepository.find(jobSeekerQuery);
    }

    public void display(Writer writer) {
        name.display(writer);
    }
}
