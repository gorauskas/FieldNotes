package com.gorauskas.fieldnotes;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Application {



    public static void main(String[] args) {
        System.out.println("Field Notes!");
    }

    protected void run(String[] args) {
        try {
            Options opt = parseArgs(args);

            if (opt.isVersion()) {
                Options.printVersion();
                System.exit(0);
            }

            if (opt.isVerbose()) {
                //
            }

        } catch (CommandLineParseException e) {
            System.err.println(e.getMessage());
        }
    }

    private Options parseArgs(String[] args) throws CommandLineParseException {
        Options o = new Options();
        CmdLineParser parser = new CmdLineParser(o);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            Options.printUsage(o);
            throw new CommandLineParseException("Invalid command line parameters: " + e.getMessage(), e);
        }

        return o;
    }
}
