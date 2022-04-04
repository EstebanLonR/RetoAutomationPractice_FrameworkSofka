package co.com.client.webproject.test.helpers.enums;

public enum TimesWaits {
    ONE_SECONDS(1),
    TWO_SECONDS(2),
    THREE_SECONDS(3),
    FOUR_SECONDS(4),
    FIVE_SECONDS(5);

    private final int value;

    TimesWaits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
