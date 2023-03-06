package finalTask.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import finalTask.util.CsvFileRecorder;

public class PrizeMachine {
    private List<Prize> prizes;

    public PrizeMachine() {
        this.prizes = new ArrayList<>();
    }

    public List<Prize> addToysList(List <Prize> list){
        for (Prize prize : list){
            prizes.add(prize);
        }
        return prizes;
    }

    // Это переехало в service
    public List<Prize> loadToys() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many toys you want to load?");
        int count = scanner.nextInt();
        for (int i = 1; i <= count; i++) {
            int id = i;
            System.out.println("Enter name of toy:");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.println("Enter amount of toys:");
            int amount = scanner.nextInt();

            System.out.println("Enter toys dropout frequency:");
            float dropoutFrequency = scanner.nextFloat();
            prizes.add(new Prize(id, name, amount, dropoutFrequency));
        }
        scanner.close();
        CsvFileRecorder recorder = new CsvFileRecorder();
        recorder.saveToFile(prizes);
        return prizes;
    }
    // И это тоже переехало
    public List<Prize> getPrize(String toyName){
        // Scanner iscanner = new Scanner(System.in);
        System.out.println("Chose the prize from list below:");
        showPrizesList(prizes);
        String name = toyName;
        for (Prize toy : prizes){
            if (name.equals(toy.getName())){
                int chance = new Random().nextInt(1,101);
                if (toy.getDropoutFrequency() <= chance){
                    System.out.printf("Congratulations! You won %s", toy.getName());
                    toy.setAmount(toy.getAmount()-1);
                }
            }
        }
        // iscanner.close();

        return prizes;
    }

   
    public void showPrizesList(List<Prize> prizes) {
        for (Prize toy : prizes){
            System.out.println(toy.getName());
            System.out.println();
        }
        
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    
}
