package br.com.fabioperettig.adapter;

import java.io.File;
import java.nio.file.Files;

public interface RecordFile {

    public void record(File file);
    public File read(String patch);

}
