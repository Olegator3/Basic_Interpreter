/**
 * Created by ПК on 19.03.2015.
 */
public class Goto extends Operator {
    public Goto(String code) {
        super(code);
    }

    @Override
    public void exec(Interpeter inte) {
        inte.goTO(Integer.parseInt(code));
    }
}
