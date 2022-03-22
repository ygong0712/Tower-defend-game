package activities.m2;

public class Tower {

    private String type;
    private int cost;

    public Tower(String totype, int tocost) {
        type = totype;
        cost = tocost;
    }

    public Tower() {
        type = "small";
        cost = 100;
    }
}