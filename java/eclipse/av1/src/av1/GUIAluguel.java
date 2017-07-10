package av1;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Cursor;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class GUIAluguel {

	private JFrame frmCadastroAluguel;
	private JTextField dataPedido;
	
	private JTextField dataEntrega;
	private JTextField dataDevolucao;
	private JTextField valorTotal;
	JList<String> motoristas;
	DefaultListModel<String> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAluguel window = new GUIAluguel();					
					window.frmCadastroAluguel.setVisible(true);					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIAluguel() {
		addMotoristas();
		initialize();		
	}
	
	JFrame GetFrameAluguel() {
		return frmCadastroAluguel;
	}
	
	public void addMotoristas() {		
		try {
			MotoristaDAO motoristaDAO = new MotoristaDAO();
			ArrayList<Motorista> motoristaList = motoristaDAO.recuperarTodos();
			if (motoristaList != null) {				
				PessoaDAO pessoaDAO = new PessoaDAO();
				model = new DefaultListModel<String>();
				for (Motorista motorista : motoristaList) {
					
					Pessoa pessoa = new Motorista(motorista.getId(), null, null, null, null, null);
					if (pessoaDAO.recuperar(pessoa) == true) {
						model.addElement(pessoa.getNome());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Clean fields from GUI.
	 */	
	public void cleanFields() {
		dataDevolucao.setText("");
		dataEntrega.setText("");
		dataPedido.setText("");
		valorTotal.setText("");
		motoristas.setSelectedIndex(0);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroAluguel = new JFrame();
		frmCadastroAluguel.setResizable(false);
		frmCadastroAluguel.setTitle("Cadastro Aluguel");
		frmCadastroAluguel.setBounds(100, 100, 551, 214);
		JPanel panel;
		
		JLabel lblMotorista = new JLabel("Motorista:");
		
		JButton criar = new JButton("Criar");
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = motoristas.getSelectedValue();
				PessoaDAO pessoaDAO = new PessoaDAO();
				if (pessoaDAO != null) {
					Pessoa motorista = new Motorista(0, nome, null, null, null, null);
					if (pessoaDAO.recuperarPeloNome(motorista) == true) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date dtPedido, dtEntrega, dtDeVolucao;
						try {
							dtPedido = dateFormat.parse(dataPedido.getText());
							dtEntrega = dateFormat.parse(dataEntrega.getText());
							dtDeVolucao = dateFormat.parse(dataDevolucao.getText());
							BigDecimal vlTotal = new BigDecimal(valorTotal.getText());
							Aluguel aluguel = new Aluguel(motorista.getId(),dtPedido, dtEntrega, dtDeVolucao, vlTotal);						
							if (aluguel != null) {
								AluguelDAO aluguelDAO = new AluguelDAO();
								if (aluguelDAO.criar(aluguel) == true) {
									cleanFields();
								}							
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					}
				}				
				
			}
		});
		
		
		JButton recuperar = new JButton("Recuperar");
		recuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TO DO.
			}
		});
		
		JButton atualizar = new JButton("Atualizar");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TO DO.
			}
		});
		
		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TO DO.
			}
		});
		
		JLabel lblDataPedido = new JLabel("Data Pedido:");
		
		JLabel lblDataEntrega = new JLabel("Data Entrega:");
		
		JLabel lblDataDevolucao = new JLabel("Data Devolu\u00E7\u00E3o:");
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		
		dataPedido = new JTextField();
		dataPedido.setColumns(10);
		
		dataEntrega = new JTextField();
		dataEntrega.setColumns(10);
		
		dataDevolucao = new JTextField();
		dataDevolucao.setColumns(10);
		
		valorTotal = new JTextField();
		valorTotal.setColumns(10);
		
		motoristas = new JList<String>(model);
		motoristas.setIgnoreRepaint(true);
		motoristas.setMinimumSize(new Dimension(6, 20));
		motoristas.setPreferredSize(new Dimension(6, 20));
		motoristas.setBorder(UIManager.getBorder("TextField.border"));
		motoristas.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		motoristas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		motoristas.setSelectedIndex(0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setView(motoristas);
		panel = new JPanel();
		panel.add(scrollPane);
	
		frmCadastroAluguel.setContentPane(panel);
		
		GUITextComponentLimit.addTo(dataPedido, 10);
		GUITextComponentLimit.addTo(dataDevolucao, 10);
		GUITextComponentLimit.addTo(dataEntrega, 10);
		GUITextComponentLimit.addTo(valorTotal, 12);
		
		GroupLayout groupLayout = new GroupLayout(frmCadastroAluguel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(motoristas, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dataPedido, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(dataEntrega, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblMotorista)
										.addGap(163))
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(lblDataPedido)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblDataEntrega)
										.addGap(18))))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataDevolucao)
								.addComponent(dataDevolucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addComponent(lblValorTotal))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(valorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(criar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(recuperar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(atualizar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deletar)))
					.addGap(171))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMotorista)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(motoristas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataPedido)
						.addComponent(lblDataEntrega)
						.addComponent(lblDataDevolucao)
						.addComponent(lblValorTotal))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(dataPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dataEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dataDevolucao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(valorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(recuperar)
						.addComponent(criar)
						.addComponent(atualizar)
						.addComponent(deletar))
					.addGap(17))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {criar, recuperar, atualizar, deletar});
		frmCadastroAluguel.getContentPane().setLayout(groupLayout);
		frmCadastroAluguel.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{motoristas, dataPedido, dataEntrega, dataDevolucao, valorTotal, criar, recuperar, atualizar, deletar}));
		frmCadastroAluguel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{motoristas, dataPedido, dataEntrega, dataDevolucao, valorTotal, criar, recuperar, atualizar, deletar}));
	}
}
