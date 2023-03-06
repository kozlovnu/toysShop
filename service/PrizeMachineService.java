package finalTask.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import finalTask.model.Prize;
import finalTask.model.PrizeMachine;
import finalTask.util.CsvDataReader;
import finalTask.util.CsvFileRecorder;

public class PrizeMachineService {
    private List<Prize> prizeList;
    private PrizeMachine prizeMachine;
    // private Scanner scanner = new Scanner(System.in);

    public PrizeMachineService() {
        this.prizeList = new ArrayList<>();
    }

    public List<Prize> addToy(Scanner iScanner){
        List<Prize> prizeList = new CsvDataReader().readFromFile("finalTask/data/data.csv");
        int id = 1;
        if (!prizeList.isEmpty()){
            id = prizeList.get(prizeList.size()-1).getId()+1;
        }
        System.out.println("Enter name of toy:");
            iScanner.nextLine();
            String name = iScanner.nextLine();

            System.out.println("Enter amount of toys:");
            int amount = iScanner.nextInt();

            System.out.println("Enter toys dropout frequency:");
            float dropoutFrequency = iScanner.nextFloat();
            prizeList.add(new Prize(id, name, amount, dropoutFrequency));

        return prizeList;
    }

    public List<Prize> loadToys(Scanner iScanner) {
        System.out.println("How many toys you want to load?");
        int count = iScanner.nextInt();
        for (int i = 1; i <= count; i++) {
            int id = i++;
            System.out.println("Enter name of toy:");
            iScanner.nextLine();
            String name = iScanner.nextLine();

            System.out.println("Enter amount of toys:");
            int amount = iScanner.nextInt();

            System.out.println("Enter toys dropout frequency:");
            float dropoutFrequency = iScanner.nextFloat();
            prizeList.add(new Prize(id, name, amount, dropoutFrequency));
        }
        CsvFileRecorder recorder = new CsvFileRecorder();
        recorder.saveToFile(prizeList);
        return prizeList;
    }

    public List<Prize> getPrize(Scanner iScanner) {
        // Scanner iscanner = new Scanner(System.in);
        List<Prize> prizeList = new CsvDataReader().readFromFile("finalTask/data/data.csv");
        System.out.println("Chose the prize from list below:");
        showPrizesList(prizeList);
        iScanner.nextLine();
        String name = iScanner.nextLine();
        for (Prize toy : prizeList) {
            if (name.equals(toy.getName())) {
                int chance = new Random().nextInt(1, 101);
                System.out.println(chance);
                if (toy.getDropoutFrequency() >= chance) {
                    System.out.printf("Congratulations! You won %s\n", toy.getName());
                    toy.setAmount(toy.getAmount() - 1);
                } else {
                    System.out.printf("Oops.. Maybe next time.\n");
                }
            }
        }
        new CsvFileRecorder().saveToFile(prizeList);

        return prizeList;
    }

    public void showPrizesList(List<Prize> prizes) {
        for (Prize toy : prizes) {
            System.out.println(toy.getName());
        }

    }
}
