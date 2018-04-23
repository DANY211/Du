package Launch;

import Du.Du ;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Launch {
    @Option(name = "-h", usage = "Normal format")
    private boolean format = false;

    @Option(name = "-c", usage = "Size")
    private boolean sumSize = false;

    @Option(name = "-si", usage = "Another unit")
    private boolean unit = false;

    @Argument(metaVar = "fileN", usage = "Input file names")
    private String[] fileN;

    public static List list = new ArrayList();

    public static void main(String[] args) {
        new Launch().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("_____");
            parser.printUsage(System.err);
            return;
        }

        Du du = new Du(format, sumSize, unit);
        du.outWriter(du.answer(fileN));
        System.out.println("End");
        list = du.answer(fileN);
    }

}