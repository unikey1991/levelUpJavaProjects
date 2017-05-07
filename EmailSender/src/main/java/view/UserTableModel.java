package view;

import entity.AccountType;
import entity.User;
import lombok.Getter;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by unike on 06.05.2017.
 */

@Getter
public class UserTableModel extends AbstractTableModel {

    private String[] columns = {"ID",
    "email",
    "password",
    "account type",
    "name",
    "last name"};

    private List<User> userList = new ArrayList<>();


    public void setUserList (List<User> userList){
        this.userList = userList;
    }


    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public int getRowCount() {
        return userList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = userList.get(rowIndex);
        switch (columnIndex){
            case 1 : return user.getEmail();
            case 2 : return user.getPassword();
            case 3 : return user.getAccountType();
            case 4 : return user.getName();
            case 5 : return user.getLastName();
            default: return user.getId();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        User user = userList.get(rowIndex);
        System.out.println(aValue+" "+columnIndex);
        switch (columnIndex){
            case 1 : user.setEmail((String) aValue);break;
            case 2 : user.setPassword((String) aValue);break;
            case 3 : user.setAccountType(AccountType.valueOf(aValue.toString()));break;
            case 4 : user.setName((String) aValue);break;
            case 5 : user.setLastName((String) aValue);break;
        }
    }

    public User getSelectedRowData(int rowIndex) {
        return userList.get(rowIndex);
    }
}
