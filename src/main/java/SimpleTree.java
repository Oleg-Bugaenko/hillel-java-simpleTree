import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SimpleTree<V> implements Iterable<V> {
    Node<V> root;

    public void add(V value) {
        Node<V> element = new Node<>(value);
        if (root == null) {
            root = element;
        } else {
            Queue<Node<V>> queue = new LinkedList<>();
            queue.add(root);
            Node<V> first;

            while (!queue.isEmpty()) {
                first = queue.remove();

                if (first.left != null) {
                    queue.add(first.left);
                } else {
                    first.left = element;
                    return;
                }

                if (first.right != null) {
                    queue.add(first.right);
                } else {
                    first.right = element;
                    return;
                }
            }
        }
    }


    @Override
    public Iterator<V> iterator() {
        Stack<Node<V>> stackNodes = new Stack<>();
        stackNodes.push(root);

        return new Iterator<V>() {
            @Override
            public boolean hasNext() {
                return !stackNodes.isEmpty();
            }

            @Override
            public V next() {
                Node<V> top = stackNodes.pop();
                if (top.right != null) stackNodes.push(top.right);
                if (top.left != null) stackNodes.push(top.left);
                return top.value;
            }
        };
    }

    private static class Node<V> {
        V value;
        Node<V> left;
        Node<V> right;
        public Node(V value) {
            this.value = value;
        }
    }

}
