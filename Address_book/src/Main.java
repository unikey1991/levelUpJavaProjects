import dao.DAO;
import dao.DataProvider;
import dao.impl.FileDataProviderImpl;
import dao.impl.StreetCSVDAOImpl;
import entity.Street;
import view.MyDataTableFrame;
import view.impl.CitizenTablePanel;
import view.impl.CreateCitizenDialog;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //new MyDataTableFrame();

        FileDataProviderImpl provider = new FileDataProviderImpl("");

        DAO<Street> streetDAO = new StreetCSVDAOImpl(provider, "street.csv");

        provider.openConnection();

        ArrayList<Street> streets = streetDAO.read();

        System.out.println(streets);

        //streetDAO.create(new Street(5L, "Artema"));
        //streetDAO.delete(new Street(7L, "Topolia_1"));
        streetDAO.update(new Street(7L, "Glink235"));


        //System.out.println( ("id;street_name"+ "\r\n").length());


    }
}

