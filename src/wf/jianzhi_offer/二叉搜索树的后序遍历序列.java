package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 解析：若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 任意节点的左、右子树也分别为二叉查找树；
 * 没有键值相等的节点。
 * 故只要判断
 */
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        二叉搜索树的后序遍历序列 a = new 二叉搜索树的后序遍历序列();
        int[] arr = {1,4,7,6,3,13,14,10,8};
        boolean b = a.VerifySquenceOfBST(arr);
        System.out.println(b);

    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length<=0||sequence==null)return false;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start>=end)return true;

        int i=start;

        while (sequence[i]<sequence[end]){
            i++;
        }
        int num = i-1;
        while (i<=end){
            if (sequence[i]<sequence[end]){
                return false;
            }
            i++;
        }
        boolean left = VerifySquenceOfBST(sequence,start,num);
        boolean right = VerifySquenceOfBST(sequence,num+1,end-1);
        return left&&right;

    }
}
