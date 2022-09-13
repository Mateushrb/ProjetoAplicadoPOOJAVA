package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Pesquisa Eleitoral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 569);
		
		JMenuBar jbPrincipal = new JMenuBar();
		setJMenuBar(jbPrincipal);
		
		JMenu jmCadastros = new JMenu("Cadastros");
		jbPrincipal.add(jmCadastros);
		
		JMenuItem jmiCandidatos = new JMenuItem("Candidatos");
		jmiCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CadastroCandidatosUI cadProduto = new CadastroCandidatosUI();
			cadProduto.setVisible(true);
			contentPane.add(cadProduto, 0);
			}
		});
		jmCadastros.add(jmiCandidatos);
		
		JMenuItem jmiPartidos = new JMenuItem("Partidos");
		jmCadastros.add(jmiPartidos);
		
		JMenuItem jmiPesquisa = new JMenuItem("Pesquisa");
		jmCadastros.add(jmiPesquisa);
		
		JMenu jmConsultas = new JMenu("Consultas");
		jbPrincipal.add(jmConsultas);
		
		JMenuItem jmiConsultaCandidatos = new JMenuItem("Candidatos");
		jmConsultas.add(jmiConsultaCandidatos);
		
		JMenuItem jmiConsultaPartidos = new JMenuItem("Partidos");
		jmConsultas.add(jmiConsultaPartidos);
		
		JMenuItem jmiCandidatoXPesquisa = new JMenuItem("Candidato/Pesquisa");
		jmConsultas.add(jmiCandidatoXPesquisa);
		
		JMenu jmPesquisa = new JMenu("Pesquisas");
		jbPrincipal.add(jmPesquisa);
		
		JMenuItem jmiRegistrarPesquisas = new JMenuItem("Registrar Pesquisas");
		jmPesquisa.add(jmiRegistrarPesquisas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
