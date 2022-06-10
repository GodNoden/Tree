package treeFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import treePackage.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;

public class TreeFrame extends JFrame {
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldPeso;

	/**
	 * Launch the application.
	 */
	Arbol arbol = new Arbol(0);
	Nodo nodoRaiz = Arbol.raiz;
	Nodo nodo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeFrame frame = new TreeFrame();
					Nodo nodo;

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TreeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 422);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel tabRegistroNodos = new JPanel();
		tabbedPane.addTab("Registro de Nodos", null, tabRegistroNodos, null);
		tabRegistroNodos.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(83, 35, 91, 14);
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		tabRegistroNodos.add(lblId);

		textFieldId = new JTextField();
		textFieldId.setBounds(184, 32, 127, 20);
		tabRegistroNodos.add(textFieldId);
		textFieldId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(83, 89, 91, 14);
		tabRegistroNodos.add(lblNombre);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(102, 143, 72, 14);
		tabRegistroNodos.add(lblPeso);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(184, 86, 195, 20);
		tabRegistroNodos.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(184, 140, 151, 20);
		tabRegistroNodos.add(textFieldPeso);
		textFieldPeso.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double id = Double.parseDouble(textFieldId.getText());
				String nombre = textFieldNombre.getText();
				double peso = Double.parseDouble(textFieldPeso.getText());

				// System.out.println(nodo.getId()+" "+ nodo.getNombre()+ " " +nodo.getPeso());
				System.out.println("Guardado");
				textFieldId.setText("");
				textFieldNombre.setText("");
				textFieldPeso.setText("");
				arbol.insertarNodo(id, nombre, peso);

			}
		});
		btnGuardar.setBounds(139, 196, 89, 23);
		tabRegistroNodos.add(btnGuardar);

		JButton btnImprimir = new JButton("Mostrar Arbol");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Arbol.printLeafNodes(nodoRaiz);
				arbol.imprimir(nodoRaiz, 10);
			}
		});
		btnImprimir.setBounds(375, 303, 127, 23);
		tabRegistroNodos.add(btnImprimir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double peso = Double.parseDouble(textFieldPeso.getText());
				Nodo nodo = arbol.buscarNodo(peso);
				System.out.println("Ingrese nuevo nombre y ID");
				double id = Double.parseDouble(textFieldId.getText());
				String nombre = textFieldNombre.getText();
				nodo.setId(id);
				nodo.setNombre(nombre);
				System.out.println("Editado");
				

			}
		});
		btnEditar.setBounds(139, 242, 89, 23);
		tabRegistroNodos.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double peso = Double.parseDouble(textFieldPeso.getText());
				Arbol.eliminar(peso);
				System.out.println("Nodo eliminado");

			}
		});
		btnEliminar.setBounds(139, 273, 89, 23);
		tabRegistroNodos.add(btnEliminar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double peso = Double.parseDouble(textFieldPeso.getText());
				long startTime = System.nanoTime();
				Nodo nodo = arbol.buscarNodo(peso);
				System.out.println("Nombre: " + nodo.getNombre() + "ID: " + nodo.getId());
				long endTime = System.nanoTime();

				long duration = ((endTime - startTime));
				System.out.println("tiempo demorado en encontrarlo: 0." + duration + " ms");
			}
		});
		btnBuscar.setBounds(139, 303, 89, 23);
		tabRegistroNodos.add(btnBuscar);

		JPanel tabRecorridos = new JPanel();
		tabbedPane.addTab("Recorridos", null, tabRecorridos, null);
		tabRecorridos.setLayout(null);

		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEjecutar.setBounds(309, 10, 89, 23);
		tabRecorridos.add(btnEjecutar);

		JLabel lblPreorden = new JLabel("Recorrido Preorden:");
		lblPreorden.setBounds(27, 84, 140, 14);
		tabRecorridos.add(lblPreorden);

		JLabel lblInorden = new JLabel("Recorrido Inorden:");
		lblInorden.setBounds(27, 137, 140, 14);
		tabRecorridos.add(lblInorden);

		JLabel lblPostorden = new JLabel("Recorrido PostOrden:");
		lblPostorden.setBounds(27, 195, 140, 14);
		tabRecorridos.add(lblPostorden);

		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(369, 56, 46, 14);
		tabRecorridos.add(lblTiempo);

		JTextArea textAreaPreorden = new JTextArea();
		textAreaPreorden.setBounds(155, 79, 184, 22);
		tabRecorridos.add(textAreaPreorden);

		JTextArea textAreaInorden = new JTextArea();
		textAreaInorden.setBounds(155, 132, 184, 22);
		tabRecorridos.add(textAreaInorden);

		JTextArea textAreaPostOrden = new JTextArea();
		textAreaPostOrden.setBounds(155, 190, 184, 22);
		tabRecorridos.add(textAreaPostOrden);

		JTextArea textAreaPreordenTiempo = new JTextArea();
		textAreaPreordenTiempo.setBounds(349, 79, 140, 22);
		tabRecorridos.add(textAreaPreordenTiempo);

		JTextArea textAreaInordenTiempo = new JTextArea();
		textAreaInordenTiempo.setBounds(349, 132, 140, 22);
		tabRecorridos.add(textAreaInordenTiempo);

		JTextArea textAreaPostOrdenTiempo = new JTextArea();
		textAreaPostOrdenTiempo.setBounds(349, 190, 140, 22);
		tabRecorridos.add(textAreaPostOrdenTiempo);
		
		String[] orders = { "PreOrden", "InOrden", "PostOrden" };
		JComboBox comboBoxOrden = new JComboBox(orders);
		comboBoxOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value = comboBoxOrden.getSelectedItem().toString();
				if(value == "PreOrden") {
					long startTime = System.nanoTime();
					arbol.preorden(nodoRaiz);
					long endTime = System.nanoTime();

					long duration = ((endTime - startTime));
					
					textAreaPreordenTiempo.setText(Long.toString(duration));
				}
				if(value == "InOrden") {
					long startTime = System.nanoTime();
					arbol.inorder(nodoRaiz);
					long endTime = System.nanoTime();

					long duration = ((endTime - startTime));
					textAreaInordenTiempo.setText(Long.toString(duration));
				}
				if (value == "PostOrden") {
					long startTime = System.nanoTime();
					arbol.postorden(nodoRaiz);
					long endTime = System.nanoTime();

					long duration = ((endTime - startTime));
					textAreaPostOrdenTiempo.setText(Long.toString(duration));
				}
;			}
		});

		comboBoxOrden.setBounds(69, 10, 230, 22);
		tabRecorridos.add(comboBoxOrden);

		
	}
}
