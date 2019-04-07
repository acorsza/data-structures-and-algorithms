/*
 * The Binary Search
 * The array must be sorted
 * Compare an index to the searched element and for slicing the list over and over until find or not 
 * Always dividing by 2
 * Complexity O(log n) (base 2, but it does not matter) 
 * Can be developed recursively or iteratively
 */
public class BinarySearch {
      
    public static void main(String[] args) {
        int[] agesArray = {16, 28, 33, 35, 45, 47, 49, 51, 55, 57, 60, 62, 73}; 
        System.out.println("Iterativo 15 " + binarySearchIterative(agesArray, 15));
        System.out.println("Recursivo 15 " + binarySearchRecursive(agesArray, 15));

        System.out.println("Iterativo 16 " + binarySearchIterative(agesArray, 16));
        System.out.println("Recursivo 16 " + binarySearchRecursive(agesArray, 16));

        System.out.println("Iterativo 30 " + binarySearchIterative(agesArray, 30));
        System.out.println("Recursivo 30 " + binarySearchRecursive(agesArray, 30));

        System.out.println("Iterativo 33 " + binarySearchIterative(agesArray, 33));
        System.out.println("Recursivo 33 " + binarySearchRecursive(agesArray, 33));

        System.out.println("Iterativo 47 " + binarySearchIterative(agesArray, 47));
        System.out.println("Recursivo 47 " + binarySearchRecursive(agesArray, 47));
    }

    public static boolean binarySearchIterative(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] == x) {
                return true;
            } else if (x < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
        // if left is bigger than right, it means the element cannot be found, hence, return false
        if (left > right) {
            return false;
        }
        // avoid integer overflow
        // https://dzone.com/articles/overflow-and-underflow-data
        // https://stackoverflow.com/questions/3001836/how-does-java-handle-integer-underflows-and-overflows-and-how-would-you-check-fo
        //int mid = (left + right) / 2;
        int mid = left + ((right - left) / 2);
        // if the element searched is in the middle of the array
        if (array[mid] == x) {
            return true;
        } else if (x < array[mid]) {
            // if X is smaller than the middle it means it is in the left side of the array
            return binarySearchRecursive(array, x, left, mid - 1);
        } else {
            // if X is bigger than the middle it means it is in the right side of the array
            return binarySearchRecursive(array, x, mid + 1, right);
        }
    }

    public static boolean binarySearchRecursive(int[] array, int x) {
        return binarySearchRecursive(array, x, 0, array.length - 1);
    }

}