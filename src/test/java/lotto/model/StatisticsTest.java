package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("통계 객체에는 수익률을 계산하는 기능이 있다.")
public class StatisticsTest {
    static Stream<Arguments> createDivisionData() {
        return Stream.of(
                Arguments.of(8000, Arrays.asList(0, 0, 0, 0, 0, 1), 62.5),
                Arguments.of(8000, Arrays.asList(0, 0, 0, 0, 0, 2), 125),
                Arguments.of(8000, Arrays.asList(0, 0, 0, 0, 3, 0), 1875)
        );
    }

    @DisplayName("수익률이 정상적으로 산출되는지 확인.")
    @ParameterizedTest
    @MethodSource("createDivisionData")
    void 수익률_계산(int amountPaid, List<Integer> divisionData, double rateOfReturn) {
        BoughtLottos boughtLottos = new BoughtLottos(amountPaid);
        Statistics statistics = new Statistics(divisionData);

        assertThat(statistics.calculateRateOfReturn(boughtLottos)).isEqualTo(rateOfReturn);
    }
}
