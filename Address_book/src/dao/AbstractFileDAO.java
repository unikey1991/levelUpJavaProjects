package dao;

import dao.impl.DAO;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Created by unike on 27.02.2017.
 */
public abstract class AbstractFileDAO implements DAO {


    private Long id;
    protected final FileDataProviderImpl fileDataProvider;
    private String fileName;

    public AbstractFileDAO(FileDataProviderImpl fileDataProvider, String fileName) {
        this.fileDataProvider = fileDataProvider;
        this.fileName = fileName;
        fileDataProvider.appendFile(fileName);
    }

    public RandomAccessFile getDataFile() throws FileNotFoundException {
        return fileDataProvider.getDataFile(fileName);
    }
}
