public class Main {
    public static void main(String[] args) {
        // Build a gaming computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        gamingDirector.constructComputer();
        Computer gamingComputer = gamingBuilder.getComputer();

        System.out.println("Gaming Computer Configuration:");
        System.out.println(gamingComputer);

        System.out.println("-----------------------------------");

        // Build an office computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);
        officeDirector.constructComputer();
        Computer officeComputer = officeBuilder.getComputer();

        System.out.println("Office Computer Configuration:");
        System.out.println(officeComputer);

        System.out.println("-----------------------------------");

        // Build a custom computer
        CustomComputerBuilder customBuilder = new CustomComputerBuilder();
        customBuilder.buildProcessor("Intel Core i7");
        customBuilder.buildRAM(32);
        customBuilder.buildHardDrive("1 TB SSD");
        customBuilder.buildGraphicsCard("NVIDIA RTX 4070");
        customBuilder.buildOperatingSystem("Windows 11 Pro");
        customBuilder.addAccessory("Mechanical Keyboard");
        customBuilder.addAccessory("Gaming Mouse");
        customBuilder.addAccessory("27-inch Monitor");

        Computer customComputer = customBuilder.getComputer();

        System.out.println("Custom Computer Configuration:");
        System.out.println(customComputer);
    }
}