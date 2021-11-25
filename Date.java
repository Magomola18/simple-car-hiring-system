import java.time.LocalDate;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValid() {
        try {
            LocalDate date = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now();

            if(date.isBefore(currentDate)) {
                return false;
            }

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
