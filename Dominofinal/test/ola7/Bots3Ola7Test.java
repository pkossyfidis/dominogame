/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ola7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import solo1.Tiles;

/**
 *
 * @author Lefteris
 */
public class Bots3Ola7Test {
    
    public Bots3Ola7Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SetTiles method, of class Bots3Ola7.
     */
    @Test
    public void testSetTiles() {
        System.out.println("SetTiles");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        
    }

    /**
     * Test of SetPbTiles method, of class Bots3Ola7.
     */
    @Test
    public void testSetPbTiles() {
        System.out.println("SetPbTiles");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
    }

    /**
     * Test of DisTilesP method, of class Bots3Ola7.
     */
    @Test
    public void testDisTilesP() {
        System.out.println("DisTilesP");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.DisTilesP();
        
    }

    /**
     * Test of DisTilesB method, of class Bots3Ola7.
     */
    @Test
    public void testDisTilesB() {
        System.out.println("DisTilesB");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.DisTilesB();
    }

    /**
     * Test of DisTilesB2 method, of class Bots3Ola7.
     */
    @Test
    public void testDisTilesB2() {
        System.out.println("DisTilesB2");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.DisTilesB2();
    }

    /**
     * Test of DisTilesB3 method, of class Bots3Ola7.
     */
    @Test
    public void testDisTilesB3() {
        System.out.println("DisTilesB3");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.DisTilesB3();
    }

    /**
     * Test of MaxTile method, of class Bots3Ola7.
     */
    @Test
    public void testMaxTile() {
        System.out.println("MaxTile");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.MaxTile();
    }

    /**
     * Test of Game2Bots method, of class Bots3Ola7.
     */
    @Test
    public void testGame2Bots() {
        System.out.println("Game2Bots");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.Game2Bots();
        
    }

    /**
     * Test of DispDominoLine method, of class Bots3Ola7.
     */
    @Test
    public void testDispDominoLine() {
        System.out.println("DispDominoLine");
        Bots3Ola7 instance = new Bots3Ola7();
        instance.DispDominoLine();
        
    }

    /**
     * Test of FindMax method, of class Bots3Ola7.
     */
    @Test
    public void testFindMax() {
        System.out.println("FindMax");
        Tiles b1=new Tiles(2,3);
        Tiles b2=new Tiles(6,6);
        Tiles b3=new Tiles(1,1);
        Tiles b4 = new Tiles(4,4);
        Tiles maxB1 =b1 ;
        Tiles maxP = b2;
        Tiles maxB2 = b3;
        Tiles maxB3 = b4;
        Bots3Ola7 instance = new Bots3Ola7();
        int expResult =0;
        int result = instance.FindMax(maxB1, maxP, maxB2,maxB3);
        assertEquals(expResult, result);
    }

    /**
     * Test of CheckPlayer method, of class Bots3Ola7.
     */
    @Test
    public void testCheckPlayer() {
        System.out.println("CheckPlayer");
        Bots3Ola7 x = new Bots3Ola7();
        Tiles y = new Tiles(6,6);
        Tiles z = new Tiles(6,4);       
        x.arrayP[0]=z;
        System.out.println("CheckPlayer");
        boolean expResult = true;
        boolean result = x.CheckPlayer();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of CheckBot1 method, of class Bots3Ola7.
     */
    @Test
    public void testCheckBot1() {
        System.out.println("CheckBot1");
        Bots3Ola7 x = new Bots3Ola7();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.arrayB1[0]=z;
        boolean expResult = true;
        boolean result = x.CheckBot1();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of CheckBot2 method, of class Bots3Ola7.
     */
    @Test
    public void testCheckBot2() {
        System.out.println("CheckBot2");
        Bots3Ola7 x = new Bots3Ola7();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.arrayB2[0]=z;
        boolean expResult = true;
        boolean result = x.CheckBot1();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of CheckBot3 method, of class Bots3Ola7.
     */
    @Test
    public void testCheckBot3() {
        System.out.println("CheckBot3");
        Bots3Ola7 x = new Bots3Ola7();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.arrayB3[0]=z;
        boolean expResult = true;
        boolean result = x.CheckBot1();
        assertEquals(expResult, result);
    }

    /**
     * Test of PlayerPoints method, of class Bots3Ola7.
     */
    @Test
    public void testPlayerPoints() {
        System.out.println("PlayerPoints");
        Tiles[] arrayP = null;
        Bots3Ola7 instance = new Bots3Ola7();
        int expResult = 0;
        int result = instance.PlayerPoints(arrayP);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of BotPoints method, of class Bots3Ola7.
     */
    @Test
    public void testBotPoints() {
        System.out.println("BotPoints");
        Tiles[] arrayB = null;
        Bots3Ola7 instance = new Bots3Ola7();
        int expResult = 0;
        int result = instance.BotPoints(arrayB);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of AddMaxBot method, of class Bots3Ola7.
     */
    @Test
    public void testAddMaxBot() {
        System.out.println("AddMaxBot");
        int flag2 = 0;
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.MaxTile();
        int expResult = 1;
        int result = instance.AddMaxBot(flag2);
        assertEquals(expResult, result);
    }

    /**
     * Test of FakeTile method, of class Bots3Ola7.
     */
    @Test
    public void testFakeTile() {
        System.out.println("FakeTile");
        int pos = 0;
        int Turn = 0;
        Bots3Ola7 instance = new Bots3Ola7();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.MaxTile();
        int expResult = 1;
        instance.FakeTile(pos, Turn);
    }

    /**
     * Test of Bot1Turn method, of class Bots3Ola7.
     */
    @Test
    public void testBot1Turn() {
        System.out.println("Bot1Turn");
        int tilenumb = 0;
        Bots3Ola7 instance = new Bots3Ola7();
        int expResult = 0;
        int result = instance.Bot1Turn(tilenumb);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of Bot2Turn method, of class Bots3Ola7.
     */
    @Test
    public void testBot2Turn() {
        System.out.println("Bot2Turn");
        int tilenumb = 0;
        Bots3Ola7 instance = new Bots3Ola7();
        int expResult = 0;
        int result = instance.Bot2Turn(tilenumb);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of Bot3Turn method, of class Bots3Ola7.
     */
    @Test
    public void testBot3Turn() {
        System.out.println("Bot3Turn");
        int tilenumb = 0;
        Bots3Ola7 instance = new Bots3Ola7();
        int expResult = 0;
        int result = instance.Bot3Turn(tilenumb);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of TilePlacement method, of class Bots3Ola7.
     */
    @Test
    public void testTilePlacement() {
        System.out.println("TilePlacement");
        Tiles tileP = null;
        int num = 0;
        int j = 0;
        Bots3Ola7 instance = new Bots3Ola7();
        instance.TilePlacement(tileP, num, j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
