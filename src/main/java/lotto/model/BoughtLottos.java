package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class BoughtLottos {

    private List<Lotto> boughtLottos;

    public BoughtLottos(int amountPaid) {
        this.boughtLottos = createBoughtLottos(amountPaid);
    }

    private List<Lotto> createBoughtLottos(int amountPaid) {
        int amount = amountPaid / LottoConstant.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (; lottos.size() < amount; ) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_NUMBER, LottoConstant.MAX_NUMBER, LottoConstant.NUMBERS_SIZE
        ));
        return new Lotto(numbers);
    }

    public List<Lotto> getBoughtLottos() {
        return boughtLottos;
    }

    public int getAmountPaid() {
        return boughtLottos.size() * LottoConstant.LOTTO_PRICE;
    }

    public int getAmount() {
        return boughtLottos.size();
    }
}
