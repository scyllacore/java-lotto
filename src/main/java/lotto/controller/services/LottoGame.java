package lotto.controller.services;

import lotto.model.BoughtLottos;
import lotto.model.WinningLotto;

public class LottoGame {
    public BoughtLottos buyLottos(String amountPaidInput){
        Buying buying = new Buying();
        return buying.buy(amountPaidInput);
    }

    public WinningLotto registerWinningLotto(String numbersInput,String bonusNumberInput){
        WinningLottoRegister winningLottoRegister = new WinningLottoRegister();
        return winningLottoRegister.register(numbersInput,bonusNumberInput);
    }

    public StatisticsCalculator calculateStatistics(BoughtLottos boughtLottos, WinningLotto winningLotto){
        return new StatisticsCalculator(boughtLottos,winningLotto);
    }
}
