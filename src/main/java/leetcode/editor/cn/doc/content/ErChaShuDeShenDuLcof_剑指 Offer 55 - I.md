<p>输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。</p>

<p>例如：</p>

<p>给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>

<pre>    3
   / \
  9  20
    /  \
   15   7</pre>

<p>返回它的最大深度&nbsp;3 。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li><code>节点总数 &lt;= 10000</code></li> 
</ol>

<p>注意：本题与主站 104&nbsp;题相同：<a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/</a></p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>

<div>👍 235, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=er-cha-shu-de-shen-du-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [104. 二叉树的最大深度](/problems/maximum-depth-of-binary-tree) 相同。

> 本文有视频版：[二叉树/递归的框架思维（纲领篇）](https://www.bilibili.com/video/BV1nG411x77H)

[我的刷题经验总结](https://labuladong.github.io/article/fname.html?fname=算法心得) 说过，二叉树问题虽然简单，但是暗含了动态规划和回溯算法等高级算法的思想。

下面提供两种思路的解法代码。

**详细题解：[东哥带你刷二叉树（纲领篇）](https://labuladong.github.io/article/fname.html?fname=二叉树总结)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/***** 解法一，回溯算法思路 *****/
class Solution {
    int depth = 0;
    int res = 0;

public:
    int maxDepth(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = std::max(res, depth);
        traverse(root->left);
        traverse(root->right);
        // 后序遍历位置
        depth--;
    }
};

/***** 解法二，动态规划思路 *****/
class Solution2 {
public:
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + std::max(leftMax, rightMax);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

# 解法一，回溯算法思路
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        depth, res = 0, 0
        self.traverse(root, depth, res)
        return res
    
    # 遍历二叉树
    def traverse(self, root: TreeNode, depth: int, res: int) -> None:
        if not root:
            return
        # 前序遍历位置
        depth += 1
        # 遍历的过程中记录最大深度
        res = max(res, depth)
        self.traverse(root.left, depth, res)
        self.traverse(root.right, depth, res)
        # 后序遍历位置
        depth -= 1

# 解法二，动态规划思路
class Solution2:
    # 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + max(leftMax, rightMax)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
/***** 解法一，回溯算法思路 *****/
class Solution {

    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
}

/***** 解法二，动态规划思路 *****/
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 // 解法一，回溯算法思路
func maxDepth(root *TreeNode) int {
    depth := 0
    res := 0
    var traverse func(root *TreeNode)

    traverse = func(root *TreeNode) {
        if root == nil {
            return
        }

        depth++
        res = Max(res, depth)
        traverse(root.Left)
        traverse(root.Right)
        depth--
    }

    traverse(root)
    return res
}

// 解法二，动态规划思路
func maxDepth2(root *TreeNode) int {
    if root == nil {
        return 0
    }
    leftMax := maxDepth(root.Left)
    rightMax := maxDepth(root.Right)
    return 1 + Max(leftMax, rightMax)
}

func Max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 解法一，回溯算法思路
var maxDepth = function(root) {
    let depth = 0;
    let res = 0;
    
    // 遍历二叉树
    function traverse(root) {
        if (root === null) {
            return;
        }
        
        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
    
    traverse(root);
    return res;
};

// 解法二，动态规划思路
var maxDepth = function(root) {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    if (root === null) {
        return 0;
    }
    let leftMax = maxDepth(root.left);
    let rightMax = maxDepth(root.right);
    // 根据左右子树的最大深度推出原二叉树的最大深度
    return 1 + Math.max(leftMax, rightMax);
};
```

</div></div>
</div></div>

**类似题目**：
  - [1376. 通知所有员工所需的时间 🟠](/problems/time-needed-to-inform-all-employees)
  - [144. 二叉树的前序遍历 🟢](/problems/binary-tree-preorder-traversal)
  - [543. 二叉树的直径 🟢](/problems/diameter-of-binary-tree)
  - [559. N 叉树的最大深度 🟢](/problems/maximum-depth-of-n-ary-tree)
  - [865. 具有所有最深节点的最小子树 🟠](/problems/smallest-subtree-with-all-the-deepest-nodes)
  - [剑指 Offer 55 - I. 二叉树的深度 🟢](/problems/er-cha-shu-de-shen-du-lcof)

</details>
</div>



