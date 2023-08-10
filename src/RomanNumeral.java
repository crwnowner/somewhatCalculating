public enum RomanNumeral {
    I("1"),
    II("2"),
    III("3"),
    IV("4"),
    V("5"),
    VI("6"),
    VII("7"),
    VIII("8"),
    IX("9"),
    X("10");

    private String arabic_equivalent;

    RomanNumeral(String arabic_equivalent) {
        this.arabic_equivalent = arabic_equivalent;
    }

    public String getEquivalent() {
        return arabic_equivalent;
    }
}
