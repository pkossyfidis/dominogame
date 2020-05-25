/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hungarian;

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
public class ThreeBotsTest {
    
    public ThreeBotsTest() {
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
     * Test of SetTiles3 method, of class ThreeBots.
     */
    @Test
    public void testSetTiles3() {
        System.out.println("SetTiles3");
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        
    }

    /**
     * Test of SetPbTiles method, of class ThreeBots.
     */
    @Test
    public void testSetPbTiles() {
        System.out.println("SetPbTiles");
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        
    }

    /**
     * Test of DisTilesP method, of class ThreeBots.
     */
    @Test
    public void testDisTilesP() {
        System.out.println("DisTilesP");
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.DisTilesP();
        
    }

    /**
     * Test of DisTilesB1 method, of class ThreeBots.
     */
    @Test
    public void testDisTilesB1() {
        System.out.println("DisTilesB1");
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.DisTilesB1();
        
    }

    /**
     * Test of DisTilesB2 method, of class ThreeBots.
     */
    @Test
    public void testDisTilesB2() {
        System.out.println("DisTilesB2");
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.DisTilesB2();
        
    }

    /**
     * Test of DisTilesB3 method, of class ThreeBots.
     */
    @Test
    public void testDisTilesB3() {
        System.out.println("DisTilesB3");
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.DisTilesB3();
        
    }

    /**
     * Test of MaxTile method, of class ThreeBots.
     */
    @Test
    public void testMaxTile() {
        System.out.println("MaxTile");
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.MaxTile();
    }

    /**
     * Test of Game3Bot method, of class ThreeBots.
     */
    @Test
    public void testGame3Bot() {
        System.out.println("Game3Bot");
        ThreeBots instance = new ThreeBots();
        instance.Game3Bot();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindMax method, of class ThreeBots.
     */
    @Test
    public void testFindMax() {
        System.out.println("FindMax");
        Tiles b1=new Tiles(2,3);
        Tiles b2=new Tiles(6,6);
        Tiles b3=new Tiles(1,1);
        Tiles b4=new Tiles(4,4);
        Tiles maxB1 =b1 ;
        Tiles maxP = b2;
        Tiles maxB2 = b3;
        Tiles maxB3 = b4;
        ThreeBots instance = new ThreeBots();
        int expResult =0;
        int result = instance.FindMax(maxB1, maxP, maxB2,maxB3);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of DispDominoLine method, of class ThreeBots.
     */
    @Test
    public void testDispDominoLine() {
        System.out.println("DispDominoLine");
        ThreeBots instance = new ThreeBots();
        instance.DispDominoLine();
        
    }

    /**
     * Test of CheckPlayer method, of class ThreeBots.
     */
    @Test
    public void testCheckPlayer() {
        
        TwoBots x = new TwoBots();
        Tiles y = new Tiles(6,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayP[0]=z;
        System.out.println("CheckPlayer");
        ThreeBots instance = new ThreeBots();
        boolean expResult = true;
        boolean result=instance.CheckPlayer();
        assertEquals(expResult,result);
    }

    /**
     * Test of FakeTile method, of class ThreeBots.
     */
    @Test
    public void testFakeTile() {
        System.out.println("FakeTile");
        int pos = 0;
        int Turn = 0;
        ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.FakeTile(pos, Turn);
        
    }

    /**
     * Test of CheckBot1 method, of class ThreeBots.
     */
    @Test
    public void testCheckBot1() {
        System.out.println("CheckBot1");
        TwoBots x = new TwoBots();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayB1[0]=z;
        ThreeBots instance = new ThreeBots();
        boolean expResult = true;
        boolean result = instance.CheckBot1();
        assertEquals(expResult, result);
        
        
        
        
    }

    /**
     * Test of CheckBot2 method, of class ThreeBots.
     */
    @Test
    public void testCheckBot2() {
        System.out.println("CheckBot2");
        TwoBots x = new TwoBots();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayB2[0]=z;
        ThreeBots instance = new ThreeBots();
        boolean expResult = true;
        boolean result = instance.CheckBot2();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of CheckBot3 method, of class ThreeBots.
     */
    @Test
    public void testCheckBot3() {
        System.out.println("CheckBot3");
        TwoBots x = new TwoBots();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayB2[0]=z;
        ThreeBots instance = new ThreeBots();
        boolean expResult = true;
        boolean result = instance.CheckBot3();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of TilePlacement method, of class ThreeBots.
     */
    @Test
    public void testTilePlacement() {
        System.out.println("TilePlacement");
        Tiles tileP = null;
        int num = 0;
        int j = 0;
        ThreeBots instance = new ThreeBots();
        instance.TilePlacement(tileP, num, j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddMaxBot method, of class ThreeBots.
     */
    @Test
    public void testAddMaxBot() {
        System.out.println("AddMaxBot");
        Tiles[] arrayB = null;
        int flag2 = 0;
        Tiles maxB = null;
       
        
        System.out.println("AddMaxBot");
        
         ThreeBots instance = new ThreeBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.MaxTile();
        int expResult = 1;
        int result = instance.AddMaxBot(arrayB, flag2, maxB);
        assertEquals(expResult, result);
    }

    /**
     * Test of Bot1Turn method, of class ThreeBots.
     */
    @Test
    public void testBot1Turn() {
        System.out.println("Bot1Turn");
        int sumb = 0;
        ThreeBots instance = new ThreeBots();
        int expResult = 0;
        int result = instance.Bot1Turn(sumb);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of Bot2Turn method, of class ThreeBots.
     */
    @Test
    public void testBot2Turn() {
        System.out.println("Bot2Turn");
        int sumb = 0;
        ThreeBots instance = new ThreeBots();
        int expResult = 0;
        int result = instance.Bot2Turn(sumb);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of Bot3Turn method, of class ThreeBots.
     */
    @Test
    public void testBot3Turn() {
        System.out.println("Bot3Turn");
        int sumb = 0;
        ThreeBots instance = new ThreeBots();
        int expResult = 0;
        int result = instance.Bot3Turn(sumb);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of BotPoints method, of class ThreeBots.
     */
    @Test
    public void testBotPoints() {
        System.out.println("BotPoints");
        Tiles[] arrayB = null;
        ThreeBots instance = new ThreeBots();
        int expResult = 0;
        int result = instance.BotPoints(arrayB);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of PlayerPoints method, of class ThreeBots.
     */
    @Test
    public void testPlayerPoints() {
        System.out.println("PlayerPoints");
        Tiles[] arrayP = null;
        ThreeBots instance = new ThreeBots();
        int expResult = 0;
        int result = instance.PlayerPoints(arrayP);
        assertEquals(expResult, result);
        
    }
    
}
