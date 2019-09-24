import java.util.Arrays;

public class QuickSort implements SortingAlgorithm{
    @Override
    public void sort ( int[] a){
        quickSort(a, 0, a.length - 1);
    }
    public void quickSort( int [] a, int left, int right){
        if (left < right){
            int p = partition(a, left, right);
            //System.out.print(a.length);
            //System.out.println(left);
            //System.out.println(right);
            //System.out.println(p);
            quickSort(a, left, p - 1);
            quickSort(a, p + 1, right);
        }
    }

    public void swap( int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int partition( int[] a, int left, int right){
        if( left < right){
            int pivot = right;
            int i = left;
            int j = right;
            while(i < j){
                while(i < right && a[i] <= a [pivot]){
                    i++;
                }
                while(j > i && a[j] >= a [pivot]){
                    j --;
                }
                if(i < j){
                    swap( a, i, j);
                }
            }
            swap(a, i, pivot);
            return i;
        }
        return right;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int [] a = {4,67,21,48,17,1,45,0};
        qs.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
