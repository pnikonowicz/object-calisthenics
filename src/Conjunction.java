import com.google.common.base.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Conjunction<A> implements Predicate<A> {
    private final Predicate<A> a;
    private final Predicate<A> b;

    public Conjunction(Predicate<A> a, Predicate<A> b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean apply(A o) {
        return a.apply(o) && b.apply(o);
    }
}
