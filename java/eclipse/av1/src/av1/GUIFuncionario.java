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
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class GUIFuncionario {

	private JFrame frmCadastroFuncionario;
	private JTextField nome;
	private JTextField dataNascimento;
	private JTextField cpf;
	private JTextField matricula;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton masculino = null;
	JRadioButton feminino = null;

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
	 * Clean fields from GUI.
	 */
	
	public void cleanFields() {
		matricula.setText("");
		nome.setText("");
		dataNascimento.setText("");
		masculino.setSelected(false);
		feminino.setSelected(false);
		cpf.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		masculino = new JRadioButton("M");
		buttonGroup.add(masculino);;
		frmCadastroFuncionario = new JFrame();
		frmCadastroFuncionario.setResizable(false);
		frmCadastroFuncionario.setTitle("Cadastro Funcion\u00E1rio");
		frmCadastroFuncionario.setBounds(100, 100, 561, 216);
		
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
					Pessoa pessoa = new Funcionario(0, nome.getText(), date, cpf.getText(), sexo, matricula.getText() );
					if (pessoaDAO != null) {				
						if (pessoaDAO.criar(pessoa) == true) {
							cleanFields();
						}
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
				try {
					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();					
					if (funcionarioDAO != null) {
						Funcionario funcionario = new Funcionario(0, null, null, null, null, matricula.getText());
						if (funcionarioDAO.recuperar(funcionario) == true) {
							System.out.println("Funcionario encontrado!");
							System.out.println("Id="+funcionario.getId());
						} else {
							System.out.println("Funcionario nao encontrado!");
						}
					}					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		
		
		feminino = new JRadioButton("F");
		buttonGroup.add(feminino);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		
		matricula = new JTextField();
		matricula.setColumns(10);
		
		GUITextComponentLimit.addTo(matricula, 15);
		GUITextComponentLimit.addTo(nome, 50);
		GUITextComponentLimit.addTo(dataNascimento, 10);
		GUITextComponentLimit.addTo(cpf, 11);
		
		GroupLayout groupLayout = new GroupLayout(frmCadastroFuncionario.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatrcula)
						.addComponent(matricula, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSexo)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(masculino)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(feminino)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataNascimento)
						.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(178, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatrcula)
						.addComponent(lblNome)
						.addComponent(lblDataNascimento))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(matricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSexo)
						.addComponent(lblNewLabel))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(masculino)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(feminino))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(30))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3});
		frmCadastroFuncionario.getContentPane().setLayout(groupLayout);
		frmCadastroFuncionario.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmCadastroFuncionario.getContentPane(), lblMatrcula, matricula, lblNome, nome, lblDataNascimento, dataNascimento, lblSexo, masculino, feminino, lblNewLabel, cpf, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3}));
	}
}
