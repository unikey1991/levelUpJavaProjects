package com.levelup.dao.impl;

import com.levelup.dao.AbstractJSONDAO;
import com.levelup.dao.DataProvider;
import com.levelup.entity.Citizen;

/**
 * Created by java on 03.03.2017.
 */
public class CitizenJSONDAOImpl extends AbstractJSONDAO<Citizen> {


    public CitizenJSONDAOImpl(DataProvider fileDataProvider, String fileName) {
        super(fileDataProvider, fileName, "{\"citizenList\": [");
    }

    @Override
    protected Citizen parseEntity(String str) {
        str = str.trim().replaceAll("[\",\\s{}]|id|firstName|lastName|age|streetId", "");
        String[] params = str.split(":");

        long id = Long.parseLong(params[1]);
        String fName = params[2];
        String lName = params[3];
        int age = Integer.parseInt(params[4]);
        long streetId = Long.parseLong(params[5]);


        return new Citizen(id, fName, lName, age, streetId);
    }

    @Override
    public String viewEntity(Citizen entity) {
        return "\t{" +
                "\"id\": " + entity.getId() + ", " +
                "\"firstName\": \"" + entity.getFistName() + "\", " +
                "\"lastName\": \"" + entity.getLastName() + "\", " +
                "\"age\": " + entity.getAge() + ", " +
                "\"streetId\": " + entity.getStreetId() +
                "}";
    }
}
