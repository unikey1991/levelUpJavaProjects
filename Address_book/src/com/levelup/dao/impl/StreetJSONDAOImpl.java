package com.levelup.dao.impl;

import com.levelup.dao.AbstractCSVDAO;
import com.levelup.dao.AbstractJSONDAO;
import com.levelup.entity.Street;

/**
 * Created by java on 28.02.2017.
 */
public class StreetJSONDAOImpl extends AbstractJSONDAO<Street> {

    public StreetJSONDAOImpl(FileDataProviderImpl fileDataProvider, String fileName) {
        super(fileDataProvider, fileName, "{\"streetList: [");
    }

    @Override
    protected Street parseEntity(String str) {
        str = str.trim().replaceAll("[\",\\s{}]|id|streetName", "");
        String[] params = str.split(":");
        long id = Long.parseLong(params[1]);
        String streetName = params[2];

        return new Street(id, streetName);
    }

    @Override
    public String viewEntity(Street entity) {
        return "\t{" +
                "\"id\": " + entity.getId() + ", " +
                "\"streetName\": \"" + entity.getStreetName() + "\", " +
                "}";
    }

}
