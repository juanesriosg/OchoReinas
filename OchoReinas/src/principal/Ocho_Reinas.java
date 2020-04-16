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
	
	public static boolean isDisponible(int[]posicion) {
        int j=0;
        
        for(int t=0;t<posicion.length;t++) {
            if(posicion[t]!=-1) 
                j++;
        }
        
        for(int i=0;i<j;i++) {
            for(int u=i+1;u<j;u++) {
                if(posicion[i]==posicion[u] || posicion[u]==posicion[i]+(u-i) || posicion[u]==posicion[i]-(u-i)) {
                    
                	return false;  
                }  
            }   
        }
        //System.out.println("is true");
        return true;
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
	
	final static int N = 8;
	final static int n = (N+1);
	static int [] reinas = new int[n];
	static boolean solucion; 
	
	public static boolean solucionReinas(){
		solucion = false;
		ponerReina(1);
		return solucion;
	}
	
	private static void ponerReina(int i){
		int j;
		j = 0; // inicializa posibles movimientos
		do {
			j++;
			reinas[i] = j; // prueba a colocar reina i en fila j,
								
			// a la vez queda anotado el movimiento
			 if (valido(i))
			 {
				 if (i < N) // no completado el problema
				 {
					 ponerReina(i+1);
					 // vuelta atrás
					 if (!solucion)
						 reinas[i] = 0;
				 }
				 else // todas las reinas colocadas
					 solucion = true;
			 }
		} while(!solucion && (j < 8));
	}
	
	private static boolean valido(int i){
			 /* Inspecciona si la reina de la columna i es atacada por
					 alguna reina colocada anteriormente */
		int r;
		boolean libre;
		libre = true;
		for (r = 1; r <= i-1; r++)
		{
				 // no esté en la misma fila
		libre = libre && (reinas[i] != reinas[r]);
				 // no esté en alguna de las dos diagonales
				 libre = libre && ((i + reinas[i]) != (r + reinas[r]));
				 libre = libre && ((i - reinas[i]) != (r - reinas[r]));
		}
		return libre;
	}
	
	public static void main(String[] args) {
		solucion=solucionReinas();
		printv(reinas);
	}
	
	public static void printv(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	
	
}
