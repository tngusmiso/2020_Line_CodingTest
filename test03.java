import java.util.Arrays;

public class test03 {
    
    class Solution {
        public int solution(String road, int n) {
            String[] part = road.split("0");
            int maxLength = 0;
            
            System.out.println(Arrays.toString(part));
            
            for(int i=0; i<part.length-n+1; ++i){
                int length = 0;
                int count = n;
                for(int j=0; j<count; ++j){
                    if (part[i+j].length()==0){
                        if (i+count<part.length-1){
                            ++count;
                        }
                    } else {
                        length += part[i+j].length();
                    }
                }
                if (maxLength < length){
                    maxLength = length;
                }
            }
            
            return maxLength+n;
        }
    }
}