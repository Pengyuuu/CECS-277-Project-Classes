public class Balance {

    private double bal;

    public Balance(){

        bal = 0.0;
    }

    public double getBal(){

        return bal;
    }

    public void setBal(){

        bal = 0.0;
    }

    public void setBal(double coin){

        bal += coin;
    }
}
