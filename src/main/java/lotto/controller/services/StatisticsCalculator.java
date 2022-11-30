package lotto.controller.services;

import lotto.constants.LottoConstant;
import lotto.constants.PrizeDivision;
import lotto.model.BoughtLottos;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatisticsCalculator {
    private Statistics statistics;

    public StatisticsCalculator(BoughtLottos boughtLottos, WinningLotto winningLotto) {
        this.statistics = new Statistics(calculateStatistics(boughtLottos, winningLotto));
    }

    private List<Integer> calculateStatistics(BoughtLottos boughtLottos, WinningLotto winningLotto) {
        List<Integer> divisionData = new ArrayList<>(Collections.nCopies(LottoConstant.DIVISION_SIZE, 0));

        for (Lotto boughtLotto : boughtLottos.getBoughtLottos()) {
            int division = rank(winningLotto.countMatching(boughtLotto), winningLotto.countBonus(boughtLotto));
            countDivision(divisionData, division);
        }
        return divisionData;
    }

    private int rank(int matchingCount, int bonusCount) {
        List<PrizeDivision> prizeDivision = Arrays.asList(PrizeDivision.values());

        for (PrizeDivision division : prizeDivision) {
            if (division.getMatchingCount() == matchingCount && division.getBonusCount() <= bonusCount) {
                return division.ordinal();
            }
        }
        return PrizeDivision.MISS.ordinal();
    }

    private void countDivision(List<Integer> divisionData, int division) {
        if (division != 0) {
            divisionData.set(division, divisionData.get(division) + 1);
        }
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
