import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                hs.add(numbers[i]+numbers[j]);
            }
        }
        
        return hs.stream().sorted().mapToInt(i->i).toArray();
    }
}
