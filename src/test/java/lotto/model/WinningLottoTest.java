package lotto.model;

import lotto.exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("6개의 기본 번호와 1개의 보너스 번호를 가지고 당첨 번호 객체를 생성할 때 필요한 유효성 검사를 진행한다.")
public class WinningLottoTest {

    @DisplayName("중복되는 보너스 번호에 대해 정상적으로 예외 처리를 하는지 확인")
    @Test
    void 중복_보너스_번호가_존재하는_winningLotto_객체_생성() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.WRONG_NUMBER.getMessage());
    }

    @DisplayName("범위를 벗어나는 보너스 번호에 대해 정상적으로 예외 처리를 하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위를_벗어난_보너스_번호가_존재하는_winningLotto_객체_생성(int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.WRONG_NUMBER.getMessage());
    }
}

// List.of immutable 오류 -> Arrays.asList는 정상 작동
