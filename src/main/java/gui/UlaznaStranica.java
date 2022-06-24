package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import crud.MeniCrud;
import crud.NarudzbinaCrud;
import model.Menadzer;
import model.Onlinemusterija;
import model.Sefkuvar;
import javax.swing.JPasswordField;

public class UlaznaStranica {

	private JFrame frmWelcome;
	private JTextField tfUsername;
	private JLabel lblPassword;
	
	MeniCrud mc = new MeniCrud();
	NarudzbinaCrud nc = new NarudzbinaCrud();
	private JPasswordField pfPassword;
	
	DSefkuvar dnm;
	DMusterija dn;
	DMenadzer dm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UlaznaStranica window = new UlaznaStranica();
					window.frmWelcome.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UlaznaStranica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setFont(new Font("Arial Black", Font.BOLD, 15));
		frmWelcome.setBackground(new Color(255, 0, 0));
		frmWelcome.getContentPane().setForeground(new Color(255, 255, 255));
		frmWelcome.getContentPane().setBackground(new Color(255, 255, 204));
		frmWelcome.setForeground(new Color(255, 0, 0));
		frmWelcome.setTitle("Login page");
		frmWelcome.setBounds(100, 100, 450, 300);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblDobrodosli = new JLabel("DOBRODOSLI");
		lblDobrodosli.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblDobrodosli.setForeground(new Color(255, 0, 51));
		lblDobrodosli.setHorizontalAlignment(SwingConstants.CENTER);
		lblDobrodosli.setBounds(94, 41, 246, 14);
		frmWelcome.getContentPane().add(lblDobrodosli);
		
		JLabel lblUlogujSe = new JLabel("ULOGUJTE SE U VAS NALOG");
		lblUlogujSe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUlogujSe.setForeground(new Color(255, 0, 51));
		lblUlogujSe.setHorizontalAlignment(SwingConstants.CENTER);
		lblUlogujSe.setBounds(94, 79, 246, 14);
		frmWelcome.getContentPane().add(lblUlogujSe);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfUsername.setForeground(new Color(255, 0, 51));
		tfUsername.setBounds(134, 129, 206, 20);
		frmWelcome.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Korisnicko ime");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setForeground(new Color(255, 0, 51));
		lblUsername.setBounds(28, 132, 97, 14);
		frmWelcome.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Lozinka");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(new Color(255, 0, 51));
		lblPassword.setBounds(28, 163, 97, 14);
		frmWelcome.getContentPane().add(lblPassword);
		
		JButton btnUlogujSe = new JButton("Uloguj se");
		btnUlogujSe.setSelectedIcon(null);
		btnUlogujSe.setIcon(null);
		btnUlogujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Onlinemusterija> omLista = nc.listaOnlinemusterija();
				List<Menadzer> mList = mc.listaMenadzera();
				List<Sefkuvar> sList = mc.listaSefkuvara();
				
				String username = tfUsername.getText();
				String password = String.valueOf(pfPassword.getPassword());
				tfUsername.setText("");
				pfPassword.setText("");
				System.out.println(username + ", " + password);
				
				System.out.println("Pre Onlinemusterija streama");
				Onlinemusterija om = omLista.stream().filter(o -> o.getTelefon().equals(username))
													 .filter(o -> o.getPassword().equals(password))
													 .findAny()
													 .orElse(null);
				
				if (om != null) {
					System.out.println("Here I am!");
					dn = new DMusterija(om,frmWelcome);
					dn.setVisible(true);
					frmWelcome.setVisible(false);
				} else {
					System.out.println("Pre Menadzer streama");
					Menadzer m = mList.stream()
									  .filter(o -> username.equals(o.getTelefon()))
							          .filter(o -> password.equals(o.getPassword()))
						              .findAny()
									  .orElse(null);
				
					if (m != null) {
						System.out.println("Here I am!");
						dm = new DMenadzer(m,frmWelcome);
						dm.setVisible(true);
						frmWelcome.setVisible(false);
					} else {
						System.out.println("Pre Sefkuvar streama");
						Sefkuvar s = sList.stream()
										  .filter(o -> username.equals(o.getTelefon()))
										  .filter(o -> password.equals(o.getPassword()))
										  .findAny()
										  .orElse(null);
				
						if (s != null) {
							System.out.println("Here I am!");
							dnm = new DSefkuvar(s,frmWelcome);
							dnm.setVisible(true);
							frmWelcome.setVisible(false);
						}
					}
				}
				System.out.println("Nisam uspeo!");
			}
		});
		btnUlogujSe.setBackground(new Color(255, 255, 204));
		btnUlogujSe.setFont(new Font("Dialog", Font.BOLD, 14));
		btnUlogujSe.setForeground(new Color(255, 0, 51));
		btnUlogujSe.setBounds(183, 201, 108, 27);
		frmWelcome.getContentPane().add(btnUlogujSe);
		
		pfPassword = new JPasswordField();
		pfPassword.setForeground(new Color(255, 0, 51));
		pfPassword.setBounds(134, 160, 206, 20);
		frmWelcome.getContentPane().add(pfPassword);
	}
}
