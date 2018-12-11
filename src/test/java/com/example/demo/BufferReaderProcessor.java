package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader bufferReader) throws IOException;
}
