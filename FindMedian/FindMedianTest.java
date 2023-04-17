package FindMedian;

import edu.princeton.cs.algs4.StdRandom;

/**
 * The FindMedianTest class contains the main method and other helper methods that test the findMedian method from the FindMedian class.
 * The main method calls the sortAndMedian method with different arguments to sort and time integer arrays of different sizes.
 * The createRandomArray method generates a new integer array of the specified size and fills it with random integer values between 0 and 99,999.
 * The sortAndMedian method generates random integer arrays of different sizes, finds the median of each array, and outputs the size of the array,
 * the median value, and the search time in seconds to the console.
 * @author Adam Zieman
 */
public class FindMedianTest {
    /**
     * This is the main method which calls the sortAndMedian() method with different arguments to sort and time integer array
     * and print the resulting median and search time for each sorted array.
     * @param args Not utilized
     * @throws Throwable if there is an error while executing the sortAndMedian() method
     */
    public static void main (String [] args) throws Throwable {
    // Hardcoded int array with values to utilize as arguments for the sortAndMedian() method call
    int[] size = {10, 50, 1000000, 5000000};
    // Sort and print a few small arrays to make certain the sort works
    sortAndMedian(size[0], size[1], 10);
    // Sort and time larger arrays
    sortAndMedian(size[2], size[3], 1000000);
    // Sort and time larger arrays
    sortAndMedian(size[2]+1, size[3]+1, 1000000);
    }

    /**
     * Generates random integer arrays of different sizes, finds the median of each array, and outputs the size of the array,
     * the median value, and the search time in seconds to the console.
     * @param start the starting size of the arrays to be generated
     * @param end the ending size of the arrays to be generated
     * @param inc the increment in size of the arrays to be generated
     * @throws Throwable if an error occurs during the execution of the method
     */
    public static void sortAndMedian(int start, int end, int inc) throws Throwable {
        double result;

        for (int size = start; size<=end; size+=inc) {
            int [] array = createRandomArray(size); // generates an array using createRandomArray()
            System.gc(); // Suggests to the JVM that the garbage collector should run
            long startTime = System.nanoTime(); // records the start of the search time
            result = FindMedian.findMedian(array); // finds the median of the array
            long endTime = System.nanoTime(); // records the end of the search time

            // Print the results of the array size, median element, and the time it took to complete the search.
            System.out.println ("Array size = " + size +
                    "\tMedian = " + result +
                    "\tSearch time = " +
                    (endTime-startTime)/1000000000.0 + " seconds");
        }
    }

    /**
     * Creates a new int array of the specified size and fills it with random integer values between 0 and 99,999.
     * @param size the length of the array to be generated
     * @return an int array of the specified size filled with random integers
     * @throws Throwable if an error occurs while generating the array
     */
    public static int[] createRandomArray(int size) throws Throwable {
        int [] array = new int [size]; // Creates an int array with the specified length to be generated

        // iterates through the array, generating a random int for every index
        for (int i=0; i<size; i++)  {
            array[i] = StdRandom.uniformInt(100000);
        }
        return array; // returns the random int array
    }
}
