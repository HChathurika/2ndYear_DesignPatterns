public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {
        if (builder instanceof GamingComputerBuilder) {
            builder.buildProcessor("AMD Ryzen 9");
            builder.buildRAM(32);
            builder.buildHardDrive("1 TB NVMe SSD");
            builder.buildGraphicsCard("NVIDIA GeForce RTX 4080");
            builder.buildOperatingSystem("Windows 11");
        } else if (builder instanceof OfficeComputerBuilder) {
            builder.buildProcessor("Intel Core i5");
            builder.buildRAM(16);
            builder.buildHardDrive("512 GB SSD");
            builder.buildGraphicsCard("Integrated Graphics");
            builder.buildOperatingSystem("Windows 10 Pro");
        }
    }
}