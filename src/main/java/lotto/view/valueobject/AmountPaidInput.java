package lotto.view.valueobject;

import lotto.exception.IllegalArgument;

import java.util.regex.Pattern;

public class AmountPaidInput {
    private final Pattern amountPaidPattern = Pattern.compile("^\\d{4,6}$");

    private final String amountPaid;

    public AmountPaidInput(String amountPaid) {
        validateAmountPaid(amountPaid);
        this.amountPaid = amountPaid;
    }

    private void validateAmountPaid(String amountPaid){
        if(amountPaidPattern.matcher(amountPaid).matches()){
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getAmountPaid() {
        return amountPaid;
    }
}
