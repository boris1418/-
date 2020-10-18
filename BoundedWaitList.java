package com.company;

/**
 * Class BoundedWaitList.
 * @author Boris
 * @version 1.0
 */
public class BoundedWaitList<E> extends WaitList<E> {

    private int capacity;

    /**
     * Constructor - creates new BoundedWaitList with capacity. You can't change capacity.
     * @param capacity - capacity (limit of elements count).
     **/
    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }

    /**
     * getCapacity method - returns capacity.
     * @return capacity - capacity (limit of elements count).
     **/
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(E element) {
        if (elements.size() < capacity) {
            super.add(element);
        }
    }

    @Override
    public String toString() {
        return super.toString("BoundedWaitList");
    }
}
