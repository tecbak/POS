package ua.rud.pos.coin;

public enum Coins implements Coin {
    FIFTY(50),
    TWENTY_FIVE(25),
    TEN(10),
    FIVE(5),
    ONE(1);

    private final long value;

    Coins(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
