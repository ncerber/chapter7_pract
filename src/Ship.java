public class Ship extends Machinerys implements Floating{
    public Ship(String name, int fullFuelTank, int lifting, int consumption) {
        super(name, fullFuelTank, lifting, consumption);
    }

    @Override
    public int mooringTo() {
        return  super.getFullFuelTank() / 100 * mooringToPercent;
    }

    @Override
    public int mooringFrom() {
        return  super.getFullFuelTank() / 100 * mooringFromPercent;
    }

    @Override
    protected int calcNeededFuel(int distance) {
        return super.getConsumption() * (distance/100) + mooringTo() + mooringFrom();
    }
}
