package edu.whitman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class MuseumTest{
    private Museum museum;
    private Ticket ticket1;
    private Ticket ticket2;

    @BeforeEach
    public void setUp(){
        museum = new Museum("Seattle Museum");
        ticket1 = new Ticket(101, "VIP", "A1", 50.0);
        ticket2 = new Ticket(102, "Standard", "B10", 30.0);
    }

    @Test
    public void testAddTicket(){
        museum.addTicket(ticket1);
        museum.addTicket(ticket2);
        HashMap<Integer, Ticket> availableTickets = museum.getAvailableTickets();
        assertEquals(2, availableTickets.size());

        // Check if ticket details are correct
        assertTrue(availableTickets.containsKey(ticket1.getId()));
        assertTrue(availableTickets.containsKey(ticket2.getId()));
    }

    @Test
    public void testRemoveTicket(){
        museum.addTicket(ticket1);
        museum.addTicket(ticket2);

        museum.removeTicket(ticket1.getId());
        HashMap<Integer, Ticket> availableTickets = museum.getAvailableTickets();
        assertEquals(1, availableTickets.size());
        assertTrue(availableTickets.containsKey(ticket2.getId()));
    }

    @Test
    public void testGetName(){
        assertEquals(museum.getName(), "Seattle Museum");
    }

    @Test
    public void testGetAvailableTickets(){
        museum.addTicket(ticket1);
        museum.addTicket(ticket2);
        HashMap<Integer, Ticket> availableTickets = museum.getAvailableTickets();
        assertEquals(availableTickets.size(), 2);
    }

}