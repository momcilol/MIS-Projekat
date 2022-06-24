package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.ZalihaCrud;
import model.Dobavljac;
import model.Namirnicazaliha;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DNaruciNamirnice extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1759356484290520309L;
	
	private final JPanel contentPanel = new JPanel();
	
	JDialog ovaj = this;
	
	ZalihaCrud zc = new ZalihaCrud();
	JComboBox<Namirnicazaliha> cbNamirnice;
	JComboBox<Dobavljac> cbDobavljaci;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DPrikazStanjaZaliha dialog = new DPrikazStanjaZaliha();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DNaruciNamirnice(JDialog jDialog) {
		getContentPane().setForeground(new Color(255, 0, 0));
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("Naruci namirnice");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 0, 0));
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNamirnice = new JLabel("Izaberite namirnice");
			lblNamirnice.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNamirnice.setForeground(new Color(255, 0, 0));
			lblNamirnice.setBackground(new Color(255, 255, 204));
			lblNamirnice.setBounds(10, 31, 128, 14);
			contentPanel.add(lblNamirnice);
		}
		{
			cbNamirnice = new JComboBox<>();
			cbNamirnice.setForeground(new Color(0, 0, 0));
			cbNamirnice.setBackground(new Color(255, 255, 204));
			cbNamirnice.setBounds(148, 27, 220, 22);
			contentPanel.add(cbNamirnice);
			List<Namirnicazaliha> listaNamirnicazalihas = zc.listaZaliha();
			for (Namirnicazaliha namirnicazaliha : listaNamirnicazalihas) {
				cbNamirnice.addItem(namirnicazaliha);
			}
		}
		{
			JLabel lblDobavljac = new JLabel("Izaberite dobavljaca");
			lblDobavljac.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDobavljac.setForeground(new Color(255, 0, 0));
			lblDobavljac.setBackground(new Color(255, 255, 204));
			lblDobavljac.setBounds(10, 130, 128, 14);
			contentPanel.add(lblDobavljac);
		}
		{
			cbDobavljaci = new JComboBox<>();
			cbDobavljaci.setForeground(new Color(0, 0, 0));
			cbDobavljaci.setBackground(new Color(255, 255, 204));
			cbDobavljaci.setBounds(148, 126, 220, 22);
			contentPanel.add(cbDobavljaci);
		}
		{
			JLabel lblKolicina = new JLabel("Izaberite kolicinu");
			lblKolicina.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblKolicina.setForeground(new Color(255, 0, 0));
			lblKolicina.setBackground(new Color(255, 255, 204));
			lblKolicina.setBounds(10, 175, 128, 14);
			contentPanel.add(lblKolicina);
		}
		
		JSlider slKolicina = new JSlider();
		slKolicina.setPaintTicks(true);
		slKolicina.setForeground(new Color(0, 0, 0));
		slKolicina.setBackground(new Color(255, 255, 204));
		slKolicina.setMaximum(100);
		slKolicina.setMinimum(0);
		slKolicina.setBounds(148, 175, 220, 26);
		contentPanel.add(slKolicina);
		
		JButton btnDobavljaci = new JButton("Prikazi dobavljace");
		btnDobavljaci.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDobavljaci.setForeground(new Color(255, 0, 0));
		btnDobavljaci.setBackground(new Color(255, 255, 204));
		btnDobavljaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Dobavljac> listaDobavljacs = zc.dobavljaciZaNamirnicu((Namirnicazaliha)cbNamirnice.getSelectedItem());
				for (Dobavljac dobavljac : listaDobavljacs) {
					cbDobavljaci.addItem(dobavljac);
				}
			}
		});
		btnDobavljaci.setBounds(148, 76, 220, 23);
		contentPanel.add(btnDobavljaci);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(255, 0, 0));
			buttonPane.setBackground(new Color(255, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNaruci = new JButton("Naruci");
				btnNaruci.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnNaruci.setForeground(new Color(255, 0, 0));
				btnNaruci.setBackground(new Color(255, 255, 204));
				btnNaruci.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Namirnicazaliha nz = (Namirnicazaliha) cbNamirnice.getSelectedItem();
						Dobavljac dobavljac = (Dobavljac) cbDobavljaci.getSelectedItem();
						double kolicina = slKolicina.getValue();
						zc.sacuvajNarudzbinu(nz, dobavljac, kolicina);
					}
				});
				btnNaruci.setActionCommand("OK");
				buttonPane.add(btnNaruci);
				getRootPane().setDefaultButton(btnNaruci);
			}
			{
				JButton btnZatvori = new JButton("Zatvori");
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
	}
}
