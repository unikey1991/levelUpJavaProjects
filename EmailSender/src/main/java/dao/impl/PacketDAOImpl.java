package dao.impl;

import dao.AbstractDAO;
import entity.Packet;

import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by unike on 07.05.2017.
 */
public class PacketDAOImpl extends AbstractDAO<Packet> {


    @Override
    public void create(Packet packet) {
        transaction.begin();
        session.save(packet);
        transaction.commit();
    }

    @Override
    public ArrayList<Packet> read() {
        Query packetQuery = session.createQuery("from Packet", Packet.class);
        ArrayList<Packet> arrayList = (ArrayList<Packet>) packetQuery.getResultList();
        return arrayList;
    }

    @Override
    public void update(Packet packet) {
        transaction.begin();
        session.update(packet);
        transaction.commit();
    }

    @Override
    public void delete(Packet packet) {
        transaction.begin();
        session.delete(packet);
        transaction.commit();
    }

    @Override
    public Packet getOneById(long id) {
        return null;
    }
}
