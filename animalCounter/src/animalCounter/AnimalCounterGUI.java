package animalCounter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AnimalCounterGUI extends JFrame implements ActionListener {
	Alligator alligator = new Alligator();
	Sheep sheep = new Sheep();
	JFrame frame;
	JLabel alligatorCount;
	JLabel sheepCount;
	JButton displayCounts;
	JRadioButton resetAlligator;
	JRadioButton resetSheep;
	AnimalCounterGUI() {
		frame = new JFrame("Animal Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel welcome = new JLabel("Welcome to The Animal Counter");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 6;
		c.insets = new Insets(5, 5, 5, 5);
		frame.add(welcome, c);
		JLabel alligatorLabel = new JLabel("Alligators:");
		alligatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		frame.add(alligatorLabel, c);
		JLabel sheepLabel = new JLabel("Sheep:");
		sheepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridx = 3;
		frame.add(sheepLabel, c);
		alligatorCount = new JLabel("0");
		alligatorCount.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 2;
		frame.add(alligatorCount, c);
		sheepCount = new JLabel("0");
		sheepCount.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridx = 3;
		frame.add(sheepCount, c);
		JButton addAlligator = new JButton("Increment Alligators");
		addAlligator.setActionCommand("addAlligator");
		addAlligator.addActionListener(this);
		c.gridx = 0;
		c.gridy = 3;
		frame.add(addAlligator, c);
		JButton addSheep = new JButton("Increment Sheep");
		addSheep.setActionCommand("addSheep");
		addSheep.addActionListener(this);
		c.gridx = 3;
		frame.add(addSheep, c);
		displayCounts = new JButton("Display Counts");
		displayCounts.setActionCommand("displayCounts");
		displayCounts.addActionListener(this);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 6;
		frame.add(displayCounts, c);
		JButton resetCounts = new JButton("Reset Counts");
		resetCounts.setActionCommand("resetCounts");
		resetCounts.addActionListener(this);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.LINE_END; // Horizontal right, vertical center
		c.insets = new Insets(10, 0, 0, 5);
		frame.add(resetCounts, c);
		resetAlligator = new JRadioButton("Alligator");
		resetAlligator.setSelected(true);
		c.gridx = 3;
		c.gridy = 5;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_START; // Horizontal left, vertical center
		c.insets = new Insets(20, 0, 0, 5);
		frame.add(resetAlligator, c);
		resetSheep = new JRadioButton("Sheep");
		c.gridx = 3;
		c.gridy = 6;
		c.insets = new Insets(0, 0, 10, 5);
		frame.add(resetSheep, c);
		ButtonGroup resetGroup = new ButtonGroup();
		resetGroup.add(resetAlligator); resetGroup.add(resetSheep);
		JButton exit = new JButton("Exit");
		exit.setActionCommand("exit");
		exit.addActionListener(this);
		c.gridx = 2;
		c.gridy = 7;
		c.gridwidth = 2;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(20, 0, 10, 0);
		frame.add(exit, c);
        frame.pack();
		frame.setVisible(true);	
	}
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("addAlligator")) {
			this.alligator.incrementCount();
			this.sheep.decrementCount();
			displayCounts.doClick();
			if (this.alligator.getCount() > this.sheep.getCount()){
				JOptionPane.showMessageDialog(frame, messageToHTML("Please add more sheep for the hungry alligators"));
			}
		} else if (command.equals("addSheep")) {
			this.sheep.incrementCount();
			displayCounts.doClick();
		} else if (command.equals("displayCounts")) {
			this.alligatorCount.setText(String.valueOf(this.alligator.getCount()));
			this.sheepCount.setText(String.valueOf(this.sheep.getCount()));
		} else if (command.equals("resetCounts")) {
			if (this.resetAlligator.isSelected()) {
				this.alligator.resetCount();
				JOptionPane.showMessageDialog(frame, messageToHTML("No alligators now so the sheep are safe"));
			} else {
				this.sheep.resetCount();
			}
			displayCounts.doClick();
		} else if (command.equals("exit")) {
			System.exit(0);
		} else {System.out.println("Invalid action command: " + command);}
	}
	String messageToHTML(String content) {
		String part1 = "<html><body style='width:200px'><p>";
		String part2 = "</p></body></html>";
		String result = part1 + content + part2;
		return result;
	}	
}