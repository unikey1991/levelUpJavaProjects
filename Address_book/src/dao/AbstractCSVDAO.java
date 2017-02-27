package dao;

/**
 * Created by unike on 27.02.2017.
 */
public abstract class AbstractCSVDAO extends AbstractFileDAO {

    protected AbstractCSVDAO(final FileDataProviderImpl fileDataProvider,
                             String fileName, final String HEADER_CSV){

        super(fileDataProvider, fileName);
        this.HEADER_CSV = HEADER_CSV;
    }


}
