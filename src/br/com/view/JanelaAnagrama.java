package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.anagramas.AnagramModel;
import br.com.constantes.ViewContantes;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class JanelaAnagrama extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pathFileList;
	private Vector<String> palavrasEncontradas;
	private JTextField pathFileDic;
	private AnagramModel modelo;
	private File fileFrases;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAnagrama frame = new JanelaAnagrama();
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
	public JanelaAnagrama() {
		fileFrases = null;
		modelo = new AnagramModel();

		palavrasEncontradas = new Vector<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 663, 392);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAnagramas = new JLabel(ViewContantes.CABECALHO_JANELA);
		lblAnagramas.setBounds(223, 0, 217, 36);
		panel.add(lblAnagramas);
		lblAnagramas.setFont(new Font("Dialog", Font.BOLD, 30));

		pathFileList = new JTextField();
		pathFileList.setBounds(12, 72, 463, 29);
		panel.add(pathFileList);
		pathFileList.setColumns(10);
		pathFileList.setEditable(false);

		final JList listaEncontrados = new JList(); // ANALISAR
		listaEncontrados.setListData(palavrasEncontradas);
		listaEncontrados.setBounds(23, 197, 613, 183);

		JScrollPane scrollPane = new JScrollPane(listaEncontrados);
		scrollPane.setBounds(12, 197, 463, 183);
		panel.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Arquivo para busca de anagramas");
		lblNewLabel.setBounds(25, 51, 263, 15);
		panel.add(lblNewLabel);

		pathFileDic = new JTextField();
		pathFileDic.setEditable(false);
		pathFileDic.setColumns(10);
		pathFileDic.setBounds(14, 134, 463, 29);
		panel.add(pathFileDic);

		JLabel lblArquivoDicionrio = new JLabel("Arquivo dicionário");
		lblArquivoDicionrio.setBounds(27, 113, 263, 15);
		panel.add(lblArquivoDicionrio);

		JButton buttonFile1 = new JButton("Escolher arquivo");
		buttonFile1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser palavras = new JFileChooser();
				palavras.setBounds(25, 25, 100, 100);
				palavras.setDialogTitle(ViewContantes.TITULO_CHOOSER_ENTRADA);
				int retorno = palavras.showOpenDialog(contentPane);
				if (retorno == JFileChooser.APPROVE_OPTION) {
					fileFrases = palavras.getSelectedFile();

				}
			}
		});
		buttonFile1.setBounds(489, 74, 147, 25);
		panel.add(buttonFile1);

		JButton buttonFile2 = new JButton("Escolher arquivo");
		buttonFile2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser palavras = new JFileChooser();
				palavras.setBounds(25, 25, 100, 100);
				palavras.setDialogTitle(ViewContantes.TITULO_CHOOSER_ENTRADA);
				int retorno = palavras.showOpenDialog(contentPane);
				if (retorno == JFileChooser.APPROVE_OPTION) {
					File arquivoSelecionado = palavras.getSelectedFile();
					pathFileDic.setText(arquivoSelecionado.getPath());
					try (BufferedReader reader = new BufferedReader(new FileReader(arquivoSelecionado));) {
						String linha;
						List<String> frasesDic = new ArrayList<>();
						while ((linha = reader.readLine()) != null) {
							frasesDic.add(linha);
						}
						modelo.setWords(frasesDic.iterator());
						// Adiciona no modelo
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		buttonFile2.setBounds(489, 136, 147, 25);
		panel.add(buttonFile2);
		
		JButton btnBuscarAnagramas = new JButton("Buscar anagramas");
		btnBuscarAnagramas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fileFrases != null) {
					
				}
			}
		});
		btnBuscarAnagramas.setBounds(487, 262, 164, 25);
		panel.add(btnBuscarAnagramas);
	}
}
