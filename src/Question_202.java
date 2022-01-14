import java.util.ArrayList;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/13
 *       202. 快乐数
 *       这道题没啥好说的，就找找规律，出现1直接判断是快乐数
 *       如果没出现1，出现了重复的sum那么直接判断不是快乐数
 *       当然我这里不是最优的解法
 *       我这里用list来保存sum用于判重（实际上内部肯定遍历了一边list，去查找待判断sum，我感觉换成HashSet效率会高一些，
 *       HashSet底层是红黑树--有进化机制，查找效率很高）
 */

public class Question_202 {
    static class Solution {
        public boolean isHappy(int n) {
            List<Integer> list = new ArrayList<>();
            int sum = -1 ;
            while(sum != 1){
                sum = 0;
                while(true){
                    int k = n % 10;
                    if((k == 0) && (n/10) == 0){
                        break;
                    }
                    n = n/10;
                    sum += (k*k);
                }
                if(list.contains(sum))
                    return false;
                list.add(sum);
                n = sum;
            }
            return true;
        }
    }
}
