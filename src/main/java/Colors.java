public enum Colors {
    //    Regular Colors
    RESET("\u001B[0m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    CYAN("\u001B[36m"),
    PURPLE("\u001B[35m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),

    //    Bolded Colors
    GREEN_BOLD("\033[1;32m"),
    YELLOW_BOLD("\u001B[1;33m"),
    CYAN_BOLD("\u001B[1;36m"),
    PURPLE_BOLD("\u001B[1;35m"),
    RED_BOLD("\u001B[1;31m"),
    BLUE_BOLD("\u001B[1;34m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
