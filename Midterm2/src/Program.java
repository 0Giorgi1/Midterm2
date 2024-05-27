public class Program {
    private String name;
    private int duration;

    public Program(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}