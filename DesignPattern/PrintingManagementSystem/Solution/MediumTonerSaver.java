public class MediumTonerSaver implements ITonerSaverMode {
    TonerSaverMode tonerSaverMode;

    public int executeTonerSaver(String tonerSavingLevel) {
        //color intensity is reduced by following another well-known standard algorithm
        return tonerSaverMode.getColor_intensity();
    }
}
