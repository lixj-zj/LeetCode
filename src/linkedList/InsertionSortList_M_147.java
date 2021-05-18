import linkedList.LinkedLists;
import linkedList.ListNode;

/**
 * @Description: 对链表进行插入排序
 * 插入排序算法：
 * 1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 3.重复直到所有输入数据插入完为止。
 * <p>
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * --------------------------------------
 * @ClassName: InsertionSortList_M_147.java
 * @Date: 2021/5/17 11:32
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class InsertionSortList_M_147 {

    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();
        int[] nums = {4, 2, 1, 3};
        for (int num : nums) {
            linkedLists.addListNodeFromLast(num);
        }
        linkedLists.showList(insertionSortList(linkedLists.head));
    }

    public static ListNode insertionSortList(ListNode head) {

        return head;
    }

}
