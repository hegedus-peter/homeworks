package xyz.codingmentor.peterhegedus03hf3generictree.source;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Péter
 * @param <T>
 */
public class TreeNode<T extends Comparable> {

    private final int idx;
    private final T data;
    private List<TreeNode<T>> children;
    private static final Logger LOG = Logger.getAnonymousLogger();

    public TreeNode(T data, int idx) {
        this.data = data;
        this.idx = idx;
        children = null;
    }

    T getData() {
        return this.data;
    }

    int getIdx() {
        return this.idx;
    }

    List<TreeNode<T>> getChildren() {
        return this.children;
    }

    public void visit() {
        LOG.log(Level.INFO, this.data.toString());
    }

    public boolean compare(int idx) {
        return idx == this.idx;
    }

    public void addNode(T element, int idx) {
        TreeNode<T> newNode = new TreeNode<>(element, idx);

        if (null == children) {
            children = new ArrayList<>();
            children.add(newNode);
        } else {
            int addIdx = 0;
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getData().compareTo(newNode.getData()) > 0) {
                    addIdx++;
                }
            }
            children.add(addIdx, newNode);
        }
    }

}
