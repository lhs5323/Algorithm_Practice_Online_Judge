import java.util.*;

public class algorithm_maxheap{

  static int[] heap;
  static int heap_size = 0;
  public void heapyfi(int[] x, int index, int heap_size){

      int largest = index;
      int leftChild = 2*index +1;
      int rightChild = 2*index +2;

      if (leftChild < heap_size && x[leftChild] > x[largest]){
        largest = leftChild;
      }
      if (rightChild < heap_size && x[rightChild] > x[largest]){
        largest = rightChild;
      }
      if (largest != index){
        int temp = x[largest];
        x[index] = x[largest];
        x[largest] = temp;
      }
      index = (index/2) -1;
      heapyfi(x, index, heap_size);

  }
  public void heap_Insert(int x, int[] heapArr, int s){
    //this.heap = heapArr;
    //this.heap_size = s;
    heapArr[s++] = x;
    heap_size = heap_size++;
    int p_idx = (heap_size/2) -1;
    //System.out.println(heapArr.length);

    heapyfi(heapArr, p_idx, heap_size);
  }


  public void heap_remove(int x, int[] heapArr, int s){
    if (s == 0){
      System.out.println("0");
    } else {
        System.out.println(heapArr[0]);
        heapArr[0] = heapArr[s-1];
        heapyfi(heapArr, 0, s--);
    }
  }


  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    algorithm_maxheap maxheap = new algorithm_maxheap();
    //int[] heap = new int[n]; int heap_size = 0;
    //List<Integer> heap_array = new ArrayList<Integer>();
    int n = sc.nextInt();
    heap = new int[n];
    for (int i = 0; i < n; i++){
      int x = sc.nextInt();
      if (x == 0){
        maxheap.heap_remove(x, heap, heap_size);
      } else{
          maxheap.heap_Insert(x, heap, heap_size);
      }

    }
  }
}
