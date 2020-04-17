package principal;
public class Ocho_Reinas {
	
	final static int N=8;
	static int cont=0;
	static int [][] tablero=new int[N][N];
	static int [][] soluciones=new int[92][N];
	static int[] solucionVectorial=new int[8];
	
	public static void main(String[] args) {
		solucionCompleta();	
	}
	
	public static void almacenarSoluciones(int cont) {
		soluciones[cont-1]=solucionVectorial;
	}
	
	public static void solucionVectorial() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tablero[i][j] != 0) 
					solucionVectorial[j]=i+1;
			}
		}
	}
	
	public static void imprimirTablero(){
		for(int i=0;i<N;i++){
			for (int j=0;j<N;j++) {
				System.out.print(tablero[i][j]+ "\t");
			}
			System.out.println();
		}
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
		int fila= 0; // maximo 8 filas disponibles
		while(fila<N){
			if(col<N){
				if (valida(fila, col)){// Verificar que fila y columna validas
					tablero[fila][col]=1;
					ponerReina(col+1);
					tablero[fila][col]=0;// backtracking siempre
				}
			}
			fila++;// nueva fila
		}
		if (col>=N){
			System.out.println("\t\t\tSolucion: "+(++cont));
			imprimirTablero();
			System.out.println();
			solucionVectorial();
			almacenarSoluciones(cont);
		}
	}

	private static boolean valida(int fila,int col){
		for (int j = 0; j <= col; j++) {
			//Verifico que no ocupada la fila
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
}	
