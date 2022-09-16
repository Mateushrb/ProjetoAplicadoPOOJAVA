package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import Controller.PartidoController;
import Model.Partido;
import view.tables.PartidoTableModel;

public class ConsultaPartidosUI extends JInternalFrame {
	private JTable jtPartidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPartidosUI frame = new ConsultaPartidosUI();
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
	public ConsultaPartidosUI() {
		setTitle("Consulta de Partidos");
		setClosable(true);
		setBounds(100, 100, 679, 396);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnAtualizar = new JButton("Atualizar Dados");
		btnAtualizar.setIcon(new ImageIcon(getClass().getResource(".../../../atualizar.png").getPath()));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtPartidos.setModel(new PartidoTableModel(new PartidoController().listar()));
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(getClass().getResource(".../../../excluir.png").getPath()));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partido partido = new PartidoTableModel(new PartidoController().listar()).get(jtPartidos.getSelectedRow());
				try {
					new PartidoController().excluir(partido.getIdPartido());
					JOptionPane.showMessageDialog(null, "Partido excluido com sucesso!");
					jtPartidos.setModel(new PartidoTableModel(new PartidoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir partido!");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(getClass().getResource(".../../../editar.png").getPath()));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partido partido = new PartidoTableModel(new PartidoController().listar()).get(jtPartidos.getSelectedRow());
				CadastroPartidosUI cadPartidoUI = new CadastroPartidosUI();
				cadPartidoUI.setPartidoEdicao(partido);
				cadPartidoUI.setVisible(true);
				getParent().add(cadPartidoUI, 0);
			}
		});
		
		JButton btnCancelar = new JButton("Fechar");
		btnCancelar.setIcon(new ImageIcon(getClass().getResource(".../../../fechar.png").getPath()));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAtualizar)
							.addGap(18)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		
		jtPartidos = new JTable();
		jtPartidos.setModel(new PartidoTableModel(new PartidoController().listar()));
		scrollPane.setViewportView(jtPartidos);
		getContentPane().setLayout(groupLayout);
		

	}
}
