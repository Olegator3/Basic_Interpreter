import javax.script.ScriptException;

/**
 * Created by ПК on 19.03.2015.
 */
public class Print extends Operator {
    public Print(String code) {
        super(code);
    }

    @Override
    public void exec(Interpeter inte) {
        Object res = null;
        inte.next();

        String trim = code.trim();
        if(trim.startsWith("\"")){
            if(trim.endsWith(";")){
                System.out.print(trim.substring(1,trim.length() - 1));
            }
            else {
                System.out.println(trim.substring(1,trim.length() - 1));
            }
            return;
        }
        try {
             res = Expression.eval(inte.getVars(),code);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(res);

    }
}
