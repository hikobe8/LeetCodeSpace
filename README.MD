## 二叉树

### BFS(Breadth-First-Search) 宽度优先查询

BFS 常见代码模板

```$java
    //存放每层元素的队列，队列为先进先出的结构
    Queue<TreeNode> queue = new 
    LinkedList<>();
    //将根节点插入队列
    queue.offer(root);
    //开始遍历队列，每次循环为二叉树的一层
    while (!queue.isEmpty()) {
        //获取当前层的宽度
        int size = queue.size();
        //开始遍历当前层的所有节点
        for (int i = 0; i < size; i++) {
            //获取节点
            TreeNode curr = queue.poll();
            //继续添加当前节点的左节点到下一层
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            //继续添加当前节点的右到下一层
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        
    }

```

常见题型

* 中等[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)
* 简单[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
* 中等[199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
* 简单[101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
* 中等[103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
* 简单[111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
* 中等[515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
* 中等[429. N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)