package xyz.codingmentor.peterhegedus03hf3generictree.source;

/**
 *
 * @author Péter
 */
public class Main {

    private Main() {

    }

    public static void main(String[] args) {

        GenericTree<Integer> tree = new GenericTree(1);

        tree.addElement(2, 1);
        tree.addElement(3, 1);
        tree.addElement(4, 1);

        tree.addElement(5, 2);
        tree.addElement(6, 2);
        tree.addElement(7, 2);

        tree.addElement(8, 3);
        tree.addElement(9, 3);
        tree.addElement(10, 3);

        tree.addElement(11, 4);
        tree.addElement(12, 4);
        tree.addElement(13, 4);

        tree.addElement(14, 5);
        tree.addElement(15, 5);
        tree.addElement(16, 5);

        tree.addElement(17, 6);
        tree.addElement(18, 6);
        tree.addElement(19, 6);

        tree.addElement(20, 7);
        tree.addElement(21, 7);

        tree.travelsar(tree.getRoot());

    }
}
