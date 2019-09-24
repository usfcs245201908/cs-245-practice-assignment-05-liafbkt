import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class MergeSort implements SortingAlgorithm {


    @Override
    public void sort(int[] a) {
        if (a.length > 1) {
            int[] left = copyOfRange(a, 0, a.length / 2);
            int[] right = copyOfRange(a, a.length / 2, a.length );
            sort(left);
            sort(right);
            merge(a, left, right);
        }
    }

    public void merge(int[] a, int[] left, int[] right) {
        int k = 0, i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
            while (i < left.length) {
                a[k++] = left[i++];
            }
            while (j < right.length) {
                a[k++] = right[j++];
            }
    }
    /*public void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int i1 = 0; i1 < temp.length; i1++) {
            a[i1 + low] = temp[i1];
        }
    }

    public void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
            //System.out.println(Arrays.toString(a));
        }

    }*/

    public static void main(String[] args) {
        int[] a = {2,1,3,56,23,100,567,3};
        MergeSort ms = new MergeSort();
        ms.sort(a);
        //System.out.println(3/2);
        System.out.println(Arrays.toString(a));
    }
}
