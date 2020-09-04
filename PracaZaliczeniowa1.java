package pracazaliczeniowa1;

import java.util.Scanner;

/**
 * @author Żaneta
 */
public class PracaZaliczeniowa1 {

    private static void quickSort(int[] tab, int l, int r){
        int i, j, v, temp;
        i=l-1;
        j=r+1;
        v=tab[(l+r)/2];
        if(l<r){
            do{
                do{ 
                   i++; 
                }while(tab[i]<v);
                do{
                    j--;
                }while(v<tab[j]);
                if(i<j){
                    temp=tab[i];
                    tab[i]=tab[j];
                    tab[j]=temp;
                }
            }while(i<j);
                    quickSort(tab,l,j);
                    quickSort(tab,j+1,r);
        }
    }
    
    public static void quickSort(int[] tab){
        quickSort(tab,0,tab.length-1);
    }
    
    public static void main(String[] args) throws Exception{
    
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj jaką ilość liczb chcesz wprowadzić (nie większą niż 100!): ");
        int ile = input.nextInt();
        int[] tab = new int[ile];
        int[] roznica = new int[ile-1];
        int[] pom = new int[ile-1];
        
        if(ile<=1){
            System.out.println("Nie mogę odejmować na takej ilości liczb!");
            
        }
        else{
        
            System.out.println("Podaj liczby (zakres od 0 do 1000!): ");
         
            for (int i=0; i<tab.length; i++) {
                tab[i] = input.nextInt();
                if(tab[i]<0 || tab[i]>1000){
                    throw new Exception("Wyjscie poza zakres! Podano niedozwolone liczby!"); 
                }
            }
            
            quickSort(tab);
        
            for(int i=0; i<tab.length-1; i++){
                roznica[i]=tab[i+1]-tab[i];
            }
        
            quickSort(roznica);
        
            System.out.println("Wyjscie:");
            System.out.println(roznica[0]);
        
            for(int i=0; i<tab.length-1; i++){
                pom[i]=tab[i+1]-tab[i];
                    if(pom[i]==roznica[0]){
                        System.out.println(tab[i]+" "+tab[i+1]);
                    }
            }
        }
    }
}
