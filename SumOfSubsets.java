import java.util.*;

public class SumOfSubsets {
    
    public static void findSubsets(int[] arr, int targetSum, int index, List<Integer> subset, int currentSum) {
        if (currentSum == targetSum) {
            System.out.println("Subset with sum " + targetSum + ": " + subset);
            return;
        }
        
        if (currentSum > targetSum || index == arr.length) {
            return;
        }
        
        subset.add(arr[index]);
        currentSum += arr[index];
        
        findSubsets(arr, targetSum, index + 1, subset, currentSum);
        
        subset.remove(subset.size() - 1);
        currentSum -= arr[index];
        
        findSubsets(arr, targetSum, index + 1, subset, currentSum);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int[] arr = {10, 7, 5, 18, 12, 20, 15};
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements : ");
        for(int i = 0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter target sum : ");
        int targetSum = sc.nextInt();
        
        List<Integer> subset = new ArrayList<>();
        findSubsets(arr, targetSum, 0, subset, 0);
    }
}