package pro.sky.hw25.sky24;

import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Integer[] data;
    private int size;

    public IntegerListImpl() {
        this(DEFAULT_INITIAL_CAPACITY);

    }

    public IntegerListImpl(int initialCapacity) {
        this.data = new Integer[initialCapacity];
        this.size = 0;
    }


    @Override
    public Integer add(Integer item) {
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {
        checkItem(item);
        checkIndex(index, true);



        if (size < data.length) {


            if (index < size) {
                System.arraycopy(data, index, data, index + 1, size - index);
            }

            data[index] = item;
            return item;
        } else {
            throw new IllegalArgumentException(" Список полный");

        }

    }
    @Override
    public Integer set(int index, Integer item){
        checkItem(item);
        checkIndex(index, false);
        return data[index] =item;
    }

    @Override
    public String add(String item) {
        return null;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index, false);
        Integer removed = data[index];
        if (index < size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
//        data[--size] == null;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        checkItem(item);
        return indexOf(item) != -1;

    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, data[i])) {
                return i;
            }

        }
        return -1;

    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = size; i >= 0; i--) {
            if (Objects.equals(item, data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index, false);
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return false;
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(get(i), otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("item не может быть null");
        }
    }

    private void checkIndex(int index, boolean include) {
        boolean checkUpperBound = include ? index <= size : index < size;
        if (index < 0 || !checkUpperBound) {
            throw new IllegalArgumentException(" индекс вышел за границу");
        }
    }


}



