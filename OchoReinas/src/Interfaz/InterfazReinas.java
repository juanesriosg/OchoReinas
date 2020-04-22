package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;


public class InterfazReinas extends JFrame {
	

	private JPanel contentPane;
	private static JTable table;
	final static int N=8;
	static int cont=0;
	static int [][] tablero=new int[N][N];
	static int [][] soluciones=new int[92][N];
	private static JTextField textField;
	static int n=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazReinas frame = new InterfazReinas();
					frame.setVisible(true);
					solucionCompleta();
					mostrarMatriz(elegirSolucion(n),n);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazReinas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.setRowHeight(40);
	
		table.setDefaultRenderer(Object.class, new MiRender());
		table.setForeground(Color.ORANGE);
		table.setBackground(Color.WHITE);
		table.setRowSelectionAllowed(false);
		table.setBounds(24, 42, 320, 320);
		contentPane.add(table);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				n=n+1;
				mostrarMatriz(elegirSolucion(n),n);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(rootPane, "No hay más soluciones.");
				}
			}
		});
		btnSiguiente.setBounds(247, 375, 97, 25);
		contentPane.add(btnSiguiente);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				n=n-1;
				mostrarMatriz(elegirSolucion(n),n);
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(rootPane, "No se puede regresar.");
				}
			}
		});
		btnAtras.setBounds(24, 375, 97, 25);
		contentPane.add(btnAtras);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(128, 13, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
	}
	
	
	public static void mostrarMatriz(int matriz [][],int cont) {		
		for (int i=0; i < 8; i++) {
			for (int j=0; j<8; j++) {			
				table.setValueAt((matriz[i][j]!=0?"\u265B":""+ "\t"), i, j);
				textField.setText("Solución: "+cont);			
			}
		}
	}
	
	public static int [][] elegirSolucion(int n) {
		int [] temp = new int[8];
		int [][] soluciontemp = new int [8][8];
		for(int i=0; i < soluciones.length; i++) {
			for (int j=0; j < soluciones[i].length; j++) {
				 temp[j]= soluciones[n-1][j];
			 }
			for (int k=0; k < soluciontemp.length; k++) {
				  for (int l=0; l < soluciontemp[k].length; l++) {
				   if(temp[k]==l+1) {
					   soluciontemp[l][k]=1;
				   }
				   else {
					   soluciontemp[l][k]=0;
				   }
				  }
				}
		}
		return soluciontemp;
	}
		
			
	
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
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
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
}	
