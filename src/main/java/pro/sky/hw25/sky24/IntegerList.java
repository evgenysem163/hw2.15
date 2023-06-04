package pro.sky.hw25.sky24;

public interface IntegerList {


    Integer add(Integer item);

    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    String add(String item);

    String add(int index, String item);

    String set(int index, String item);

    Integer remove(int index);

        boolean contains(Integer item);

        int indexOf(Integer item);

        int lastIndexOf(Integer item);

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    Integer get(int index);

        boolean equals(pro.sky.hw25.IntegerList otherList);

    boolean equals(StringList otherList);

    int size();

        boolean isEmpty();

        void clear();

    Integer []toArray();


    }


