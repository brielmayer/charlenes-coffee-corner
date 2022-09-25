package com.brielmayer.coffeecorner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public String readLine() throws IOException {
        return READER.readLine();
    }

    public void writeLine(final String line) {
        System.out.println(line);
    }
}
