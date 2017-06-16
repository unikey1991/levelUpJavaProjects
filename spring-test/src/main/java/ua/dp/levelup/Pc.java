package ua.dp.levelup;

/**
 * Created by java on 16.06.2017.
 */
public class Pc {

    private long hddCapacity;
    private long ram;
    private User owner;

    public Pc() {
    }



    public Pc(long hddCapacity, long ram, User owner) {

        this.hddCapacity = hddCapacity;
        this.ram = ram;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "hddCapacity=" + hddCapacity +
                ", ram=" + ram +
                ", owner='" + owner + '\'' +
                '}';
    }

    public long getHddCapacity() {
        return hddCapacity;
    }

    public void setHddCapacity(long hddCapacity) {
        this.hddCapacity = hddCapacity;
    }

    public long getRam() {
        return ram;
    }

    public void setRam(long ram) {
        this.ram = ram;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
