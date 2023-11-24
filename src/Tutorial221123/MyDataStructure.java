package Tutorial221123;

import java.util.Iterator;

public
    class MyDataStructure<T>
    implements Iterable<T>{

    private Object[] array;
    private int fill;

    public MyDataStructure() {
        this.array = new Object[3];
        this.fill = 0;
    }

    public void add(T obj){
        if(tmp != null)
            throw new RuntimeException("Problem with Iterator");

        if(fill >= array.length){
            Object[] tmpArr = new Object[array.length*2];
            for(int i=0; i< array.length; i++)
                tmpArr[i] = array[i];
            this.array = tmpArr;
        }
        array[fill++] = obj;
    }

    public void remove(){
        if(tmp != null)
            throw new RuntimeException("Problem with Iterator");
        
        Object[] tmpArr = new Object[array.length-1];
        for(int i=1; i< array.length; i++)
            tmpArr[i-1] = array[i];
        this.array = tmpArr;
    }

    private Iterator<T> tmp = null;

    @Override
    public Iterator<T> iterator() {
        tmp = new Iterator<T>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                boolean bVal = count < fill;
                if(!bVal)
                    tmp = null;
                return bVal;
            }

            @Override
            public T next() {
                return (T) array[count++];
            }
        };
        return tmp;
    }
}
