public class Plane extends Machinerys implements Flying {
    @Override
    protected int calcNeededFuel(int distance) {
        return super.getConsumption() * (distance/100) + takeOff() + planeLanding();
    }

    @Override
    public int takeOff() {
        return super.getFullFuelTank() / 100 * takeOffPercent;
    }

    @Override
    public int planeLanding() {
        return super.getFullFuelTank() / 100 * planeLandingPercent;
    }

    public Plane(String name, int fullFuelTank, int lifting, int consumption) {
        super(name, fullFuelTank, lifting, consumption);
    }
}
