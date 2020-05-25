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
public class MainGameTest {
    
    public MainGameTest() {
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
     * Test of SetTiles method, of class MainGame.
     */
    @Test
    public void testSetTiles() {
        System.out.println("SetTiles");
        MainGame instance = new MainGame();
        instance.SetTiles();
        
    }

    /**
     * Test of SetPbTiles method, of class MainGame.
     */
    @Test
    public void testSetPbTiles() {
        System.out.println("SetPbTiles");
        MainGame instance = new MainGame();
        instance.SetTiles();
        instance.SetPbTiles();
        
    }

    /**
     * Test of DisTilesP method, of class MainGame.
     */
    @Test
    public void testDisTilesP() {
        System.out.println("DisTilesP");
        MainGame instance = new MainGame();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.DisTilesP();
    }

    /**
     * Test of DisTilesB method, of class MainGame.
     */
    @Test
    public void testDisTilesB() {
        System.out.println("DisTilesB");
        MainGame instance = new MainGame();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.DisTilesB();
    }

    /**
     * Test of MaxTile method, of class MainGame.
     */
    @Test
    public void testMaxTile() {
        System.out.println("MaxTile");
        MainGame instance = new MainGame();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.MaxTile();
    }

    /**
     * Test of GameOla7 method, of class MainGame.
     */
    @Test
    public void testGameOla7() {
        System.out.println("GameOla7");
        MainGame instance = new MainGame();
        instance.GameOla7();
        
    }

    /**
     * Test of DispDominoLine method, of class MainGame.
     */
    @Test
    public void testDispDominoLine() {
        System.out.println("DispDominoLine");
        MainGame instance = new MainGame();
        instance.DispDominoLine();
        
    }

    /**
     * Test of CheckPlayer method, of class MainGame.
     */
    @Test
    public void testCheckPlayer() {
        System.out.println("CheckPlayer");
        MainGame x = new MainGame();
        Tiles y = new Tiles(6,6);
        Tiles z = new Tiles(6,4);       
        
        x.arrayP[0]=z;
        System.out.println("CheckPlayer");
        MainGame instance = new MainGame();
        boolean expResult = true;
        boolean result=instance.CheckPlayer();
        assertEquals(expResult,result);
        
    }

    /**
     * Test of CheckBot method, of class MainGame.
     */
    @Test
    public void testCheckBot() {
        System.out.println("CheckBot");
        MainGame x = new MainGame();
        Tiles y = new Tiles(5,6);
        Tiles z = new Tiles(6,4);       
        
        x.arrayB[0]=z;
        MainGame instance = new MainGame();
        boolean expResult = true;
        boolean result=instance.CheckBot();
        assertEquals(expResult,result);
    }

    /**
     * Test of AddMaxBot method, of class MainGame.
     */
    @Test
    public void testAddMaxBot() {
        System.out.println("AddMaxBot");
        int flag2 = 0;
        MainGame instance = new MainGame();
       System.out.println("AddMaxBot");
       
        instance.SetTiles();
        instance.SetPbTiles();
        instance.MaxTile();
        int expResult = 1;
        int result = instance.AddMaxBot(flag2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of FakeTile method, of class MainGame.
     */
    @Test
    public void testFakeTile() {
        System.out.println("FakeTile");
        int pos = 0;
        int Turn = 0;
        MainGame instance = new MainGame();
        instance.FakeTile(pos, Turn);
        
    }


    /**
     * Test of TilePlacement method, of class MainGame.
     */
    @Test
    public void testTilePlacement() {
        System.out.println("TilePlacement");
        Tiles tileP = new Tiles(3,5);
        int num = 0;
        int j = 0;
        MainGame instance = new MainGame();
        instance.SetTiles();
        instance.SetPbTiles();
        instance.arrayB[0]=tileP;
        instance.TilePlacement(tileP, num, j);
       
    }
    
}
