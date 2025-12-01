/**
 *  partida completa gato
 * @author  b98132
 * @version 2.0
 */

import java.util.Scanner;
import java.util.InputMismatchException;




public class Gato {
    String [][] tablero;
    String jugador1;
    String jugador2;


    public Gato(){

        tablero = new String[3][3];
        for (int i = 0 ; i < tablero.length ; i++){
            for(int o = 0 ; o < tablero.length ; o++){
                tablero[i][o] = "[ ]";
            }
        }
    }

    public void iniciarJuego(){
        int fila1;
        int fila2;
        int columna1;
        int columna2;
        boolean win = false;
        boolean valido;
        Scanner sc = new Scanner(System.in);

        while (win == false){
             
                    //Se muestra tablero
                    System.out.println();
                    for (int w = 0 ; w < tablero.length ; w++){
                    for(int e = 0 ; e < tablero.length ; e++){
                        System.out.print(tablero[w][e]+ "\t");
                    }
                    System.out.println();
                    }







                    //　input de jugador 1
                    System.out.print("\nTurno Jugador 1");
                        valido = false;
                        while (valido == false){
                            
                            fila1 = -1;
                            // recibir Fila 
                            while (fila1 < 0  || fila1 > 2){
                                try{
                                    System.out.print("\nFila Jugador 1:");
                                    fila1 = sc.nextInt();
                                }catch (InputMismatchException e){
                                    sc.next();
                                }
                                if (fila1 < 0  || fila1 > 2){
                                System.out.print("\nValor invalido. Digite otra vez\n");
                                }
                                
                            }
                            columna1 = -1;
                            // recibir Columna
                            while (columna1 < 0  || columna1 > 2){
                                try{
                                    System.out.print("Columna Jugador 1:");
                                    columna1 = sc.nextInt();
                                }catch (InputMismatchException e){
                                    sc.next();
                                }
                                if (columna1 < 0  || columna1 > 2){
                                   System.out.print("\nValor invalido. Digite otra vez\n");
                                } 
                            }
                        
                            // colocacion nueva pieza player 1
                            if (tablero[fila1][columna1] == "[ ]"){

                                tablero[fila1][columna1] = "[X]";
                                valido = true;
                            }else {
                                System.out.print("\nEspacio no disponible.\n"); 
                                fila1 = -1;
                                columna2= -1;

                            }
                        }
                    
                
                    //Se muestra tablero segunda vez
                    System.out.println();
                    for (int w = 0 ; w < tablero.length ; w++){
                    for(int e = 0 ; e < tablero.length ; e++){
                        System.out.print(tablero[w][e]+ "\t");
                    }
                    System.out.println();
                    }


                    //win check player 1
                    for (int q = 0 ; q < tablero.length ; q++){ //horizontal 
                            if (tablero[q][1] == tablero[q][0] && tablero[q][1] == tablero[q][2] && tablero[q][1] != "[ ]"){
                                win = true;
                                System.out.println("Jugador 1 ha ganado con movida horizontal .");
                                break;
                            }else if (tablero[1][q] == tablero[0][q] && tablero[1][q] == tablero[2][q] && tablero[1][q] != "[ ]"){ //vertical 
                                win = true;
                                System.out.println("Jugador 1 ha ganado con movida vertical .");
                                break;
                            } else if (tablero[1][1] == tablero[0][0] && tablero[1][1] == tablero[2][2] && tablero[1][1] != "[ ]" ){ 
                                win = true;
                                System.out.println("Jugador 1 ha ganado con movida ascendiente.");
                                break;
                            } else if (tablero[1][1] == tablero[0][2] && tablero[1][1] == tablero[2][0] && tablero[1][1] != "[ ]" ){
                                win = true;
                                System.out.println("Jugador 1 ha ganado con movida diagonal descendiente.");
                                break;
                            }    
                        
                    }



                    // chequeo empate 2
                    int contador = 9;
                    for (int i = 0 ; i < tablero.length ; i++){
                        for(int o = 0 ; o < tablero.length ; o++){
                            if (tablero[i][o] != "[ ]"){
                            contador -=1;
                            }
                        }
                    }
                    if (contador == 0){
                        System.out.println("Empate");
                        break;
                    }
                    
                    if ( win == true){
                    break;
                    }


                    //　input de jugador 2

                    valido = false;
                    System.out.print("\nTurno Jugador 2");
                    while (valido == false){

                        // recibir Fila 
                            fila2 = -1;
                            while (fila2 < 0  || fila2 > 2){
                                try{
                                    System.out.print("\nFila Jugador 2:");
                                    fila2 = sc.nextInt();
                                }catch (InputMismatchException e){
                                    sc.next();
                                }
                                if (fila2 < 0  || fila2 > 2){
                                    System.out.print("\nValor invalido. Digite otra vez\n");
                                }
                                
                            }
                            columna2 = -1;
                            // recibir Columna
                            while (columna2 < 0  || columna2 > 2){
                                try{
                                    System.out.print("Columna Jugador 2:");
                                    columna2 = sc.nextInt();
                                }catch (InputMismatchException e){
                                    sc.next();
                                }
                                if (columna2 < 0  || columna2 > 2){
                                System.out.print("\nValor invalido. Digite otra vez\n");
                                }
                            }



                            // colocacion nueva pieza player 2
                            if (tablero[fila2][columna2] == "[ ]"){
                                tablero[fila2][columna2] = "[O]";
                                valido = true;
                            }else {
                                System.out.print("\nEspacio no disponible.\n");
                                fila2 = -1;
                                columna2= -1;
                            
                            }
                    }



                    //win check player 2
                    for (int d = 0 ; d < tablero.length ; d++){ 
                            if (tablero[d][1] == tablero[d][0] && tablero[d][1] == tablero[d][2] && tablero[d][1] !="[ ]" ){ //horizontal 
                                win = true;
                                System.out.println("Jugador 2 ha ganado con movida horizontal.");
                                break;
                            }else if (tablero[1][d] == tablero[0][d] && tablero[1][d] == tablero[2][d] && tablero[1][d] !="[ ]" ){ //vertical 
                                win = true;
                                System.out.println("Jugador 2 ha ganado con movida vertical.");
                                break;
                            }else if (tablero[1][1] == tablero[0][0] && tablero[1][1] == tablero[2][2] && tablero[1][1] !="[ ]"){ //diagonal
                                win = true;
                                System.out.println("Jugador 2 ha ganado con movida diagonal descendiente.");
                                break;
                            } else if (tablero[1][1] == tablero[0][2] && tablero[1][1] == tablero[2][0] && tablero[1][1] !="[ ]"){
                                win = true;
                                System.out.println("Jugador 2 ha ganado con movida diagonal ascendiente.");
                                break;
                            }    
                         
                  
                    }   
                    // chequeo empate 2
                    int contador1 = 9;
                    for (int i = 0 ; i < tablero.length ; i++){
                        for(int o = 0 ; o < tablero.length ; o++){
                            if (tablero[i][o] != "[ ]"){
                            contador1 -=1;
                            }
                        }
                    }
                    if (contador1 == 0){
                        System.out.println("Empate");
                        break;
                    }
             
        
        
            
        }
        
        
        
        
        
        
        
        
                




      
        

        sc.close();     
    }
     
}

