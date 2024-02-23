import java.util.Scanner;

public class Ms {

    public static void ms(int[] a, int l, int r){
        if(l < r){
            int m = (l + r) / 2;
            ms(a, l, m);
            ms(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(int[] a, int l, int m, int r){
        int i = l;
        int j = m + 1;
        int k = l;
        int[] temp = new int[a.length];
        while(i <= m && j <= r){
            if(a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while(i <= m){
            temp[k++] = a[i++];
        }

        while(j <= r){
            temp[k++] = a[j++];
        }

        for(int z = l; z <= r; z++) {
            a[z] = temp[z];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array : ");
        int n = sc.nextInt();
        System.out.println("Enter the array : ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("Original array:");
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        ms(a, 0, n - 1);
        System.out.println("\nAfter sorting:");
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
