import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class System_frame implements ActionListener {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void audio_frame() {
		JFrame audioFrame = new JFrame ("Noise Canceller"); //set up the frame for audio cancelling
		audioFrame.setBounds(750, 300, 300, 250);
		
		JPanel windowTabPanel_audio = new JPanel(); //init panel for switching between frames
		JButton windowTab1 = new JButton("Noise Canceller");
		JButton windowTab2 = new JButton("System Settings"); //only need to impl. action for button to change windows
		windowTab2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings set = new Settings();
				set.settings_frame();
				audioFrame.setVisible(false);
			}
		});
		
		windowTabPanel_audio.add(windowTab1);
		windowTabPanel_audio.add(windowTab2);
		
		JPanel centerPanel = new JPanel();
		JLabel decibelLabel = new JLabel("dB Threshold Slider: ");
		JSlider decibelSlider = new JSlider(0, 100, 50);

		// need to implement action capability for slider
		decibelSlider.addChangeListener(new ChangeListener() { //sliders are handled differently to buttons/textfields, so we used a change listener
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			       int dBThresh = (int)source.getValue(); //whenever the value has stopped after being altered, read it and store it for use
			       System.out.println(dBThresh);
			    }
			}
		});
		
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
		decibelSlider.setPaintLabels(true); //set tick marks and regular numerical labels for slider to make it easier to use
		centerPanel.add(decibelLabel);
		centerPanel.add(decibelSlider);
		
		
		JLabel toneUpperLabel = new JLabel("Upper tone (in Hz)"); //set default value for upper range and read new val. if its changed
		JTextField toneFieldUpper = new JTextField("2000");
		toneFieldUpper.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New high range value for noise cancelling accepted.");
			}
		})); 
		JLabel toneLowerLabel = new JLabel("Lower tone (in Hz)"); //set default value for lower range and read new val. if its changed
		JTextField toneFieldLower = new JTextField("200");
		toneFieldLower.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New low range value for noise cancelling accepted.");
			}
		}));
		
		centerPanel.add(toneUpperLabel);
		centerPanel.add(toneFieldUpper);
		centerPanel.add(toneLowerLabel);
		centerPanel.add(toneFieldLower);
		
		JPanel activationKeyPanel = new JPanel(); //toggle bool state to engage noise cancelling (for now just return an output)
		JButton activationKey = new JButton("Noise Cancelling Switch");
		activationKey.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("check"); //test to trigger 
			}
		}));
		activationKeyPanel.add(activationKey);
		

		audioFrame.add(windowTabPanel_audio, BorderLayout.NORTH);
		audioFrame.add(centerPanel, BorderLayout.CENTER);
		audioFrame.add(activationKeyPanel, BorderLayout.SOUTH);
		audioFrame.setVisible(true); //set all elements visible after adding/formatting
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}