package grafos;

import grafos.estrutura.Aresta;
import grafos.estrutura.Grafo;
import grafos.estrutura.Representacoes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private Grafo grafo = new Grafo();
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea txtrestaPrntandoNo;
	private JCheckBox chckbxDirigido;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           e.printStackTrace();
        }
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVertice = new JLabel("Vertice:");
		lblVertice.setBounds(10, 35, 46, 14);
		contentPane.add(lblVertice);
		
		textField = new JTextField();
		textField.setBounds(10, 60, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafo.getVertices().add(textField.getText());
				comboBox.addItem(textField.getText());
				comboBox_1.addItem(textField.getText());
				textArea.setText("V = {");
				for (int i = 0; i < grafo.getVertices().size(); i++) {
					if (i+1 == grafo.getVertices().size()) {
						textArea.setText(textArea.getText() + grafo.getVertices().get(i));
					}else{
						textArea.setText(textArea.getText() + grafo.getVertices().get(i) + ",");
					}
				}
				textArea.setText(textArea.getText() + "}");
				textField.setText("");
			}
		});
		btnAdicionar.setBounds(111, 59, 89, 23);
		contentPane.add(btnAdicionar);
		
		textArea = new JTextArea();
		textArea.setBounds(217, 35, 468, 45);
		textArea.setLineWrap(true); 
		contentPane.add(textArea);
		
		chckbxDirigido = new JCheckBox("Dirigido");
		chckbxDirigido.setBounds(10, 7, 97, 23);
		chckbxDirigido.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (chckbxDirigido.isSelected()) {
					label.setVisible(true);
				}else{
					label.setVisible(false);
				}
			}
		});
		contentPane.add(chckbxDirigido);
		
		JLabel lblAresta = new JLabel("Aresta:");
		lblAresta.setBounds(10, 99, 46, 14);
		contentPane.add(lblAresta);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 123, 68, 20);
		comboBox.addItem("");
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(124, 123, 68, 20);
		comboBox_1.addItem("");
		contentPane.add(comboBox_1);
		
		label = new JLabel("");
		label.setBounds(91, 126, 32, 14);
		label.setText("--->");
		label.setVisible(false);
		contentPane.add(label);
		
		JButton btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aresta aresta = new Aresta(comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString());
				grafo.getArestas().add(aresta);

				textArea_1.setText("V = {");
				for (int i = 0; i < grafo.getArestas().size(); i++) {
					String valor = "("+ grafo.getArestas().get(i).getPontoA()+","+grafo.getArestas().get(i).getPontoB()+")";
					if (i+1 == grafo.getArestas().size()) {
						textArea_1.setText(textArea_1.getText() +valor);
					}else{
						textArea_1.setText(textArea_1.getText() +valor+ ",");
					}
				}
				textArea_1.setText(textArea_1.getText() + "}");
			}
		});
		btnAdicionar_1.setBounds(213, 122, 89, 23);
		contentPane.add(btnAdicionar_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(323, 118, 362, 73);
		textArea_1.setLineWrap(true);
		contentPane.add(textArea_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 218, 675, 2);
		contentPane.add(separator);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(10, 231, 68, 14);
		contentPane.add(lblResultado);
		
		txtrestaPrntandoNo = new JTextArea();
		txtrestaPrntandoNo.setText("********ESTA PRNTANDO NO CONSOLE***********\r\n");
		txtrestaPrntandoNo.setBounds(10, 249, 675, 183);
		contentPane.add(txtrestaPrntandoNo);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafo.setDirigido(chckbxDirigido.isSelected());
				Representacoes representacoes = Processador.processaGrafo(grafo);
				printaListaAdjacencia(representacoes);
				printaMatrizAdjacencia(representacoes);
				printaMatrizIncidencia(representacoes);
				printaListasDeArestas(representacoes);
				printaCentroGrafo(representacoes);
			}



		});
		btnGerar.setBounds(10, 189, 89, 23);
		contentPane.add(btnGerar);
	}
	private void printaMatrizAdjacencia(Representacoes representacoes) {
		System.out.println("matriz de adjacencia:");
		for (int i = 0; i < representacoes.getMatrizDeAdjacencia().length; i++) {
			String linha = "";
			for (int j = 0; j < representacoes.getMatrizDeAdjacencia()[i].length; j++) {
				linha += " "+ representacoes.getMatrizDeAdjacencia()[i][j];
			}
			System.out.println(linha);
			System.out.println("-------------------------------------------------------------");
		}
		System.out.println();
	}
	private void printaListaAdjacencia(Representacoes representacoes) {
		System.out.println("lista de adjacencia: ");
		for (Entry<String, ArrayList<String>> listaDeAdjacencia : representacoes.getListasDeAdjacencia().entrySet()) {
			String linha = listaDeAdjacencia.getKey() + " --> ";
			for (String destino : listaDeAdjacencia.getValue()) {
				linha += destino +" , ";
			}
			System.out.println(linha);
		}
		System.out.println();
	}
	
	private void printaListasDeArestas(Representacoes representacoes) {
		System.out.println("Listas de arestas:");
		for (ArrayList<String> listasDeArestas : representacoes.getListasDeArestas()) {
			String linha = "";
			for (String aresta : listasDeArestas) {
				linha+= " " + aresta;
			}
			System.out.println(linha);
		}
		System.out.println();
	}

	private void printaMatrizIncidencia(Representacoes representacoes) {
		
		System.out.println("Matriz de incidencia:");
		for (int i = 0; i < representacoes.getMatrizDeIncidencia().length; i++) {
			String linha = "";
			for (int j = 0; j < representacoes.getMatrizDeIncidencia()[i].length; j++) {
				linha += " "+ representacoes.getMatrizDeIncidencia()[i][j];
			}
			System.out.println(linha);
			System.out.println("-------------------------------------------------------------");
		}
		
		System.out.println();
	}
	
	private void printaCentroGrafo(Representacoes representacoes) {
		
		System.out.println("Centros do Grafo:");
		String linha = "";
		for (String centros : representacoes.getCentroGrafo()) {
			linha+= centros+", ";
		}
		System.out.println(linha);
		System.out.println("-------------------------------------------------------------");
		System.out.println();
	}


}
