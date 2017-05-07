package view;

import entity.Packet;
import lombok.Getter;
import sun.swing.BakedArrayList;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by unike on 06.05.2017.
 */
@Getter
public class PacketTableModel extends AbstractTableModel {


    private String[] columns = {"ID",
            "packet name",
            "load date",
            "loaded by",
            "assigned to"};

    private List<Packet> packetList = new ArrayList<>();

    public void setPacketList(List<Packet> packetList) {
        this.packetList = packetList;
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
        return packetList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Packet packet = packetList.get(rowIndex);
        switch (columnIndex){
            case 1 : return packet.getPacketName();
            case 2 : return packet.getLoadDate();
            case 3 : return packet.getLoadedBy().getEmail();
            case 4 : return packet.getAssignedTo().getEmail();
            default: return packet.getId();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Packet packet = packetList.get(rowIndex);
        switch (columnIndex){
            case 1 : packet.setPacketName((String) aValue);
        }
    }

    public Packet getSelectedRowData(int rowIndex) {
        return packetList.get(rowIndex);
    }
}
