// time complexity = O(n^2)
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        // this is same as how we compute in real world
        
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ret.add(first);
        
        for (int i=1; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // first ele
            int p1=0;
            int p2 =1;
            while (p2<i){
                row.add(ret.get(ret.size()-1).get(p1) + ret.get(ret.size()-1).get(p2));
                p1++;
                p2++;
            }
            row.add(1); // last ele
            
            ret.add(row);
        }
        
        return ret;
    }
}