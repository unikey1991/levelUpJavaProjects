package view.impl;

import java.io.File;

/**
 * Created by unike on 09.05.2017.
 */
public class FileFilter extends javax.swing.filechooser.FileFilter {
    String ext,description;

    public String getDescription() {
        return description;
    }

    FileFilter(String ext, String description) {
        this.ext = ext;
    }
    //В этом методе может быть любая проверка файла
    public boolean accept(File f) {
        if(f != null) {
            if(f.isDirectory()) {
                return true;
            }

            return f.toString().endsWith(ext);
        }
        return false;
    }
}
