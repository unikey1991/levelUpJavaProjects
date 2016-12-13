/**
 * Created by java on 13.12.2016.
 */
public class Alist {

    private int initialSize;
    private int size = 0;
    private float maxLoad = 0.8f;
    private float minLoad = 0.6f;
    private int[] array;
    private static final int MIN_SIZE = 10;


    public Alist() {
        this.initialSize = 10;
        this.array = new int [initialSize];
    }



    public Alist(int initialSize) {
        this.initialSize = initialSize;
        this.array = new int [initialSize];
    }


    public int size() {
        return size;
    }

    public void add(int n){
        float curentLoad = (float)size/(float)initialSize;
        if (curentLoad >= maxLoad){
            initialSize = (int)(size * 1.5);
            int tmp [] = new int[initialSize] ;
            for (int i = 0; i < size; i++){
                tmp[i]= array[i];
            }
            array = tmp;
        }
        array[size++] = n;
    }

    public void remove() {
        if (size > 0){
            array[--size] = 0;
        }
        float curetLoad = (float)size/(float)initialSize;
        if (curetLoad <= minLoad && array.length > MIN_SIZE){
            initialSize = (int) (size * 1.5);
            int [] tmp = new int [initialSize];
            for (int i = 0; i < size; i++){
                tmp[i]= array[i];
            }
            array = tmp;
        }
    }

    public int get(int index){
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        return array[index];
    }

    public int getArrayLength(){
        return array.length;
    }
}
