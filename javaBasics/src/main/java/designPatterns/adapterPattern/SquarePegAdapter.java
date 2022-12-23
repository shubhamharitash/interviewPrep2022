package designPatterns.adapterPattern;

public class SquarePegAdapter extends RoundPeg{
    SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        super((int)((Math.sqrt(2) * squarePeg.getWidth()) / 2));
        this.squarePeg = squarePeg;
    }
}
