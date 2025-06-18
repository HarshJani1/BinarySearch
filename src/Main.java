import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int arr[] = {1,10,2,1};
        int n = arr.length;
        System.out.println(findPeakElement(arr,n));
    }


    // finds lower bound
    // smallest element >= target
    // O(LogN)
    public static int lowerBound(int arr[],int n,int target){
        int ans = n;
        int low=0;
        int high=n-1;
        while(low<=high){

            int mid = (low)+(high-low)/2;

            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    // finds upperbound
    // smallest element > target
    // O(LogN)
    public static int upperBound(int arr[],int n,int target){
        int ans = n;
        int low=0;
        int high=n-1;
        while(low<=high){

            int mid = (low)+(high-low)/2;

            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    // finds the first occurrence of target element from array
    // O(LogN)
    public static int firstOccurrences(int arr[],int n,int target){
        int low=0;
        int high=n-1;
        int first = -1;
        while(low<=high){
            int mid = (low)+(high-low)/2;
            if(arr[mid]==target){
                first = mid;
                high = mid-1;
            }else if(arr[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return first;
    }

    // finds the last occurrence of target element from array
    // O(LogN)
    public static int lastOccurrences(int arr[],int n,int target){
        int low=0;
        int high=n-1;
        int last = -1;
        while(low<=high){
            int mid = (low)+(high-low)/2;
            if(arr[mid]==target){
                last = mid;
                low = mid+1;
            }else if(arr[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return last;
    }

    // finds the first and last occurrence of target element from array
    // O(2LogN)
    public static int[] findFirstAndLast(int[] arr,int n,int target){
        int first = firstOccurrences(arr,n,target);
        if(first==-1){return new int[]{-1,-1};}
        return new int[]{first,lastOccurrences(arr,n,target)};
    }

    // finds the total number of occurrence of target element from array
    // O(2LogN)
    public static int findTotalOccurrences(int[] arr,int n,int target){
        int first = firstOccurrences(arr,n,target);
        if(first==-1) return 0;
        return lastOccurrences(arr,n,target)-first+1;
    }

    // finds the only single element from an array
    // [1,1,2,2,3,3,4,5,5,6,6,7,7] => 4
    // O(LogN)
    public static int findNonRepeatingElement(int[] arr, int n) {
        if (n == 1) return 0;
        if (arr[0] != arr[1]) return 0;
        if (arr[n - 1] != arr[n - 2]) return n - 1;

        int start = 1;
        int end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return mid; // found the single element
            }

            // If mid is even and arr[mid] == arr[mid + 1], single element is on right
            // If mid is odd and arr[mid] == arr[mid - 1], single element is on right
            // Else it's on left
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) ||
                    (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    // Finds the peak of the mountain array
    // O(LogN)
    public static int findPeakElement(int[] arr, int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean leftSmaller = (mid == 0 || arr[mid - 1] <= arr[mid]);
            boolean rightSmaller = (mid == n - 1 || arr[mid + 1] <= arr[mid]);

            if (leftSmaller && rightSmaller) {
                return mid;
            } else if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}