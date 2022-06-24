package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import crud.MeniCrud;
import model.Meni;
import model.Stavkameni;
import java.awt.Color;
import java.awt.Font;

public class DNapraviMeni extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5631144567017999451L;
	
	MeniCrud mc = new MeniCrud();
	private JTextField tfMeni;
	JList<Stavkameni> list;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DNapraviMeni dialog = new DNapraviMeni();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DNapraviMeni(JDialog jDialog) {
		getContentPane().setForeground(new Color(255, 0, 0));
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("Novi Meni");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(255, 0, 0));
			buttonPane.setBackground(new Color(255, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSacuvaj = new JButton("Sacuvaj");
				btnSacuvaj.setSelectedIcon(null);
				btnSacuvaj.setIcon(null);
				btnSacuvaj.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnSacuvaj.setForeground(new Color(255, 0, 0));
				btnSacuvaj.setBackground(new Color(255, 255, 204));
				btnSacuvaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Meni m = new Meni(tfMeni.getText());
						mc.dodajNoviMeni(m);
						
						List<Stavkameni> listaStavkamenis = list.getSelectedValuesList();
						for (Stavkameni stavkameni : listaStavkamenis) {
								mc.dodajStavkuUMeni(stavkameni, m);
						}
					}
				});
				btnSacuvaj.setActionCommand("OK");
				buttonPane.add(btnSacuvaj);
				getRootPane().setDefaultButton(btnSacuvaj);
			}
			{
				JButton btnZatvori = new JButton("Zatvori");
				btnZatvori.setSelectedIcon(null);
				btnZatvori.setIcon(null);
				btnZatvori.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnZatvori.setForeground(new Color(255, 0, 0));
				btnZatvori.setBackground(new Color(255, 255, 204));
				btnZatvori.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						jDialog.setVisible(true);
					}
				});
				btnZatvori.setActionCommand("Cancel");
				buttonPane.add(btnZatvori);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(255, 0, 0));
			panel.setBackground(new Color(255, 255, 204));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setForeground(new Color(255, 0, 0));
				panel_1.setBackground(new Color(255, 255, 204));
				panel.add(panel_1, BorderLayout.NORTH);
				{
					JLabel lblMeni = new JLabel("Novi Meni");
					lblMeni.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblMeni.setForeground(new Color(255, 0, 0));
					lblMeni.setBackground(new Color(255, 255, 204));
					panel_1.add(lblMeni);
				}
				{
					tfMeni = new JTextField();
					tfMeni.setForeground(new Color(0, 0, 0));
					tfMeni.setBackground(new Color(245, 255, 250));
					panel_1.add(tfMeni);
					tfMeni.setColumns(20);
				}
			}
			{
				JLabel lblStavke = new JLabel("Izaberite stavke za novi meni");
				lblStavke.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblStavke.setForeground(new Color(255, 0, 0));
				lblStavke.setBackground(new Color(255, 255, 204));
				lblStavke.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblStavke, BorderLayout.SOUTH);
			}
		}
		{

			DefaultListModel<Stavkameni> listModel = new DefaultListModel<>();
			List<Stavkameni> listaStavkamenis = mc.listaStavki();
			for (Stavkameni stavkameni : listaStavkamenis) {
				listModel.addElement(stavkameni);
			}
			list = new JList<>();
			list.setForeground(new Color(0, 0, 0));
			list.setBackground(new Color(245, 255, 250));
			list.setModel(listModel);
			getContentPane().add(list, BorderLayout.CENTER);
		}
	}
}
