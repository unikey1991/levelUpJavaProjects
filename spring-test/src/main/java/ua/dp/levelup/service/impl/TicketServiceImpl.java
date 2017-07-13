package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dp.levelup.cinema.Ticket;
import ua.dp.levelup.dao.TicketDao;
import ua.dp.levelup.service.TicketService;

import java.util.List;

/**
 * Created by unike on 02.07.2017.
 */

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Override
    public void createTicket(Ticket ticket) {

        ticketDao.createTicket(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketDao.updateTicket(ticket);
    }

    @Override
    public List<Ticket> getAllOrders() {
        return ticketDao.getAllTickets();
    }

    @Override
    public List<Ticket> getTicketsOfMovieSession(Long sessionId) {
        return ticketDao.getTicketsOfMovieSession(sessionId);
    }
}
