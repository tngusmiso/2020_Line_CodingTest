import java.util.*;

public class test05 {

    class Solution {
        public String[] solution(String[][] dataSource, String[] tags) {
            
            String[] answer = {};
            List<String> tagList = Arrays.asList(tags);
            HashMap<String, Integer> countTag = new HashMap<>();
            
            for(String[] data : dataSource){
                int count = 0;
                for (int i=1; i<data.length; ++i){
                    if (tagList.contains(data[i])){
                        ++count;
                    }
                }
                if (count != 0){
                    countTag.put(data[0], count);
                }
            }
            
            List<String> keySetList = new ArrayList<>(countTag.keySet());
            Collections.sort(keySetList, (o1, o2) 
                             -> (countTag.get(o2).compareTo(countTag.get(o1))));
            
            
            answer = new String[keySetList.size()];
            int i = 0;
            for(String key : keySetList) {
                answer[i++] = key;
            }
            
            return answer;
        }
    }
}