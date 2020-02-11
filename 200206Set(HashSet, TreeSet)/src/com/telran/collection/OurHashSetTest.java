package com.telran.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OurHashSetTest {

    private final static Object INSTANCE = new Object();
 //   private Map<Integer, Object> source;
    OurHashSet<Integer> toTest = new OurHashSet<>();
    OurHashSet<Integer> toTest1 = new OurHashSet<>();


    @Test
    public void add_addNewElementToNonEmptySet() {

        int[] source = {9, -8, 11, 15};

        for (int i : source) {
            toTest.add(i);
        }

        assertTrue(toTest.add(5));
    }

    @Test
    public void add_addExistingElementToNonEmptySet() {

        int[] source = {9, -8, 11, 15};

        for (int i : source) {
            toTest.add(i);
        }

        assertFalse(toTest.add(11));
    }

    @Test
    public void add_addElementToEmptySet() {

        assertTrue(toTest.add(5));
    }

    @Test
    public void remove_removesElementFromNonEmptySet() {

        int[] source = {9, -8, 11, 15};

        for (int i : source) {
            toTest.add(i);
        }

        assertTrue(toTest.remove(-8));
    }

    @Test
    public void remove_removesNonExistingElementFromNonEmptySet() {

        int[] source = {9, -8, 11, 15};

        for (int i : source) {
            toTest.add(i);
        }

        assertFalse(toTest.remove(28));
    }

    @Test
    public void contains_NonEmptySet_ContainsElement() {
        int[] source = {9, -8, 11, 15};

        for (int i : source) {
            toTest.add(i);
        }

        assertTrue(toTest.contains(9));
        assertTrue(toTest.contains(-8));
        assertTrue(toTest.contains(11));
        assertTrue(toTest.contains(15));
    }

   @Test
    public void contains_NonEmptySet_NotContainsElement() {
        int[] source = {9, -8, 11, 15};

        for (int i : source) {
            toTest.add(i);
        }

        assertFalse(toTest.contains(10));
        assertFalse(toTest.contains(20));
        assertFalse(toTest.contains(-3));
    }

    @Test
    public void size_nonEmptySet_returnsSize() {
        int[] source = {9, -8, 11, 15};

        for (int i : source) {
            toTest.add(i);
        }
        assertEquals(4, toTest.size());
    }

   @Test
    public void size_emptySet_returns0() {
        assertEquals(0, toTest.size());
    }

    @Test
    public void addAll_adds2ElementsOutOf4() {

        int[] source = {9, -8, 11, 15};
        for (int i : source) {
            toTest.add(i);
        }

        int[] source1 = {18, -8, 5, 15};
        for (int i : source1) {
            toTest1.add(i);
        }

        assertTrue(toTest.addAll(toTest1));

        assertEquals(6, toTest.size());
    }

    @Test
    public void addAll_adds4ElementsOutOf4() {

        int[] source = {9, -8, 11, 15};
        for (int i : source) {
            toTest.add(i);
        }

        int[] source1 = {18, 5, 3};
        for (int i : source1) {
            toTest1.add(i);
        }

        assertTrue(toTest.addAll(toTest1));

        assertEquals(7, toTest.size());
    }

    @Test
    public void addAll_addsNoElement() {

        int[] source = {9, -8, 11, 15};
        for (int i : source) {
            toTest.add(i);
        }

        int[] source1 = {-8, 15};
        for (int i : source1) {
            toTest1.add(i);
        }

        assertFalse(toTest.addAll(toTest1));

        assertEquals(4, toTest.size());
    }

    @Test
    public void removeAll_removes2Elements() {

        int[] source = {9, -8, 11, 15};
        for (int i : source) {
            toTest.add(i);
        }

        int[] source1 = {18, -8, 5, 15};
        for (int i : source1) {
            toTest1.add(i);
        }

        assertTrue(toTest.removeAll(toTest1));

        assertEquals(2, toTest.size());
    }

    @Test
    public void removeAll_nothingToRemove() {
        int[] source = {9, -8, 11, 15};
        for (int i : source) {
            toTest.add(i);
        }

        int[] source1 = {18, 3, 20};
        for (int i : source1) {
            toTest1.add(i);
        }

        assertFalse(toTest.removeAll(toTest1));

        assertEquals(4, toTest.size());
    }

    @Test
    public void retainAll_3IntersectedElements() {
        int[] source = {9, -8, 11, 15, 28, -30};

        for (int i : source) {
            toTest.add(i);
        }

        int[] source1 = {18, -8, 5, 15, -30};

        for (int i : source1) {
            toTest1.add(i);
        }

        assertTrue(toTest.retainAll(toTest1));

        assertEquals(3, toTest.size());

    }

    @Test
    public void retainAll_noIntersectedElements() {
        int[] source = {9, -8, 11, 15, 28, -30};

        for (int i : source) {
            toTest.add(i);
        }

        int[] source1 = {18, 5, 7};

        for (int i : source1) {
            toTest1.add(i);
        }

        assertTrue(toTest.retainAll(toTest1));

        assertEquals(0, toTest.size());

    }
}