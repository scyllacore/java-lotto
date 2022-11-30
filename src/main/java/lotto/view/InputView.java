package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.valueobject.AmountPaid;
import lotto.view.valueobject.BonusNumber;
import lotto.view.valueobject.Numbers;

public class InputView {
    private static final String AMOUNT_PAID_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String readAmountPaid() {
        printAmountPaidInputMessage();
        return new AmountPaid(input()).getAmountPaid();
    }

    private static void printAmountPaidInputMessage() {
        System.out.println(AMOUNT_PAID_INPUT_MESSAGE);
    }

    public static String readNumbers() {
        printNumbersInputMessage();
        return new Numbers(input()).getNumbers();
    }

    private static void printNumbersInputMessage() {
        System.out.println(NUMBERS_INPUT_MESSAGE);
    }

    public static String readBonusNumber() {
        printBonusNumberInputMessage();
        return new BonusNumber(input()).getBonusNumber();
    }

    private static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static String input() {
        return Console.readLine();
    }
}
