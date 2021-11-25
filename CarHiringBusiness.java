import java.util.ArrayList;
import java.util.Scanner;

public class CarHiringBusiness {
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    void menuSeparator() {
        System.out.println("=======================\n");
    }

    void backToMainMenu() {
        System.out.println("99. Return to Main Menu");
    }

    void selectionPrompt(){
        System.out.print("Your selection: ");
    }

    void invalidInputMessage() {
        System.out.println("Input cannot be blank or empty");
    }

    void mainMenu() {
        System.out.println("Main Menu");
        menuSeparator();
        System.out.println("(1) Cars");
        System.out.println("(2) People");
        System.out.println("(3) Transactions");
        System.out.println("(4) Exit");
        selectionPrompt();
        int selectedMenu = scanner.nextInt();

        switch (selectedMenu) {
            case 1:
                carsMenu();
                break;
            case 2:
                peopleMenu();
                break;
            case 3:
                transactionMenu();
                break;
            default:
                System.exit(0);
        }
    }

    //Cars

    void carsMenu() {
        System.out.println("Cars Menu");
        menuSeparator();
        System.out.println("1. Add new car");
        System.out.println("2. View Available Cars");
        System.out.println("3. View Hired Cars");
        System.out.println("4. Search For Specific Car");
        backToMainMenu();
        selectionPrompt();

        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                addCar();
                break;
            case 2:
                printCars(false);
                break;
            case 3:
                printCars(true);
                break;
            case 4:
                searchCars();
                break;
            case 99:
                mainMenu();
                break;

        }
    }

    void addCar() {
        System.out.println("Add new car");
        menuSeparator();
        System.out.print("Car type: ");

        String type = scanner.next();

        if(isBlankOrEmpty(type)) {
            invalidInputMessage();
            addCar();
        }
        else {
            cars.add(new Car(type));
            System.out.println("Car successfully added\n");
            carsMenu();
        }
    }

    void printCars(boolean onlyHired) {
        cars.forEach(car -> {
            if(onlyHired && car.isHired()) {
                System.out.println(car.toString());
            }
            else if (!car.isHired()) {
                System.out.println(car.toString());
            }
        });
    }

    void searchCars() {
        System.out.println("Search Cars");
        menuSeparator();
        System.out.println("Enter car type: ");

        String type = scanner.next();

        cars.forEach(car -> {
            if(car.getCarType().equals(type)) {
                System.out.println(car.toString());
            }
        });
    }


    //People

    void peopleMenu() {
        System.out.println("People Menu");
        menuSeparator();
        System.out.println("1. Add new person");
        System.out.println("2. View All People");
        backToMainMenu();

        selectionPrompt();

        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                addPerson();
                break;
            case 2:
                printPeople();
                break;
            case 99:
                mainMenu();
                break;

        }
    }

    void addPerson() {
        System.out.println("Add new person");
        menuSeparator();
        System.out.print("Name: ");

        String name = scanner.next();

        System.out.println();

        System.out.print("Phone:");

        String phone = scanner.next();

        if(isBlankOrEmpty(name) || isBlankOrEmpty(phone)) {
            invalidInputMessage();
            addPerson();
        }
        else {
            people.add(new Person(name, phone));
            System.out.println("Person successfully added\n");
            peopleMenu();
        }
    }

    void printPeople() {
        people.forEach(person -> {
            System.out.println(person.toString());
        });
    }

    void transactionMenu() {
        System.out.println("Transaction Menu");
        menuSeparator();
        System.out.println("1. Hire a car");
        System.out.println("2. View All Transactions");
        backToMainMenu();
        selectionPrompt();

        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                hireCar();
                break;
            case 2:
                printTransactions();
                break;
            case 99:
                mainMenu();
                break;

        }
    }

    void hireCar() {
        System.out.println("Hire A Car");
        menuSeparator();
        System.out.println("Select car to hire\n");
        for(int i = 0; i < cars.size(); i++) {
            if(!cars.get(i).isHired()) {
                System.out.println("(" + i + ") " + cars.get(i).toString() );
            }
        }
        selectionPrompt();
        int carIndex = scanner.nextInt();

        System.out.println("Select hirer\n");

        for(int i = 0; i < people.size(); i++) {
            System.out.println("(" + i + ") " + people.get(i).toString());
        }

        selectionPrompt();
        int personIndex = scanner.nextInt();

        System.out.println("Enter date\n");

        System.out.print("Day: ");
        int day = scanner.nextInt();

        System.out.print("Month: ");
        int month = scanner.nextInt();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        Date date = new Date(day, month, year);

        if(date.isValid()) {
            cars.get(carIndex).setHired();

            transactions.add(new Transaction(people.get(personIndex), cars.get(carIndex), date));

            System.out.println("Transaction completed");

            transactionMenu();
        }
    }

    void printTransactions() {
        transactions.forEach(trans -> {
            System.out.println(trans.toString());
        });
    }

    public static void main(String[] args) {
        CarHiringBusiness d = new CarHiringBusiness();
        d.mainMenu();
    }

    private boolean isBlankOrEmpty(String input) {
        if (input.length() == 0 || input == null) {
            return true;
        }

        return false;
    }
}
