
package kartyatrukk;

import java.util.Scanner;


public class Jatek {
    private String[] tartalmaz = new String[7];
    private static String[] pakli =new String[21];
    private String[] szinek={"P","T","Z","M"};
    private String[] ertekek={"Asz","Kir","Fel","X  ","IX ","VIII"};
    
    Jatek(){
        start();
    }
    
    private void start(){
        megjelenit(osztas());
        for (int i = 0; i < 4; i++) {
            if(i==3){
                System.out.println("A valasztott kartya: "+pakli[10]);
            }else{
                valasztas();
                megjelenit(pakli);
            }
        }
    }
    
    private String[] osztas(){
        int ertekindex=0,szinindex=0;
        for (int i = 0; i < 21; i++) {
            if(i%6==0 && i>0){
                szinindex++;
                ertekindex=0;
            } 
            pakli[i] = szinek[szinindex]+"-"+ertekek[ertekindex];
            ertekindex++;
        }
        return pakli;
    }
    
    private void valasztas(){
        int valasztas;
        do{
        valasztas = bekeres("\nMelyik oszlopban van a kivalasztott kartya?");
        if(valasztas ==1){
            kever(0);
        }else if(valasztas ==2){
            kever(1);
        }else if(valasztas ==3){
            kever(2);
        }else{
            System.out.println("Nincs ilyen oszlop");
        }
        }while(valasztas<0 || valasztas>3);
    }
    
    private void kever(int index){
        
          int start = index*7;
          for (int i = 0; i < 7; i++) {
            String csere = pakli[start+i];
            pakli[start+i] =pakli[7+i];
            pakli[7+i]=csere;
        }
    }
    
    private void megjelenit(String[] osztas){
        for (int i = 0; i < osztas.length; i++) {
            if(i%3==0){
                System.out.print(" \n");
            }
            System.out.print(String.format("%2s ",osztas[i]));
        }
        System.out.println("\n");
    }
    
    private int bekeres(String szoveg){
        String valasztas;
        Scanner beker = new Scanner(System.in);
        System.out.println(szoveg);
        do{
        valasztas = beker.nextLine();
        }while(valasztas.isBlank());  //Szöveg ellenőrzés kimaradt
        return Integer.parseInt(valasztas);
    }
}



