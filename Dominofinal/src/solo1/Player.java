package solo1;
import domino.*;
/**
 *
 * @author Ελευθέριος Δημητρίου
 * @author Παναγιώτης Κοσσυφίδης
 */
public class Player {
    
    public void Start(){
        UserInterface ui = new UserInterface();
        ui.Player();
        Table x = new Table();
        x.SetTiles();
        x.FillTable();
        x.DispTable();
        x.SelectTile();
        x.DispList();
        
    }
}
