package system.process;

import models.PurchasedLottosData;
import utils.Input;

public class Purchase {

    //TODO : 헷갈리는 이름 수정할 것. ex) purchasedLottos 와 purchaseLottos
    private PurchasedLottosData purchasedLottosData;

    public Purchase() {
        purchasedLottosData = proceedPurchase();
        printPurchasedLottoList();
    }

    private PurchasedLottosData proceedPurchase() {

        int amount = calculateAvailableAmount(inputAmountPaid());
        return purchaseLottos(amount);
    }

    int inputAmountPaid() throws IllegalArgumentException {
        printInputAmountPaidText();
        String moneyInput = Input.input();

        if (moneyInput.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해주세요.");
        }

        return Integer.parseInt(moneyInput);
    }

    void printInputAmountPaidText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    int calculateAvailableAmount (int amountPaid) throws IllegalArgumentException {

        if (amountPaid % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 금액에 맞춰 로또를 구매할 수 없습니다.");
        }

        return amountPaid / 1000;
    }

    private PurchasedLottosData purchaseLottos(int amount){
        return new PurchasedLottosData(amount);
    }

    private void printPurchasedLottoList(){
        purchasedLottosData.printLottoList();
    }

    public PurchasedLottosData getPurchasedLottosData() {
        return purchasedLottosData;
    }
}
