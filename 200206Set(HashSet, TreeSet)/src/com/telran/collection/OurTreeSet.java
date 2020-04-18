package com.telran.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class OurTreeSet<E> implements OurSet<E> {

    TreeNode<E> root;
    private Comparator<E> comparator;
    private int size;

    public OurTreeSet (Comparator<E> comparator){
        this.comparator = comparator;
    }

    public OurTreeSet (){
        this.comparator = new Comparator<>() {
            @Override
            public int compare(E o1, E o2) {

                return ((Comparable<E>) o1).compareTo(o2);
                // same as:
                // Comparable o1comparable = (Comparable<E>) o1; // here we make an up-casting, we define that E is now comparable
                //return o1comparable.compareTo(o2);
            }
        };
    }


    @Override
    public boolean add(E element) {

        if (root == null){
            root = new TreeNode<E>(element);
            size++;
            return true;
        }

        TreeNode<E> parent = root;
        TreeNode<E> current = root;

        while (current != null && comparator.compare(current.key, element) != 0){
            // here we look for the place for our element
            parent = current;
            current = comparator.compare(element, current.key) < 0 ? current.left : current.right;
            // if the element lesser then key, element goes to the left (?), in other case it goes to the right (:)
            // after this line current == null
        }

        if (current != null) { // this means that this node already exists and == element
            return false;
        }

        current = new TreeNode<>(element);
        current.parent = parent; // parent is the previous current

        if (comparator.compare(element, parent.key) < 0){
            parent.left = current;

        }else{
            parent.right = current;
        }

        size++;

        return true;
    }

//    private boolean addRecursive(TreeNode<E> node, E element){
//
//        if (comparator.compare(element, node.key) < 0) {
//            if (node.left == null) {
//                node.left = new TreeNode<E>(element);
//                size++;
//                return true;
//            }
//            else {
//                return addRecursive(node.left, element);
//            }
//        }
//
//        if (comparator.compare(element, node.key) > 0) {
//            if (node.right == null) {
//                node.right = new TreeNode<E>(element);
//                size++;
//                return true;
//            }
//            else {
//                return addRecursive(node.right, element);
//            }
//        }
//
//        return false;
//    }

    @Override
    public boolean remove(E element) {

        TreeNode<E> nodeToRemove = getNode(element);

        if (nodeToRemove == null)
            return false;

        if (nodeToRemove.left == null || nodeToRemove.right == null){
            linealRemove(nodeToRemove);
        }else {
            junctionRemove(nodeToRemove);
        }

        size--;

        return true;
    }


    private void linealRemove(TreeNode<E> nodeToRemove) {
        // when nodeToRemove has only one child

        TreeNode<E> parent = nodeToRemove.parent;
        TreeNode<E> child = nodeToRemove.left == null ? nodeToRemove.right : nodeToRemove.left;
        // child is the "brother" from nodeToRemove

        if (parent == null){
            // if the child has no parent, then nodeToRemove it the root. we are removing root and saying that child == root now
            clearNode(nodeToRemove);
            root = child;
        }

        else if (parent.right == nodeToRemove){
            // if nodeToRemove has a right child
            parent.right = child; // the brother from the nodeToRemove is now child
        }

        else{
            // if nodeToRemove has a left child
            parent.left = child;
        }

        if (child != null)
            child.parent = parent;

        clearNode(nodeToRemove);
    }

    private void clearNode(TreeNode<E> nodeToRemove){
        nodeToRemove.key = null;
        nodeToRemove.right = null;
        nodeToRemove.left = null;
        nodeToRemove.parent = null;
    }

    private void junctionRemove(TreeNode<E> nodeToRemove) {

        TreeNode<E> needle = nodeToRemove.right;

        while (needle.left != null)
            needle = needle.left;
        // we look for the last left element from the right tree

        nodeToRemove.key = needle.key;
        linealRemove(needle);
    }


    private void linealRemoveWithShurik(TreeNode<E> nodeToRemove) {

        TreeNode<E> parent = nodeToRemove.parent;
        TreeNode<E> current = nodeToRemove;

        if (current == parent.right){
            if(current.left == null && current.right != null){
                parent.right = current.right;
                current.right.parent = parent;
            }
            else if(current.left != null && current.right == null){
                parent.right = current.left;
                current.left.parent = parent;
            }

        } else {
            // in this case current == parent.left
            if(current.left == null && current.right != null){
                parent.left = current.right;
                current.right.parent = parent;
            }
            else if(current.left != null && current.right == null){
                parent.left = current.left;
                current.left.parent = parent;
            }
        }

        current.key = null;
    }

    private void junctionRemoveWithShurik(TreeNode<E> nodeToRemove) {

        TreeNode<E> nextNode = getNextNode(nodeToRemove);

        nodeToRemove.key = nextNode.key;

        nextNode.parent.left = nextNode.right;
    }

    private TreeNode<E> getNode (E element){

        TreeNode<E> current = root;

        while (current != null && comparator.compare(current.key, element) != 0)
            current = comparator.compare(element, current.key) < 0 ? current.left : current.right;

        return current;
    }

    private TreeNode<E> getNextNode (TreeNode<E> node){

        TreeNode<E> current = node.right;

        if (current == null)
            return null;

        while (current.left != null)
            current = current.left;

        return current;
    }

    @Override
    public boolean contains(E element) {

        return (getNode(element) != null); // != returns a boolean
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new OurTreeSetIterator<>(this);
    }

    static class TreeNode<E> {
        E key;
        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E key) {
            this.key = key;
            parent = null;
            right = null;
            left = null;
        }
    }


//    class OurComparator<E> implements Comparator<E> {
//
//        @Override
//        public int compare(E o1, E o2) {
//            Comparable o1comparable = (Comparable) o1; // here we make an up-casting, we define that E is now comparable
//            return o1comparable.compareTo(o2);
//        }
//    }

}

class OurTreeSetIterator<E> implements Iterator<E>{

    private OurTreeSet<E> treeSet;
    private OurTreeSet.TreeNode <E> current;


    public OurTreeSetIterator(OurTreeSet<E> treeSet) {
        this.treeSet = treeSet;
        this.current = treeSet.root == null ? null : getLeast(treeSet.root);
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E res = current.key;

        if (current.right != null){
            current = getLeast(current.right); // if current has right child, the right child is the next
        } else {
            current = firstRightParent(current);
        }

        return res;
    }

    private OurTreeSet.TreeNode <E> getLeast(OurTreeSet.TreeNode<E> root) {

        OurTreeSet.TreeNode<E> needle = root;

        while (needle.left != null)
            needle = needle.left;

        return needle;
    }

    // the method finds first parent, which is to the right from child,
    // this is our next element if current has no right child

    private OurTreeSet.TreeNode<E> firstRightParent(OurTreeSet.TreeNode<E> current) {

        OurTreeSet.TreeNode<E> parent = current.parent;

        while (parent != null && current != parent.left){
            current = parent;
            parent = current.parent;
        }

        return parent;
    }
}

