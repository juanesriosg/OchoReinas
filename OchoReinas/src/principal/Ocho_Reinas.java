package principal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ocho_Reinas {
	
	
	/*public static void main(String[] args) {
		print(resolver());
	}
	
	public static int[] ponerReina(int[][] sln,int[] arr,int col,int i) {
		int[] disp=disponibles(arr);
		System.out.print("disp: col:"+col+"\t");
		printv(disp);
		while(col<=7) {	
			if(i<disp.length) {
				arr[col]=disp[i];
				System.out.print("col: "+col+" :\t");
				printv(arr);
				
				return ponerReina(sln,arr,col+1,i);
			}else if(i==disp.length) {
				System.out.println("BackT en col: "+col+" : ");
				arr[col-1]=-1;
				System.out.print("col desde bt: "+col+" :\t");
				printv(arr);
				return ponerReina(sln,arr, col-1,i+1);
			}
			
			
			
			
		}
		if(isSolucion(sln, arr))
			return arr;
		else {
			return ponerReina(sln,arr,0,i+1);
		}
	}
	
	public static int[] disponibles(int[] arr) {
		
		int j=0;
		for(int t=0;t<arr.length;t++) {
            if(arr[t]!=-1) 
                j++;
		}
		
		int[] aux=Arrays.copyOf(arr, j+1);
		
		
		String a="";
		int k=0;
		for (int i = 0; i <=7; i++) {
			aux[aux.length-1]=i;
			
			if(isDisponible(aux)) {
				k++;
				a+=i;
			}
		}
		
		String[] arrAuxStr=a.split("");
		int[] disp=new int[k];
		
		if(!a.isEmpty()) {
			for (int i = 0; i < disp.length; i++) {
				disp[i]=Integer.parseInt(arrAuxStr[i]);
			}
		}
		
		return disp;
	}
	
	
	public static int[][] resolver() {
		int[] arr=new int[8];
		
		int[][] sln=new int[92][8];
		for (int i = 0; i < arr.length; i++) {
			arr=llenarArr(arr);
			sln[i]= ponerReina(sln,arr,0,0);
			
		}
		return sln;
	}
	
	public static int[] llenarArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i]=-1;
		}
		return arr;
	}
	
	public static boolean isSolucion(int[][] arr, int[] eval) {
		int cont=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]==eval[j]) {
					cont++;
				}
			}
		}
		return cont==8?false:true;
	}
	
	public static void printv(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	
	public static void print(int[][] arr) {
		for(int i=0;i<10;i++) {
			System.out.print("Solucion "+(i+1)+" :\t");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
			
		}
	}*/
	
	final static int N = 7;
	final static int n = (N+1);
	static int [] reinas = new int[n];
	static boolean solucion=false; 
	static int[][] nSol=new int[1][8];
	
	public static boolean solucionReinas(){
		solucion = false;
		ponerReina(0);
		return solucion;
	}
	
	public static boolean solucionIgual() {
		
		for (int i = 0; i < nSol.length; i++) {
			if(Arrays.equals(reinas, nSol[i]))
				return true;
		}
		return false;
	}
	
	private static void ponerReina(int i){
		int j;
		j = -1; // inicializa posibles movimientos
		do {
			j++;
			reinas[i] = j; // prueba a colocar reina i en fila j,
							
			// a la vez queda anotado el movimiento
			 if (valido(i)){
				 if (i < N){
					 ponerReina(i+1);
					 // vuelta atrás
					 if (!solucion)
						 reinas[i] = 0;
				 }
				 else { // todas las reinas colocadas
					 solucion = true;
					 add(reinas);
				 }
			}
		} while(!solucion && (j < 7) && !solucionIgual());
	}
	
	public static void add(int[] reinas) {
		nSol=Arrays.copyOf(nSol, nSol.length+1);
		
		nSol[nSol.length-1]=reinas;
	}
	
	private static boolean valido(int i){
			 /* Inspecciona si la reina de la columna i es atacada por
					 alguna reina colocada anteriormente */
		 	int j=0;
	        for(j=0;j<i;j++) {
	                if(reinas[i]==reinas[j] || reinas[i]==reinas[j]+(i-j) || reinas[i]==reinas[j]-(i-j)) {  
	                	return false;  
	                }  
	            }   
	        return true;
		
	}
	
	public static void main(String[] args) {
		ponerReina(0);
		printv(reinas);
	}
	
	public static void printv(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	
	
}
