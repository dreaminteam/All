package SecMax;

/**
 * @version 1.8
 * @author Andrej Zenov
 * searching for the second maximum element
 */
public class SecondMax {

    public int[] initMas(int n){
        int[] arrA=new int[n];
        for(int i=0;i<n;i++){
            arrA[i]=(int)(Math.random()*100);
        }
        return arrA;
    }

    public static int secMax(int[] array){
        int max=Integer.MIN_VALUE;
        int smax=Integer.MIN_VALUE;
        int buf;
        for(int e:array){
            if (e>max){
               buf=max;
                max=e;
                smax=buf;
            }
        }
        return smax;
    }

    public static void main(String[] args){
        SecondMax sm=new SecondMax();
        int[] a = sm.initMas(100);
        int sMax=secMax(a);
        System.out.println();
        for (int e: a){
            System.out.print(e + " ");}
        System.out.println();
        System.out.println("Second maximum element= "+sMax);
    }

}
