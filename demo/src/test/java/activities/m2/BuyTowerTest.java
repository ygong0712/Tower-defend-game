package activities.m2;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BuyTowerTest {

    // M3
    @Test
    void testReceiveName() {
        BuyTower buyTower = new BuyTower();
        buyTower.receiveName("test");
        assertEquals(buyTower.getName(), "test");
    }

    // M3
    @Test
    void testBuyingWithInsufficientFund() {
        BuyTower buyTower = new BuyTower();
        assertEquals(buyTower.canBuy(0, 200), false);
    }

    // M3
    @Test
    void testCanBuyWithSufficientFund() {
        BuyTower buyTower = new BuyTower();
        assertEquals(buyTower.canBuy(200, 2), true);
    }

    @Test
    void testCanBuyWithEqualFund() {
        BuyTower buyTower = new BuyTower();
        assertEquals(buyTower.canBuy(200, 200), true);
    }


    // M3
    @Test
    void testReceiveSpot1() {
        BuyTower buyTower = new BuyTower();
        buyTower.receiveSpot1("Spot1", "Spot2", "Spot3", "Spot4", "Spot5");
        assertEquals(buyTower.getSpot1(), "Spot1");
        assertEquals(buyTower.getSpot2(), "Spot2");
        assertEquals(buyTower.getSpot3(), "Spot3");
        assertEquals(buyTower.getSpot4(), "Spot4");
        assertEquals(buyTower.getSpot5(), "Spot5");
    }

    // M3
    @Test
    void testReceiveSpot2() {
        BuyTower buyTower = new BuyTower();
        buyTower.receiveSpot2("Spot6", "Spot7", "Spot8", "Spot9", "Spot10");
        assertEquals(buyTower.getSpot6(), "Spot6");
        assertEquals(buyTower.getSpot7(), "Spot7");
        assertEquals(buyTower.getSpot8(), "Spot8");
        assertEquals(buyTower.getSpot9(), "Spot9");
        assertEquals(buyTower.getSpot10(), "Spot10");
    }

}