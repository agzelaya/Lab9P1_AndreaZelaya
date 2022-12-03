package lab9p1_andreazelaya;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Lab9P1_AndreaZelaya {
static Scanner in = new Scanner(System.in);
static Random random = new Random();
static Game g = new Game();

    public static void main(String[] args) {
        int opcion;
        do{
            System.out.println("Bienvenido al juego de la vida");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Ingrese la opcion que desea: ");
            opcion = in.nextInt();
            
            switch (opcion){
                case 1:{
                    
                    System.out.print("Ingrese el numero de rondas: ");
                    int rondas = in.nextInt();
                    
                    int [][] tablero = new int [10][10];
                    int [][] newTablero = new int [10][10];
                    ArrayList<String> list = new ArrayList<>();
                    
                    tablero = llenarMatriz(tablero, newTablero, list);
                    g.setMatrizInicial(tablero);
                    g.setNewMatriz(newTablero);
                    g.setRondas(rondas);
                    
                    g.jugar(rondas);
                }
                
                case 2:{
                    
                }
            }
            
        }while(opcion != 2);
        
    }
    
    public static int [][] llenarMatriz(int[][] tablero, int[][] newTablero, ArrayList<String> list){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if(i == 0 || j == 0 || i == 9 || j == 9){
                    tablero[i][j] = 0;
                }
                
                else{
                    tablero[i][j] = random.nextInt(2);
                    if(tablero[i][j] == 1){
                        list.add(Integer.toString(i)+":"+Integer.toString(j));
                    }
                }
            }
        }
        g.setCoords(list);
        return tablero;
    }
    

    
}
