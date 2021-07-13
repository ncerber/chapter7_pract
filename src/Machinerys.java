public abstract class Machinerys {
    private String name;

    private int fuelTank;
    private final int fullFuelTank;
    private int consumption;

    private int lifting;
    private final int maxLifting;

    public Machinerys(String name, int fullFuelTank, int lifting, int consumption) {
        this.name = name;
        this.fullFuelTank = fullFuelTank;
        this.fuelTank = fullFuelTank;
        this.maxLifting = lifting;
        this.lifting = 0;
        this.consumption = consumption;
    }

    public int getFullFuelTank() {
        return fullFuelTank;
    }

    public int getMaxLifting() {
        return maxLifting;
    }

    public int getConsumption() {
        return consumption;
    }

    protected void decFromFuelTank(int decValue){
        fuelTank-=decValue;
        if(fuelTank<0){
            fuelTank = 0;
        }
    }

    public void addToFuelTank(int addValue){
        fuelTank+=addValue;
        if(fuelTank>fullFuelTank){
            fuelTank = fullFuelTank;
        }
    }

    public void loadingWeight(int weight){
        lifting+=weight;
        if(lifting>maxLifting){
            lifting = maxLifting;
        }
    }
    public void loadingAll(){
        lifting = maxLifting;
    }

    public void move(int[][] points){
        int distance = getDistance(points);
        if(checkDistance(distance)){
            fuelTank -= calcNeededFuel(distance);
        } else {
            //Выведем сообщение, хотя по хорошему нужно бы сгенерировать исключение
            System.out.println(name+": недостаточно топлива для совершения рейса, требуется топлива "+calcNeededFuel(distance)+", а есть в баке "+fuelTank);
        }
    }

    private int getDistance(int[][] points) {
        int x1 = points[0][0];
        int x2 = points[1][0];
        int y1 = points[0][1];
        int y2 = points[1][1];

        int degreeX = (int) Math.pow((double) (x2-x1),2);
        int degreeY = (int) Math.pow((double) (y2-y1),2);

        int res = (int) Math.floor(Math.sqrt((double) (degreeX+degreeY)));
        return res;
    }

    protected boolean checkDistance(int distance){
        int neededFuel = calcNeededFuel(distance);
        if(neededFuel<=fuelTank) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Machinerys{" +
                "name='" + name + '\'' +
                ", fuelTank=" + fuelTank +
                ", fullFuelTank=" + fullFuelTank +
                ", consumption=" + consumption +
                ", lifting=" + lifting +
                ", maxLifting=" + maxLifting +
                '}';
    }

    protected abstract int calcNeededFuel(int distance);
}
