package hexlet.code;

import java.io.IOException;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@SuppressWarnings({"unused", "FieldMayBeFinal", "FieldCanBeLocal"})
@CommandLine.Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true)
public class App implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", paramLabel = "filepath1",
            description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(index = "1", paramLabel = "filepath2",
            description = "path to second file")
    private String filePath2;

    @CommandLine.Option(names = { "-f", "--format" },
            defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String format = "stylish";

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true,
            description = "Show this help message and exit.")
    private boolean helpRequested;

    @CommandLine.Option(names = { "-V", "--version" }, versionHelp = true,
            description = "Print version information and exit.")
    private boolean versionRequested;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws IOException {
        if (this.filePath1 != null && this.filePath2 != null) {
            System.out.println(Differ.generate(filePath1, filePath2, format));
        }

        return 0;
    }
}