import java.util.ArrayList;

public class BST<K extends Comparable<K>, V>  {
    private Node root;
    private int size = 0;
    public class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{key: " + this.key + " value: " + this.value + "}";
        }
    }

    public int getSize() {
        return size;
    }

    public void put(K key, V value) {
        this.root = insertNode(root, key, value);
        size++;
    }

    private Node insertNode(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (node.key.compareTo(key) == 1) {
            node.left = insertNode(node.left, key, value);
        } else if(node.key.compareTo(key) == -1) {
            node.right = insertNode(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        Node node = getTreeNode(root, key);
        return (node != null) ? node.value : null;
    }

    private Node getTreeNode(Node node, K key) {
        if (node == null || key.compareTo(node.key) == 0) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return getTreeNode(node.left, key);
        } else {
            return getTreeNode(node.right, key);
        }
    }
    public void delete(K key) {
        root = deleteNode(root, key);
        if (root != null) {
            size--;
        }
    }

    private Node deleteNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {

            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node successor = findMinimumNode(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = deleteNode(node.right, successor.key);
        }

        return node;
    }

    private Node findMinimumNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Iterable<Node> iterator() {
        ArrayList<Node> arrayList = Traversal(new ArrayList<>(), root);
        return (Iterable) arrayList;
    }
    public ArrayList<Node> Traversal(ArrayList<Node> list, Node node) {
        if (node == null) {
            return list;
        }

        Traversal(list, node.left);
        list.add(node);
        Traversal(list, node.right);

        return list;
    }
}