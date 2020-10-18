package com.company;

import java.util.*;

/**
 * Class WhiteList.
 * @author Boris
 * @version 1.0
 */

public class WaitList <E> implements IWaitList <E> {

    protected ArrayDeque<E> elements;

    /**
     *  Constructor - creates new empty WaitList
     **/
    public WaitList() {
        elements = new ArrayDeque<>();
    }

    /**
     * Constructor - creates new WaitList container from collection
     * @param c - collection of elements
     **/
    public WaitList(Collection <E> c) {
        Stack<E> reverseStack = new Stack<>();
        for (E x : c) {
            reverseStack.push(x);
        }
        elements = new ArrayDeque<>();
        while (!reverseStack.empty()) {
            elements.addLast(reverseStack.pop());
        }
    }

    @Override
    public void add(E element) {
        elements.addLast(element);
    }

    @Override
    public E remove() {
        return elements.poll();
    }

    @Override
    public boolean contains(E element) {
        return elements.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        for (E x : c) {
            if (!elements.contains(x)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    protected String toString(String name) {
        Stack<E> reverseStack = new Stack<>();
        for (E x : elements) {
            reverseStack.push(x);
        }
        StringBuilder res = new StringBuilder("'" + name + ":[");
        while (!reverseStack.empty()) {
            res.append(reverseStack.pop().toString());
            res.append(", ");
        }
        res = new StringBuilder(
            res.substring(
                0,
                res.length() - 2
            )
        );
        res.append("]'");
        return res.toString();
    }

    /**
     * toString method - returns String representation of WaitList.
     * @return String representation of WaitList.
     **/
    public String toString() {
        return toString("WaitList");
    }

}
