package org.example.practice.buy_ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyTicketTest {

    private BuyTicket buyTicket;

    @BeforeEach
    void setUp() {
        buyTicket = new BuyTicket();
    }

    @Test
    void timeToBuyTicketMethod1() {
        assertEquals(6, buyTicket.timeRequiredToBuy1(new int[]{2, 3, 2}, 2));
        assertEquals(8, buyTicket.timeRequiredToBuy1(new int[]{5, 1, 1, 1}, 0));
    }

    @Test
    void timeToBuyTicketMethod2() {
        assertEquals(6, buyTicket.timeRequiredToBuy2(new int[]{2, 3, 2}, 2));
        assertEquals(8, buyTicket.timeRequiredToBuy2(new int[]{5, 1, 1, 1}, 0));
    }

    @Test
    void timeToBuyTicketMethod3() {
        assertEquals(6, buyTicket.timeRequiredToBuy3(new int[]{2, 3, 2}, 2));
        assertEquals(8, buyTicket.timeRequiredToBuy3(new int[]{5, 1, 1, 1}, 0));
    }
}