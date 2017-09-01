package com.flpkrt.conf;

import io.dropwizard.cli.Command;
import io.dropwizard.setup.Bootstrap;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;

public class MyCommandLine extends Command {

    public MyCommandLine() {
        super("hello", "printing a greeting");
    }

    @Override
    public void configure(Subparser subparser) {
        subparser.addArgument("-u","--user")
                .dest("user")
                .type(String.class)
                .required(true)
                .help("the user of the program");
    }

    @Override
    public void run(Bootstrap<?> bootstrap, Namespace namespace) throws Exception {
        System.out.println("hello" + "   "+namespace.getString("user"));
    }
}
