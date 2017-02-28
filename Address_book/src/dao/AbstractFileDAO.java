package dao;


import dao.DAO;
import dao.impl.FileDataProviderImpl;

import java.io.IOException;
import java.io.RandomAccessFile;


public abstract class AbstractFileDAO<T> implements DAO<T> {

    private Long id;
    protected final FileDataProviderImpl fileDataProvider;
    private String fileName;

    public AbstractFileDAO(FileDataProviderImpl fileDataProvider, String fileName) {
        this.fileDataProvider = fileDataProvider;
        this.fileName = fileName;
        fileDataProvider.appendFile(fileName);
    }

    public RandomAccessFile getDataFile() throws IOException {
        return fileDataProvider.getDataFile(fileName);
    }


    public String getFileName() {
        return fileName;
    }
}
