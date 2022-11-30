package lotto.model;

import lotto.exception.IllegalArgument;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private Set<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = new HashSet<>(new Lotto(numbers).getNumbers());
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateInRange(bonusNumber);
        validateDuplication(bonusNumber);
    }

    private void validateInRange(int bonusNumber) {
        if (Lotto.isNumberInRange(bonusNumber)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBER.getMessage());
    }

    private void validateDuplication(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBER.getMessage());
        }
    }

    public int countMatching(Lotto boughtLotto) {
        return (int) boughtLotto.getNumbers().stream()
                .filter(number -> numbers.contains(number))
                .count();

        /*
        int MatchingCount = 0;

        for (int number : boughtLotto.getNumbers()) {
            if (numbers.contains(number)) {
                MatchingCount++;
            }
        }
        return MatchingCount;
        */
    }

    public int countBonus(Lotto boughtLotto) {
        return (int) boughtLotto.getNumbers().stream()
                .filter(number -> number == bonusNumber)
                .count();

        /*
        if (boughtLotto.getNumbers().contains(bonusNumber)) {
            return 1;
        }
        return 0;
        */
    }
}
