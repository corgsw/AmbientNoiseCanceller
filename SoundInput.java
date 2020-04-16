import javax.sound.sampled.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
 
public class SoundInput {
    // record duration, in milliseconds
    static final long RECORD_TIME = System.currentTimeMillis();  // 1 minute
 
    // path of the wav file
    File wavFile = new File("C:/Test/RecordAudio.wav");
 
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // the line from which audio data is captured
    TargetDataLine line;
 
    /**
     *  audio format
     */
    AudioFormat getAudioFormat() 
    {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
 
    /**
     * Captures the sound and record into a WAV file
     */
    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
 

    public static void main(String[] args) {
        
        final SoundInput recorder = new SoundInput();
 
        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            int aryType;
            public void run() {
                try 
                {
                    Thread.sleep(RECORD_TIME);
                } 
                catch (InterruptedException ex) 
                {
                    ex.printStackTrace();
                }
                
            }
        });
 
        stopper.start();
 
        // start recording
        recorder.start();
    }
}
