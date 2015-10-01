package euler.Euler15;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dreaminteam on 14.10.14.
 */
public class LatticePaths {

    public static void main(String[] args) {

        LatticePaths lp = new LatticePaths();
        System.out.println(lp.numberOfRoutes(20, 20));

        for (Map.Entry<String,Long> entry: saveRoutes.entrySet()){
            String key=entry.getKey();
            Long value=entry.getValue();
            System.out.println(key+" >>> " +value);
        }

    }

    public long numberOfRoutes(int line, int column) {

        long result = 1;

        if (saveRoutes.containsKey(line + ";" + column)) {
            return saveRoutes.get(line + ";" + column);
        }

        if (line == 0 | column == 0) {
            saveRoutes.put(line+";"+column,1L);
            return result;
        }

        result = numberOfRoutes(line, column - 1) + numberOfRoutes(line - 1, column);
        saveRoutes.put(line+";"+column,result);
        return result;
    }

    public static Map<String, Long> saveRoutes = new HashMap<>();
}
