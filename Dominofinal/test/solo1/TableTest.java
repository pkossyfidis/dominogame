package solo1;

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
public class TableTest {
    
    public TableTest() {
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
     * Test of SetTiles method, of class Table.
     */
    @Test
    public void testSetTiles() {
        System.out.println("SetTiles");
        Table instance = new Table();
        instance.SetTiles();
        
    }

    /**
     * Test of FillTable method, of class Table.
     */
    @Test
    public void testFillTable() {
        System.out.println("FillTable");
        Table instance = new Table();
        instance.SetTiles();
        instance.FillTable();       
    }

    /**
     * Test of DispTable method, of class Table.
     */
    @Test
    public void testDispTable() {
        System.out.println("DispTable");
        Table instance = new Table();
        instance.SetTiles();
        instance.FillTable();
        instance.DispTable();      
    }

    /**
     * Test of SelectTile method, of class Table.
     */
    @Test
    public void testSelectTile() {
        System.out.println("SelectTile");
        Table instance = new Table();
        Tiles x = new Tiles(-1,-1);
        instance.SelectTile();
        instance.List.add(x);
         
        
    }

    /**
     * Test of TileList method, of class Table.
     */
    @Test
    public void testTileList() {
        System.out.println("TileList");
        Tiles t = new Tiles(4,3);
        Tiles t2 = new Tiles (3,4);
        Table instance = new Table();
        instance.TileList(t, t2);
    }

    /**
     * Test of DisTable method, of class Table.
     */
    @Test
    public void testDisTable() {
        System.out.println("DisTable");
        int y1 = 0;
        int y2 = 0;
        Table instance = new Table();
        instance.SetTiles();
        instance.FillTable();
        instance.DisTable(y1, y2);
       
    }

    /**
     * Test of DispList method, of class Table.
     */
    @Test
    public void testDispList() {
        System.out.println("DispList");
        Table instance = new Table();
        instance.DispList(); 
    }
    
}