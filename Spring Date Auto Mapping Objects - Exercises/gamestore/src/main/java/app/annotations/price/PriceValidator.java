package app.annotations.price;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/26/2017.
 */
public class PriceValidator implements ConstraintValidator<Price, BigDecimal> {
    int digits;

    @Override
    public void initialize(Price price) {
        this.digits = price.digitsAfterDecPlate();
    }

    private int getDigitsAfterDecPlate(String price) {
        String[] split = price.split("\\.");
        return split[1].length();
    }

    @Override
    public boolean isValid(BigDecimal s, ConstraintValidatorContext constraintValidatorContext) {
        if (getDigitsAfterDecPlate(s.toString()) != this.digits && getDigitsAfterDecPlate(s.toString()) != 1) {
            return false;
        }
        return true;
    }
}
