package com.gorauskas.fieldnotes;

import org.kohsuke.args4j.CmdLineException;

public class CommandLineParseException extends Exception {
    public CommandLineParseException(String message, CmdLineException e) {
        super(message + " - " + e.getMessage());
    }
}
