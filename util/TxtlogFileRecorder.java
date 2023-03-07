package finalTask.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import finalTask.model.Prize;

public class TxtlogFileRecorder extends FileRecorder <Prize> {

    @Override
    public void saveToFile(Prize prize) {
        DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try (Writer writer = new FileWriter("finalTask/data/log.txt", true)) {
            // writer.write("id; name; amount; dropout frequency\n");
                writer.write(dateF.format(cal.getTime()) + "; " +
                        prize.getId() + "; " +
                        prize.getName() + "; " +
                        prize.getAmount() + "; " +
                        prize.getDropoutFrequency() + "%");
                
                writer.write("\n");
            
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void saveLog(String action, Prize prize) {
        DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try (Writer writer = new FileWriter("finalTask/data/log.txt", true)) {
                writer.write(dateF.format(cal.getTime()) + "; " +
                        action + "; " +
                        prize.getId() + "; " +
                        prize.getName() + "; " +
                        prize.getAmount() + "; " +
                        prize.getDropoutFrequency() + "%");
                
                writer.write("\n");
            
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }        
        throw new UnsupportedOperationException("Unimplemented method 'saveLog'");
    }


    
}
