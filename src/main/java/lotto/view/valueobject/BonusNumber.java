package lotto.view.valueobject;

import lotto.exception.IllegalArgument;

import java.util.regex.Pattern;

public class BonusNumber {
    private final Pattern bonusNumberPattern = Pattern.compile("^\\d{1,2}$");

    private final String bonusNumber;

    public BonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(String bonusNumber){
        if(bonusNumberPattern.matcher(bonusNumber).matches()){
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
