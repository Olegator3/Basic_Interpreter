import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ПК on 19.03.2015.
 */
public class Interpeter {
    TreeMap<Integer,Operator> code = new TreeMap<Integer, Operator>();
    Map<String,Double> vars = new HashMap<String, Double>();
    Integer curLine;

    public void next(){
       curLine = code.higherKey(curLine);
    }
    public void goTO(int line){
        curLine = line;

    }
    //20 LET x=2;
    public void parse(String line){
        if(line.equalsIgnoreCase("RUN")){
            this.run();
            return;
        }
        if(line.equalsIgnoreCase("LIST")){
            for(int number : code.keySet()){
                System.out.println(number+" "+code.get(number));
            }
            return;
        }
        try {
            String parts[] = line.split(" ");
            int lineN = Integer.parseInt(parts[0]);
            String opName = parts[1];
            Operator operator = OperatorFactory.createOperator(opName, line.substring(parts[0].length()+parts[1].length()+2));
            code.put(lineN,operator);
        }catch (RuntimeException e){
            System.err.println("Wrong Operation!");
        }

    }

    public Map<String, Double> getVars() {
        return vars;
    }
    public void run(){
       curLine = code.firstKey();
        while (true){
            Operator operator = code.get(curLine);
            operator.exec(this);
            if(curLine == null) break;
        }
    }
}
