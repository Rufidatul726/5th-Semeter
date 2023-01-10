public class HighTonerSaver implements ITonerSaverMode {
    TonerSaverMode tonerSaverMode;

    public int executeTonerSaver(String tonerSavingLevel) {
        //color intensity is reduced by following another well-known standard algorithm
        tonerSaverMode.setColor_intensity(tonerSaverMode.getColor_intensity() - 1);
        return tonerSaverMode.getColor_intensity();
    }
}
