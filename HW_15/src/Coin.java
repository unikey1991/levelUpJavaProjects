/**
 * Created by java on 23.12.2016.
 */
public class Coin {
    private double weight;
    private double diametr;

    public Coin(double diametr, double weight) throws CoinLogicException {
        if (diametr < 0) throw new CoinLogicException("ne, hernya, bratan");
        this.diametr = diametr;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getDiametr() {
        return diametr;
    }

    public void setDiametr(int diametr) {
        this.diametr = diametr;
    }
}
