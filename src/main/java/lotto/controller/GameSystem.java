package lotto.controller;

import lotto.controller.services.LottoGame;
import lotto.controller.services.StatisticsCalculator;
import lotto.model.BoughtLottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameSystem {
    private LottoGame lottoGame;

    public void runGame() {
        try {
            loadLottoGame();
            BoughtLottos boughtLottos = proceedBuying();
            WinningLotto winningLotto = proceedWinningLottoRegister();
            runStatisticsCalculator(boughtLottos, winningLotto);
        } catch (IllegalArgumentException error) {
            System.out.print(error.getMessage());
        }
    }

    private void loadLottoGame() {
        lottoGame = new LottoGame();
    }

    private BoughtLottos proceedBuying() {
        BoughtLottos boughtLottos = lottoGame.buyLottos(InputView.readAmountPaid());
        OutputView.printBoughtLottos(boughtLottos);
        return boughtLottos;
    }

    private WinningLotto proceedWinningLottoRegister() {
        String numbersInput = InputView.readNumbers();
        String bonusInput = InputView.readBonusNumber();
        return lottoGame.registerWinningLotto(numbersInput, bonusInput);
    }

    private void runStatisticsCalculator(BoughtLottos boughtLottos, WinningLotto winningLotto) {
        StatisticsCalculator statisticsResult = lottoGame.calculateStatistics(boughtLottos, winningLotto);
        OutputView.printStatistics(statisticsResult.getStatistics(), boughtLottos);
    }
}
