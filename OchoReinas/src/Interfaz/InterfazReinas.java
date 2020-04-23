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
	private static JTextField textField;
	static int n=1;
	private static OchoReinas reina=new OchoReinas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazReinas f=new InterfazReinas();
					reina.solucionCompleta();
					mostrarMatriz(reina.getSoluciones()[n-1],n);
					f.setVisible(true);
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
					n++;
					mostrarMatriz(reina.getSoluciones()[n-1],n);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(rootPane, "No hay más soluciones.");
				}
			}
		});
		btnSiguiente.setBounds(247, 375, 97, 25);
		contentPane.add(btnSiguiente);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					n--;
					mostrarMatriz(reina.getSoluciones()[n-1],n);
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
	
	public static void mostrarMatriz(int sln [],int cont) {	
		for (int i=0; i < N; i++) {
			for (int j = 0; j < N; j++)
				table.setValueAt((""+ "\t"), j, i);	
			table.setValueAt(("\u265B"+ "\t"), sln[i]-1, i);	
		}				
		textField.setText("Solución: "+cont);
	}
	
	
}	
