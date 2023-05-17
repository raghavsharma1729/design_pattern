package CreationalPattern.Singleton;

public class RuntimeSingletonExample {
    public static void main(String[] args) {
        // Get the singleton instance of Runtime
        Runtime runtime = Runtime.getRuntime();

        // Use the Runtime instance
        System.out.println("Available Processors: " + runtime.availableProcessors());
        System.out.println("Total Memory: " + runtime.totalMemory());
        System.out.println("Free Memory: " + runtime.freeMemory());
    }
}
