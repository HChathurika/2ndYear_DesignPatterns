package printer;

public class Main {

    public static void main(String[] args) {

        Printer printer = new BasicPrinter();
        printer.print("Hello ,This is the new World!");

        Printer printer2 =
                new EncryptedPrinter(
                        new XMLPrinter(
                                new BasicPrinter()
                        )
                );

        printer2.print("Hello World!");
    }
}
