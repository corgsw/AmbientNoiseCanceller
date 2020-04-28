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
		audioFrame.setBounds(750, 300, 450, 250);
		
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
		JLabel balanceLabel = new JLabel("Audio Balance Slider: ");
		JSlider balanceSlider = new JSlider(-1000, 1000, 0);

		// need to implement action capability for slider
		balanceSlider.addChangeListener(new ChangeListener() {//sliders are handled differently to buttons/textfields, so we used a change listener
			SoundOut snd = new SoundOut();
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			       float panVal = (float)source.getValue() / 1000; //whenever the value has stopped after being altered, read it and store it for us
			       snd.setPan(panVal);
			       
			    }
			}
		});
		
		
		balanceSlider.setPaintTicks(true);
		Hashtable labelTable = new Hashtable();
		labelTable.put(new Integer(-1000), new JLabel("L"));
		labelTable.put(new Integer(-800), new JLabel("-"));
		labelTable.put(new Integer(-600), new JLabel("-"));
		labelTable.put(new Integer(-400), new JLabel("-"));
		labelTable.put(new Integer(-200), new JLabel("-"));
		labelTable.put(new Integer(0), new JLabel("0"));
		labelTable.put(new Integer(200), new JLabel("-"));
		labelTable.put(new Integer(400), new JLabel("-"));
		labelTable.put(new Integer(600), new JLabel("-"));
		labelTable.put(new Integer(800), new JLabel("-"));
		labelTable.put(new Integer(1000), new JLabel("R"));
		
		balanceSlider.setLabelTable(labelTable);
		balanceSlider.setPaintLabels(true); //set tick marks and regular numerical labels for slider to make it easier to use
		centerPanel.add(balanceLabel);
		centerPanel.add(balanceSlider);

		
		JPanel activationKeyPanel = new JPanel(); //toggle bool state to engage noise cancelling
		JButton activationKey = new JButton("Noise Cancelling Toggle ON");
		JButton deactivationKey = new JButton("Noise Cancelling Toggle OFF");
		
		activationKey.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				SoundOut.StartSoundOut();
			}
		}));
		
		deactivationKey.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				SoundOut.StopSoundOut();
			}
		}));
		activationKeyPanel.add(activationKey);
		activationKeyPanel.add(deactivationKey);
		
		audioFrame.add(windowTabPanel_audio, BorderLayout.NORTH);
		audioFrame.add(centerPanel, BorderLayout.CENTER);
		audioFrame.add(activationKeyPanel, BorderLayout.SOUTH);
		audioFrame.setVisible(true); //set all elements visible after adding/formatting
		audioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}