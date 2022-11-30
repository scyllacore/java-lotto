package lotto.view;

import lotto.constants.LottoConstant;
import lotto.constants.PrizeDivision;
import lotto.model.BoughtLottos;
import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static final String AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String STATISTICS_START_MESSAGE = "당첨 통계\n---";
    public static final String DIVISION_MESSAGE = "%s (%,d원) - %d개";
    public static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %,.1f%%입니다.";


    public static void printBoughtLottos(BoughtLottos boughtLottos) {
        printAmountMessage(boughtLottos.getAmount());
        boughtLottos.getBoughtLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static void printAmountMessage(int amount) {
        System.out.println(String.format(AMOUNT_MESSAGE, amount));
    }

    public static void printStatistics(Statistics statistics, BoughtLottos boughtLottos) {
        printStatisticsStartMessage();
        printDivisionData(statistics);
        printRateOfReturnMessage(statistics.calculateRateOfReturn(boughtLottos));
    }

    private static void printDivisionData(Statistics statistics){
        List<PrizeDivision> prizeDivision = Arrays.asList(PrizeDivision.values());

        for (int division = PrizeDivision.FIFTH.ordinal(); division >= PrizeDivision.FIRST.ordinal(); division--) {
            String divisionText = prizeDivision.get(division).getDivisionText();
            int prizeAmount = prizeDivision.get(division).getPrizeAmount();
            int divisionCount = statistics.getDivisionCount(division);

            System.out.println(String.format(DIVISION_MESSAGE, divisionText, prizeAmount, divisionCount));
        }
    }

    private static void printStatisticsStartMessage() {
        System.out.println(STATISTICS_START_MESSAGE);
    }

    private static void printRateOfReturnMessage(double rateOfReturn){
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE,rateOfReturn));
    }
}
