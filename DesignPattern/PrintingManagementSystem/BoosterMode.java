import java.util.List;

public class BoosterMode extends PrintMode{
    int intensityThreshold;
    int maxIntensity=10;
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

    public int intensityThreshold(){
        maxIntensity= intensityThreshold;
        return intensityThreshold;
    }
}
