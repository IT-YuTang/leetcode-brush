[中文原题](https://leetcode-cn.com/problems/two-sum/)
#### 两数之和
> 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
  你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例：
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

#### 原题解析
通过数组元素计算结果，同时还得获取对应的下标，所以每次运算都需要清楚的知道数组元素及其下标。

##### 方法一：两层循环遍历
很容易想到通过两层循环遍历整个数组，找到合适的解，返回结果。

* 解题代码
```
public static int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        throw new IllegalArgumentException("Solution Not Found");
    }
```
* 复杂度分析
    * 时间复杂度：每个元素都需要遍历数组的其余部分来找到它对应的目标元素，花费时间为O(n)，所以所有元素遍历时间复杂度为O(n^2)。
    * 空间复杂度：不存在其它开销，空间复杂度为O(1)。
    
    
##### 方法二：哈希表一次遍历
能不能通过一次循环就能找到结果？如果使用一次循环，那参与计算的数组元素和下标需要有对应的存储。既然要同时知道数组元素和下标，能够使用的数组结构就很有限，哈希表作为首选，数组元素与下标分别作为key和value。每次运算查看是否有对应的key，如果有，则找到了答案返回结果；如果没有，添加到哈希表中，继续运算。
###### 解题代码
```
public static int[] twoSum02(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)){
                return new int[]{map.get(result),i};
            }

            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("Solution Not Found");
    }
```

###### 复杂度分析
    * 时间复杂度：O(n)，只遍历了包含有n个元素的列表一次。在表中进行的每次查找只花费O(1)的时间。
    * 空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储n个元素。

#### 性能亲测
在同一环境下，提交代码后的执行用时：

| 方案  | 执行时间 |
| :-----: | :-----: |
| 两层循环遍历 | 29ms    |
| 哈希表一次遍历 | 5ms      |

#### 请指教
有更优方案，欢迎指教。
