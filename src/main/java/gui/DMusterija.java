package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.Onlinemusterija;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class DMusterija extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1890477314492619068L;

	private final JPanel contentPanel = new JPanel();
	JDialog ovaj = this;
	DNarudzbina dn;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DMusterija dialog = new DMusterija();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DMusterija(Onlinemusterija om, JFrame frame) {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setBackground(new Color(255, 255, 204));
		setForeground(new Color(255, 0, 0));
		getContentPane().setForeground(new Color(255, 0, 0));
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("Musterija");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 0, 0));
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
				JLabel lblDobrodosli = new JLabel("DOBRODOSLI NAZAD!!!");
				lblDobrodosli.setHorizontalAlignment(SwingConstants.CENTER);
				lblDobrodosli.setPreferredSize(new Dimension(250, 14));
				lblDobrodosli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				lblDobrodosli.setForeground(new Color(255, 0, 0));
				lblDobrodosli.setBackground(new Color(255, 255, 204));
				panel.add(lblDobrodosli);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(255, 0, 0));
			panel.setBackground(new Color(255, 255, 204));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JButton btnNarucivanje = new JButton("Naruci");
				btnNarucivanje.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnNarucivanje.setSelectedIcon(null);
				btnNarucivanje.setIcon(null);
				btnNarucivanje.setForeground(new Color(255, 0, 0));
				btnNarucivanje.setBackground(new Color(255, 255, 204));
				btnNarucivanje.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dn = new DNarudzbina(om, ovaj);
						dn.setVisible(true);
						ovaj.setVisible(false);
					}
				});
				btnNarucivanje.setBounds(159, 77, 106, 39);
				panel.add(btnNarucivanje);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(255, 0, 0));
			buttonPane.setBackground(new Color(255, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOdjava = new JButton("Odjava");
				btnOdjava.setSelectedIcon(null);
				btnOdjava.setIcon(null);
				btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnOdjava.setForeground(new Color(255, 0, 0));
				btnOdjava.setBackground(new Color(255, 255, 204));
				btnOdjava.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						frame.setVisible(true);
					}
				});
				btnOdjava.setActionCommand("Cancel");
				buttonPane.add(btnOdjava);
			}
		}
	}

}
