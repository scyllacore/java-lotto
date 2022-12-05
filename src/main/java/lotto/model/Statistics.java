package lotto.model;

import lotto.constants.PrizeDivision;

import java.util.Arrays;
import java.util.List;

public class Statistics {
    private final List<Integer> divisionData;

    public Statistics(List<Integer> divisionData) {
        //validateDivisionData(divisionData);
        this.divisionData = divisionData;
    }

    /*
    private void validateDivisionData(List<Integer> divisionData) {
        validateSize(divisionData);
        validateZeroIndex(divisionData);
    }

    private void validateSize(List<Integer> divisionData) {
        if (divisionData.size() == LottoConstant.DIVISION_SIZE) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_DIVISION_DATA.getMessage());
    }

    private void validateZeroIndex(List<Integer> divisionData) {
        if (divisionData.get(PrizeDivision.MISS.ordinal()) == 0) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_DIVISION_DATA.getMessage());
    }*/

    public double calculateRateOfReturn(BoughtLottos boughtLottos) {
        double rateOfReturn = (double) accumulatePrizeAmount() / boughtLottos.getAmountPaid();
        return (double) Math.round(rateOfReturn * 1000) / 10;
    }

    private long accumulatePrizeAmount() {
        /*
        long prizeAmountSummation = 0;

        for (PrizeDivision division : PrizeDivision.values()) {
            prizeAmountSummation += division.getPrizeAmount() * getDivisionCount(division.ordinal());
        }
        return prizeAmountSummation;
        */

        return Arrays.stream(PrizeDivision.values())
                .mapToLong(this::calculatePrizeAmount)
                .sum();
    }

    private long calculatePrizeAmount(PrizeDivision division){
        return division.getPrizeAmount() * getDivisionCount(division.ordinal());
    }

    public int getDivisionCount(int division) {
        return divisionData.get(division);
    }
}

