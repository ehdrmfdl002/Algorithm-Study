import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            hm.put(genres[i],hm.getOrDefault(genres[i],0)+plays[i]);
        }
        
        ArrayList<String> list = new ArrayList<>(hm.keySet());
        list.sort((value1,value2)->(hm.get(value2).compareTo(hm.get(value1))));
        
        List<Integer> tmp = new ArrayList<>();
        for(String s: list){
            int first = 0;
            int second = 0;
            int max = 0;
            
            for(int i=0;i<genres.length;i++){
                if(s.equals(genres[i])){
                    if(plays[i]>max){
                        max = plays[i];
                        first = i;
                    }
                }
            }
            max=0;
            for(int i=0;i<genres.length;i++){
                if(s.equals(genres[i])){
                    if(i!=first && plays[i]>max){
                        max = plays[i];
                        second = i;
                    }
                }
            }
            tmp.add(first);
            
            if(max!=0){
                tmp.add(second);
            }
        }
        int[] answer = new int[tmp.size()];
        
        for(int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}
