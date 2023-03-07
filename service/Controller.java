package toysShop.service;

import java.util.Scanner;

import toysShop.model.PrizeMachineService;

public class Controller {

    public void start() {
        PrizeMachineService service = new PrizeMachineService();
        System.out.println("Welcome to Toy's Store Prizemachine!");
        System.out.println(
                " - For trying to win a prize enter 'start': \n - To load toys enter'load': \n - To change dropout frequency enter 'chage':\n - To exit enter 'exit':");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        switch (command) {
            case "start":
                service.getPrize(scanner);
                System.out.println("Thank you for choosing our store!");
                break;
            case "load":
                service.loadToys(scanner);
                System.out.println("Toys successfully loaded to machine!");
                break;
            case "change":
                service.changeDropoutFrequency(scanner);
                System.out.println("Dropout frequency was changed");

            default:
                scanner.close();
                break;
        }
    }
}
