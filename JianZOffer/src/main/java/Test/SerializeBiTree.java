package main.java.Test;


/**
 * @Desc:
 * @Date: 2019/2/2 11:08  better late than never. 认真思考，不要直接就动手写
 * 利用前序遍历
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 所谓序列化就是将二叉树遍历为字符串，
 * 所谓反序列化就是将字符串还原成二叉树
 * 当遍历到null指针时，用'#'替代，节点之间用‘,’隔开
 */
public class SerializeBiTree {

    public static int index = -1;  //节点在序列中的索引

    static String Serialize(TreeNode root) {
        StringBuffer strbuf = new StringBuffer();
        if (root == null) {
            strbuf.append("#,");
            return strbuf.toString();
        }
        strbuf.append(root.val+",");
        strbuf.append(Serialize(root.left));
        strbuf.append(Serialize(root.right));
        return strbuf.toString();
    }

    static TreeNode Deserialize(String str) {

        String []s=str.split(",");//将序列化之后的序列用，分隔符转化为数组
        index++;//索引每次加一
        int len=s.length;
        if(index>len) {//鲁棒性
            return null;
        }
        TreeNode treeNode=null;
        if(!s[index].equals("#")) {//不是叶子节点 继续走 是叶子节点出递归
            treeNode=new TreeNode(Integer.parseInt(s[index]));
            treeNode.left=Deserialize(str);
            treeNode.right=Deserialize(str);
        }
        return treeNode;
        /*index++;
        String stra[] = str.split(",");
        if (index >= stra.length) return null;
        TreeNode root = null;
        if (!stra[index].equals("#")) { //不是叶子节点 继续走 是叶子节点出递归
            root = new TreeNode(Integer.valueOf(stra[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;*/
    }

    public static void main(String[] args) {
        TreeNode s=new TreeNode(1);
        s.left=new TreeNode(2);
        s.right=new TreeNode(3);
        s.left.left=new TreeNode(4);
        s.left.right=new TreeNode(5);
        s.right.left=new TreeNode(6);
        s.right.right=new TreeNode(7);
        String s1=Serialize(s);
        System.out.print("-------------");
        Deserialize(s1);
        System.out.print("-------------");
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
