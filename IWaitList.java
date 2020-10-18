package com.company;

import java.util.Collection;

/**
 * Interface IWaitList.
 * @author Boris
 * @version 1.0
 */
public interface IWaitList <E> {

    /**
     * add method - adds new element on the end of list.
     * @param element - element to add.
     **/
    void add(E element);

    /**
     * remove method - removes last element.
     * @return deleted element
     **/
    E remove();

    /**
     * contains method - checks if element contains in list.
     * @param element - element to find.
     **/
    boolean contains(E element);

    /**
     * containsAll method - checks if all collection elements contains in list.
     * @param c - collection of elements to find.
     **/
    boolean containsAll(Collection<E> c);

    /**
     * isEmpty method - checks if whiteList empty.
     **/
    boolean isEmpty();
}
