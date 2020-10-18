package com.company;

/**
 * Class UnfairWaitList.
 * @author Boris
 * @version 1.0
 */
public class UnfairWaitList <E> extends WaitList<E> {

    /**
     *  Constructor - creates new empty UnfairWaitList
     **/
    public UnfairWaitList() {
        super();
    }

    /**
     *  remove element method - remove first element by value
     * @param element - element to remove by value
     **/
    public void remove(E element) {
        elements.remove(element);
    }

    /**
     * moveToBack method - move element to back of list
     * @param element - element to move by value
     **/
    public void moveToBack(E element) {
        elements.remove(element);
        add(element);
    }

    @Override
    public String toString() {
        return toString("UnfairWaitList");
    }
}
