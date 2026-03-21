package br.com.fabioperettig.adapter.dropBox;

import br.com.fabioperettig.adapter.RecordFile;
import java.io.File;

public class DropBoxAdapter implements RecordFile {

    private DropBox dropBox;

    //ctor
    public DropBoxAdapter(DropBox dropBox) {
        this.dropBox = dropBox;
    }

    @Override
    public void record(File file) {
        dropBox.download(file.getAbsolutePath());
    }

    @Override
    public File read(String patch) {
        DropBoxFile file = dropBox.download(patch);
        return new File(file.getLocalPath());
    }
}
