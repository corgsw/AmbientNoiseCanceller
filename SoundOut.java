import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;

public class SoundOut {
    static boolean exit=false;
    static float pan=0;
    static AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
    public static void soundtest() {
        try {
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            final TargetDataLine target = (TargetDataLine) AudioSystem.getLine(info);
            target.open();

            info = new DataLine.Info(SourceDataLine.class, format);
            final SourceDataLine source = (SourceDataLine) AudioSystem.getLine(info);
            source.open();

            final ByteArrayOutputStream out = new ByteArrayOutputStream();

            Thread monitorThread = new Thread() {
                @Override
                public void run() {
                    while (!exit) {
                        target.start();
                        source.start();
                        int readBytes;
                        short inverse;
                        byte[] data = new byte[target.getBufferSize()];
                        FloatControl panorama = (FloatControl) source.getControl(FloatControl.Type.PAN);
                        panorama.setValue(pan);
                        while (true) {
                            readBytes = target.read(data, 0, data.length);
                            for (int i = 0; i < readBytes; i += 2) {
                                inverse = (short) -((short) (data[i + 1] << 8 | data[i] & 0xff));
                                System.out.println(inverse / 100);
                                data[i] = (byte) (inverse & 0xff);
                                data[i + 1] = (byte) ((inverse >> 8) & 0xff);
                            }
                            source.write(data, 0, readBytes);
                        }
                    }
                }
            };

            monitorThread.start();
            Thread.sleep(0);


        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
        }
    }

    public static void StopSoundOut(){
        exit=true;
    }
    public static void StartSoundOut(){
        exit=false;
        soundtest();
    }
    public void setPan(int p){
        pan=p;
    }

}