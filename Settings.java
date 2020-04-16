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
		settingsFrame.setBounds(750, 300, 300, 250);
		
		JPanel windowTabPanel_audio = new JPanel(); //init panel for switching between frames
		JButton windowTab1 = new JButton("Noise Canceller"); //only need to impl. action for button to change windows
		windowTab1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System_frame sys = new System_frame();
				sys.audio_frame();
				settingsFrame.setVisible(false);
			}
		});
		JButton windowTab2 = new JButton("System Settings");
		windowTabPanel_audio.add(windowTab1);
		windowTabPanel_audio.add(windowTab2);
		
		JPanel centerPanel = new JPanel(); //set up primary component panel
		
		
		JLabel sizeXLabel = new JLabel("Size of window (x direction)"); //add and set up listener to detect change in value for x
		JTextField sizeXField = new JTextField("300");
		sizeXField.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New x value for window accepted.");
			}
		})); 

		JLabel sizeYLabel = new JLabel("Size of window (y direction)"); //add and set up listener to detect change in value for y
		JTextField sizeYField = new JTextField("250");
		sizeYField.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New y value for window accepted.");
			}
		})); 
		
		JLabel scaleLabel = new JLabel("Scale of elements within the window"); //add and set up listener to detect change in value for scale
		JTextField scaleField = new JTextField("1.0");
		scaleField.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New scale value for window accepted.");
			}
		})); 
		
		centerPanel.add(sizeXLabel); //add components to panel
		centerPanel.add(sizeXField);
		centerPanel.add(sizeYLabel);
		centerPanel.add(sizeYField);
		centerPanel.add(scaleLabel);
		centerPanel.add(scaleField);
		
		JPanel applicationKeyPanel = new JPanel();
		JButton applicationKey = new JButton("Apply"); //set up process to push user values to window for resizing
		applicationKey.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Push values for scale, x, and y to size components");
			}
		}));
		
		applicationKeyPanel.add(applicationKey);
		
		settingsFrame.add(windowTabPanel_audio, BorderLayout.NORTH);
		settingsFrame.add(centerPanel, BorderLayout.CENTER);
		settingsFrame.add(applicationKeyPanel, BorderLayout.SOUTH);
		settingsFrame.setVisible(true); //set all elements visible after adding/formatting
	}
}
