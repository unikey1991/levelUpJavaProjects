package view;

import entity.Citizen;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 10.01.2017.
 */
public class CitizenTableModelContainer extends AbstractTableModel {

    private String[] colums = {"ID",
            "First name",
            "Last name",
            "Age",
            "Streer id"};

    protected List<Citizen> data = new ArrayList<>();
    protected List<Citizen> updated = new ArrayList<>();



    public List<Citizen> getData() {
        return data;
    }

    public void setData(List<Citizen> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Citizen citizen = data.get(rowIndex);
        switch (columnIndex){
            case 2 : return citizen.getLastName();
            case 1 : return citizen.getFirstName();
            case 3 : return citizen.getAge();
            case 4 : return citizen.getStreetId();
            default:
                return citizen.getId();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Citizen citizen = data.get(rowIndex);
        switch (columnIndex){
            case 2 : citizen.setLastName((String)aValue);break;
            case 1 : citizen.setFirstName((String)aValue);break;
            case 3 : citizen.setAge(Integer.parseInt((String) aValue));break;
            case 4 : citizen.setStreetId(Long.parseLong((String) aValue));break;
        }
    }

    public Citizen getSelectedRowData(int rowIndex){
        return data.get(rowIndex);
    }


}
