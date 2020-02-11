package com.telran.collection;

public interface OurSet<E> extends Iterable<E>{

    /**
     * adds a new element to the set
     * @param element to add
     * @return true if the set was changed
     */
    boolean add(E element);

    /**
     * removes the element from the set
     * @param element to remove
     * @return true if the set was changed
     */
    boolean remove (E element);

    /**
     * determines whether the element is the set
     * @param element to find
     * @returnt rue if the set contains the element
     */
    boolean contains (E element);

    int size();

    /**
     * adds all the elements from other to this set
     * @param other elements of which to be added
     * @return true if the set was changed
     */
    boolean addAll (OurSet<E> other);

    /**
     * removes all the elements appearing in other from this Set
     * @param other elements of which to be removed
     * @return true if the set was changed
     */
    boolean removeAll (OurSet<E> other);

    /**
     * retains all the elements appearing in the both this and the other sets
     * @param other elements of which (appearing also in this set) to be retained
     * @return true if the set was changed
     */
    boolean retainAll (OurSet<E> other);



}
