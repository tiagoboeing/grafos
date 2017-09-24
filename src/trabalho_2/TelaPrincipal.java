package trabalho_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxTipoGrafo;
	private JTextField txtVertices;
	private JTextField txtVerticeInicial;
	private JTextField txtAresta1;
	private JTextField txtAresta2;
	private JTextField txtValorAresta;
	private JTextArea txtListaArestas;
	private JButton btnCadastrarArestas;
	private JButton btnCalcular;
	
	private static ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Dijkstra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTituloPrograma = new JLabel("Menor dist\u00E2ncia - Algoritmo de Dijkstra");
		lblTituloPrograma.setBounds(27, 10, 268, 17);
		lblTituloPrograma.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblTituloPrograma);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 38, 326, 2);
		contentPane.add(separator);

		comboBoxTipoGrafo = new JComboBox();
		comboBoxTipoGrafo.setMaximumRowCount(2);
		comboBoxTipoGrafo.setBounds(31, 80, 107, 20);
		comboBoxTipoGrafo.addItem("Orientado");
		comboBoxTipoGrafo.addItem("Não orientado");
		contentPane.add(comboBoxTipoGrafo);

		JLabel lblTipoDeGrafo = new JLabel("Tipo de grafo:");
		lblTipoDeGrafo.setBounds(31, 57, 107, 14);
		contentPane.add(lblTipoDeGrafo);

		JLabel lblVrtices = new JLabel("V\u00E9rtices (somente n\u00FAmeros)");
		lblVrtices.setBounds(33, 120, 174, 14);
		contentPane.add(lblVrtices);

		txtVertices = new JTextField();
		txtVertices.setBounds(33, 138, 151, 20);
		contentPane.add(txtVertices);
		txtVertices.setColumns(10);

		JLabel lblEx = new JLabel("Ex.: 1,2,3 *separe com v\u00EDrgula");
		lblEx.setForeground(Color.GRAY);
		lblEx.setBounds(33, 162, 174, 14);
		contentPane.add(lblEx);

		JLabel lblArestas = new JLabel("Arestas");
		lblArestas.setBounds(31, 274, 174, 14);
		contentPane.add(lblArestas);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {

			private Aresta[] arestas;

			// AÇÃO DO BOTÃO CALCULAR
			public void actionPerformed(ActionEvent arg0) {

				// pega os vértices
				String resultadoVertices = "==============\nLISTA DE VÉRTICES: \n";
				
				String[] todosVertices = txtVertices.getText().split(",");
				for (int i = 0; i < todosVertices.length; i++) {
					resultadoVertices += "Vértice: " + todosVertices[i] + "\n";
				}					
				System.out.println(resultadoVertices); // mostra os vértices cadastrados
				
				
				// pega arestas
				String dados = "==============\nLISTA DE ARESTAS \n----- valor \n";

				for(Aresta a1 : listaArestas) {
					dados += a1.getVerticeOrigem() + "," + a1.getVerticeDestino() + " = " + a1.getValor() + "\n";							
				}		
				System.out.println(dados);
					
				
				Grafo g = new Grafo(listaArestas);
				g.calculaMenorDistancia();
				g.mostraResultado();

			}
		});
		btnCalcular.setBounds(27, 471, 292, 23);
		contentPane.add(btnCalcular);
		
		txtListaArestas = new JTextArea();
		txtListaArestas.setForeground(Color.BLACK);
		txtListaArestas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtListaArestas.setBackground(Color.ORANGE);
		txtListaArestas.setEditable(false);
		txtListaArestas.setLineWrap(true);
		txtListaArestas.setText("Lista de arestas\r\n----");
		txtListaArestas.setBounds(27, 327, 292, 133);
		contentPane.add(txtListaArestas);
		
		JLabel lblVrticeInicial = new JLabel("V\u00E9rtice inicial");
		lblVrticeInicial.setBounds(31, 195, 174, 14);
		contentPane.add(lblVrticeInicial);
		
		txtVerticeInicial = new JTextField();
		txtVerticeInicial.setColumns(10);
		txtVerticeInicial.setBounds(31, 213, 151, 20);
		contentPane.add(txtVerticeInicial);
		
		JLabel lblDeveEstarPresente = new JLabel("Deve estar presente na lista de v\u00E9rtices");
		lblDeveEstarPresente.setForeground(Color.GRAY);
		lblDeveEstarPresente.setBounds(31, 237, 233, 14);
		contentPane.add(lblDeveEstarPresente);
		
		txtAresta1 = new JTextField();
		txtAresta1.setBounds(31, 294, 45, 20);
		contentPane.add(txtAresta1);
		txtAresta1.setColumns(10);
		
		JLabel label = new JLabel(",");
		label.setBounds(80, 299, 4, 14);
		contentPane.add(label);
		
		txtAresta2 = new JTextField();
		txtAresta2.setColumns(10);
		txtAresta2.setBounds(86, 294, 45, 20);
		contentPane.add(txtAresta2);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(141, 300, 46, 14);
		contentPane.add(lblValor);
		
		txtValorAresta = new JTextField();
		txtValorAresta.setColumns(10);
		txtValorAresta.setBounds(174, 294, 45, 20);
		contentPane.add(txtValorAresta);
		
		btnCadastrarArestas = new JButton("Salvar");
		btnCadastrarArestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
					// caso algum campo fica vazio ele utiliza um grafo predefinido
					if(txtAresta1.getText().isEmpty() || txtAresta2.getText().isEmpty() || txtValorAresta.getText().isEmpty()) {
						
						// valores apenas para testes
						listaArestas.add(0, new Aresta(1, 3, 20));
						listaArestas.add(1, new Aresta(1, 2, 5));
						listaArestas.add(2, new Aresta(1, 4, 40));
						listaArestas.add(3, new Aresta(1, 5, 50));
						listaArestas.add(4, new Aresta(2, 4, 15));
						listaArestas.add(5, new Aresta(3, 5, 5));
						listaArestas.add(6, new Aresta(4, 5, 5));
						
						System.out.println("ALGUM CAMPO NAS ARESTAS FICOU VAZIO!! \n"
								+ "--> utilizando grafo predefinido \n");
						
					} else {
						
						// pega valores de arestas
						int aresta1 = Integer.parseInt(txtAresta1.getText());
						int aresta2 = Integer.parseInt(txtAresta2.getText());
						int valorAresta = Integer.parseInt(txtValorAresta.getText());
	
						// joga para arraylist
						Aresta a = new Aresta(aresta1, aresta2, valorAresta);
						listaArestas.add(a);
							
					}
				
			}
		});
		btnCadastrarArestas.setBounds(229, 293, 90, 23);
		contentPane.add(btnCadastrarArestas);
	}
}
