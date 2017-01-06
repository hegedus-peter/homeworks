package xyz.codingmentor.peterhegedus03hf3generictree.source;

import java.util.ArrayList;
import java.util.List;
import xyz.codingmentor.peterhegedus03hf3generic.exception.GenericTreeException;

/**
 *
 * @author Péter
 * @param <T>
 */
public class GenericTree<T extends Comparable> {

    private int nextIdx;
    private final List<Integer> idxes;
    private final TreeNode root;

    public GenericTree(T element) {
        this.root = new TreeNode(element, 1);
        idxes = new ArrayList<>();
        idxes.add(1);
        nextIdx = 2;
    }

    TreeNode getRoot() {
        return this.root;
    }

    public TreeNode findNode(TreeNode node, int nodeIdx, TreeNode retVal) {
        TreeNode actNode = retVal;
        if (idxes.contains(nodeIdx) && null != node) {
            if (node.compare(nodeIdx)) {
                return node;
            }
            if (null != node.getChildren()) {
                for (int i = 0; i < node.getChildren().size(); ++i) {
                    actNode = findNode((TreeNode) node.getChildren().get(i), nodeIdx, actNode);
                }
            }
            return actNode;
        } else {
            throw new GenericTreeException("The given node is not part of the tree");
        }
    }

    public void addElement(T element, int nodeIdx) {
        TreeNode t = findNode(root, nodeIdx, null);
        t.addNode(element, nextIdx);
        idxes.add(nextIdx);
        nextIdx++;
    }

    public void travelsar(TreeNode node) {
        if (null != node) {
            node.visit();
            if (null != node.getChildren()) {
                for (int i = node.getChildren().size() - 1; i > -1; --i) {
                    travelsar((TreeNode) node.getChildren().get(i));
                }
            }

        }
    }

}
