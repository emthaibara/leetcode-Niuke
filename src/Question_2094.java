import java.util.*;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/12
 *          2094.找出 3 位偶数
 *                  这里的做法是罗列100-1000之间的所有偶数
 *                  然后去比对每一位的数是否存在数组中
 *                  这里的比对方法值得一记：
 *                      他首先是用一个临时数组cur，具体操作是把digit的每个出现的数值作为cur的索引并把他对应的值赋1
 */

public class Question_2094 {
    static class Solution {
        public int[] findEvenNumbers(int[] digits) {
            int[] cur = new int[10];
            for (int digit : digits) {
                cur[digit]++;
            }
            List<Integer> res=new ArrayList<Integer>();
            for(int i=100;i<1000;i+=2){
                int a=i/100;
                int b=i/10%10;
                int c=i%10;
                cur[a]--;
                cur[b]--;
                cur[c]--;
                if(cur[a]<0||cur[b]<0||cur[c]<0){

                }else{
                    res.add(i);
                }
                cur[a]++;
                cur[b]++;
                cur[c]++;
            }
            int[] ans=new int[res.size()];
            for(int i=0;i<res.size();i++){
                ans[i]=res.get(i);
            }
            return ans;
        }
    }
}
