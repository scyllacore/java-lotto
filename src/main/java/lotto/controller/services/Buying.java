package lotto.controller.services;

import lotto.constants.LottoConstant;
import lotto.exception.IllegalArgument;
import lotto.model.BoughtLottos;

public class Buying {
    public BoughtLottos buy(String amountPaidInput) {
        int amountPaid = Integer.parseInt(amountPaidInput);
        validateAmountPaid(amountPaid);
        return new BoughtLottos(amountPaid);
    }

    private void validateAmountPaid(int amountPaid) {
        validateInRange(amountPaid);
        validateRemainder(amountPaid);
    }

    private void validateInRange(int amountPaid) {
        if (isAmountPaidInRange(amountPaid)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_AMOUNT_PAID.getMessage());
    }

    private boolean isAmountPaidInRange(int amountPaid){
        return amountPaid >= LottoConstant.LOTTO_PRICE && amountPaid <= LottoConstant.MAX_AMOUNT_PAID;
    }

    private void validateRemainder(int amountPaid) {
        if (amountPaid % LottoConstant.LOTTO_PRICE == 0) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_AMOUNT_PAID.getMessage());
    }
}
