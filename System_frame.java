import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;


import javax.swing.*;

public class System_frame implements ActionListener {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void audio_frame() {
		JFrame audioFrame = new JFrame ("Noise Canceller");
		audioFrame.setBounds(750, 300, 300, 250);
		
		JPanel windowTabPanel_audio = new JPanel();
		JButton windowTab1 = new JButton("Noise Canceller");
		JButton windowTab2 = new JButton("System Settings");
		windowTab2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings set = new Settings();
				set.settings_frame();
				audioFrame.setVisible(false);
			}
		});
		
		windowTabPanel_audio.add(windowTab2);
		windowTabPanel_audio.add(windowTab1);
		
		JPanel centerPanel = new JPanel();
		JLabel decibelLabel = new JLabel("dB Threshold Slider: ");
		JSlider decibelSlider = new JSlider(0, 100, 50);
		// need to implement action capability for slider
		decibelSlider.setMajorTickSpacing(10);
		decibelSlider.setMinorTickSpacing(2);
		decibelSlider.setPaintTicks(true);
		Hashtable labelTable = new Hashtable();
		labelTable.put(new Integer(0), new JLabel("0"));
		labelTable.put(new Integer(20), new JLabel("20"));
		labelTable.put(new Integer(40), new JLabel("40"));
		labelTable.put(new Integer(60), new JLabel("60"));
		labelTable.put(new Integer(80), new JLabel("80"));
		labelTable.put(new Integer(100), new JLabel("100"));
		decibelSlider.setLabelTable(labelTable);
		decibelSlider.setPaintLabels(true);
		centerPanel.add(decibelLabel);
		centerPanel.add(decibelSlider);
		
		
		JLabel toneUpperLabel = new JLabel("Upper tone (in Hz)");
		JTextField toneFieldUpper = new JTextField("2000");
		/*toneFieldUpper.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//placeholder to call setUpperTone method
			}
		}); */

		JLabel toneLowerLabel = new JLabel("Lower tone (in Hz)");
		JTextField toneFieldLower = new JTextField("200");
		/*toneFieldLower.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//placeholder to call setLowerTone method
			}
		}); */
		
		centerPanel.add(toneUpperLabel);
		centerPanel.add(toneFieldUpper);
		centerPanel.add(toneLowerLabel);
		centerPanel.add(toneFieldLower);
		
		JPanel activationKeyPanel = new JPanel();
		JButton activationKey = new JButton("Noise Cancelling Switch");
		/*activationKey.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//placeholder to call activation method
			}
		}); */
		activationKeyPanel.add(activationKey);
		

		audioFrame.add(windowTabPanel_audio, BorderLayout.NORTH);
		audioFrame.add(centerPanel, BorderLayout.CENTER);
		audioFrame.add(activationKeyPanel, BorderLayout.SOUTH);
		audioFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}