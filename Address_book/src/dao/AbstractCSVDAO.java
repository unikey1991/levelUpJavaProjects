package dao;

import dao.impl.FileDataProviderImpl;
import entity.Entity;
import entity.Street;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by java on 28.02.2017.
 */
public abstract class AbstractCSVDAO<T extends Entity> extends AbstractFileDAO<T> {


    private final String HEADER_CSV;
    long maxId = -1L;

    public AbstractCSVDAO(FileDataProviderImpl fileDataProvider, String fileName, String header_csv) {
        super(fileDataProvider, fileName);
        HEADER_CSV = header_csv;
    }

    protected abstract T parseEntity(final String str);
    public abstract String viewEntity(T entity);

    public long[] getStartAndEndOfStr(RandomAccessFile file, T entity){
        long[] arr = new long[2];

        String line;


        try {
            file.seek((HEADER_CSV + "\r\n").length());
            while ((line = file.readLine()) != null){
                if (line.startsWith(entity.getId() + ";")){
                    arr[1] = file.getFilePointer();
                    arr[0] = file.getFilePointer() - line.length();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }

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
            if (maxId == -1L) maxId = getMaxId();
            RandomAccessFile file = getDataFile();
            file.seek((HEADER_CSV + "\r").length());
            file.seek(file.length());
            long id;
            if (entity.getId() < 0) id = ++maxId;
            else id = entity.getId();
            String write = ((id) +";"+ viewEntity(entity).split(";")[1]);
            file.write(write.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        try {
            RandomAccessFile file = null;
            ArrayList<T> list = new ArrayList<>();
            file = getDataFile();
            long [] startAndEnd = getStartAndEndOfStr(file, entity);
            file.seek(startAndEnd[1]);

            String line;
            while ((line = file.readLine()) != null) {
                list.add(parseEntity(line));
            }

            file.setLength(startAndEnd[0]-1L);
            for (T e:list) {
                create(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        RandomAccessFile file = null;
        ArrayList<T> list = new ArrayList<>();

        try {
            file = getDataFile();
            long [] startAndEnd = getStartAndEndOfStr(file, entity);
            file.seek(startAndEnd[1]);

            String line;
            while ((line = file.readLine()) != null) {
                list.add(parseEntity(line));
            }

            file.setLength(startAndEnd[0]-1L);
            create(entity);
            for (T e:list) {
                create(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getMaxId() {
        try{
            RandomAccessFile file = getDataFile();
            file.seek((HEADER_CSV + "\r").length());
            String line;
            while ((line = file.readLine()) != null) {
                if (Long.parseLong((line.split(";"))[0]) > maxId) maxId = Long.parseLong((line.split(";"))[0]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return maxId;
    }
}