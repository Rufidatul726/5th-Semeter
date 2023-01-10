import java.util.Collections;
import java.util.List;

public class TonerSaverMode extends PrintMode{
    private List<String> tonerSavingLevel = List.of("High", "Medium", "Low");
    private int color_intensity;
    private ITonerSaverMode iTonerSaverMode;

    public void saveToner(ITonerSaverMode iTonerSaverMode) {   //long method
        this.iTonerSaverMode = iTonerSaverMode;
    }

    public int executeTonerSaver(String tonerSavingLevel) {
        iTonerSaverMode.executeTonerSaver(tonerSavingLevel);
        return 0;
    }

    public int getColor_intensity() {
        return color_intensity;
    }

    public void setColor_intensity(int color_intensity) {

        this.color_intensity = color_intensity;
    }

    public String getTonerSavingLevel() {
        return tonerSavingLevel.toString();
    }

    public void setTonerSavingLevel(String tonerSavingLevel) {
        this.tonerSavingLevel = Collections.singletonList(tonerSavingLevel);
    }

}


