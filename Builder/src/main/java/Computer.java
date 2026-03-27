import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private List<String> accessories;

    public Computer() {
        accessories = new ArrayList<>();
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void addAccessory(String accessory) {
        accessories.add(accessory);
    }

    @Override
    public String toString() {
        return "Processor: " + processor + "\n"
                + "RAM: " + ram + " GB\n"
                + "Hard Drive: " + hardDrive + "\n"
                + "Graphics Card: " + graphicsCard + "\n"
                + "Operating System: " + operatingSystem + "\n"
                + "Accessories: " + (accessories.isEmpty() ? "None" : String.join(", ", accessories));
    }
}