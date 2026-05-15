package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;
    private int indexNextEvenNumber;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        while (index < data.length) {
            if (data[index] % 2 == 0) {
                result = true;
                indexNextEvenNumber = index;
                break;
            } else {
                index++;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = indexNextEvenNumber + 1;
        return data[indexNextEvenNumber];
    }
}