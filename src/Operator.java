/**
 * Created by ПК on 19.03.2015.
 */
public abstract class Operator {
    String code;

    protected Operator(String code) {
        this.code = code;
    }
    public  abstract  void exec(Interpeter inte);

    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase() + " " + code;
    }
}
