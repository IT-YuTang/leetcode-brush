[中文原题](https://leetcode-cn.com/problems/add-two-numbers/)
#### 两数相加
> 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

#### 原题解析
题中给的的是单向链表，并且每一位数字是逆序存储，在前面节点存储的就是低位数字，所以在处理进位(相加大于10)时，只需要从左向右进位即可。

##### 错误解法
* 由于都是存储的数字，很容易联想到把每一位取出来，反转，再转换为数字。两个数字相加，再反序，依次添加到链表。该方法不可行，因为位数不确定，数字型是不够容纳太长的位数。
* 使用中层间转换，比如栈、队列等，该方法能够实现，不过此题既然给出了链表，就只使用链表也可以实现。
    
##### 正确解法

1. 可初始化一个表头，同时当前节点也指向表头；

![image](https://github.com/IT-YuTang/leetcode-brush/blob/master/src/com/it/yutang/lc002/img/img1.png)

2. 遍历两个链表，当有一个不空时，继续循环。当其中一个链表为空时，值为0，两个节点相加，需要注意的是加上它的进位值。如果当前结果大于9，则会生成进位值；

![image](https://github.com/IT-YuTang/leetcode-brush/blob/master/src/com/it/yutang/lc002/img/img2.png)

3. 当前节点继续后移，直到链表遍历完成；

![image](https://github.com/IT-YuTang/leetcode-brush/blob/master/src/com/it/yutang/lc002/img/img3.png)

4. 最后需要判断最后一个节点是否有进位，如果有进位，生成一个新的节点存放进位值。

![image](https://github.com/IT-YuTang/leetcode-brush/blob/master/src/com/it/yutang/lc002/img/img4.png)


###### 解题代码
```
public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode header = new ListNode(0);
        ListNode curNode = header;

        int carry = 0;
        while (node1 != null || node2 != null) {
            int node1Val = node1 == null ? 0 : node1.val;
            int node2Val = node2 == null ? 0 : node2.val;

            int sum = carry + node1Val + node2Val;
            carry = sum / 10;

            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;

            if (node1 != null)
                node1 = node1.next;
            if (node2 != null)
                node2 = node2.next;
        }

        if (carry > 0){
            curNode.next = new ListNode(carry);
        }

        return header.next;
    }
```

###### 复杂度分析
    * 时间复杂度：O(max(m,n))，m和n分别表示两个链表的长度，最多重复max(m, n)次。
    * 空间复杂度：O(max(m,n))，新列表的长度最多为 \max(m,n) + 1max(m,n)+1。

#### 扩展
> 如果链表中的数字不是按逆序存储的呢？例如：
> (3 \to 4 \to 2) + (4 \to 6 \to 5) = 8 \to 0 \to 7 (3→4→2)+(4→6→5)=8→0→7

正序存储，需要从最后一位开始计算，进位与数学一样。如果是单向链表，需要先遍历，逆序排列再进行计算。
可采用双向链表实现。

#### 请指教
有更优方案，欢迎指教。
