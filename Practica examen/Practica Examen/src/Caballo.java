import java.util.Scanner;
import java.util.InputMismatchException;
public class Caballo {
    private String [][] tablero;
    private String[] numeros;
    private int contador;
    private int x;
    private int y;
    private Scanner sc;

    public Caballo(){
        tablero = new String[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                tablero[i][j] = " ";
             }
        }
    numeros = new String[64];
    contador = 0;
    sc = new Scanner(System.in);
        
        try{
            x = sc.nextInt();
            y = sc.nextInt();
        }catch ( InputMismatchException e){
            System.out.print("valor invalido");
            sc.next();
        }


    }


    public boolean chequeoMovimiento(int y, int x){
        boolean yaPasado = false;
        String position = Integer.toString(x) + Integer.toString(y);
        if (y < 8 && x<8){
            for (String n : numeros){
                if (n.equals(position)){
                    yaPasado = true;
                }
            }
            if (!tablero[y][x].equals(" ") || yaPasado == false){
                numeros[contador] = tablero[y][x];
                contador ++;
                return true;

            }else{
                return false;
    
            }
        }else{
            return false;
        }
    }

    public void horseTime(int y, int x){ //posicion inicial

        //CASO BASE 64**** MEJORAR
        //CREO QUE VA A SUMAR MAS DE 64
        //posibles direcciones
        if (chequeoMovimiento(y-2, x-1)){
            horseTime(y-2, x-1);
        }
        if (chequeoMovimiento(y-2, x+1)){
            horseTime(y-2, x+1);
        }
        if (chequeoMovimiento(y+2,x-1)){
            horseTime(y+2,x-1);
        }
        if (chequeoMovimiento(y+2,x+1)){
            horseTime(y+2,x+1);
        }
        if (chequeoMovimiento(x-2, y+1)){
            horseTime(x-2, y+1);
        }
        if (chequeoMovimiento(x-2, y-1)){
            horseTime(x-2, y-1);
        }
        if (chequeoMovimiento(x+2,y+1)){
            horseTime(x+2,y+1);
        }
        if (chequeoMovimiento(x+2,y-1)){
            horseTime(x+2,y-1);
        }

        if (contador == 64){
            System.out.print("Posicion con solucion");
        }
    }




}
