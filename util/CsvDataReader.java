package finalTask.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import finalTask.model.Prize;

public class CsvDataReader extends DataReader<Prize> {

    @Override
    public List<Prize> readFromFile(String file) {
        List<Prize> prizes = new ArrayList<>();
        boolean firstLine = true;
        File csvFile = new File(file);
        if (csvFile.isFile()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    String[] str = line.split("; | |%");
                    prizes.add(new Prize(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]),
                            Float.parseFloat(str[3])));

                }
                br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return prizes;

    }

}
