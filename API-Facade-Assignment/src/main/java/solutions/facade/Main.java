package solutions.facade;

public class Main {

    public static void main(String[] args) {

        ApiFacade facade = new ApiFacade();

        try {
            // ✅ Chuck Norris API
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );
            System.out.println("Chuck Norris Joke:");
            System.out.println(joke);

            System.out.println("----------------------");

            // ✅ Another API (Exchange rates)
            String base = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "base"
            );
            System.out.println("FX API Base Currency:");
            System.out.println(base);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}