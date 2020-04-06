￼
import java.util.List;
import java.util.ArrayList;

class Solution {

    public int solution(String inputString) {
        
        int answer = 0;
        String[] strArr = inputString.split("");
        List<String> stack = new ArrayList<>();
        
        for (String s : strArr){
            
            int lastIdx = stack.size()-1;
            
            if (s.equals("(") || s.equals("{") || s.equals("[") || s.equals("<") ) {
                stack.add(s);   
            } else if(s.equals(")")) {
                
                if (stack.size()>0 && stack.get(lastIdx).equals("(")){
                    stack.remove(lastIdx);
                    ++answer;
                } else {
                    return -1;
                }
                
            } else if(stack.size()>0 && s.equals("}")){
                
                if (stack.get(lastIdx).equals("{")){
                    stack.remove(lastIdx);
                    ++answer;
                } else {
                    return -1;
                }
                
            } else if(stack.size()>0 && s.equals("]")){
                
                if (stack.get(lastIdx).equals("[")){
                    stack.remove(lastIdx);
                    ++answer;
                } else {
                    return -1;
                }
                
            } else if(stack.size()>0 && s.equals(">")){
                
                if (stack.get(lastIdx).equals("<")){
                    stack.remove(lastIdx);
                    ++answer;
                } else {
                    return -1;
                }
                
            }
        }
        
        if (stack.size() != 0){
            return -1;
        }
        return answer;
    }
}