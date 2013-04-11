/**
 * Created with IntelliJ IDEA.
 * User: pnikonowicz
 * Date: 4/11/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Conjunction<A> implements Query<A> {
    private final Query<A> a;
    private final Query<A> b;

    public Conjunction(Query<A> a, Query<A> b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean assertTrue(A o) {
        return a.assertTrue(o) && b.assertTrue(o);
    }
}
