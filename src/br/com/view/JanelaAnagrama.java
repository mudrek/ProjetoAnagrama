package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.constantes.ViewContantes;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class JanelaAnagrama extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Vector<String> palavrasEncontradas;
	private JTextField textField_1;

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

		textField = new JTextField();
		textField.setBounds(12, 72, 463, 29);
		panel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		final JList list = new JList(); // ANALISAR
		list.setListData(palavrasEncontradas);
		list.setBounds(23, 197, 613, 183);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(12, 197, 624, 183);
		panel.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Arquivo para busca de anagramas");
		lblNewLabel.setBounds(25, 51, 263, 15);
		panel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(14, 134, 463, 29);
		panel.add(textField_1);

		JLabel lblArquivoDicionrio = new JLabel("Arquivo dicionário");
		lblArquivoDicionrio.setBounds(27, 113, 263, 15);
		panel.add(lblArquivoDicionrio);

		JButton button = new JButton("Escolher arquivo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser palavras = new JFileChooser();
				palavras.setBounds(25, 25, 100, 100);
				palavras.setDialogTitle(ViewContantes.TITULO_CHOOSER_ENTRADA);
				int retorno = palavras.showOpenDialog(contentPane);
				if (retorno == JFileChooser.APPROVE_OPTION) {
					File arquivoSelecionado = palavras.getSelectedFile();
					textField_1.setText(arquivoSelecionado.getPath());
					try (BufferedReader reader = new BufferedReader(new FileReader(arquivoSelecionado));) {
						palavrasEncontradas = new Vector<>();
						String linha;
						while ((linha = reader.readLine()) != null) {
							palavrasEncontradas.add(linha);
							list.setListData(palavrasEncontradas);
						}
						//Adiciona no modelo
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		button.setBounds(489, 136, 147, 25);
		panel.add(button);

		JButton btnNewButton = new JButton(ViewContantes.TITULO_BUTTON_ARQUIVO);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser palavras = new JFileChooser();
				palavras.setBounds(25, 25, 100, 100);
				palavras.setDialogTitle(ViewContantes.TITULO_CHOOSER_ENTRADA);
				int retorno = palavras.showOpenDialog(contentPane);
				if (retorno == JFileChooser.APPROVE_OPTION) {
					File arquivoSelecionado = palavras.getSelectedFile();
					textField.setText(arquivoSelecionado.getPath());
					try (BufferedReader reader = new BufferedReader(new FileReader(arquivoSelecionado));) {
						palavrasEncontradas = new Vector<>();
						String linha;
						while ((linha = reader.readLine()) != null) {
							palavrasEncontradas.add(linha);
							list.setListData(palavrasEncontradas);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//				palavras.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				String[] extension = new String[1];
//				extension[0] = ".java";
//				FileNameExtensionFilter file = new FileNameExtensionFilter("Arquivo txt", extension);
//				palavras.setFileFilter(file);
			}
		});
		btnNewButton.setBounds(487, 74, 147, 25);
		panel.add(btnNewButton);

	}
}
