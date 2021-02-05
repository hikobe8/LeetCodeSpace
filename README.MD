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

#### BFS常见题型

* [x] 中等[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)
* [x] 简单[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
* [x] 中等[199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
* [x] 简单[101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
* [x] 中等[103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
* [x] 简单[111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
* [x] 中等[515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
* [x] 中等[429. N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

### DFS(Depth-First-Search) 深度优先查询

二叉树的三种遍历
```$java

//前序遍历 PreOrder
public void dfs(TreeNode root){
    if(root == null) {
        return null;
    }   
    print(root.val);
    dfs(root.left);
    dfs(root.right);
}


//中序遍历 InOrder
public void dfs(TreeNode root){
    if(root == null) {
        return null;
    }   
    dfs(root.left);
    print(root.val);
    dfs(root.right);
}

//后序遍历 PostOrer
public void dfs(TreeNode root){
    if(root == null) {
        return null;
    }   
    dfs(root.left);
    dfs(root.right);
    print(root.val);
}

```
Bottom Up DFS 从下往上递归

一般步骤
1. 定义Base Case，结束递归的条件
2. 向子问题要答案(return value)
3. 利用子问题的答案构建当前问题（当前递归层）的答案
4. 若有必要，做一些额外操作
5. 返回答案到父问题


Top Down DFS 从上往下递归

一般步骤
1. 定义Base Case，结束递归的条件
2. 利用父问题传下来的值做一些计算
3. 若有必要，做一些额外操作
4. 把值传下去给子问题继续递归


### DFS常见题型
* [x] 简单[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
* [x] 困难[124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
* [x] 中等[129. 求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers)
* [x] 中等[98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)
* [x] 简单[110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)
* [ ] 中等[113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)
* [ ] 中等[236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
* [ ] 中等[450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/)
* [ ] 中等[508. 出现次数最多的子树元素和](https://leetcode-cn.com/problems/most-frequent-subtree-sum/)