package lotto.controller;

import lotto.controller.services.StatisticsCalculator;
import lotto.model.BoughtLottos;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsCalculatorTest {
    private WinningLotto winningLotto;

    static Stream<Arguments> createBoughtLottos() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        Arrays.asList(1, 2, 3, 8, 9, 10),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 7),
                        Arrays.asList(1, 2, 3, 7, 41, 42)
                ))
        );
    }

    @BeforeEach
    void 당첨_번호_객체_생성() {
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("통계 산출을 위한 번호 비교 진행.")
    @ParameterizedTest
    @MethodSource("createBoughtLottos")
    void 통계_산출을_위한_번호_비교(List<List<Integer>> numbers) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    BoughtLottos boughtLottos = new BoughtLottos(4000);
                    StatisticsCalculator statisticsCalculator = new StatisticsCalculator(boughtLottos, winningLotto);
                    Statistics statistics = statisticsCalculator.getStatistics();

                    assertThat(statistics.getDivisionCount(5)).isEqualTo(2);
                    assertThat(statistics.getDivisionCount(2)).isEqualTo(1);
                    assertThat(statistics.getDivisionCount(1)).isEqualTo(1);

                }, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3)
        );
    }
}
