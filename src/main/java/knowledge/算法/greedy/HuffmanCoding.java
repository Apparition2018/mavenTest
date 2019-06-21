package knowledge.算法.greedy;

/**
 * 哈夫曼编码（霍夫曼编码）
 * 一种编码方式，哈夫曼编码是可变字长编码(VLC)的一种。
 * Huffman于1952年提出一种编码方法，该方法完全依据字符出现概率来构造异字头的平均长度最短的码字
 * <p>
 * https://blog.csdn.net/likunkun__/article/details/80258515
 * https://blog.csdn.net/xuefeng0707/article/details/7844834
 */
public class HuffmanCoding {

    /**
     * @param cs    : characters
     * @param freqs : frequency of each character
     */
    private static void huffman(char[] cs, double[] freqs) {
        int n = cs.length;
        MinHeap<TreeNode> heap = new MinHeap<>(n);
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(cs[i], freqs[i]);
            heap.add(node);     // 以最小堆来每次取出频率最小的两个
            nodes[i] = node;    // 保存所有的叶子节点
        }

        TreeNode node, node1, node2;
        while (heap.size > 1) {
            // 取出两个最小的
            node1 = heap.removeMin();
            node2 = heap.removeMin();

            node = new TreeNode('\0', node1.freq + node2.freq);
            node.left = node1;
            node.right = node2;
            node1.parent = node;
            node2.parent = node;
            heap.add(node); // 组合成一个新的节点，并放入堆中，继续比较

            System.out.println(node1.val + "+" + node2.val + " : " + node1.freq + "+" + node2.freq + " = " + node.freq);
        }
        heap.removeMin(); // 二叉树根节点

        StringBuffer sb;
        for (int i = 0; i < n; i++) {
            node = nodes[i]; // 从每个叶子节点，向上追溯，直到根节点，确定每个字符的编码
            sb = new StringBuffer();
            while (node != null) {
                if (node.parent != null) {
                    if (node == node.parent.left) {
                        sb.insert(0, 0); // 如果是左边的，编码取0
                    } else {
                        sb.insert(0, 1); // 如果是右边的，编码取1
                    }
                }
				node = node.parent;
            }
            System.out.println(nodes[i].val + " : " + sb.toString());
        }
    }

    public static void main(String[] args) {
        char[] cs = {'a', 'b', 'c', 'd', 'e', 'f'};
        double[] freqs = {45, 13, 12, 16, 9, 5}; // %

        huffman(cs, freqs);

        // http://zh.wikipedia.org/wiki/%E5%AD%97%E6%AF%8D%E9%A2%91%E7%8E%87

        char[] cs2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
        double[] freqs2 = {8.167, 1.492, 2.782, 4.253, 12.702, 2.228, 2.015,
                6.094, 6.966, 0.153, 0.772, 4.025, 2.406, 6.749, 7.507, 1.929,
                0.095, 5.987, 6.327, 9.056, 2.758, 0.978, 2.360, 0.150, 1.974,
                0.074};

        huffman(cs2, freqs2);
    }
}

class TreeNode implements Comparable<TreeNode> {

    public char val;

    public double freq;

    public TreeNode left, right, parent;

    public TreeNode(char val, double freq) {
        this.val = val;
        this.freq = freq;
    }

    @Override
    public int compareTo(TreeNode node) {
        double d = freq - node.freq;
        return d > 0 ? 1 : (d == 0 ? 0 : -1);
    }

}