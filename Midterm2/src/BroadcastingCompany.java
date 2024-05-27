import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BroadcastingCompany {
    private List<Program> programs;

    public BroadcastingCompany() {
        this.programs = new ArrayList<>();
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void addProgram(Program program) {
        this.programs.add(program);
    }

    public void removeProgram(Program program) {
        this.programs.remove(program);
    }

    public void saveState() {
        try (FileWriter writer = new FileWriter("state.csv")) {
            for (Program program : programs) {
                writer.write(program.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState() {
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].split("=")[1];
                int duration = Integer.parseInt(parts[1].split("=")[1].replace("}", ""));
                addProgram(new Program(name, duration));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}