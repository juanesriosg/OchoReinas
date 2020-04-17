package principal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class OchoReinas {
	
		public void solucion(){
			solucion(0);// cantidad de reinas
		}
	
		//cReinas- número de reinas
		public void solucion(int col){
			solucion=false; 	// boolean para saber si ya se encontró la solución
			int fila= 0; 	// cantidad de posiciones posibles 
			while (fila<N && !solucion){
				if (col>=N)
					solucion=true;
				else{
					if (valida(fila, col)){// Verificar que la fila sea válida
						tab[fila][col]=col+1;
						solucion(col+1);
						if (!solucion) // regreso atrás
							tab[fila][col]=0;
					}
				}
				fila++;// nueva fila
			}
		}

		

		final int N=8;//Dimension del tablero
		int cont=0;
		boolean solucion;
		private int [][] tab;

		public int[][] getTablero() {
			return tab;
		}

		public void setTablero(int[][] tab) {
			this.tab = tab;
		}

		public void imprimirTablero(){
			for(int i=0;i<tab.length;i++){
				for (int j=0;j<tab.length;j++)
					System.out.print(tab[i][j]+ "\t");
				System.out.println();
			}

		}

		public OchoReinas(){
			tab=new int[N][N];
		}

		public void solucionTodas(){
			solucionT(0);
		}
		
		public void solucionT(int col){
			int fila= 0; // cantidad de posiciones posibles (8 filas como máximo)
			while (fila<N){
				if (col<N){
					if (valida(fila, col)){// Verificar que la fila sea válida
						tab[fila][col]=col+1;
						solucionT(col+1);
						tab[fila][col]=0;// regreso atrás siempre
					}
				}
				fila++;// nueva fila
			}
			
			if (col>=N){
				cont++;
				System.out.println("Solucion: "+cont);
				imprimirTablero();
				System.out.println();
			}
		}

		// Verifica si una posición es válida
		public boolean valida(int x){
			return (x>=0 && x<N);
		}

		public boolean valida(int fila, int col){
			// la misma fila y diagonal
			//tablero[fila][j]!=0;//hay una en la misma fila
			//tablero [fila-col] y tablero[fila+col] != 0 para que no haya reina en diagonal
			int j=0;
			while (j<col && tab[fila][j]==0 && 
					((valida (fila-col+j) && tab [fila-col+j][j]==0)||!(valida (fila-col+j))) && 
					((valida (fila+col-j) &&(tab[fila+col-j][j] == 0))||!(valida (fila+col-j)))
					)
				j++;
			return (j<col)? false: true;
		}
		//Devuelve los ocho movimientos posibles

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			OchoReinas r= new OchoReinas();
			r.solucionTodas();
			//r.solucionTodas();
			r.imprimirTablero();
			System.out.println();

		}
	}	
	
	
	


