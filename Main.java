package finalTask;

import java.util.List;
import java.util.Scanner;

import finalTask.model.Machine;
import finalTask.model.Prize;
import finalTask.util.CsvDataReader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine();
        // machine.loadToys();
        // machine.showPrizesList(machine.loadToys());
        // String toyName = scanner.nextLine();
        // machine.getPrize("car");
        // machine.showPrizesList(machine.getPrizes());

        CsvDataReader reader = new CsvDataReader();
        // reader.readFromFile("finalTask/data/data.csv");
        List<Prize> list = reader.readFromFile("finalTask/data/data.csv");
        // machine.showPrizesList(reader.readFromFile("finalTask/data/data.csv"));
        System.out.println();
        for (Prize toy : list){
            System.out.println(toy.getName());
        }

        // Prize prize = new Prize(1,"car", 10, 20);
        // System.out.println(prize.toString());
        scanner.close();
    }
}
