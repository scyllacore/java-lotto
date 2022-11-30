package lotto.constants;

public enum PrizeDivision {
    MISS(0, 0, 0, "MISS"),
    FIRST(2_000_000_000, 6, 0, "6개 일치"),
    SECOND(30_000_000, 5, 1, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000, 5, 0, "5개 일치"),
    FOURTH(50_000, 4, 0, "4개 일치"),
    FIFTH(5_000, 3, 0, "3개 일치");

    private int prizeAmount;
    private int matchingCount;
    private int bonusCount;
    private String divisionText;

    PrizeDivision(int prizeAmount, int matchingCount, int bonusCount, String divisionText) {
        this.prizeAmount = prizeAmount;
        this.matchingCount = matchingCount;
        this.bonusCount = bonusCount;
        this.divisionText = divisionText;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public String getDivisionText() {
        return divisionText;
    }
}

