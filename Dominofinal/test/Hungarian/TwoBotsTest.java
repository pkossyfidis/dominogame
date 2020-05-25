/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hungarian;

import solo1.Tiles;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kossyfidis
 */
public class TwoBotsTest {
    
    public TwoBotsTest() {
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
     * Test of SetTiles3 method, of class TwoBots.
     */
    @Test
    public void testSetTiles3() {
        System.out.println("SetTiles3");
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        
    }

    /**
     * Test of SetPbTiles method, of class TwoBots.
     */
    @Test
    public void testSetPbTiles() {
        System.out.println("SetPbTiles");
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        
    }

    /**
     * Test of DisTilesP method, of class TwoBots.
     */
    @Test
    public void testDisTilesP() {
        System.out.println("DisTilesP");
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.DisTilesP();
    }

    /**
     * Test of DisTilesB1 method, of class TwoBots.
     */
    @Test
    public void testDisTilesB1() {
        System.out.println("DisTilesB1");
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.DisTilesB1();
    }

    /**
     * Test of DisTilesB2 method, of class TwoBots.
     */
    @Test
    public void testDisTilesB2() {
        System.out.println("DisTilesB2");
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.DisTilesB2();
    }

    /**
     * Test of MaxTile method, of class TwoBots.
     */
    @Test
    public void testMaxTile() {
        System.out.println("MaxTile");
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.MaxTile();
    }

    /**
     * Test of Game2Bot method, of class TwoBots.
     */
    @Test
    public void testGame2Bot() {
        System.out.println("Game2Bot");
        TwoBots instance = new TwoBots();
        instance.Game2Bot();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindMax method, of class TwoBots.
     */
    @Test
    public void testFindMax() {
        System.out.println("FindMax");
        Tiles b1=new Tiles(2,3);
        Tiles b2=new Tiles(6,6);
        Tiles b3=new Tiles(1,1);
        Tiles maxB1 =b1 ;
        Tiles maxP = b2;
        Tiles maxB2 = b3;
        TwoBots instance = new TwoBots();
        int expResult =0;
        int result = instance.FindMax(maxB1, maxP, maxB2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of DispDominoLine method, of class TwoBots.
     */
    @Test
    public void testDispDominoLine() {
        System.out.println("DispDominoLine");
        TwoBots instance = new TwoBots();
        instance.DispDominoLine();
        
    }

    /**
     * Test of CheckPlayer method, of class TwoBots.
     */
    @Test
    public void testCheckPlayer() {
        System.out.println("CheckPlayer");
        TwoBots x = new TwoBots();
        Tiles y = new Tiles(6,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayP[0]=z;
        System.out.println("CheckPlayer");
        TwoBots instance = new TwoBots();
        boolean expResult = true;
        boolean result=instance.CheckPlayer();
        assertEquals(expResult,result);
    }

    /**
     * Test of FakeTile method, of class TwoBots.
     */
    @Test
    public void testFakeTile() {
        System.out.println("FakeTile");
        int pos = 0;
        int Turn = 0;
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.AddMaxBot(Turn);
        instance.FakeTile(pos, Turn); 
    }

    /**
     * Test of CheckBot1 method, of class TwoBots.
     */
    @Test
    public void testCheckBot1() {
        System.out.println("CheckBot1");
        TwoBots x = new TwoBots();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayB1[0]=z;
        TwoBots instance = new TwoBots();
        boolean expResult = true;
        boolean result=instance.CheckBot1();
        assertEquals(expResult,result);
    }

    /**
     * Test of CheckBot2 method, of class TwoBots.
     */
    @Test
    public void testCheckBot2() {
        System.out.println("CheckBot2");
        TwoBots instance = new TwoBots();
        TwoBots x = new TwoBots();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayB1[0]=z;
        boolean expResult = true;
        boolean result=instance.CheckBot1();
        assertEquals(expResult,result);
    }

    /**
     * Test of TilePlacement method, of class TwoBots.
     */
    @Test
    public void testTilePlacement() {
        System.out.println("TilePlacement");
        Tiles tileP = null;
        int num = 0;
        int j = 0;
        TwoBots instance = new TwoBots();
        instance.TilePlacement(tileP, num, j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddMaxBot method, of class TwoBots.
     */
    @Test
    public void testAddMaxBot() {
        System.out.println("AddMaxBot");
        int flag2 = 0;
         TilePrep instance = new TilePrep();
        instance.SetTiles2();
        instance.SetPbTiles();
        instance.MaxTile();
        int expResult = 1;
        int result = instance.AddMaxBot(flag2);
        assertEquals(expResult, result);
    }

    /**
     * Test of Bot1Turn method, of class TwoBots.
     */
    @Test
    public void testBot1Turn() {
        System.out.println("Bot1Turn");
        int sumb = 0;
        TwoBots instance = new TwoBots();
        int expResult = 0;
        int result =0;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of Bot2Turn method, of class TwoBots.
     */
    @Test
    public void testBot2Turn() {
        System.out.println("Bot2Turn");
        int sumb = 0;
        TwoBots instance = new TwoBots();
        int expResult = 0;
        int result =0;
        assertEquals(expResult, result);
       
    }

    /**
     * Test of BotPoints method, of class TwoBots.
     */
    @Test
    public void testBotPoints() {
        System.out.println("BotPoints");
        Tiles[] arrayB = null;
        TwoBots instance = new TwoBots();
        int expResult = 0;
        int result = 0;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of PlayerPoints method, of class TwoBots.
     */
    @Test
    public void testPlayerPoints() {
        System.out.println("PlayerPoints");
        Tiles[] arrayP = null;
        TwoBots instance = new TwoBots();
        int expResult = 0;
        int result = 0;
        assertEquals(expResult, result);
        
    }
    
}