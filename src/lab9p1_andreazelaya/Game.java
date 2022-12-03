package lab9p1_andreazelaya;

import java.util.ArrayList;

public class Game {

    int[][] matrizInicial = new int[10][10];
    int[][] newMatriz = new int[10][10];
    ArrayList<String> coords = new ArrayList<>();

    int rondas = 0;

    public Game() {

    }

    public int[][] getMatrizInicial() {
        return matrizInicial;
    }

    public void setMatrizInicial(int[][] matrizInicial) {
        this.matrizInicial = matrizInicial;
    }

    public int[][] getNewMatriz() {
        return newMatriz;
    }

    public void setNewMatriz(int[][] newMatriz) {
        this.newMatriz = newMatriz;
    }

    public ArrayList<String> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<String> coords) {
        this.coords = coords;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public void print(ArrayList<String> list) {
        int[][] temp = new int[10][10];
        String output = "";

        for (int i = 0; i < list.size(); i++) {
            String[] coords = list.get(i).split(":");
            temp[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])] = 1;
        }

        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                output += '[' + Integer.toString(temp[j][k]) + ']';
            }
            output += '\n';
        }
        System.out.println(coords);
        System.out.println(output);
    }

    public void nextGen() {
        coords.clear();
        for (int i = 1; i <9; i++) {
            for (int j = 1; j <9; j++) {
                if (matrizInicial[i][j] == 1 && getNumVecinos(i, j) < 2) {
                    newMatriz[i][j] = 0;
                } else if (matrizInicial[i][j] == 1 && getNumVecinos(i, j) > 3) {
                    newMatriz[i][j] = 0;
                } else if (matrizInicial[i][j] == 0 && getNumVecinos(i, j) == 3) {
                    newMatriz[i][j] = 1;
                } else if (matrizInicial[i][j] == 1 && getNumVecinos(i, j) == 2) {
                    newMatriz[i][j] = 1;
                } else {
                    newMatriz[i][j] = 0;
                }
                if(newMatriz[i][j]==1){
                    coords.add(Integer.toString(i)+":"+Integer.toString(j));
                }
            }
        }

        matrizInicial = newMatriz;
        newMatriz = new int[10][10];

    }

    public int getNumVecinos(int i, int j) {
        int cont = 0;
        for (int k = -1; k <= 1; k++) {
            if (i + k > -1 && i + k < 10 && j-1 > -1) {
                if (matrizInicial[i + k][j - 1] == 1 && i + k != i) {
                    cont++;
                }
            }

        }

        for (int k = -1; k <= 1; k++) {
            if (i + k > -1 && i + k < 10 && j+1 < 10) {
                if (matrizInicial[i + k][j + 1] == 1 && i + k != i) {
                    cont++;
                }
            }
        }

        for (int k = -1; k <= 1; k++) {
            if (j + k > -1 && j + k < 10 && i-1 > -1) {
                if (matrizInicial[i - 1][j + k] == 1 && j + k != j) {
                    cont++;
                }
            }
        }

        for (int k = -1; k <= 1; k++) {
            if (j + k > -1 && j + k < 10 && i +1 < 10) {
                if (matrizInicial[i + 1][j + k] == 1 && j + k != j) {
                    cont++;
                }
            }
        }

        return cont;
    }

    public void jugar(int x) {
        for (int i = 0; i < x; i++) {
            print(coords);
            nextGen();
        }
        
    }
    
   
}
