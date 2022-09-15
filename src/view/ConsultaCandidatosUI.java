package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.CandidatoController;
import Model.Candidato;
import view.tables.CandidatoTableModel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class ConsultaCandidatosUI extends JInternalFrame {
	private JTable jtCandidatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCandidatosUI frame = new ConsultaCandidatosUI();
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
	public ConsultaCandidatosUI() {
		getContentPane().setBackground(SystemColor.control);
		setClosable(true);
		setTitle("Consulta de Candidatos");
		setBounds(100, 100, 631, 270);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\devbarbosa\\Downloads\\erro.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidatos.getSelectedRow());
				try {
					new CandidatoController().excluir(candidato.getIdCandidato());
					JOptionPane.showMessageDialog(null, "Candidato excluido com sucesso!");
					jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir candidato!");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\devbarbosa\\Downloads\\editar.png"));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidatos.getSelectedRow());
				CadastroCandidatosUI cadCandidatoUI = new CadastroCandidatosUI();
				cadCandidatoUI.setCandidatoEdicao(candidato);
				cadCandidatoUI.setVisible(true);
				getParent().add(cadCandidatoUI, 0);
			}
		});
		
		JButton btnCancelar = new JButton("Fechar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\devbarbosa\\Downloads\\excluir.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnAtualizar = new JButton("Atualizar Dados");
		btnAtualizar.setIcon(new ImageIcon("C:\\Users\\devbarbosa\\Downloads\\atualizar.png"));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAtualizar)
							.addGap(18)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAtualizar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar))
					.addGap(25))
		);
		
		jtCandidatos = new JTable();
		jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
		scrollPane.setViewportView(jtCandidatos);
		getContentPane().setLayout(groupLayout);

	}
}
