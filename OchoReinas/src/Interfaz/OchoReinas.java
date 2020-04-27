package Interfaz;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class OchoReinas {
	
	final static int N=8;
	static int cont=0;
	static int [][] tablero=new int[N][N];
	static int [][] soluciones=new int[92][N];
	
	public static void main(String[] args) {
		solucionCompleta();
		//estadisticas(8, 8);
	}
	
	public static void almacenarSoluciones(int cont) {
		soluciones[cont]=solucionVectorial();
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
	
	public static void solucionCompleta(){
		ponerReina(0);
	}
	
	public static void ponerReina(int columna){
		//Inicializa fila para comprobar cada valor si es valido
		//Menor que N para que no sobrepase el tamaño de la matriz
		//Se le suma 1 para intentar poner la reina en la siguiente fila
		for (int fila= 0; fila<N; fila++) { 
			// Verificar columna <8 y que fila y columna validas
				if (columna<N && valida(fila, columna)){
					tablero[fila][columna]=1;
					ponerReina(columna+1); //se intenta poner siguiente reina
					tablero[fila][columna]=0;
					//si no consigue poner la siguiente reina hace backtracking
				}
		}
		if (columna>=N){
			almacenarSoluciones(cont++);	
		}
	}
	
	private static boolean valida(int fila,int col){
		for (int j = 0; j <= col; j++) {
			//Verifico que no este ocupada la fila
			if(tablero[fila][j] !=0 && j!=col)
				return false; 
			//Verifico diagonal superior
			if(fila-j>=0 && col-j>=0 && tablero[fila-j][col-j] != 0 && j>0)
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
			
	public static void estadisticas(int col , int fila) {
			int cont =0;
			for(int i=0; i<soluciones.length; i++){
					if(soluciones[i][col-1]==fila){
						cont ++;
					}	
			}
			System.out.println("En la columna "+ col +", fila "+fila+ " hay: "+ cont+" reinas");
	}
	
	
	/*public static void imprimirTablero(){
		System.out.println("\t\t       Solución:"+(++cont));
		for(int i=0;i<N;i++){
			for (int j=0;j<N;j++) {
				System.out.print(tablero[i][j]!=0?"\u265B\t":"0"+ "\t");
			}
			 
			System.out.println();
		}
		System.out.println();
	}*/

	
}	
