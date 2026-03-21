package br.com.fabioperettig.adapter.googledrive;

import br.com.fabioperettig.adapter.RecordFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GoogleDriveAdapter implements RecordFile {

    private GoogleDrive googleDrive;

    //ctor
    public GoogleDriveAdapter(GoogleDrive googleDrive) {
        this.googleDrive = googleDrive;
    }

    @Override
    public void record(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        googleDrive.get(file.getAbsolutePath());
    }

    @Override
    public File read(String name) {

        byte[] data = googleDrive.get(name);
        GoogleDriveFile file = new GoogleDriveFile(name);
        return new File(file.getLocalPath());
    }
}
