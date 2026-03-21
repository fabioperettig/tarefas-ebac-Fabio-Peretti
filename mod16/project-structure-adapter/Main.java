import br.com.fabioperettig.adapter.dropBox.*;
import br.com.fabioperettig.adapter.googledrive.*;
import br.com.fabioperettig.adapter.RecordFile;

import java.io.File;


public class Main {

    public static void main(String[] args) {
        String file = "test.txt";
        DropBox dropBox = new DropBox();
        RecordFile file1 = new DropBoxAdapter(dropBox);
        file1.record(new File(file));
    }

}
