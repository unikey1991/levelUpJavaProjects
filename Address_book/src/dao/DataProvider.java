package dao;


public interface DataProvider {

    enum ConnectionType {
        MYSQL, H2, MONGODB, CSV, JSON, XML
    }

    void openConnection();

    void closeConnection();
}
