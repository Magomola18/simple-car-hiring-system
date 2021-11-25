public class Transaction {
    private Person aPerson;
    private Car aCar;
    private Date dateToHire;

    public Transaction(Person person, Car car, Date date) {
        aPerson = person;
        aCar = car;
        dateToHire = date;
    }

    @Override
    public String toString() {
        return "Hirer: " + aPerson.toString() + " | " +
                "Car: " + aCar.toString() + " | " +
                "Date: " + dateToHire.toString();
    }
}
