package core;

import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Job {
    boolean is(Recruiter recruiter);
    void displayTitle(Writer writer);
}
