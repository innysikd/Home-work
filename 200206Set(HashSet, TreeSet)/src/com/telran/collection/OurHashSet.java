package com.telran.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OurHashSet<E> implements OurSet<E> {

    private final static Object INSTANCE = new Object(); // we created this mock object so we can add it instead of key to our Map
    private Map<E, Object> source; // OurHashSet is realised through Map, where instead of key we use our mock

    public OurHashSet(){
        this.source = new HashMap<>();
    }

    @Override
    public boolean add(E element) {
        return source.put(element, INSTANCE) == null; // if there was no such element, returns null and adds the new one
    }

    @Override
    public boolean remove(E element) {
        return source.remove(element) != null; // if there was no such key, returns null
    }

    @Override
    public boolean contains(E element) {
        return source.containsKey(element);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public boolean addAll(OurSet<E> other) {

        boolean res = false;
        for(E element : other) { // keys from the other set, our Iterator helps us to iterate through other
            res |= this.add(element);
       //     same as: res = this.add(element) | res; (if anything at all was changed, the result is true) (| res == or false)
        }
        return res;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {

        boolean res = false;
        for(E element : other){
            res |= this.remove(element);
        }
        return res;
    }

    // with iterator
//    @Override
//    public boolean retainAll(OurSet<E> other) {
//
//        Iterator<E> iterator = this.iterator();
//        boolean res = false;
//
//        while (iterator.hasNext()){ // we go through our source
//            E element = iterator.next();
//
//            if (!other.contains(element)){ // if there is no elements in other, which == elements from source
//                iterator.remove();
//                res = true;
//            }
//        }
//        return res;
//    }

    //or without iterator
   @Override
    public boolean retainAll(OurSet<E> other) {
        OurSet<E> thisSubstractedOther = new OurHashSet<>();

       for (E element: this) {
           if (!other.contains(element))
               thisSubstractedOther.add(element);
       }
        return this.removeAll(thisSubstractedOther);
    }

    @Override // Iterator, so that we can iterate trough our HashSet
    public Iterator<E> iterator() {
        return source.keySet().iterator();
    }
}
