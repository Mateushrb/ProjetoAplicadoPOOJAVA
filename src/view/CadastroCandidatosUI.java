package view;

import java.awt.Color;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Controller.CandidatoController;
import Model.Candidato;
import Model.Partido;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class CadastroCandidatosUI extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtFichaLimpa;
	private JTextField txtIdCandidato;
	private JTextField txtIdPartido;
	private Candidato candidato;

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
		getContentPane().setBackground(SystemColor.control);
		setClosable(true);
		setTitle("Cadastro de Candidatos");
		setBounds(100, 100, 450, 240);
		
		JPanel jpCadastroCandidatos = new JPanel();
		jpCadastroCandidatos.setBackground(SystemColor.control);
		jpCadastroCandidatos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Candidato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnCancelar = new JButton("Fechar");
		btnCancelar.setIcon(new ImageIcon(getClass().getResource(".../../../fechar.png").getPath()));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(getClass().getResource("../.../../salvar.png").getPath()));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (candidato != null && candidato.getIdCandidato() > 0) {
						candidato.getPartido().setIdPartido(Integer.parseInt(txtIdPartido.getText()));
						candidato.setIdCandidato(Integer.parseInt(txtIdCandidato.getText()));
						candidato.setNome(txtNome.getText());
						candidato.setFichaLimpa(txtFichaLimpa.getText());
						new CandidatoController().atualizar(candidato);
						JOptionPane.showMessageDialog(null, "Candidato atualizado com sucesso!");
					} else {
						Candidato candidato = new Candidato();
						Partido partido = new Partido();
						partido.setIdPartido(Integer.parseInt(txtIdPartido.getText()));
						candidato.setPartido(partido);
						candidato.setIdCandidato(Integer.parseInt(txtIdCandidato.getText()));
						candidato.setNome(txtNome.getText());
						candidato.setFichaLimpa(txtFichaLimpa.getText());
						
						new CandidatoController().salvar(candidato);
						JOptionPane.showMessageDialog(null, "Candidato salvo com sucesso!");
					}
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar candidato!");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpCadastroCandidatos, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroCandidatos, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		JLabel jlNomeCandidato = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel jlFichaLimpa = new JLabel("Ficha limpa:");
		
		txtFichaLimpa = new JTextField();
		txtFichaLimpa.setColumns(10);
		
		JLabel jlIdCandidato = new JLabel("ID:");
		
		txtIdCandidato = new JTextField();
		txtIdCandidato.setColumns(10);
		
		JLabel jlIdPartido = new JLabel("ID partido:");
		
		txtIdPartido = new JTextField();
		txtIdPartido.setColumns(10);
		GroupLayout gl_jpCadastroCandidatos = new GroupLayout(jpCadastroCandidatos);
		gl_jpCadastroCandidatos.setHorizontalGroup(
			gl_jpCadastroCandidatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
							.addComponent(jlIdCandidato)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtIdCandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
								.addComponent(jlFichaLimpa)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtFichaLimpa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jlIdPartido)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtIdPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_jpCadastroCandidatos.createSequentialGroup()
								.addComponent(jlNomeCandidato)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_jpCadastroCandidatos.setVerticalGroup(
			gl_jpCadastroCandidatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdCandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlIdCandidato))
					.addGap(18)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlNomeCandidato))
					.addGap(18)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFichaLimpa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlFichaLimpa)
						.addComponent(txtIdPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlIdPartido))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		jpCadastroCandidatos.setLayout(gl_jpCadastroCandidatos);
		getContentPane().setLayout(groupLayout);

	}
	
	public void setCandidatoEdicao(Candidato candidato) {
		this.candidato = candidato;
		preencheFormulario();
	}
	
	private void preencheFormulario() {
		if (candidato != null) {
			txtIdCandidato.setText(Integer.toString(candidato.getIdCandidato()));
			txtNome.setText(candidato.getNome());
			txtFichaLimpa.setText(candidato.getFichaLimpa());
			txtIdPartido.setText(Integer.toString(candidato.getPartido().getIdPartido()));
		}
	}
}
