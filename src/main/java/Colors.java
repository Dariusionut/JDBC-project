public enum Colors {
    RESET("\u001B[0m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    CYAN("\u001B[36m"),
    PURPLE("\u001B[35m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m");


    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
