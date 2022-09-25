package com.brielmayer.coffeecorner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public final class Console {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintStream WRITER = System.out;

    public String readLine() throws IOException {
        return READER.readLine();
    }

    public void writeLine(final String line) {
        WRITER.println(line);
    }
}
