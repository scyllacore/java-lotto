package lotto.controller.services;

import lotto.model.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoRegister {
    public WinningLotto register(String numbersInput,String bonusNumberInput){
        List<Integer> numbers = convertNumbers(numbersInput);
        int bonusNumber = convertBonusNumber(bonusNumberInput);
        return new WinningLotto(numbers,bonusNumber);
    }

    private List<Integer> convertNumbers(String numbers) {
        return Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int convertBonusNumber(String bonusNumber) {
       return Integer.parseInt(bonusNumber);

    }
}
