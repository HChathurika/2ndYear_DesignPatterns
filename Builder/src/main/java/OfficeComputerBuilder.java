public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
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

    @Override
    public Computer getComputer() {
        return computer;
    }
}