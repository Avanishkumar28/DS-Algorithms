package google;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/discuss/interview-question/2233033/Google-Interview-Question
 * For example, Router A is at (0, 0); Router B is at (0, 8); Router C is at (0, 17); Router D is at (11, 0).
 *
 * If the wireless range is 10, when Router A sends a message, it could first reach B;
 * the message from Router B would further reach Router C but Router D would never receive this message.
 *
 * Given a list of routers' locations (their names and the corresponding 2D coordinates),
 * tell me whether a message from Router A can reach Router B.
 * */
public class RouterProblem {

    public static boolean broadcastSignal(Map<String, int[]> routersMap, int range,
                                          String source, String destination){
        if(routersMap == null || !routersMap.containsKey(source) || !routersMap.containsKey(destination))
            return false;
        int[] sourceLocation = routersMap.get(source);
        int[] destLocation = routersMap.get(destination);
        //make it all positive i.e. (-1, 1)=> (1,1)
        sourceLocation[0] = sourceLocation[0] < 0 ? sourceLocation[0] * -1 : sourceLocation[0];
        sourceLocation[1] = sourceLocation[1] < 0 ? sourceLocation[1] * -1 : sourceLocation[1];

        destLocation[0] = destLocation[0] < 0 ? destLocation[0] * -1 : destLocation[0];
        destLocation[1] = destLocation[1] < 0 ? destLocation[1] * -1 : destLocation[1];

        //check if destination is reachable
        if (sourceLocation[0]+range >= destLocation[0] || sourceLocation[1]+range >= destLocation[1]){
            return true;
        }
        PriorityQueue<Router> sortOnX = new PriorityQueue<>((r1, r2) -> r1.x - r2.x);
        PriorityQueue<Router> sortOnY = new PriorityQueue<>((r1, r2) -> r1.y - r2.y);
        for(Map.Entry<String, int[]> entity : routersMap.entrySet()){
            Router router = new Router(entity.getKey(), entity.getValue()[0], entity.getValue()[1]);
            sortOnX.add(router);
            sortOnY.add(router);
        }
        while (!sortOnX.isEmpty() || !sortOnY.isEmpty()){
            while (!sortOnX.isEmpty()){
                Router currentX = sortOnX.remove();
                Integer[] arr = sortOnX.toArray(new Integer[sortOnX.size()]);
                if (currentX.name.equals(source))
                    break;
            }
        }

        return false;
    }
    static class Router{
        String name;
        int x;
        int y;
        int[] location = new int[]{x,y};
        public Router(String name, int x, int y){
            this.name = name;
            this.x = x;
            this.y = y;
        }

    }
}
