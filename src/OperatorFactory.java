import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ПК on 19.03.2015.
 */
public class OperatorFactory {
   static Map<String,Class> ops = new HashMap<>();
    static {
        ops.put("PRINT",Print.class);
        ops.put("LET",Let.class);
        ops.put("IF",If.class);
        ops.put("GOTO",Goto.class);
    }
    public static Operator createOperator(String opName, String substring) {
        Class opClass = ops.get(opName);
        try {
           return (Operator)(opClass.getConstructor(String.class).newInstance(substring));
        } catch (InstantiationException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }

    }
}
