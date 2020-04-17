package principal;

public class OchoReinas {
		public static void main(String[] args) {
			solucionCompleta();	
		}
	
		final static int N=8;//Dimension del tablero
		static int cont=0;
		private static int [][] tablero=new int[N][N];

		public static void imprimirTablero(){
			int[] sln=new int[8];
			for(int i=0;i<tablero.length;i++){
				for (int j=0;j<tablero.length;j++) {
					System.out.print(tablero[i][j]+ "\t");
					if(tablero[i][j]!=0) {
						sln[j]=i+1;
					}
				}
				
				System.out.println();
			}
			System.out.println("solucion vectorial: ");
			print(sln);
			System.out.println();
		}
		
		public static void print(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+"\t");
			}
			System.out.println();
		}

		public static void solucionCompleta(){
			ponerReina(0);
		}
		
		public static void ponerReina(int col){
			int fila= 0; // cantidad de posiciones posibles (8 filas como máximo)
			while (fila<N){
				if (col<N){
					if (valida(fila, col)){// Verificar que fila y columna validas
						tablero[fila][col]=1;
						ponerReina(col+1);
						tablero[fila][col]=0;// regreso atrás siempre
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
		public static boolean rango(int num){
			return (num>=0 && num<N);
		}
		
		private static boolean valida(int fila,int col){
			//int j=0;
			for (int j = 0; j <= col; j++) {
				//Verifico que no ocupada la fila
				if(tablero[fila][j] !=0 && j!=col)
					return false; 
				//Verifico diagonal superior
				if((rango (fila-j)&&rango(col-j) && tablero[fila-j][col-j] != 0 && j>0 ))
					return false;
				//Verifico diagonal inferior
				if(rango (fila+j)&& rango(col-j) &&tablero[fila+j][col-j] != 0 && j>0)
					return false;	
			}
			
			return true;	
		}
	}	



	


