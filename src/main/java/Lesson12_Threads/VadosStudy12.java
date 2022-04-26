package Lesson12_Threads;



public class VadosStudy12 {
    public static void main(String[] args) {
        final int size = 10000000;
        DoSmg arr = new DoSmg(size);
        System.out.println("В одном потоке время исполнения: " + arr.work() + " мс");
        System.out.println("В двух потоках время исполнения: " + arr.splitWokr() + " мс");

        // Проверяем правильно ли склеились массивы
        //arr.printArr();
        //arr.printArr();
    }

}

class DoSmg {
    float[] arr;
    int size;

    DoSmg(int size){
        this.size = size;
        arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    public void printArr(){
        for (float e:arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public long work(){
        long a = System.currentTimeMillis();
        for (int i = 0;i <= arr.length-1;i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - a;
    }

    public long splitWokr() {
        long a = System.currentTimeMillis();
        float[] arr1 = new float[size/2];
        float[] arr2 = new float[size/2];
        System.arraycopy(arr, 0, arr1, 0,size/2);
        System.arraycopy(arr,size/2,arr2,0,size/2);
        Spring spring01 = new Spring(arr1,0);
        Spring spring02 = new Spring(arr2,size/2);
        spring01.start();
        spring02.start();

        try {
            spring01.join();
            spring02.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(spring01.getArr(),0,arr,0,size/2);
        System.arraycopy(spring02.getArr(),0,arr,size/2,size/2);
        return System.currentTimeMillis() - a;
    }
}

class Spring extends Thread {
    float arr[];
    int splitIndex;

    public Spring(float arr[], int splitIndex){
       this.arr = arr;
       this.splitIndex = splitIndex;
    }

    @Override
    public void run() {
            for (int i = 0;i <= arr.length-1;i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+splitIndex) / 5) * Math.cos(0.2f + (i+splitIndex) / 5) *
                        Math.cos(0.4f + (i+splitIndex) / 2));
            }
    }

    public float[] getArr(){
        return arr;
    }

}