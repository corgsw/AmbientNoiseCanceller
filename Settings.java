import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Settings {
	public void settings_frame() {
		JFrame settingsFrame = new JFrame ("Noise Canceller"); //set up the frame for settings changes
		settingsFrame.setBounds(750, 300, 450, 250);
		System_frame sys = new System_frame();
		JPanel windowTabPanel_audio = new JPanel(); //init panel for switching between frames
		JButton windowTab1 = new JButton("Noise Canceller"); //only need to impl. action for button to change windows
		windowTab1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sys.audio_frame();
				settingsFrame.setVisible(false);
			}
		});
		JButton windowTab2 = new JButton("System Settings");
		windowTabPanel_audio.add(windowTab1);
		windowTabPanel_audio.add(windowTab2);
		
		JPanel centerPanel = new JPanel(); //set up primary component panel
		
		JLabel sizeXLabel = new JLabel("Size of window (x direction)"); //add and set up listener to detect change in value for x
		JTextField sizeXField = new JTextField("450");
		sizeXField.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resizeX = sizeXField.getText();
				int resizeX_num = Integer.parseInt(resizeX);
				final int x = resizeX_num;
				settingsFrame.setSize(x, settingsFrame.getY());
			}
			
		})); 
		

		JLabel sizeYLabel = new JLabel("Size of window (y direction)"); //add and set up listener to detect change in value for y
		JTextField sizeYField = new JTextField("250");
		sizeYField.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resizeY = sizeYField.getText();
				int resizeY_num = Integer.parseInt(resizeY);
				final int y = resizeY_num;
				settingsFrame.setSize(settingsFrame.getX(), y);
			}
		})); 
		
		
		centerPanel.add(sizeXLabel); //add components to panel
		centerPanel.add(sizeXField);
		centerPanel.add(sizeYLabel);
		centerPanel.add(sizeYField);
		
		JPanel applicationKeyPanel = new JPanel();
		JButton applicationKey = new JButton("Apply"); //set up process to push user values to window for resizing
		applicationKey.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sys.audio_frame(audioFrame.setSize(settingsFrame.getX(), settingsFrame.getY()));  //application of resizing across classes continues to breakdown
			}
		}));
		
		applicationKeyPanel.add(applicationKey);
		
		settingsFrame.add(windowTabPanel_audio, BorderLayout.NORTH);
		settingsFrame.add(centerPanel, BorderLayout.CENTER);
		settingsFrame.add(applicationKeyPanel, BorderLayout.SOUTH);
		settingsFrame.setVisible(true); //set all elements visible after adding/formatting
		settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
