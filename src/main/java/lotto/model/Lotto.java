package lotto.model;

import lotto.constants.LottoConstant;
import lotto.exception.IllegalArgument;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() == LottoConstant.NUMBERS_SIZE) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBER.getMessage());
    }

    private void validateInRange(List<Integer> numbers) {
        if (numbers.stream().allMatch(number -> isNumberInRange(number))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBER.getMessage());
    }

    public static boolean isNumberInRange(int number) {
        return number >= LottoConstant.MIN_NUMBER && number <= LottoConstant.MAX_NUMBER;
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() == numbers.stream().distinct().count()) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBER.getMessage());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
