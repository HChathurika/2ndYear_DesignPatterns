public interface ComputerBuilder {
    void buildProcessor(String processor);
    void buildRAM(int ram);
    void buildHardDrive(String hardDrive);
    void buildGraphicsCard(String graphicsCard);
    void buildOperatingSystem(String operatingSystem);
    Computer getComputer();
}