/*
 * Feature 9 - Construct Recommendation Tree - PROBLEM - Binary Tree Inorder and Preorder traversal
 */

package Facebook;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

public class BinaryTreePreAndInOrderTraversal {
    public TreeNode buildTreeHelper(int[] pOrder, int[] iOrder, int left, int right, HashMap<Integer, Integer> mapping, int[] pIndex) {
        if(left > right) return null;

        int curr = pOrder[pIndex[0]];
        pIndex[0]++;
        TreeNode root = new TreeNode(curr);
        if(left == right){
            return root;
        }

        int inIndex = mapping.get(curr);
        root.left = buildTreeHelper(pOrder, iOrder, left, inIndex - 1, mapping, pIndex);
        root.right = buildTreeHelper(pOrder, iOrder, inIndex + 1, mapping, pIndex);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> mapping = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mapping.put(inorder[i], i);
        }

        int[] pIndex = {0};
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, mapping, pIndex);
    }
}
