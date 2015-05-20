import javax.script.ScriptException;

/**
 * Created by ПК on 19.03.2015.
 */
public class Let extends Operator {
    public Let(String code) {
        super(code);
    }

    @Override
    public void exec(Interpeter inte) {
        String[] parts = code.split("=");
        try {

            Object val = Expression.eval(inte.getVars(),parts[1]);
            inte.getVars().put(parts[0].trim(),Double.parseDouble(val.toString()));

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        inte.next();
    }
}
