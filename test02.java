public class test02 {

    class Solution {
        public int solution(String answer_sheet, String[] sheets) {
            int maxIndicator = 0;
            
            for(int i = 0; i<sheets.length-1; ++i){
                for(int j = i+1; j<sheets.length; ++j){
                    String str1 = sheets[i];
                    String str2 = sheets[j];
                    
                    int misCount = 0;
                    int startSequence = -1;
                    int maxSequence = 1;
                    
                    for(int k = 0; k<answer_sheet.length(); ++k){
                        if(answer_sheet.charAt(k) != str1.charAt(k) 
                        && str1.charAt(k) == str2.charAt(k)){
                            ++misCount;
                            
                            if (startSequence == -1){
                                startSequence = k;
                            } else if (maxSequence < (k-startSequence+1)){
                                maxSequence = k-startSequence+1;
                            }
                        } else {
                            startSequence = -1;
                        }
                    }
                    
                    int indicator = (misCount == 0) ? misCount : maxSequence*maxSequence + misCount;
                    if (maxIndicator < indicator){
                        maxIndicator = indicator;
                    }
                }
            }
            
            return maxIndicator;
        }
    }
}