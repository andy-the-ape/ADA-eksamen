package general_tools;

import java.util.*;

public class BinaryTreeAnalyzer {
    private static BinaryNode root;

    public static void main(String[] args) {
        root = new BinaryNode(50);
        BinaryNode n48 = new BinaryNode(48);
        BinaryNode n70 = new BinaryNode(70);
        BinaryNode n30 = new BinaryNode(30);
        BinaryNode n65 = new BinaryNode(65);
        BinaryNode n90 = new BinaryNode(90);
        BinaryNode n20 = new BinaryNode(20);
        BinaryNode n32 = new BinaryNode(32);
        BinaryNode n67 = new BinaryNode(67);
        BinaryNode n98 = new BinaryNode(98);
        BinaryNode n15 = new BinaryNode(15);
        BinaryNode n25 = new BinaryNode(25);
        BinaryNode n31 = new BinaryNode(31);
        BinaryNode n35 = new BinaryNode(35);
        BinaryNode n66 = new BinaryNode(66);
        BinaryNode n69 = new BinaryNode(69);
        BinaryNode n94 = new BinaryNode(94);
        BinaryNode n99 = new BinaryNode(99);

        root.left = n48;
        root.right = n70;

        n70.left = n65;
        n70.right = n90;

        n90.right = n98;

        n98.left = n94;
        n98.right = n99;

        n65.right = n67;

        n67.left = n66;
        n67.right = n69;

        n48.left = n30;

        n30.left = n20;
        n30.right = n32;

        n32.left = n31;
        n32.right = n35;

        n20.left = n15;
        n20.right = n25;


        System.out.println("Tree Height: " + getHeight(root));
        System.out.println("Leaf Count: " + countLeaves(root));
        System.out.println("Internal Path Length: " + getInternalPathLength(root, 0));
        System.out.println("Is Valid BST: " + isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println("Is Balanced: " + isBalanced(root));
        System.out.println("Is Complete: " + isComplete(root));
        System.out.println("Is Full: " + isFull(root));
        System.out.println("Is Perfect: " + isPerfect(root));

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


    }

    public static void insert(int value) {
        root = insert(new BinaryNode(value), root);
    }

    private static BinaryNode insert(BinaryNode nodeToBeInserted, BinaryNode current) {
        if (current == null) {
            return nodeToBeInserted;
        }
        if (nodeToBeInserted.value < current.value) {
            current.left = insert(nodeToBeInserted, current.left);
        } else {
            current.right = insert(nodeToBeInserted, current.right);
        }
        return current;
    }

    public static void delete(int value) {
        root = delete(value, root);
    }

    private static BinaryNode delete(int value, BinaryNode current) {
        if (current == null) {
            return null;
        }
        if (value < current.value) {
            current.left = delete(value, current.left);
        } else if (value > current.value) {
            current.right = delete(value, current.right);
        } else {
            // Node to be deleted found
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            current.value = findMin(current.right).value;

            // Delete the inorder successor
            current.right = delete(current.value, current.right);
        }
        return current;
    }

    private static BinaryNode findMin(BinaryNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
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

    public static boolean isBalanced(BinaryNode node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public static boolean isComplete(BinaryNode node) {
        if (node == null) {
            return true;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);
        boolean end = false;

        while (!queue.isEmpty()) {
            BinaryNode current = queue.poll();

            if (current == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    public static boolean isFull(BinaryNode node) {
        if (node == null) {
            return true;
        }
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            return false;
        }
        return isFull(node.left) && isFull(node.right);
    }

    public static boolean isPerfect(BinaryNode node) {
        int depth = getHeight(node);
        return isPerfectRec(node, depth, 0);
    }

    private static boolean isPerfectRec(BinaryNode node, int depth, int level) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return depth == level + 1;
        }
        if (node.left == null || node.right == null) {
            return false;
        }
        return isPerfectRec(node.left, depth, level + 1) && isPerfectRec(node.right, depth, level + 1);
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

    private static class BinaryNode {
        int value;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
