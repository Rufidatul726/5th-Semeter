import java.util.List;

public class BoosterMode extends PrintMode{
    @Override
    public void saveToner() {

    }

    @Override
    public void savePage() {

    }

    @Override
    public void boost() {
        setColor_intensity(intensityThreshold());
    }

    public String intensityThreshold(){
        List<String> intensity = List.of("High", "Medium", "low");
        return intensity.get(0);
    }
}
