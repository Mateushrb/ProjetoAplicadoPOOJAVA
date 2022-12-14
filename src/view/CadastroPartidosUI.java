package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import Controller.PartidoController;
import Model.Partido;

public class CadastroPartidosUI extends JInternalFrame {
	private JTextField txtSiglaPartido;
	private JTextField txtNomePartido;
	private JTextField txtIdPartido;
	private Partido partido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPartidosUI frame = new CadastroPartidosUI();
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
	public CadastroPartidosUI() {
		getContentPane().setBackground(SystemColor.control);
		setClosable(true);
		setTitle("Cadastro de partidos");
		setBounds(100, 100, 450, 222);
		
		JPanel jpCadastroPartidos = new JPanel();
		jpCadastroPartidos.setBackground(SystemColor.control);
		jpCadastroPartidos.setBorder(new TitledBorder(null, "Partido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnCancelar = new JButton("Fechar");
		btnCancelar.setIcon(new ImageIcon(getClass().getResource("../.../../fechar.png").getPath()));
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
					if (partido != null && partido.getIdPartido() > 0) {
						partido.setIdPartido(Integer.parseInt(txtIdPartido.getText()));
						partido.setSigla(txtSiglaPartido.getText());
						partido.setNomePartido(txtNomePartido.getText());
						new PartidoController().atualizar(partido);
						JOptionPane.showMessageDialog(null, "Partido atualizado com sucesso!");
						
					} else {
						Partido partido = new Partido();
						partido.setIdPartido(Integer.parseInt(txtIdPartido.getText()));
						partido.setSigla(txtSiglaPartido.getText());
						partido.setNomePartido(txtNomePartido.getText());
						
						new PartidoController().salvar(partido);
						JOptionPane.showMessageDialog(null, "Partido salvo com sucesso!");
					}
					dispose();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar partido!");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpCadastroPartidos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroPartidos, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap())
		);
		
		JLabel jlSiglaPartido = new JLabel("Sigla:");
		
		txtSiglaPartido = new JTextField();
		txtSiglaPartido.setColumns(10);
		
		JLabel jlNomePartido = new JLabel("Nome:");
		
		txtNomePartido = new JTextField();
		txtNomePartido.setColumns(10);
		
		JLabel jlIdPartido = new JLabel("ID partido");
		
		txtIdPartido = new JTextField();
		txtIdPartido.setColumns(10);
		GroupLayout gl_jpCadastroPartidos = new GroupLayout(jpCadastroPartidos);
		gl_jpCadastroPartidos.setHorizontalGroup(
			gl_jpCadastroPartidos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroPartidos.createSequentialGroup()
					.addGroup(gl_jpCadastroPartidos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroPartidos.createSequentialGroup()
							.addGap(8)
							.addComponent(jlIdPartido)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(jlSiglaPartido)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSiglaPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroPartidos.createSequentialGroup()
							.addContainerGap()
							.addComponent(jlNomePartido)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomePartido, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_jpCadastroPartidos.setVerticalGroup(
			gl_jpCadastroPartidos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroPartidos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroPartidos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlSiglaPartido)
						.addComponent(txtSiglaPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlIdPartido)
						.addComponent(txtIdPartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroPartidos.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomePartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlNomePartido))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		jpCadastroPartidos.setLayout(gl_jpCadastroPartidos);
		getContentPane().setLayout(groupLayout);

	}
	
	public void setPartidoEdicao(Partido partido) {
		this.partido = partido;
		preencheFormulario();
	}
	
	private void preencheFormulario() {
		if (partido != null) {
			txtIdPartido.setText(Integer.toString(partido.getIdPartido()));
			txtSiglaPartido.setText(partido.getSigla());
			txtNomePartido.setText(partido.getNomePartido());
		}
	}
}
