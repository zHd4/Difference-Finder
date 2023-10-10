package hexlet.code;

import picocli.CommandLine;
import java.util.concurrent.Callable;

@CommandLine.Command(name="gendiff", description="Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions=true)
public class App implements Callable<Integer> {
    @CommandLine.Option(names={ "-h", "--help" }, usageHelp=true, description="Show this help message and exit.")
    private boolean helpRequested = false;

    @CommandLine.Option(names={ "-V", "--version" }, versionHelp=true, description="Print version information and exit.")
    private boolean versionRequested = false;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}