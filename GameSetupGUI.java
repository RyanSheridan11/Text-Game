import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

public class GameSetupGUI {

	private JFrame frame;
	private JTextField txtTeamName;
	private JTextField inputHeroName;
	private String heroType = "Gambler";
	private int inputNumHeroes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSetupGUI window = new GameSetupGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameSetupGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Main setup frame");
		frame.setBounds(100, 100, 1109, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblWhatWouldYou = new JLabel("What would you like your super team to be called?");
		lblWhatWouldYou.setBounds(2, -7, 378, 59);
		frame.getContentPane().add(lblWhatWouldYou);
		
		txtTeamName = new JTextField();
		txtTeamName.setBounds(22, 38, 306, 25);
		txtTeamName.setText("Must be between 2 and 10 chars long!");
		txtTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamName.setToolTipText("Wowwo cools!");
		frame.getContentPane().add(txtTeamName);
		txtTeamName.setColumns(10);
		
		inputHeroName = new JTextField();
		inputHeroName.setBounds(379, 454, 134, 31);
		frame.getContentPane().add(inputHeroName);
		inputHeroName.setColumns(10);
		
		JLabel inputCheck = new JLabel("");
		inputCheck.setBounds(423, 131, 181, 26);
		frame.getContentPane().add(inputCheck);
		
		JLabel lblHeroes = new JLabel("List of Heroes");
		lblHeroes.setBounds(70, 27, 973, 245);
		frame.getContentPane().add(lblHeroes);
		
		JLabel picGambler = new JLabel("Pic Gambler");
		picGambler.setBounds(379, 267, 147, 50);
		frame.getContentPane().add(picGambler);
		
		JLabel picMedic = new JLabel("Medic Pic");
		picMedic.setVisible(false);
		picMedic.setBounds(319, 234, 87, 50);
		frame.getContentPane().add(picMedic);
		
		JLabel picDiplomat = new JLabel("Pic Diplomat");
		picDiplomat.setVisible(false);
		picDiplomat.setBounds(379, 224, 166, 31);
		frame.getContentPane().add(picDiplomat);
		
		JLabel picTank = new JLabel("Pic Tank");
		picTank.setVisible(false);
		picTank.setBounds(362, 181, 117, 31);
		frame.getContentPane().add(picTank);
		
		JLabel picExplorer = new JLabel("Pic Explorer");
		picExplorer.setVisible(false);
		picExplorer.setBounds(379, 302, 124, 39);
		frame.getContentPane().add(picExplorer);
		
		JLabel picLucky = new JLabel("Pic Lucky");
		picLucky.setVisible(false);
		picLucky.setBounds(443, 181, 117, 50);
		frame.getContentPane().add(picLucky);
		
		JLabel lblNewLabel = new JLabel("How many cities to explore?");
		lblNewLabel.setBounds(377, 6, 302, 31);
		frame.getContentPane().add(lblNewLabel);

		JLabel sliderLabel = new JLabel("3             4              5             6");
		sliderLabel.setBounds(383, 64, 296, 26);
		frame.getContentPane().add(sliderLabel);
		
		JLabel lblAddUpTo = new JLabel("Pick and name up to 3 heroes to your team");
		lblAddUpTo.setBounds(19, 67, 401, 39);
		frame.getContentPane().add(lblAddUpTo);
		
		JButton btnPreviousHero = new JButton("Previous Hero");
		btnPreviousHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (heroType == "Gambler") {
					heroType = "Lucky";
					picGambler.setVisible(false);
					picLucky.setVisible(true);
				} else if (heroType == "Medic") {
					heroType = "Gambler";
					picMedic.setVisible(false);
					picGambler.setVisible(true);
				} else if (heroType == "Diplomat") {
					heroType = "Medic";
					picDiplomat.setVisible(false);
					picMedic.setVisible(true);
				} else if (heroType == "Tank") {
					heroType = "Diplomat";
					picTank.setVisible(false);
					picDiplomat.setVisible(true);
				} else if (heroType == "Explorer") {
					heroType = "Tank";
					picExplorer.setVisible(false);
					picTank.setVisible(true);
				} else if (heroType == "Lucky") {
					heroType = "Explorer";
					picLucky.setVisible(false);
					picExplorer.setVisible(true);
				}
			}
		});
		btnPreviousHero.setBounds(207, 317, 134, 25);
		frame.getContentPane().add(btnPreviousHero);
		
		//Slider to choose number cities
		JSlider numCities = new JSlider();
		numCities.setMajorTickSpacing(1);
		numCities.setSnapToTicks(true);
		numCities.setPaintTicks(true);
		numCities.setMinimum(3);
		numCities.setMaximum(6);
		numCities.setBounds(379, 46, 200, 16);
		frame.getContentPane().add(numCities);
		
		/** This is the button to add a new hero **/
		JButton btnAddHero = new JButton("Add hero");
		btnAddHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if inputHeroName.getText().length() 
				Team.heroes.add(new Hero(inputHeroName.getText(), heroType));
				inputNumHeroes++;
				Team.setNumberHeroes(inputNumHeroes);
				
				String longS;
				for (int i = 0; i <= inputNumHeroes; i++) {
					longS = Team.heroes.toString();
				}
				lblHeroes.setText(Team.heroes.toString());
				//heroes.add();
				
				
				
				//clear text box
				
			}
		});
		btnAddHero.setBounds(379, 511, 145, 25);
		frame.getContentPane().add(btnAddHero);
		/**END**/
		
		
		
		/** Next HEROO BUTTON**/
		JButton btnNextHero = new JButton("Next Hero");
		btnNextHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (heroType == "Gambler") {
					heroType = "Medic";
					picGambler.setVisible(false);
					picMedic.setVisible(true);
				} else if (heroType == "Medic") {
					heroType = "Diplomat";
					picMedic.setVisible(false);
					picDiplomat.setVisible(true);
				} else if (heroType == "Diplomat") {
					heroType = "Tank";
					picDiplomat.setVisible(false);
					picTank.setVisible(true);
				} else if (heroType == "Tank") {
					heroType = "Explorer";
					picTank.setVisible(false);
					picExplorer.setVisible(true);
				} else if (heroType == "Explorer") {
					heroType = "Lucky";
					picExplorer.setVisible(false);
					picLucky.setVisible(true);
				} else if (heroType == "Lucky") {
					heroType = "Gambler";
					picLucky.setVisible(false);
					picGambler.setVisible(true);
				}
				
				
			}
		});
		btnNextHero.setBounds(625, 317, 145, 25);
		frame.getContentPane().add(btnNextHero);
		/**END HERE!!!!**/
		
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game_Environment.setTeamName(txtTeamName.getText());
				
				Game_Environment.setNumberCities(numCities.getValue());
				//Game_Environment.setNumberHeroes(heroes.size());//length of the list of heroes)
				
				System.out.println(Game_Environment.getTeamName());
				CiyGUI City1 = new CiyGUI();
				City1.NewScreen();
				City1.exit();
				
			}
		});
		btnDone.setBounds(841, 570, 117, 25);
		frame.getContentPane().add(btnDone);
		
		
		
		
	}
}
