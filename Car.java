public class Car {
    private String carType;
    private boolean isHired;

    public Car(String type) {
        carType = type;
        isHired = false;
    }

    public String getCarType() {
        return carType;
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired() {
        isHired = true;
    }

    @Override
    public String toString() {
        return carType + " - " + (isHired ? "Hired" : "Available");
    }
}
