package av1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Button;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class GUIFuncionario {

	private JFrame frmCadastroFuncionario;
	private JTextField nome;
	private JTextField dataNascimento;
	private JTextField cpf;
	private JTextField matricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFuncionario window = new GUIFuncionario();
					window.frmCadastroFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JRadioButton masculino = new JRadioButton("M");;
		frmCadastroFuncionario = new JFrame();
		frmCadastroFuncionario.setTitle("Cadastro Funcion\u00E1rio");
		frmCadastroFuncionario.setBounds(100, 100, 592, 216);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				Date date;
				try {
					SEXO sexo;
					date = dateFormat.parse(dataNascimento.getText());
					if (masculino.isSelected()) {
						sexo = SEXO.Masculino;
					} else {
						sexo = SEXO.Feminino;
					}
					Pessoa pessoa = new Funcionario(0, nome.getText(), date, cpf.getText(), sexo );
					if (pessoaDAO != null) {				
						pessoaDAO.criar(pessoa);
					}					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Recuperar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_3 = new JButton("Deletar");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		
		JLabel lblNewLabel = new JLabel("CPF:");
		
		JLabel lblSexo = new JLabel("Sexo:");
		
		nome = new JTextField();
		nome.setColumns(10);
		
		dataNascimento = new JTextField();
		dataNascimento.setColumns(10);
		
		cpf = new JTextField();
		cpf.setColumns(10);	
		
		
		JRadioButton feminino = new JRadioButton("F");
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		
		matricula = new JTextField();
		matricula.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmCadastroFuncionario.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nome, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNome, Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblSexo)
												.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(masculino)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(feminino)
												.addGap(62)))
										.addGap(1)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblMatrcula)
												.addGap(39))
											.addComponent(matricula, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(lblDataNascimento)
									.addGap(41)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cpf, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(lblNewLabel)))
								.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addGap(17))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_3)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNome)
								.addComponent(lblDataNascimento))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(lblMatrcula))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(masculino)
								.addComponent(feminino)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(matricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(20))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3});
		frmCadastroFuncionario.getContentPane().setLayout(groupLayout);
	}
}
