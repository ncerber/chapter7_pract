public abstract class Machinerys {
    private String name;

    private int fuelTank;
    private int fullFuelTank;

    private int lifting;
    private int maxLifting;


    public Machinerys(String name, int fullFuelTank, int lifting) {
        this.name = name;
        this.fullFuelTank = fullFuelTank;
        this.fuelTank = fullFuelTank;
        this.maxLifting = lifting;
        this.lifting = 0;
    }

    public void decFromFuelTank(int decValue){
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

    public abstract void move(int[][] points);

}
