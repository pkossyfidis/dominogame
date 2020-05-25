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
public class TilePrepTest {
    
    public TilePrepTest() {
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
     * Test of SetTiles2 method, of class TilePrep.
     */
    @Test
    public void testSetTiles2() {
        System.out.println("SetTiles2");
        TilePrep instance = new TilePrep();
        instance.SetTiles2();
        
    }

    /**
     * Test of SetPbTiles method, of class TilePrep.
     */
    @Test
    public void testSetPbTiles() {
        System.out.println("SetPbTiles");
        TilePrep instance = new TilePrep();
        instance.SetTiles2();
        instance.SetPbTiles();
        
    }

    /**
     * Test of DisTilesP method, of class TilePrep.
     */
    @Test
    public void testDisTilesP() {
        System.out.println("DisTilesP");
        TilePrep instance = new TilePrep();
        instance.SetTiles2();
        instance.SetPbTiles();
        instance.DisTilesP();
        
    }

    /**
     * Test of DisTilesB method, of class TilePrep.
     */
    @Test
    public void testDisTilesB() {
        System.out.println("DisTilesB");
        TilePrep instance = new TilePrep();
        instance.SetTiles2();
        instance.SetPbTiles();
        instance.DisTilesB();
        
    }

    /**
     * Test of MaxTile method, of class TilePrep.
     */
    @Test
    public void testMaxTile() {
        System.out.println("MaxTile");
        TilePrep instance = new TilePrep();
        instance.SetTiles2();
        instance.SetPbTiles();
        instance.MaxTile();
        
    }

    /**
     * Test of Game method, of class TilePrep.
     */
    @Test
    public void testGame() {
        System.out.println("Game");
        TilePrep instance = new TilePrep();
        instance.Game();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DispDominoLine method, of class TilePrep.
     */
    @Test
    public void testDispDominoLine() {
        System.out.println("DispDominoLine");
        TilePrep instance = new TilePrep();
        instance.DispDominoLine();
       
    }

    /**
     * Test of CheckPlayer method, of class TilePrep.
     */
    @Test
    public void testCheckPlayer() {
        System.out.println("CheckPlayer");
        TilePrep x = new TilePrep();
        Tiles y = new Tiles(6,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayP[0]=z;
        System.out.println("CheckPlayer");
        TilePrep instance = new TilePrep();
        boolean expResult = true;
        boolean result=instance.CheckPlayer();
        assertEquals(expResult,result);
    }

    /**
     * Test of CheckBot method, of class TilePrep.
     */
    @Test
    public void testCheckBot() {
        TilePrep x = new TilePrep();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        x.DominoLine.addFirst(y);
        x.arrayB[0]=z;
        TilePrep instance = new TilePrep();
        boolean expResult = true;
        boolean result=instance.CheckBot();
        assertEquals(expResult,result);
    }

    /**
     * Test of PlayerPoints method, of class TilePrep.
     */
    @Test
    public void testPlayerPoints() {
        System.out.println("PlayerPoints");
        Tiles[] arrayP = null;
        TilePrep instance = new TilePrep();
        int expResult = 0;
        int result = instance.PlayerPoints(arrayP);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BotPoints method, of class TilePrep.
     */
    @Test
    public void testBotPoints() {
        System.out.println("BotPoints");
        Tiles x = new Tiles(0,0);
        TilePrep instance = new TilePrep();
        int expResult =0;
        int result = 0;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of AddMaxBot method, of class TilePrep.
     */
    @Test
    public void testAddMaxBot() {
        System.out.println("AddMaxBot");
        int flag2 = 0;
        TwoBots instance = new TwoBots();
        instance.SetTiles3();
        instance.SetPbTiles();
        instance.MaxTile();
        int expResult = 1;
        int result = instance.AddMaxBot(flag2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of FakeTile method, of class TilePrep.
     */
    @Test
    public void testFakeTile() {
        System.out.println("FakeTile");
        int pos = 0;
        int Turn = 0;
        TilePrep instance = new TilePrep();
        instance.SetTiles2();
        instance.SetPbTiles();
        instance.AddMaxBot(Turn);
        instance.FakeTile(pos, Turn);      
    }

    /**
     * Test of TilePlacement method, of class TilePrep.
     */
    @Test
    public void testTilePlacement() {
        System.out.println("TilePlacement");
       int sumb = 0;
        TwoBots instance = new TwoBots();
        int expResult = 0;
        int result =0;
        assertEquals(expResult, result);
        
    }
    
}