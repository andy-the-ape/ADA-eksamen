package eksamen_2023_2;

import java.util.*;

public class Opgave7 {
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
        BinaryNode node0025 = new BinaryNode(25);
        BinaryNode node0019 = new BinaryNode(19);
        BinaryNode node0032 = new BinaryNode(32);
        BinaryNode node0016 = new BinaryNode(16);
        BinaryNode node0021 = new BinaryNode(21);
        BinaryNode node0029 = new BinaryNode(29);
        BinaryNode node0063 = new BinaryNode(63);
        BinaryNode node0012 = new BinaryNode(12);
        BinaryNode node0018 = new BinaryNode(18);
        BinaryNode node0020 = new BinaryNode(20);
        BinaryNode node0024 = new BinaryNode(24);
        BinaryNode node0028 = new BinaryNode(28);
        BinaryNode node0030 = new BinaryNode(30);
        BinaryNode node0058 = new BinaryNode(58);
        BinaryNode node0087 = new BinaryNode(87);
        BinaryNode node0006 = new BinaryNode(6);
        BinaryNode node0015 = new BinaryNode(15);

        BinaryNode root = node0025;
        node0025.left = node0019;
        node0025.right = node0032;

        node0019.left = node0016;
        node0019.right = node0021;

        node0032.left = node0029;
        node0032.right = node0063;

        node0016.left = node0012;
        node0016.right = node0018;

        node0021.left = node0020;
        node0021.right = node0024;

        node0029.left = node0028;
        node0029.right = node0030;

        node0063.left = node0058;
        node0063.right = node0087;

        node0012.left = node0006;
        node0012.right = node0015;

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

}
