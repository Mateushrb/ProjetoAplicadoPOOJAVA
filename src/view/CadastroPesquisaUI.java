package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.PesquisaController;
import Model.Pesquisa;

public class CadastroPesquisaUI extends JInternalFrame {
	private JTextField txtIdPesquisa;
	private JTextField txtInstitutoPesquisa;
	private JTextField txtDataPesquisa;
	private JTextField txtMediaIdade;
	private JTextField txtIdUf;
	private JTextField txtIdTipoPesquisa;
	private JTextField txtIdTipo;
	private JTextField txtIdFormato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPesquisaUI frame = new CadastroPesquisaUI();
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
	public CadastroPesquisaUI() {
		setClosable(true);
		setBounds(100, 100, 670, 226);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pesquisa pesquisa = new Pesquisa();
					pesquisa.setIdPesquisa(Integer.parseInt(txtIdPesquisa.getText()));
					pesquisa.setInstitutoPesquisa(txtInstitutoPesquisa.getText());
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate ld = LocalDate.parse(txtDataPesquisa.getText(), formatter);
					pesquisa.setDatetime(ld);
					
					pesquisa.setMediaIdade(Integer.parseInt(txtMediaIdade.getText()));
					pesquisa.setUf(Integer.parseInt(txtIdUf.getText()));
					pesquisa.setTipopesquisa(Integer.parseInt(txtIdTipoPesquisa.getText()));
					pesquisa.setTipo(Integer.parseInt(txtIdTipo.getText()));
					pesquisa.setFormato(Integer.parseInt(txtIdFormato.getText()));
					
					new PesquisaController().registrarPesquisa(pesquisa);
					JOptionPane.showMessageDialog(null, "Pesquisa salva com sucesso!");
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar pesquisa!");
					System.out.println(ex);
				}
			}
		});
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancelar)
							.addGap(22))
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
					.addGap(54))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		
		JLabel jlIdPesquisa = new JLabel("ID Pesquisa:");
		
		txtIdPesquisa = new JTextField();
		txtIdPesquisa.setColumns(10);
		
		txtInstitutoPesquisa = new JTextField();
		txtInstitutoPesquisa.setColumns(10);
		
		JLabel lbInstitutoPesquisa = new JLabel("Instituto:");
		
		JLabel jlDataPesquisa = new JLabel("Data:");
		
		txtDataPesquisa = new JTextField();
		txtDataPesquisa.setColumns(10);
		
		JLabel jlMediaIdade = new JLabel("Média Idade:");
		
		txtMediaIdade = new JTextField();
		txtMediaIdade.setColumns(10);
		
		JLabel jlIdUf = new JLabel("ID UF:");
		
		txtIdUf = new JTextField();
		txtIdUf.setColumns(10);
		
		JLabel jbIdTipoPesquisa = new JLabel("ID Tipo Pesquisa:");
		
		txtIdTipoPesquisa = new JTextField();
		txtIdTipoPesquisa.setColumns(10);
		
		JLabel jlIdTipo = new JLabel("ID Tipo:");
		
		txtIdTipo = new JTextField();
		txtIdTipo.setColumns(10);
		
		JLabel jlIdFormato = new JLabel("ID Formato:");
		
		txtIdFormato = new JTextField();
		txtIdFormato.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(jlIdPesquisa)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtIdPesquisa, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lbInstitutoPesquisa)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtInstitutoPesquisa, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(jlDataPesquisa)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDataPesquisa, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(jlMediaIdade)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtMediaIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(jlIdUf)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtIdUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(jbIdTipoPesquisa)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtIdTipoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jlIdTipo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jlIdFormato)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdFormato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlIdPesquisa)
						.addComponent(txtIdPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbInstitutoPesquisa)
						.addComponent(txtInstitutoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlDataPesquisa)
						.addComponent(txtDataPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlMediaIdade)
						.addComponent(txtMediaIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlIdUf)
						.addComponent(txtIdUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbIdTipoPesquisa)
						.addComponent(txtIdTipoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlIdTipo)
						.addComponent(txtIdTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlIdFormato)
						.addComponent(txtIdFormato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
