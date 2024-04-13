package ItemInteract;
import main.GamePanel;

public class ItemInteract {
    GamePanel gamePanel;
    BallInteract ballInteract;
    MyPCInteract myPCInteract;
    public ItemInteract(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        ballInteract = new BallInteract(gamePanel);
        myPCInteract = new MyPCInteract(gamePanel);
    }
    public void update(){
        if (gamePanel.inventory.isUsingItem) {
            switch (gamePanel.inventory.usingItem.Name) {
                case "Ball": {
                    ballInteract.update();
                }
                case "My PC": {
                    myPCInteract.update();
                }
            }
        }
    }
}
