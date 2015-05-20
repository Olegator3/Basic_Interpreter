import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

/**
 * Created by ПК on 19.03.2015.
 */
public class Expression {

    public static Object eval(Map<String,Double> vars,String code) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        for(String var : vars.keySet()){
          code = code.replace(var,vars.get(var).toString());
        }
        code = code.replace("SQRT","Math.sqrt");
       return engine.eval(code);
    }
}
