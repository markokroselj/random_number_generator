package eNumbers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
   


import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.NumericShaper;
import java.awt.im.InputContext;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

	private JFrame frame;
	private JTextField output;
	
	int[] prviKrog = new int[5];
	int[] drugiKrog = new int[2];
	
	
	int l;
	
	
	int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws URISyntaxException 
	 */
	public Main() throws URISyntaxException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void Izpis() {
		
		if(!output.getText().equals("")) {
			output.setText("");
		}
		
		//shrani števila za prvi krog od 1 do 50 v arraylist
		ArrayList<Integer> numbers1 = new ArrayList<Integer>();
		for(int i = 0; i < 50; i++){
		numbers1.add(i+1);
		}
		//zmešaj števila v arraylist numbers1
		Collections.shuffle(numbers1);
		
		//shrani 5 števil prvega kroga v tabelo prviKrog
		for(int i = 0; i < prviKrog.length; i++) {
			prviKrog[i] = numbers1.get(i);
			
		}
		
		//shrani števila za drugi krog od 1 do 10 v arraylist
		ArrayList<Integer> numbers2 = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
		numbers2.add(i+1);
		}	
		//zmešaj števila v arraylist numbers2
		Collections.shuffle(numbers2);
		
		//shrani 2 števili drugega kroga v tabelo drugiKrog
		for(int i = 0; i < drugiKrog.length; i++) {
			drugiKrog[i] = numbers2.get(i);
		}
		
		//izpis prvega kroga
		for(int i = 0; i < prviKrog.length; i++) {
			
			output.setText(output.getText() + (Integer.toString(prviKrog[i]))+ " ");
		}
		output.setText(output.getText() + " ");
		//izpis drugega kroga
		for(int i = 0; i < drugiKrog.length; i++) {
			output.setText(output.getText() + (Integer.toString(drugiKrog[i])) + " ");
		}
		
			
		}
		
	public void sort() {
		
		output.setText("");
		java.util.Arrays.sort(prviKrog);
		java.util.Arrays.sort(drugiKrog);
		//izpis prvega kroga
		for(int i = 0; i < prviKrog.length; i++) {
			
			output.setText(output.getText() + (Integer.toString(prviKrog[i])) + " ");
		}
		output.setText(output.getText() + " ");
		//izpis drugega kroga
		for(int i = 0; i < drugiKrog.length; i++) {
			output.setText(output.getText() + (Integer.toString(drugiKrog[i])) + " ");
		}
	}
	
	public void Copy() {
			StringSelection stringSelection = new StringSelection (output.getText());
	        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
	        clpbrd.setContents (stringSelection, null);
	}
	
	    private void initialize() throws URISyntaxException {
	    	//dvo dimenzionalna tabela za angleški in slovenski jezik
	    	InputContext context = InputContext.getInstance();  
	    	if((context.getLocale().toString()).equals("sl_SI")) l = 0;
	    	else l = 1;
	    	
	    	String[][] lang = new String[2][6];
	    	
	    	//slo
	    	
	    	//naslov 
	    	lang[0][0] = "Generator naključnih števil za Euro Jackpot";
	    	//opis
	    	lang[0][1] = "<html><body>Generator naključnih števil za Euro Jackpot.<br> Klikni zaženi za izpis števila.<br>Klikni kopiraj za kopiranje številk v odložišče.</body></html>";
	    	//zaženi
	    	lang[0][2] = "zaženi";
	    	//kopiraj
	    	lang[0][3] = "kopiraj";
	    	//razvrsti
	    	lang[0][4] = "razvrsti";
	    	//jezik
	    	lang[0][5] = "SLO";
	    	
	    	//eng
	    	
	    	//title
	    	lang[1][0] = "Random number generator for Euro Jackpot";
	    	//description
	    	lang[1][1] = "<html><body>Random number generator for Euro Jackpot.<br> Click run to output the numbers.<br>Click copy to copy numbers to clipboard.</body></html>";
	    	//run
	    	lang[1][2] = "run";
	    	//copy
	    	lang[1][3] = "copy";
	    	//sort
	    	lang[1][4] = "sort";
	    	//lang 
	    	lang[1][5] = "ENG";
	    	
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/eNumbers/icon.png")));
	
		frame.setBounds(100, 100, 653, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		
		JLabel icona = new JLabel("");
		icona.setIcon(new ImageIcon(Main.class.getResource("/eNumbers/logo-eurojackpot-big.png")));
		icona.setBounds(376, 84, 261, 177);
		frame.getContentPane().add(icona);
		
		output = new JTextField();
		output.setEditable(false);
		output.setForeground(new Color(255, 255, 204));
		output.setFont(new Font("Tahoma", Font.PLAIN, 15));
		output.setBackground(Color.DARK_GRAY);
		output.setBounds(22, 182, 309, 47);
		frame.getContentPane().add(output);
		output.setColumns(10);
		
		JLabel opis = new JLabel(lang[l][1]);
		opis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		opis.setForeground(Color.WHITE);
		opis.setVerticalAlignment(SwingConstants.TOP);
		opis.setBounds(22, 84, 324, 75);
		frame.getContentPane().add(opis);
		
		//run
		
		JButton run = new JButton(lang[l][2]);
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Izpis();
			}
		});
		run.setBackground(new Color(237, 49, 16));
		run.setBounds(22, 240, 100, 32);
		run.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frame.getContentPane().add(run);
		
		JButton copy = new JButton(lang[l][3]);
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Copy();
			}
		});
		copy.setBackground(new Color(237, 49, 16));
		copy.setBounds(127, 240, 100, 32);
		copy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frame.getContentPane().add(copy);
		
		JLabel lblMarkoKroelj = new JLabel("\u00a9 Marko Krošelj");
		lblMarkoKroelj.setForeground(new Color(255, 255, 255));
		lblMarkoKroelj.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblMarkoKroelj.setBounds(525, 256, 112, 32);
	final URI uri = new URI("http://markokroselj.atwebpages.com/");
		
		lblMarkoKroelj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				open(uri);
			}

			private void open(URI uri) {
				if (Desktop.isDesktopSupported()) {
				      try {
				        Desktop.getDesktop().browse(uri);
				      } catch (IOException e) { /* TODO: error handling */ }
				    } else { /* TODO: error handling */ }
				
			}
		});
		frame.getContentPane().add(lblMarkoKroelj);
		
		JPanel topBar = new JPanel();
		topBar.setBackground(new Color(230,74,25));
		topBar.setBounds(0, 0, 653, 63);
		frame.getContentPane().add(topBar);
		topBar.setLayout(null);
		
		JLabel exit = new JLabel("");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exit.setIcon(new ImageIcon(Main.class.getResource("/eNumbers/icons8-multiply-filled-48.png")));
		exit.setBounds(595, 11, 48, 41);
		topBar.add(exit);
		
		JLabel min = new JLabel("");
		min.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(Frame.ICONIFIED);
			}
		});
		
		min.setIcon(new ImageIcon(Main.class.getResource("/eNumbers/icons8-minimize-window-48.png")));
		min.setBounds(537, 11, 48, 41);
		topBar.add(min);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/eNumbers/icon48.png")));
		label.setBounds(10, 11, 48, 41);
		topBar.add(label);
		
		JLabel titleText = new JLabel(lang[l][0]);
		titleText.setFont(new Font("Tahoma", Font.PLAIN, 22));
		titleText.setBounds(61, 11, 435, 41);
		topBar.add(titleText);
		
		JButton btn = new JButton(lang[l][4]);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!output.getText().equals("")) {
					sort();
				}else {
					
				}
				
			}
		});
		btn.setBackground(new Color(237, 49, 16));
		btn.setBounds(237, 240, 89, 32);
		btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frame.getContentPane().add(btn);
		
		JLabel lblVer = new JLabel("ver: 1.2.0");
		lblVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(icona, "version 1.2.0","version",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblVer.setForeground(Color.WHITE);
		lblVer.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblVer.setBounds(554, 288, 59, 14);
		frame.getContentPane().add(lblVer);
		
		JLabel lblLang = new JLabel(lang[l][5]);
		lblLang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(l == 0) {
					l = 1;
				}else {
					l = 0;
				}
				System.out.println();
			}
		});
		lblLang.setForeground(Color.GRAY);
		lblLang.setToolTipText(lang[l][5]);
		lblLang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLang.setBounds(611, 64, 32, 20);
		frame.getContentPane().add(lblLang);
	
		
	
		topBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				  xx = arg0.getX();

			        xy = arg0.getY();
			}
		});
		topBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();

		        int y = arg0.getYOnScreen();

		       frame.setLocation(x - xx, y - xy);  
			}
		});
	}
}
