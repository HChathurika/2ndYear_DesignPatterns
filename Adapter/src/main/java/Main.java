public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        dateAdapter.setDay(25);
        dateAdapter.setMonth(3);
        dateAdapter.setYear(2026);

        System.out.println("Initial Date: "
                + dateAdapter.getDay() + "/"
                + dateAdapter.getMonth() + "/"
                + dateAdapter.getYear());

        dateAdapter.advanceDays(10);

        System.out.println("After advancing 10 days: "
                + dateAdapter.getDay() + "/"
                + dateAdapter.getMonth() + "/"
                + dateAdapter.getYear());

        dateAdapter.advanceDays(30);

        System.out.println("After advancing 30 more days: "
                + dateAdapter.getDay() + "/"
                + dateAdapter.getMonth() + "/"
                + dateAdapter.getYear());
    }
}