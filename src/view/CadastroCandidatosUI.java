package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import Controller.CandidatoController;
import Model.Candidato;

public class CadastroCandidatosUI extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtFichaLimpa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCandidatosUI frame = new CadastroCandidatosUI();
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
	public CadastroCandidatosUI() {
		setClosable(true);
		setTitle("Cadastro de Candidatos");
		setBounds(100, 100, 450, 204);
		
		JPanel jpCadastroProdutos = new JPanel();
		jpCadastroProdutos.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Candidato candidato = new Candidato();
					candidato.setNome(txtNome.getText());
					candidato.setFichaLimpa(txtFichaLimpa.getText());
					
					new CandidatoController().salvar(candidato);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,  "Erro ao salvar candidato");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpCadastroProdutos, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroProdutos, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel jlNome = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel jlFichaLimpa = new JLabel("Ficha limpa:");
		
		txtFichaLimpa = new JTextField();
		txtFichaLimpa.setColumns(10);
		GroupLayout gl_jpCadastroProdutos = new GroupLayout(jpCadastroProdutos);
		gl_jpCadastroProdutos.setHorizontalGroup(
			gl_jpCadastroProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroProdutos.createSequentialGroup()
					.addGroup(gl_jpCadastroProdutos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroProdutos.createSequentialGroup()
							.addComponent(jlNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroProdutos.createSequentialGroup()
							.addComponent(jlFichaLimpa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFichaLimpa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_jpCadastroProdutos.setVerticalGroup(
			gl_jpCadastroProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroProdutos.createSequentialGroup()
					.addGroup(gl_jpCadastroProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlFichaLimpa)
						.addComponent(txtFichaLimpa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		jpCadastroProdutos.setLayout(gl_jpCadastroProdutos);
		getContentPane().setLayout(groupLayout);

	}
}
