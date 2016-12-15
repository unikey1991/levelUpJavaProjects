/**
 * Created by java on 13.12.2016.
 */
public class Alist {

    private int initialSize;
    private int size = 0;
    private float maxLoad = 0.8f;
    private float minLoad = 0.6f;
    public int[] array;
    private static final int MIN_SIZE = 10;


    public Alist() {
        this.initialSize = 10;
        this.array = new int [initialSize];
    }

    public Alist(int arr[]) {
        this.initialSize = arr.length;
        this.array = new int[initialSize];
        for (int x:arr) {
            add(x);
        }
    }

    public Alist(int initialSize) {
        this.initialSize = initialSize;
        this.array = new int [initialSize];
    }

    //сортировка по возрастанию и убыванию используя алгоритм сортировки вставками (Insertion)
    public void insertionSortFromMaxToMin(){
        if (size < 2) System.out.println("Array elements number < 2");
        else {
            for (int i = size-1; i > 0; i--){
                for (int j = i; j < size && array[j] > array[j-1]; j++ ){
                    int buffer = array[j];
                    array[j]= array[j-1];
                    array[j-1]=buffer;
                }
            }
        }
    }


    //сортировка по возрастанию и убыванию используя алгоритм сортировки вставками (Insertion)
    public void insertionSortFromMinToMax(){
        if (size < 2) System.out.println("Array elements number < 2");
        else {
            for (int i = 1; i < size; i++){
                    for (int j = i; j > 0 && array[j] < array[j-1]; j-- ){
                        int buffer = array[j-1];
                        array[j-1]= array[j];
                        array[j]=buffer;
                }
            }
        }
    }

    //метод, который принимает разделитель и возвращает все элементы списка через разделитель в виде строки
    public String outAllElementsThroughtSeparator(String separator){
        if (size > 0){
            String out = "";
            for (int i =0; i < size; i++){
                out += array[i];
                if (i < size-1) out += separator+" ";
            }
            return out;
        }
        else return "not have elements";
    }

    //получение индекса элемента по значению (indexOf)
    public int indexOf(int n){
        for (int i = 0; i < size; i++){
            if (array[i] == n) return i;
        }
        return -1;
    }

    //добавления/удаления элемента из середины списка (по индексу)
    public void addToArrayIndex (int n, int index){
        int buffer;
        if (index >= size) throw new ArrayIndexOutOfBoundsException(index);
        else {
            add(n);
            buffer = array[size-1];
            for (int i = size-1; i > index; i--){
                array[i]= array[i-1];
            }
            array[index] = buffer;
        }
    }
//добавления/удаления элемента из середины списка (по индексу)
    public void removeFromArrayIndex (int index){
        int buffer = 0;
        if (index >= size) throw new ArrayIndexOutOfBoundsException(index);
        else {
            buffer = array[index];
            for (int i = index; i < size; i++){
                array[i]= array[i+1];
            }
            array[size-1]=buffer;
            remove();
        }
    }

    //добавления/удаления элемента из начала списка
    public void addToArrayStarting(int n){
        add(n);
        int buffer = array[size-1];
        for (int i = size-1; i > 0; i--){
            array[i]= array[i-1];
        }
        array[0] = buffer;
    }

    //добавления/удаления элемента из начала списка
    public void removeFromArrayStarting(){
        int buffer = array[0];
        for (int i = 0; i < size; i++){
            array[i]= array[i+1];
        }
        array[size-1]=buffer;
        remove();
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
