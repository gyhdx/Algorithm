//package 秋招.顺网;
//
//public class Main2 {
//    private static BsTree head;
//    private static BsTree[] path = new BsTree[32];
//    private static int p;
//    public static void main(String[] args) {
//
//    }
//
//    public static boolean addNode(int value){
//        if (head == null){
//            head = new BsTree(value);
//            head.bf = 0;
//            return true;
//        }
//        p = 0;
//        BsTree pre = null;
//        BsTree cur = head;
//        while (cur != null){
//            path[p++] = cur;
//            if (cur.value == value){
//                return false;//存在就不能插入
//            }
//            pre = cur;
//            cur = (value < pre.value ? pre.left:pre.right);
//        }
//        cur = new BsTree(value);
//        cur.bf = 0;
//        if (value < pre.value){
//            pre.left = cur;
//        }else {
//            pre.right = cur;
//        }
//
//        path[p] = cur;
//        int bf = 0;
//
//        while (p>0){
//            bf = value<path[p-1].value?1:-1;
//            path[--p].bf += bf;
//            bf = path[p].bf;
//
//            if (bf == 0){
//                return true;
//            }else if (bf == 2 || bf == -2){
//                chang(bf);
//                return true;
//            }
//        }
//        return true;
//    }
//
//    private static void chang(int bf) {
//        BsTree root = path[p];
//        BsTree nRoot = null;
//        boolean flag = true;
//
//        if (bf == 2){
//            if (root.left.bf == 1){
//                nRoot = LL(root);
//            }else if (root.left.bf == -1){
//                nRoot = LR(root);
//            }
//        }else if (bf == -1){
//            if (root.right.bf == -1){
//                nRoot = RR(root);
//            }else if (root.right.bf == 1){
//                nRoot = RL(root);
//            }
//        }
//
//        if (p>0){
//            if (root.value < path[p-1].value){
//                path[p-1].left = nRoot;
//            }else {
//                path[p-1].right = nRoot;
//            }
//        }else {
//            head = nRoot;
//        }
//        return;
//    }
//
//
//    static class BsTree{
//        int value;
//        int bf;
//        BsTree left;
//        BsTree right;
//
//        public BsTree(int value){
//            this.value = value;
//        }
//    }
//}
