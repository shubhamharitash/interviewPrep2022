package designPatterns.adapterPattern;

public class RoundHole {
    private final int radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return radius >= roundPeg.getRadius();
    }
}
