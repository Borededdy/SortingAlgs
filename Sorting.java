package SortingAlgorithms;

/**
 * This Class implements various sorting algorithms
 *
 * @author Borededdy
 * @version 1.0
 * @since 2025-03-04
 */
public class Sorting {

    /**
     * <a href="https://en.wikipedia.org/wiki/Bubble_sort">Classic BubbleSort</a>, complexity of O(n^2)
     *
     * @param a Integer Array to sort
     * @return Sorted array
     * @since 1.0
     */
    public static int[] bubbleSort(int[] a){
        int i,j;
        for(i=a.length-1;i>=1;i--){
            for(j=1;j<=i;j++){
                if(a[j-1]>a[j]){
                    swap(a,j,j-1);
                }
            }
        }
        return a;
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Cocktail_shaker_sort">Shaker Sort</a>, complexity of O(n^2)
     *
     * @param a Integer Array to sort
     * @return Sorted Array
     * @since 1.0
     */

    public static int[] shakerSort(int[] a){
        int start = 0;
        int end = a.length - 1;
        boolean swapsDone = true;

        while(swapsDone){
            swapsDone = false;
            for(int i = start + 1; i <= end; i++){
                if(a[i - 1] > a[i]){
                    swap(a, i - 1, i);
                    swapsDone = true;
                }
            }

            end--;

            for(int i = end; i >= start + 1; i--){
                if(a[i - 1] > a[i]){
                    swap(a, i - 1, i);
                    swapsDone = true;
                }
            }

            start++;
        }
        return a;
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Comb_sort">Comb Sort</a>, complexity of O(n(log(n)))
     *
     * @param a Integer Array to sort
     * @return Sorted Array
     * @since 1.0
     */

    public static int[] CombSort(int[] a){
        int step = a.length;
        boolean swapsDone = false;

        while(step > 1 || swapsDone){
            if(step > 1){
                step = (int) (step / 1.3);
            }

            swapsDone = true;
            for(int i = 0; i + step <= a.length - 1; i++){
                if(a[i] > a[i + step]){
                    swap(a, i, i + step);
                    swapsDone = true;
                }
            }
        }
        return a;
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion Sort</a>, complexity of O(n^2)
     *
     * @param a Integer Array to sort
     * @return Sorted Array
     * @since 1.0
     */

    public static int[] insertionSort(int[] a){
        int i, j, t;
        for(i = 1; i < a.length - 1; i++){
            t = a[i];
            j = i;
            while(j > 0 && a[j - 1] > t){
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }
        return a;
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Shellsort">Shell Sort</a>, complexity of O(n^1.25)
     *
     * @param gaps Array of Gaps
     * @param a Integer Array to sort
     * @return Sorted array
     * @since 1.0
     */

    public static int[] shellSort(int[] gaps, int[] a){
        int i, j, k, h, t;

        for(k = 0; k < gaps.length; k++){
            h = gaps[k];
            for(i = h; i < a.length; i++){
                t = a[i];
                j = i;
                while(j >= h && a[j - h] > t){
                    a[j] = a[j - h];
                    j = j - h;
                }
                a[j] = t;
            }
        }
        return a;
    }

    // Other Methods

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
