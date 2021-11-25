public class Person {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        setPhoneNumber(phoneNumber);
    }

    public Person() {
        name = null;
        phoneNumber = null;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() < 7 || phoneNumber.length() > 10) {
            System.out.println("Phone number must be between 7 and 10 digits");
            System.exit(1);
        }
        else if (phoneNumber.length() == 10 && phoneNumber.charAt(0) != '0') {
            System.out.println("Phone number must start with 0");
            System.exit(1);
        }
        else {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
