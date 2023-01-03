import java.util.List;

public class TonerSaveMode extends PrintMode{

    private String tonerSavingLevel;

    @Override
    public void saveToner() {   //long method
        int colorIntensity;

        if(tonerSavingLevel=="High"){
            colorIntensity=this.getColor_intensity();
            colorIntensity--;
            setColor_intensity(colorIntensity);
            //color intensity is reduced by following a well-known standard algorithm
        }
        else if(tonerSavingLevel=="Medium"){
            //color intensity is reduced by following another well-known standard algorithm
        }
        else if(tonerSavingLevel=="Low"){
            //color intensity is reduced by following another one well-known standard algorithm
        }
    }

    @Override
    public void savePage() {

    }

    @Override
    public void boost() {

    }



}
