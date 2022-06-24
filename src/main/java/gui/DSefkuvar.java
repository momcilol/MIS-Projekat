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

import model.Sefkuvar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class DSefkuvar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5366039308948189899L;
	
	private final JPanel contentPanel = new JPanel();
	
	JDialog ovaj = this;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DSefkuvar dialog = new DSefkuvar();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DSefkuvar(Sefkuvar sefkuvar, JFrame frame) {
		getContentPane().setForeground(new Color(255, 0, 0));
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("Sef Kuhinje");
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
				JLabel lblMenadzer = new JLabel("Dobrodosli " + sefkuvar.getIme() + " " + sefkuvar.getPrezime() + "!!!");
				lblMenadzer.setHorizontalAlignment(SwingConstants.CENTER);
				lblMenadzer.setPreferredSize(new Dimension(350, 14));
				lblMenadzer.setMaximumSize(new Dimension(350, 14));
				lblMenadzer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
				lblMenadzer.setForeground(new Color(255, 0, 0));
				lblMenadzer.setBackground(new Color(255, 255, 204));
				panel.add(lblMenadzer);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setForeground(new Color(255, 0, 0));
				lblNewLabel.setBackground(new Color(255, 255, 204));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(255, 0, 0));
			panel.setBackground(new Color(255, 255, 204));
			panel.setLayout(null);
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				JButton btnMeni = new JButton("Pravljenje novog menija");
				btnMeni.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnMeni.setSelectedIcon(null);
				btnMeni.setIcon(null);
				btnMeni.setForeground(new Color(255, 0, 0));
				btnMeni.setBackground(new Color(255, 255, 204));
				btnMeni.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DNapraviMeni dnm = new DNapraviMeni(ovaj);
						dnm.setVisible(true);
						setVisible(false);
					}
				});
				btnMeni.setBounds(111, 79, 201, 36);
				panel.add(btnMeni);
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
