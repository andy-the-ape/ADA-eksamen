package eksamen_2024_1;

import java.util.*;

public class Opgave3 {

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
        BinaryNode node0007 = new BinaryNode(7);

        BinaryNode node0004 = new BinaryNode(4);
        BinaryNode node0028 = new BinaryNode(28);

        BinaryNode node0003 = new BinaryNode(3);
        BinaryNode node0055 = new BinaryNode(55);

        BinaryNode node0002 = new BinaryNode(2);
        BinaryNode node0051 = new BinaryNode(51);
        BinaryNode node0060 = new BinaryNode(60);

        BinaryNode node0001 = new BinaryNode(1);
        BinaryNode node0048 = new BinaryNode(48);
        BinaryNode node0058 = new BinaryNode(58);
        BinaryNode node0069 = new BinaryNode(69);

        BinaryNode node0040 = new BinaryNode(40);
        BinaryNode node0057 = new BinaryNode(57);
        BinaryNode node0035 = new BinaryNode(35);


        BinaryNode root = node0007;
        node0007.left = node0004;
        node0007.right = node0028;

        node0004.left = node0003;

        node0003.left = node0002;

        node0002.left = node0001;

        node0028.right = node0055;

        node0055.left = node0051;
        node0055.right = node0060;

        node0051.left = node0048;

        node0048.left = node0040;

        node0040.left = node0035;

        node0060.left = node0058;
        node0060.right = node0069;

        node0058.left = node0057;

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

        System.out.println("Number of branches: " + countBranches(root));
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

    public static int countBranches(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        return countBranchHelper(root, null);
    }

    private static int countBranchHelper(BinaryNode node, BinaryNode parent) {
        if (node == null) {
            return 0;
        }

        int branchCount = 0;

        if (isBranch(node, parent)) {
            branchCount++;
        }

        // Recur for left and right subtrees
        branchCount += countBranchHelper(node.left, node);
        branchCount += countBranchHelper(node.right, node);

        return branchCount;
    }

    private static boolean isBranch(BinaryNode node, BinaryNode parent) {
        if (node == null || parent == null) {
            return false;
        }

        //Check if node has no siblings
        boolean nodeHasNoSiblings = (parent.left == node && parent.right == null) ||
                (parent.right == node && parent.left == null);

        //Check if node has only one child
        boolean nodeHasOnlyOneChild = hasOnlyOneChild(node, parent);

        //Check if the child has only one child, which is a leaf
        boolean childHasOnlyOneChildWhichIsLeaf = false;
        if (nodeHasOnlyOneChild) {
            if (node.left != null && node.right == null) {
                childHasOnlyOneChildWhichIsLeaf = hasOnlyOneChild(node.left, node) && isLeaf(node.left);
            } else if (node.right != null && node.left == null) {
                childHasOnlyOneChildWhichIsLeaf = hasOnlyOneChild(node.right, node) && isLeaf(node.right);
            }
        }

        return nodeHasNoSiblings && nodeHasOnlyOneChild && childHasOnlyOneChildWhichIsLeaf;
    }

    //Check if node has only one child
    private static boolean hasOnlyOneChild(BinaryNode node, BinaryNode parent) {
        return (node.left != null && node.right == null) ||
                (parent.right != null && node.left == null);
    }

    private static boolean isLeaf(BinaryNode node) {
        return node.left == null && node.right == null;
    }
}
