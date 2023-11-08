package Day231013;

import java.util.*;

public class AvoidFlood {
    public static final int[] rains = {1, 2, 0, 2, 3};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }

    public static int[] avoidFlood(int[] rains) {
        int[] ans =  new int[rains.length];
        Arrays.fill(ans, 1);

        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();


        for(int i = 0;i < rains.length; i++) {
            if(rains[i] > 0) {
                if(map.containsKey(rains[i])){
                    int index = map.get(rains[i]);
                    Integer k = set.ceiling(index);
                    if(k == null) return new int[0];
                    ans[k] = rains[i];
                    set.remove(k);
                }
                ans[i]=-1;
                map.put(rains[i], i);
            }
            else set.add(i);
        }
        return ans;
    }
}
