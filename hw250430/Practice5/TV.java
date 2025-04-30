package hw250430.Practice5;

public class TV extends Controller{
    @Override
    String getName() {
        return "TV";
    }

    public TV (boolean power) {
        super(power);
    }
}
