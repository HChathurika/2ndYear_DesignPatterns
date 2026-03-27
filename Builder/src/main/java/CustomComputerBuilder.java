public class CustomComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public CustomComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor(String processor) {
        computer.setProcessor(processor);
    }

    @Override
    public void buildRAM(int ram) {
        computer.setRam(ram);
    }

    @Override
    public void buildHardDrive(String hardDrive) {
        computer.setHardDrive(hardDrive);
    }

    @Override
    public void buildGraphicsCard(String graphicsCard) {
        computer.setGraphicsCard(graphicsCard);
    }

    @Override
    public void buildOperatingSystem(String operatingSystem) {
        computer.setOperatingSystem(operatingSystem);
    }

    public void addAccessory(String accessory) {
        computer.addAccessory(accessory);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}