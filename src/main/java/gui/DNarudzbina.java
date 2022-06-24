package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.MeniCrud;
import crud.NarudzbinaCrud;
import model.Meni;
import model.Onlinemusterija;
import model.Stanje;
import model.Stavkameni;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class DNarudzbina extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5273179685210238860L;
	
	private final JPanel contentPanel = new JPanel();
	static MeniCrud mc = new MeniCrud();
	static NarudzbinaCrud nc = new NarudzbinaCrud();
	JComboBox<Meni> cbMeni;
	JList<Stavkameni> list;
	JCheckBox chbxKartica;
	
	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		try {
//			System.out.println("Pozvan sam");
//			DNarudzbina dialog = new DNarudzbina(nc.vratiMusteriju(1));
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	
	public DNarudzbina(Onlinemusterija om, JDialog jd) {
		getContentPane().setForeground(new Color(255, 0, 0));
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("Narucivanje");
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
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblMeni = new JLabel("Izaberite Meni");
				lblMeni.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMeni.setForeground(new Color(255, 0, 0));
				lblMeni.setBackground(new Color(255, 255, 204));
				panel.add(lblMeni);
			}
			{
				cbMeni = new JComboBox<>();
				cbMeni.setPreferredSize(new Dimension(175, 22));
				cbMeni.setForeground(new Color(0, 0, 0));
				cbMeni.setBackground(new Color(255, 255, 204));
				panel.add(cbMeni);
				List<Meni> listaMenis = mc.listaMenija();
				for (Meni meni : listaMenis) {
					cbMeni.addItem(meni);
				}
				
			}
			{
				JButton btnPrikaziMeni = new JButton("Prikazi Meni");
				btnPrikaziMeni.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnPrikaziMeni.setSelectedIcon(null);
				btnPrikaziMeni.setIcon(null);
				btnPrikaziMeni.setForeground(new Color(255, 0, 0));
				btnPrikaziMeni.setBackground(new Color(255, 255, 204));
				btnPrikaziMeni.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultListModel<Stavkameni> listModel = new DefaultListModel<>();
						List<Stavkameni> listaStavkamenis = mc.prikaziMeni((Meni) cbMeni.getSelectedItem());
						for (Stavkameni stavkameni : listaStavkamenis) {
							listModel.addElement(stavkameni);
						}
						list.setModel(listModel);
					}
				});
				panel.add(btnPrikaziMeni);
			}
		}
		{
			list = new JList<>();
			list.setForeground(new Color(0, 0, 0));
			list.setBackground(new Color(245, 255, 250));
			contentPanel.add(list, BorderLayout.CENTER);
		}
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(255, 0, 0));
			panel.setBackground(new Color(255, 255, 204));
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				chbxKartica = new JCheckBox("Placanje karticom");
				chbxKartica.setFont(new Font("Tahoma", Font.BOLD, 12));
				chbxKartica.setForeground(new Color(255, 0, 0));
				chbxKartica.setBackground(new Color(255, 255, 204));
				panel.add(chbxKartica);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(255, 0, 0));
			buttonPane.setBackground(new Color(255, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNaruci = new JButton("Naruci");
				btnNaruci.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnNaruci.setSelectedIcon(null);
				btnNaruci.setIcon(null);
				btnNaruci.setForeground(new Color(255, 0, 0));
				btnNaruci.setBackground(new Color(255, 255, 204));
				btnNaruci.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						List<Stavkameni> listaStavkamenis = list.getSelectedValuesList();
						boolean kartica = chbxKartica.isSelected();
						nc.sacuvajNarudzbinu(kartica, Stanje.PRIPREMA, om, listaStavkamenis, new Date());
					}
				});
				btnNaruci.setActionCommand("OK");
				buttonPane.add(btnNaruci);
				getRootPane().setDefaultButton(btnNaruci);
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
						jd.setVisible(true);
					}
				});
				btnZatvori.setActionCommand("Cancel");
				buttonPane.add(btnZatvori);
			}
		}
	}

}
