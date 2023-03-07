package toysShop.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import toysShop.model.Prize;

public class CsvFileRecorder extends FileRecorder <List<Prize>> {

    @Override
    public void saveToFile(List<Prize> list) {
        try (Writer writer = new FileWriter("toysShop/data/data.csv", false)) {
            writer.write("id; name; amount; dropout frequency\n");
            for (Prize prize : list) {
                writer.write(prize.getId() + "; " +
                        prize.getName() + "; " +
                        prize.getAmount() + "; " +
                        prize.getDropoutFrequency() + "%");
                writer.write("\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveLog(String action, List<Prize> val) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveLog'");
    }

}
