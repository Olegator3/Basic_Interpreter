import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ПК on 19.03.2015.
 */
public class If extends Operator {
    public If(String code) {
        super(code);
    }

    @Override
    public void exec(Interpeter inte) {
        Pattern pattern = Pattern.compile("(.*) THEN GOTO (.*)");
       Matcher matcher = pattern.matcher(code);
        inte.next();
       if(!matcher.find()){
           System.err.println("Bad operator IF!");
       }
        else {
           String cond = matcher.group(1);
           int line = Integer.parseInt(matcher.group(2));

           try {

              Object res = Expression.eval(inte.getVars(), cond.replace("=","=="));
               if(res instanceof Boolean && res.equals(true))
               inte.goTO(line);
           } catch (ScriptException e) {
               e.printStackTrace();
           }

       }
    }
}
