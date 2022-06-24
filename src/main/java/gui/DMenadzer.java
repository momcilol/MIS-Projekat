package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.MeniCrud;
import model.Menadzer;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;

public class DMenadzer extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4751356407331544888L;
	private final JPanel contentPanel = new JPanel();

	static MeniCrud mc = new MeniCrud();
	JDialog ovaj = this;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DMenadzer dialog = new DMenadzer(mc.listaMenadzera().get(0), new JFrame());
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DMenadzer(Menadzer m, JFrame us) {
		setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("Menadzer");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(255, 0, 0));
			panel.setBackground(new Color(255, 255, 204));
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblMenadzer = new JLabel("Dobrodosli " + m.getIme() + " " + m.getPrezime() + "!!!");
				lblMenadzer.setHorizontalAlignment(SwingConstants.CENTER);
				lblMenadzer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				lblMenadzer.setForeground(new Color(255, 0, 0));
				panel.add(lblMenadzer);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setForeground(new Color(255, 0, 0));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(255, 0, 0));
			panel.setBackground(new Color(255, 255, 204));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JButton btnMeni = new JButton("Pravljenje novog menija");
			btnMeni.setSelectedIcon(null);
			btnMeni.setIcon(null);
			btnMeni.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnMeni.setForeground(new Color(255, 0, 0));
			btnMeni.setBackground(new Color(255, 255, 204));
			btnMeni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DNapraviMeni dnm = new DNapraviMeni(ovaj);
					dnm.setVisible(true);
					ovaj.setVisible(false);
				}
			});
			btnMeni.setBounds(111, 49, 201, 36);
			panel.add(btnMeni);
			
			JButton btnNarucivanjeNamirnica = new JButton("Naruci namirnice");
			btnNarucivanjeNamirnica.setForeground(new Color(255, 0, 0));
			btnNarucivanjeNamirnica.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNarucivanjeNamirnica.setBackground(new Color(255, 255, 204));
			btnNarucivanjeNamirnica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DNaruciNamirnice dnn = new DNaruciNamirnice(ovaj);
					dnn.setVisible(true);
					setVisible(false);
				}
			});
			btnNarucivanjeNamirnica.setBounds(111, 121, 201, 36);
			panel.add(btnNarucivanjeNamirnica);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOdjava = new JButton("Odjava");
				btnOdjava.setForeground(new Color(255, 0, 0));
				btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnOdjava.setSelectedIcon(null);
				btnOdjava.setIcon(null);
				btnOdjava.setBackground(new Color(255, 255, 204));
				btnOdjava.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						us.setVisible(true);
					}
				});
				btnOdjava.setActionCommand("Cancel");
				buttonPane.add(btnOdjava);
			}
		}
	}
}
