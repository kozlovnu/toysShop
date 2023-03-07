package toysShop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import toysShop.util.CsvDataReader;
import toysShop.util.CsvFileRecorder;
import toysShop.util.TxtlogFileRecorder;

public class PrizeMachineService {
    private List<Prize> prizeList;

    public PrizeMachineService() {
        this.prizeList = new ArrayList<>();
    }

    public List<Prize> loadToys(Scanner iScanner) {
        prizeList = new CsvDataReader().readFromFile("toysShop/data/data.csv");
        int id = 0;
        if (!prizeList.isEmpty()) {
            id = prizeList.get(prizeList.size() - 1).getId();
        }
        System.out.println("How many toys you want to load?");
        int count = iScanner.nextInt();
        for (int i = 1; i <= count; i++) {
            id += 1;
            System.out.println("Enter name of toy:");
            iScanner.nextLine();
            String name = iScanner.nextLine();

            System.out.println("Enter amount of toys:");
            int amount = iScanner.nextInt();

            System.out.println("Enter toys dropout frequency:");
            float dropoutFrequency = iScanner.nextFloat();
            int index = -1;
            boolean flag = false;
            if (!prizeList.isEmpty()) {
                for (Prize toy : prizeList) { 
                    index += 1; 
                    if (name.equals(toy.getName())) {
                        
                        id = toy.getId();
                        amount = toy.getAmount() + amount;
                        flag = true;
                    } 
                }
            }
            if (flag == true){
                prizeList.remove(index);
            }
            prizeList.add(new Prize(id, name, amount, dropoutFrequency));
            
        }
        sortList(prizeList);
        CsvFileRecorder recorder = new CsvFileRecorder();
        recorder.saveToFile(prizeList);
        return prizeList;
    }

    public List<Prize> getPrize(Scanner iScanner) {
        List<Prize> prizeList = new CsvDataReader().readFromFile("toysShop/data/data.csv");
        System.out.println("Chose the prize from list below:");
        showPrizesList(prizeList);
        // iScanner.nextLine();
        String name = iScanner.nextLine();
        for (Prize toy : prizeList) {
            if (name.equals(toy.getName())) {
                int chance = new Random().nextInt(1, 101);
                if (toy.getDropoutFrequency() >= chance) {
                    System.out.printf("Congratulations! You won %s\n", toy.getName());
                    toy.setAmount(toy.getAmount() - 1);
                    new TxtlogFileRecorder().saveToFile(toy);
                } else {
                    System.out.printf("Oops.. Maybe next time.\n");
                }
            }
        }
        sortList(prizeList);
        new CsvFileRecorder().saveToFile(prizeList);
        return prizeList;
    }

    public List<Prize> changeDropoutFrequency(Scanner iScanner){
        prizeList = new CsvDataReader().readFromFile("toysShop/data/data.csv");
        if (!prizeList.isEmpty()) {
            System.out.println("Enter toy name to change dropout frequency: ");
            String name = iScanner.nextLine();
            System.out.println("Enter new dropout frequency: ");
            Float dropoutFrequency = iScanner.nextFloat();
            int index = -1;
            for (Prize toy : prizeList){
                index +=1;              
                if (name.equals(toy.getName())){
                    prizeList.get(index).setDropoutFrequency(dropoutFrequency);
                }
            }
        }
        else{
            System.out.println("Oops.. Prize machine is empty");
        }
        new CsvFileRecorder().saveToFile(prizeList);
        return prizeList;
    }

    public List<Prize> sortList(List<Prize> list){
        // Prize maxId = list.get(0);
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size()-1; j++){
                if (list.get(j).getId() > list.get(j+1).getId()){
                    Prize temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return list;
    }

    // Перенести во viewer
    public void showPrizesList(List<Prize> prizes) {
        for (Prize toy : prizes) {
            System.out.println("toy = " + toy.getName() 
                                + ", amout = " + toy.getAmount()
                                + ", dropout freqency = " + toy.getDropoutFrequency());
        }

    }
}
