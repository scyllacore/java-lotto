package lotto.controller;

import lotto.controller.services.Buying;
import lotto.exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또를 구매할 때 금액에 대해 유효성 검사를 하여 구매 가능한 금액인지 확인한다.")
public class BuyingTest {

    @DisplayName("1,000원으로 나눠지지 않는 금액을 지불할 시 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2100", "10001","5020"})
    void 나눠지지_않는_금액으로_Buying_객체_생성(String amountPaidInput) {
        assertThatThrownBy(() -> new Buying().buy(amountPaidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.WRONG_AMOUNT_PAID.getMessage());
    }

    @DisplayName("1,000원에서 100,000을 벗어난 금액을 지불할 시 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "110000", "101000"})
    void 범위를_벗어난_금액으로_Buying_객체_생성(String amountPaidInput) {
        assertThatThrownBy(() -> new Buying().buy(amountPaidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.WRONG_AMOUNT_PAID.getMessage());
    }
}
