package driver;

public class BinarySearch {
    Double binarySearch(Double arr[], int l, int r, Double key) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == key)
                return (double) mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > key)
                return binarySearch(arr, l, mid - 1, key);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, key);
        }

        // We reach here when element is not present
        // in array
        return (double) -1;
    }
}
