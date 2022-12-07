package lotto.controller;

import lotto.controller.services.WinningLottoRegister;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinningLotto 객체를 생성하고 메소드가 정상적으로 실행되는지 확인한다.")
public class WinningLottoRegisterTest {
    private WinningLotto winningLotto;

    static Stream<Arguments> createCountMatchingTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), 2),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 8, 9), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 9), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        );
    }

    static Stream<Arguments> createCountBonusTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), 1),
                Arguments.of(Arrays.asList(1, 2, 3, 8, 9, 10), 0)
        );
    }

    @BeforeEach
    void createWinningLotto() {
        winningLotto = new WinningLottoRegister().register("1,2,3,4,5,6", "7");
    }

    @DisplayName("입력값을 이용해 당첨 번호 등록을 진행하고 같은 숫자의 개수를 확인.")
    @ParameterizedTest
    @MethodSource("createCountMatchingTestData")
    void 당첨_번호를_등록하고_당첨_번호_객체를_반환_받아_countMatching_실행(List<Integer> boughtLotto, int matchingCount) {
        assertThat(winningLotto.countMatching(new Lotto(boughtLotto))).isEqualTo(matchingCount);
    }

    @DisplayName("입력값을 이용해 당첨 번호 등록을 진행하고 보너스 번호가 동일한지 확인.")
    @ParameterizedTest
    @MethodSource("createCountBonusTestData")
    void 당첨_번호를_등록하고_당첨_번호_객체를_반환_받아_countBonus_실행(List<Integer> boughtLotto, int bonusCount) {
        assertThat(winningLotto.countBonus(new Lotto(boughtLotto))).isEqualTo(bonusCount);
    }
}
