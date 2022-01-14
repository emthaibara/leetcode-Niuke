import java.util.HashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/14
 *          205. 同构字符串
 *          HashMap的作法，我这里维护了一个哈希表遍历2遍
 *          官方给出的是遍历一边维护两个哈希表
 */


public class Question_205 {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length() != t.length())return false;
            //这里可以启用两个线程同时扫描 s t 加快速度

            return doMap(s).equals(doMap(t));
        }
        public String doMap(String s){
            HashMap<String,Integer> map = new HashMap<>();
            StringBuilder a = new StringBuilder();
            int max = 1;
            for(int i = 0 ; i < s.length() ; i++){
                if(map.containsKey(s.charAt(i)+"")){
                    map.put(s.charAt(i)+"",map.get(s.charAt(i)+""));
                }else{
                    map.put(s.charAt(i)+"",max);
                    max++;
                }
                a.append(map.get(s.charAt(i) + ""));
            }
            return a.toString();
        }
    }
}
