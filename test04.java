import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;

public class test04 {

    class Solution {
        public String[][] solution(String[][] snapshots, String[][] transactions) {
            String[][] answer = {};
            
            TreeMap<String,Integer> balance = new TreeMap<String,Integer>();
            ArrayList<String> checkedID = new ArrayList<>();
            
            for (String[] snap : snapshots){
                balance.put(snap[0], Integer.parseInt(snap[1]));
            }
            
            for(int i=0; i<transactions.length; ++i){
                
                if (checkedID.contains(transactions[i][0])){
                    continue;
                }
                
                checkedID.add(transactions[i][0]);
                
                String name = transactions[i][2];
                Integer money = Integer.parseInt(transactions[i][3]);
                    
                switch (transactions[i][1]) {
                    case "SAVE":
                        if(balance.containsKey(name)){
                            money += balance.get(name);
                        }
                        balance.put(name, money);
                        break;
                        
                    case "WITHDRAW":
                        if(balance.containsKey(name)){
                            money -= balance.get(name);
                        }
                        balance.put(name, -money);
                        break;
                }
            }
            
            answer = new String[balance.size()][2];
            Iterator<String> iterator = balance.keySet().iterator();
            
            int i = 0;
            while (iterator.hasNext()){
                String key = iterator.next();
                String value = ""+ balance.get(key);
                
                answer[i][0] = key;
                answer[i][1] = value;
                ++i;
            }
            
            return answer;
        }
    }
}