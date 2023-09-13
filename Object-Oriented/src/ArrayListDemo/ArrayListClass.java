package ArrayListDemo;

//手工写一个ArrayList

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * ArrayList的扩容机制：第一次扩大10个，之后扩大原来的1.5倍
 * */
public class ArrayListClass<E> {
    private Object[] elementData={};
    private int size;
    private int DEFALUT_CAPACITY = 10;

    public boolean add(E e){
        if (size==elementData.length){
            grow();
        }
        elementData[size++]=e;
        return true;
    }
    public E get(int index){
        //判断越界
        checkIndex(index);
        return (E) elementData[index];
    }

    public E remove(int index){
        E e = (E) elementData[index];
        checkIndex(index);
        //考虑是否需要元素移位
        int moveFlag = size-index-1;
        if (moveFlag!=0){
            //挪元素
//            for (int i = index; i < size-1; i++) {
//                elementData[i]=elementData[i+1];
//            }
            //调用函数
            System.arraycopy(elementData,index+1, elementData, index, moveFlag);
        }
        elementData[--size]=null;
        return e;
    }

    public int size(){
        return size;
    }
//
    public void forEach(MyConsumer<E> action){
        Objects.requireNonNull(action);
        for (int i = 0; i < size; i++) {
            action.accept((E) elementData[i]);
        }

    }

    public void checkIndex(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException(index+"out of max length "+ size);
        }
    }

    private void grow() {
        if (size==0){
            elementData = new Object[DEFALUT_CAPACITY];
        }else{
            elementData = Arrays.copyOf(elementData, elementData.length+elementData.length>>1);
        }
    }

    @Override
    public String toString() {
        return "ArrayListClass{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                ", DEFALUT_CAPACITY=" + DEFALUT_CAPACITY +
                '}';
    }
}
