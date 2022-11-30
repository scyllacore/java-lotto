package lotto.view.valueobject;

import lotto.exception.IllegalArgument;

import java.util.regex.Pattern;

public class Numbers {
    private final Pattern numbersPattern = Pattern.compile("^(\\d{1,2},){5}(\\d{1,2})$");

    private final String numbers;

    public Numbers(String numbers) {
       validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(String numbers){
        if(numbersPattern.matcher(numbers).matches()){
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getNumbers() {
        return numbers;
    }
}
