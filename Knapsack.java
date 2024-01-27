import java.util.Scanner;

class DataObject{
    int p;
    int w;
    double pw;
}

public class Knapsack{
    DataObject d[];
    int n, max;
    Scanner sc;

    public Knapsack(){
        sc = new Scanner(System.in);
        System.out.println("Enter number of objects ");
        n = sc.nextInt();

        d = new DataObject[n];

        System.out.println("Enter the profit and weights of objects\n ");

        for(int i = 0; i<n; i++){
            d[i] = new DataObject();
            System.out.println("Object : "+(i+1));
            d[i].p = sc.nextInt();
            d[i].w = sc.nextInt();
        }
    }

    public void calc(){
        for(int i = 0; i<n; i++){
            d[i].pw = d[i].p/(double)d[i].w;
        }

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n;j++){
                if(d[i].pw < d[j].pw){
                    DataObject t = d[i];
                    d[i] = d[j];
                    d[j] = t;
                }
            }
        }

        int s =0, k=0;
        System.out.println("Enter max objects");
        max = sc.nextInt();
        while(max>0 && k<n){
            if(max>=d[k].w){
                max = max - d[k].w;
                s+=d[k].p;
            }
            else{
                s+=(int)(max*d[k].pw);
                max=0;
            }
            k++;
        }
        System.out.println("Profit : "+s);
    }

    public static void main(String args[]){
        Knapsack k = new Knapsack();
        k.calc();
    }
}
