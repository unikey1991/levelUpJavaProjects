package dao.impl;

import dao.AbstractDAO;
import email.EmailConsumer;
import email.EmailMessage;
import email.EmailProducer;
import email.EmailSenderFromFileList;
import entity.Packet;

import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by unike on 07.05.2017.
 */
public class PacketDAOImpl extends AbstractDAO<Packet> {


    public File currentPacket = null;
    public EmailSenderFromFileList senderFromFileList = new EmailSenderFromFileList();
    ArrayBlockingQueue<EmailMessage> queue = new ArrayBlockingQueue<EmailMessage>(1000);
    public EmailProducer producer = new EmailProducer(queue);
    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public PacketDAOImpl() throws IOException {
        executorService.execute(new EmailConsumer(queue) );
        executorService.execute(new EmailConsumer(queue) );
        executorService.execute(new EmailConsumer(queue) );
    }


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
