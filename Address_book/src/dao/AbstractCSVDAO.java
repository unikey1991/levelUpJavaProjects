package dao;

import dao.impl.FileDataProviderImpl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by java on 28.02.2017.
 */
public abstract class AbstractCSVDAO<T> extends AbstractFileDAO<T> {


    private final String HEADER_CSV;

    public AbstractCSVDAO(FileDataProviderImpl fileDataProvider, String fileName, String header_csv) {
        super(fileDataProvider, fileName);
        HEADER_CSV = header_csv;
    }

    protected abstract T parseEntity(final String str);
    public abstract String viewEntity(T entity);

    @Override
    public ArrayList<T> read(){
        ArrayList<T> list = new ArrayList<>();

        RandomAccessFile file = null;
        try {
            file = getDataFile();
            getDataFile().seek(0);
            String line;
            while ((line = file.readLine()) != null){
                if (line.contains(HEADER_CSV)) continue;
                list.add(parseEntity(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void create(T entity) {
        try{
            RandomAccessFile file = getDataFile();
            file.seek(file.length());

            file.write(viewEntity(entity).getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) { // FIXME: 28.02.2017
        RandomAccessFile file = getDataFile();

        String[] line;
        while ((line = file.readLine().split(";")) != null){
            if (file.readLine().contains(HEADER_CSV)) continue;
            if (line[0] == viewEntity(entity))
        }
    }
}