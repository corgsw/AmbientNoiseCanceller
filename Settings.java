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
		JFrame settingsFrame = new JFrame ("Noise Canceller");
		settingsFrame.setBounds(750, 300, 300, 250);
		
		JPanel windowTabPanel_audio = new JPanel();
		JButton windowTab1 = new JButton("Noise Canceller");
		windowTab1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System_frame sys = new System_frame();
				sys.audio_frame();
				settingsFrame.setVisible(false);
			}
		});
		JButton windowTab2 = new JButton("System Settings");
		windowTabPanel_audio.add(windowTab2);
		windowTabPanel_audio.add(windowTab1);
		
		JPanel centerPanel = new JPanel();
		
		
		JLabel sizeXLabel = new JLabel("Size of window (x direction)");
		JTextField sizeXField = new JTextField("300");

		JLabel sizeYLabel = new JLabel("Size of window (y direction)");
		JTextField sizeYField = new JTextField("250");
		
		JLabel scaleLabel = new JLabel("Scale of elements within the window");
		JTextField scaleField = new JTextField("1.0");
		centerPanel.add(sizeXLabel);
		centerPanel.add(sizeXField);
		centerPanel.add(sizeYLabel);
		centerPanel.add(sizeYField);
		centerPanel.add(scaleLabel);
		centerPanel.add(scaleField);
		
		JPanel applicationKeyPanel = new JPanel();
		JButton applicationKey = new JButton("Apply");
		applicationKeyPanel.add(applicationKey);
		
		settingsFrame.add(windowTabPanel_audio, BorderLayout.NORTH);
		settingsFrame.add(centerPanel, BorderLayout.CENTER);
		settingsFrame.add(applicationKeyPanel, BorderLayout.SOUTH);
		settingsFrame.setVisible(true);
	}
}
