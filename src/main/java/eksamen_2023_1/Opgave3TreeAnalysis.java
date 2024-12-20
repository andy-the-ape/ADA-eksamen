package eksamen_2023_1;

import java.util.*;

public class Opgave3TreeAnalysis {

    public static class BinaryNode {
        int value;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryNode node0022 = new BinaryNode(22);
        BinaryNode node0010 = new BinaryNode(10);
        BinaryNode node0036 = new BinaryNode(36);
        BinaryNode node0008 = new BinaryNode(8);
        BinaryNode node0015 = new BinaryNode(15);
        BinaryNode node0026 = new BinaryNode(26);
        BinaryNode node0040 = new BinaryNode(40);
        BinaryNode node0006 = new BinaryNode(6);
        BinaryNode node0011 = new BinaryNode(11);
        BinaryNode node0024 = new BinaryNode(24);
        BinaryNode node0028 = new BinaryNode(28);
        BinaryNode node0045 = new BinaryNode(45);
        BinaryNode node0002 = new BinaryNode(2);
        BinaryNode node0007 = new BinaryNode(7);
        BinaryNode node0013 = new BinaryNode(13);
        BinaryNode node0027 = new BinaryNode(27);
        BinaryNode node0030 = new BinaryNode(30);
        BinaryNode node0048 = new BinaryNode(48);
        BinaryNode node0012 = new BinaryNode(12);
        BinaryNode node0014 = new BinaryNode(14);
        BinaryNode node0029 = new BinaryNode(29);
        BinaryNode node0032 = new BinaryNode(32);
        BinaryNode node0046 = new BinaryNode(46);
        BinaryNode node0050 = new BinaryNode(50);


        BinaryNode root = node0022;
        node0022.left = node0010;
        node0022.right = node0036;

        node0010.left = node0008;
        node0010.right = node0015;

        node0036.left = node0026;
        node0036.right = node0040;

        node0008.left = node0006;

        node0015.left = node0011;

        node0026.left = node0024;
        node0026.right = node0028;

        node0040.right = node0045;

        node0006.left = node0002;
        node0006.right = node0007;

        node0011.right = node0013;

        node0028.left = node0027;
        node0028.right = node0030;

        node0045.right = node0048;

        node0013.left = node0012;
        node0013.right = node0014;

        node0030.left = node0029;
        node0030.right = node0032;

        node0048.left = node0046;
        node0048.right = node0050;

        System.out.println("Tree Height: " + getHeight(root));
        System.out.println("Leaf Count: " + countLeaves(root));
        System.out.println("Internal Path Length: " + getInternalPathLength(root, 0));
        System.out.println("Is Valid BST: " + isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
        System.out.println();

        System.out.print("Level-order Traversal: ");
        levelOrderTraversal(root);
        System.out.println();

        System.out.println("Tree Structure:");
        BTreePrinter.printNode(root);

        mirrorTree(root);
        System.out.print("Mirrored Tree In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("Number of twigs: " + countTwigs(root));
    }
    public static int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public static int countLeaves(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public static int getInternalPathLength(BinaryNode node, int depth) {
        if (node == null) {
            return 0;
        }
        return depth + getInternalPathLength(node.left, depth + 1) + getInternalPathLength(node.right, depth + 1);
    }

    public static boolean isValidBST(BinaryNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value <= min || node.value >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
    }

    public static void inOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    public static void preOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void postOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    public static void levelOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void mirrorTree(BinaryNode node) {
        if (node == null) {
            return;
        }

        BinaryNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirrorTree(node.left);
        mirrorTree(node.right);
    }

    static class BTreePrinter {
        public static void printNode(BinaryNode root) {
            int maxLevel = maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static void printNodeInternal(List<BinaryNode> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || isAllElementsNull(nodes)) {
                return;
            }

            int floor = maxLevel - level;
            int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
            int firstSpaces = (int) Math.pow(2, floor) - 1;
            int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

            printWhitespaces(firstSpaces);

            List<BinaryNode> newNodes = new ArrayList<>();
            for (BinaryNode node : nodes) {
                if (node != null) {
                    System.out.print(node.value);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                printWhitespaces(betweenSpaces);
            }
            System.out.println();

            for (int i = 1; i <= edgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        printWhitespaces(edgeLines + edgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null) {
                        System.out.print("/");
                    } else {
                        printWhitespaces(1);
                    }

                    printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null) {
                        System.out.print("\\");
                    } else {
                        printWhitespaces(1);
                    }

                    printWhitespaces(edgeLines + edgeLines - i);
                }
                System.out.println();
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++) {
                System.out.print(" ");
            }
        }

        private static int maxLevel(BinaryNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
        }

        private static boolean isAllElementsNull(List<BinaryNode> list) {
            for (Object object : list) {
                if (object != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int countTwigs(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        return countTwigsHelper(root, null, null);
    }

    private static int countTwigsHelper(BinaryNode node, BinaryNode parent, BinaryNode grandparent) {
        if (node == null) {
            return 0;
        }

        int twigCount = 0;

        if (isTwig(node, parent, grandparent)) {
            twigCount++;
        }

        // Recur for left and right subtrees
        twigCount += countTwigsHelper(node.left, node, parent);
        twigCount += countTwigsHelper(node.right, node, parent);

        return twigCount;
    }

    private static boolean isTwig(BinaryNode node, BinaryNode parent, BinaryNode grandparent) {
        if (node == null || parent == null || grandparent == null) {
            return false;
        }

        // Check if node has two children, and both are leaves
        if (node.left != null && node.right != null &&
                isLeaf(node.left) && isLeaf(node.right)) {

            // Check if node has no siblings
            boolean nodeHasNoSiblings = (parent.left == node && parent.right == null) ||
                    (parent.right == node && parent.left == null);

            // Check if parent has no siblings
            boolean parentHasNoSiblings = (grandparent.left == parent && grandparent.right == null) ||
                    (grandparent.right == parent && grandparent.left == null);

            if (nodeHasNoSiblings && parentHasNoSiblings) {
                return true;
            }
        }

        return false;
    }

    private static boolean isLeaf(BinaryNode node) {
        return node.left == null && node.right == null;
    }

}
