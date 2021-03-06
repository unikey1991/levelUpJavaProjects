package ua.dp.levelup.service;

import ua.dp.levelup.cinema.Ticket;

import java.util.List;

/**
 * Created by unike on 02.07.2017.
 */
public interface TicketService {

    void createTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    List<Ticket> getAllOrders();
    List<Ticket> getTicketsOfMovieSession(Long sessionId);


}
