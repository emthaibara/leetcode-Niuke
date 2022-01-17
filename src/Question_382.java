import java.util.ArrayList;
import java.util.Random;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/16
 *              382. 链表随机节点
 *
 *             O(n)的作法比较直接暴力的作法就是遍历一遍链表存入ArrayList然后取一个[0,List.size()-1]的随机数按索引取值
 *
 *             但是这不适合n-----很大很大，无法确定数据流大小的时候我们没办法用东西来存储，就要用下面的算法
 *
 *             这道题主要考查----蓄水池抽样算法（Reservoir Sampling）
 *                  具体问题就将算法具像化，不同场景的事务不同，但处理逻辑算法是一类似的
 *
 *                  同样从头到尾遍历一边----注意不需要容器来暂存！！！
 *                  每次从[0，i)随机挑选一个数，如果这个数字==0那么就替换答案
 *                  这样做可以保证最后的结果-----1/n
 *                  证明就不说了，数学证明
 */


public class Question_382 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNodeListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    //me
    static class Solution {
        private final ListNode head;
        private final Random random;

        private ArrayList<Integer> list = new ArrayList<>();

        public Solution(ListNode head) {
            this.head = head ;
            this.random = new Random();
            ListNode node = head;
            while(node != null){
                list.add(node.val);
                node = node.next;
            }
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
    //官方
    static class ReservoirSampling {
        private final ListNode head;
        private final Random random;

        public ReservoirSampling(ListNode head) {
            this.head = head ;
            this.random = new Random();
        }

        public int getRandom() {
            int i = 1, ans = 0;
            for (ListNode node = head; node != null; node = node.next) {

                if (random.nextInt(i) == 0) {
                    ans = node.val;
                }

                ++i;
            }
            return ans;
        }
    }


    static class ListNode{
        public int val;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
