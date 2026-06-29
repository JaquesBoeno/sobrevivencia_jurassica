package TrabalhoPOO;

public class TextColor {

    // Enum interno (ou pode ser um arquivo separado: Color.java)
    public enum Color {
        BLACK("30"), RED("31"), GREEN("32"),
        YELLOW("33"), BLUE("34"), AGENTA("35"),
        CYAN("36"), WHITE("37"), GRAY("90"),
        BRIGHT_RED("91"), BRIGHT_GREEN("92"),
        BRIGHT_YELLOW("93"), BRIGHT_BLUE("94"),
        BRIGHT_MAGENTA("95"), BRIGHT_CYAN("96"),
        BRIGHT_WHITE("97");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    private static final String CLEAR = "\u001b[0m";

    public static String color(String text, Color color) {
        return "\u001b["+ color.getCode() + "m" + text + CLEAR;
    }
}