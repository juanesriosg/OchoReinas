package principal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ocho_Reinas {
	
	
	public static void main(String[] args) {
		print(resolver());
	}
	
	public static int[] ponerReina(int[][] sln,int[] arr,int col,int i) {
		int[] disp=disponibles(arr);
		int aux=0;
		while(col<7) {	
			
			if(disp.length==0) {
				System.out.println("Hace backtracking");
				return ponerReina(sln,arr, col-1,i+1);
			}
			
			arr[col]=disp[i];
			
			return ponerReina(sln,arr,col+1,i);
		
		}
		if(isSolucion(sln, arr))
			return arr;
		else {
			return ponerReina(sln,arr,0,i);
		}
		
	
	}
	
	public static int[] disponibles(int[] arr) {
		int j=0;
		
		for(int t=0;t<arr.length;t++) {
            if(arr[t]!=-1) 
                j++;
		}
		int[] aux=Arrays.copyOf(arr, arr.length);
		
		int[] disp=new int[8-j];
		int k=0,i=0;
		while(k<=7 && j<8) {
			aux[j+i]=k;
			if(isDisponible(aux) && i<disp.length) {
				disp[i]=k;
				i++;
			}
			k++;
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
                if(posicion[i]==posicion[u] || posicion[u]==posicion[i]+(u-i) || posicion[u]==posicion[i]-(u-i) || posicion[u]>posicion.length) {
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
			printV(sln[i]);
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
		return cont==7?false:true;
	}
	
	public static void printV(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	
	public static void print(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print("Solucion "+(i+1)+" :\t");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
			
		}
	}
	
/*	static int cont=0;
	
	public static void main(String[] args) {
		//1 OPCION con el método disponibles
		// Creo un ejemplo para ver si la funcion disponibles funciona bien
		// Creamos la lista de prueba
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(new Integer(3));
		a.add(new Integer(5));
		// Creo otra lista para guardar lo que devuelve el método disponibles
		List<Integer> z = disponibles(a);
		for (Iterator<Integer> j=z.iterator();j.hasNext();){
			System.out.println(j.next().intValue());
		}
		// 2 OPCION con el algoritmo resolver
		LinkedList<Integer> b = new LinkedList<Integer>();
		System.out.println("La solucón con el método resolver es: ");
		resolver(b);
	}
	
	public static List<Integer> disponibles(List<Integer>ocup){
		//creamos la lista de disponibles que inicialmente tiene todas las columnas
		//		d=[0,1,2,3,4,5,6,7]
		List<Integer> d= new LinkedList<Integer>();//podría haber utilizado un ArrayList
		for(int i=0;i<8;i++){
			d.add(new Integer(i));
		}
		//averiguamos cuántas reinas hay ya colocadas y lo guardamos en la variable k
		//		k= tamaño(ocup)
		int k=ocup.size();
		//recorremos la lista de columnas ocupadas para ir tachando los lugares que 
		 //no nos vale. Podriamos hacerlo con un for, pero para listas mejor el Iterator
		//Para cada c en ocup:
		//			Eliminar c de d
		//			Eliminar (c+k) de d
		//			Eliminar (c-k) de d
		//			K - -
		for (Iterator<Integer> j=ocup.iterator();j.hasNext();k--){
			Integer c=j.next();
			//trabajamos con objetos que contienen números enteros por eso uso el remove
			d.remove(c);
			d.remove(new Integer(c.intValue()+k));
			d.remove(new Integer(c.intValue()-k));
		}
		//finalmente devolvemos lo que nos queda
		//devolver d
		return d;
	}
	

	public static void resolver(List<Integer> ocup){
		// si tenemos ya 8 reinas ubicadas, es que encontramos una solución, si no, hay que iterar recursivamente
		if (ocup.size()<8){
			// d=disponibles(ocup)
			List<Integer> d = disponibles(ocup);
			// para cada c en d:
			for (Iterator<Integer> c=d.iterator();c.hasNext();){
				//resolver(ocup+c) Aquí tengo que crear una lista provisional
				List<Integer> provisional = new LinkedList<Integer>(ocup);
				provisional.add(c.next());
				resolver(provisional);
			}
		}else{
			//mostramos la solución por pantalla como una linea
			String solucion="";
		for (Iterator<Integer> j=ocup.iterator();j.hasNext();){
				solucion += j.next().intValue();
			}
			cont++;
		System.out.println("Solucion " + cont+" "+solucion + " ");
		}
	}
	*/
	
	/*static int cont=0;
	public static int[] disponible(int[] ocupados) {
		int[] d=new int[8];
		
		for (int i = 0; i < d.length; i++) {
			d[i]=i;
		}
		
		int k=ocupados.length;
		
		for(int c:ocupados) {
			remove(d, c);
			remove(d,c+k);
			remove(d,c-k);
			k--;
		}
		
		return d;
	}
	
	public static void remove(int[] arr,int element) {
		int pos =busqueda(arr, element);
		if(pos != -1) {
			for (int i = pos; i < arr.length-1; i++) {
				arr[i]=arr[i+1];
			}
			arr=Arrays.copyOf(arr, arr.length-1);
		}
	}
	
	public static int busqueda(int[] ps, int p3){
		int i=0;
		while ( i<ps.length && ps[i]!=p3) i++ ;
		return(i==ps.length) ? -1: i;
	}
	
	
	
	public static void resolver(int[] ocupado) {
		if(diferente(ocupado)) {
			int[] d=disponible(ocupado);
			
			for (int c:d) {
				int[] provisional=ocupado; 
				add(provisional, c);
				resolver(provisional);
			}
		}else {
			print(ocupado);
		}
	}
	
	public static boolean diferente(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == -1) {
				return true;
			}
		}
		return false;
	}
	
	public static void print(int[] arr) {
		cont++;
		System.out.print("Solucion: "+cont+"\t");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
	}
	
	public static void add(int[] arr,int element) {
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=element;
	}
	
	public static void main(String[] args) {
		System.out.println("Las soluciones son : ");
		int[] b=new int[8];
		
		for(int i=0;i<b.length;i++) {
			b[i]=-1;
		}
		
		resolver(b);
	}*/
	
}
