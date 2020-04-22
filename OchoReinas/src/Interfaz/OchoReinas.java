package Interfaz;

import java.util.Arrays;

public class OchoReinas {
	
	final static int N=8;
	static int cont=0;
	static int [][] tablero=new int[N][N];
	static int [][] soluciones=new int[92][N];
	
	/*public static void main(String[] args) {
		solucionCompleta();
	}*/
	
	public static void almacenarSoluciones(int cont) {
		soluciones[cont-1]=solucionVectorial();
	}
	
	public static int[] solucionVectorial() {
		int[] sv=new int[8];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tablero[i][j] != 0) 
					sv[j]=i+1;
			}
		}
		return sv;
	}
	
	public static void imprimirTablero(){
		System.out.println("\t\t       Solucion:"+(++cont));
		for(int i=0;i<N;i++){
			for (int j=0;j<N;j++) {
				System.out.print(tablero[i][j]!=0?"\u2655\t":tablero[i][j]+ "\t");
			}
			 
			System.out.println();
		}
		System.out.println();
	}

	public static void solucionCompleta(){
		ponerReina(0);
	}
	
	
	
	public static void ponerReina(int columna){
		//Inicializa fila para comprobar cada valor si es valido
		//Menor que N para que no sobrepase el tama�o de la matriz
		//Se le suma 1 para intentar poner la reina en la siguiente fila
		for (int fila= 0; fila<N; fila++) { 
			// Verificar columna <8 y que fila y columna validas
				if (columna<N && valida(fila, columna)){
					tablero[fila][columna]=1;
					ponerReina(columna+1); //se intenta poner siguiente reina
					tablero[fila][columna]=0; //si no consigue poner la otra reina hace backtracking
				}
		}
		if (columna>=N){
			imprimirTablero();
			almacenarSoluciones(cont);
			
		}
	}
	
	private static boolean valida(int fila,int col){
		for (int j = 0; j <= col; j++) {
			//Verifico que no este ocupada la fila
			if(tablero[fila][j] !=0 && j!=col)
				return false; 
			//Verifico diagonal superior
			if(fila-j>=0 && col-j>=0 && tablero[fila-j][col-j] != 0 && j>0 )
				return false;
			//Verifico diagonal inferior
			if(fila+j<N && col-j>=0 &&tablero[fila+j][col-j] != 0 && j>0)
				return false;	
		}
		return true;	
	}
	
	public static int[][] getSoluciones() {
		return soluciones;
	}	
	
	
}	
