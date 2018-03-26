package com.gorauskas.fieldnotes;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.CmdLineParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;

public class Options {

    private static final String USAGE_PREFIX = "Usage: fnt";
    private static final String ALT_USAGE_PREFIX = "   or fnt";

    @Option(name = "-V", aliases = {"--version"}, usage = "show version and exit")
    private boolean version;

    @Option(name = "-v", aliases = {"--verbose"}, usage = "show verbose output")
    private boolean verbose;

    @Option(name = "-C", aliases = {"--config"}, usage = "specify the configuration file to use")
    private String configFile;

    @Argument(index = 0, usage = "the command to execute", metaVar = "<command>")
    private String command;

    public String getCommand() {
        return command;
    }

    public String getConfigFile() throws FileNotFoundException {
        if (new File(configFile).isFile()) {
            return configFile;
        } else {
            throw new FileNotFoundException("Config file " + configFile + " does not exist.");
        }
    }

    public boolean isVerbose() {
        return verbose;
    }

    public boolean isVersion() {
        return version;
    }

    public static void printUsage(Object options) {
        CmdLineParser parser = new CmdLineParser(options);
        StringWriter sw = new StringWriter();
        sw.append(USAGE_PREFIX + "\n");
        sw.append(ALT_USAGE_PREFIX + " [OPTION] ... [<value> ...]\n\n");
        sw.append("Options:");
        System.out.println(sw.toString());
        parser.getProperties().withUsageWidth(100);
        parser.printUsage(System.out);
    }

    public static void printVersion() {
        System.out.println("fieldnotes (fnt) v. 0.1");
    }
}
