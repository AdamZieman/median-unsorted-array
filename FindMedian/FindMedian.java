package FindMedian;

/**
 * The FindMedian class contains methods for finding the median value of an array of integers. If the array has an odd
 * number of elements, the median is the middle element. If the array has an even number of elements, the median is the
 * average of the two middle elements. The class uses the quickselect algorithm to find the kth smallest element in the
 * array, where k is the middle index or the average of the two middle indices depending on whether the array length is
 * even or odd.
 * @author Adam Zieman
 */
public class FindMedian {
    /**
     * This method finds the median value of an array of integers. If the array has an odd number of elements, the
     * median is the middle element. If the array has an even number of elements, the median is the average of the two
     * middle elements. The method uses the findMiddleElement() method to find the kth smallest element in the array,
     * where k is the middle index or the average of the two middle indices depending on whether the array length is
     * even or odd.
     * @param arr the array of integers
     * @return the median value of the array
     */
    public static double findMedian(int[] arr) {
        // Check if the length of the array is even or odd
        /* If the array length is even, find the two middle elements by finding the kth smallest element at indices
        k = length / 2 and k = length / 2 + 1. Take the average of the two middle elements and return the result.*/
        if (arr.length % 2 == 0) {
            int kElement = arr.length / 2;
            int leftMidElement = findMiddleElement(arr, 0, arr.length - 1, kElement);
            int rightMidElement = findMiddleElement(arr, 0, arr.length - 1, kElement + 1);
            return (leftMidElement + rightMidElement) / 2.0;
        }
        /* If the array length is odd, find the middle element by finding the kth smallest element at index k =
        (length + 1) / 2 and return it. */
        else {
            int middleIndex = (arr.length + 1) / 2;
            return findMiddleElement(arr, 0, arr.length - 1, middleIndex);
        }
    }

    /**
     * The findMiddleElement method recursively finds the kth smallest element in an integer array by using
     * the quickselect algorithm.
     * @param arr the integer array to be searched
     * @param left the leftmost index of the array
     * @param right the rightmost index of the array
     * @param k the rank of the element to be found
     * @return the kth smallest element in the array
     */
    private static int findMiddleElement(int[] arr, int left, int right, int k) {
         // Base case. If the left and right indices are equal, the current subarray contains only one element.
        if (left == right) {
            return arr[left];
        }

        // Partition the array and get the index of the pivot element and its rank in the partitioned array.
        int pivotIndex = partition(arr, left, right);
        int pivotRank = pivotIndex - left + 1;

        // Base case. If the pivot element is the kth smallest element, return it.
        if (k == pivotRank) {
            return arr[pivotIndex];
        }
        // If the kth smallest element is on the left side of the pivot, recursively search the left subarray.
        else if (k < pivotRank) {
            return findMiddleElement(arr, left, pivotIndex - 1, k);
        }
        // If the kth smallest element is on the right side of the pivot, recursively search the right subarray.
        else {
            return findMiddleElement(arr, pivotIndex + 1, right, k - pivotRank);
        }
    }

    /**
     * Partitions an array into two sections, one containing elements less than or equal to
     * the pivot value, and the other containing elements greater than the pivot value.
     * @param arr the array to be partitioned
     * @param left the leftmost index of the partition range
     * @param right the rightmost index of the partition range
     * @return the index of the pivot element after partitioning
     */
    private static int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right]; // sets the pivot element to the rightmost element in the partition range
        int index = left - 1; // sets the index to keep track of the index of the last element that is LTE to the pivot

        /* Iterate through the partition range and move any elements that are LTE to the pivot value to the left side
        of the partition range by swapping them with the elements at the current index. */
        for (int leftIndex = left; leftIndex < right; leftIndex++) {
            if (arr[leftIndex] <= pivotValue) {
                index++;
                int temp = arr[index];
                arr[index] = arr[leftIndex];
                arr[leftIndex] = temp;
            }
        }

        /* Once all elements LTE to the pivot value have been moved to the left side of the partition range, swap the
        pivot element with the element at the index following the last LTE element. */
        int temp = arr[index + 1];
        arr[index + 1] = arr[right];
        arr[right] = temp;

        return index + 1; // Return the index of the pivot element after partitioning.
    }
}
