import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class Connect4 extends PApplet {

	public void settings() {
    size(700, 700);
	}

	private boolean mouseClicked = false;
	private String screen = "start";
	private Player player;
	private HumanPlayer me = new HumanPlayer(0, Color.WHITE, this, true);
	private Player currentPlayer = me;
	private GameFrame board;
	private String playerType;
	public void setup() {
    	background(0);
    	//noLoop();
		board = new GameFrame(700, 700, loadImage("connect4.png"));
  	}

  	public void draw() {
		switch (screen) {
			case "start":
				textSize(30);
				text("Welcome to Connect 4!", 170, 250);
				fill(0, 102, 153);
				text("Click to start playing", 190, 300);
				fill(0, 102, 153, 51);
				break;

			case "selection":
				background(0); //reset background to gray
				textSize(18);
				fill(0, 102, 153, 255);
				text("Choose your Opponent:", 10, 30);
				text("Random Player", 40, 70);
				text("Smart Player", 40, 90);
				text("Human Player (Friend)", 40, 110);
				if (mouseX > 20 && mouseX < 250) {
					if (mouseY > 49 && mouseY < 70) {
						fill(255, 255, 0);
						triangle(25, 50, 35, 60, 25, 70);
					} else if (mouseY > 69 && mouseY < 90) {
						fill(255, 255, 0);
						triangle(25, 70, 35, 80, 25, 90);
					} else if (mouseY > 89 && mouseY < 110) {
						fill(255, 255, 0);
						triangle(25, 90, 35, 100, 25, 110);
					}
				}
				break;


			case ("gameOn"):

				//renders board and markers
				background(0);//reset background to gray
				image(board.getGameBoard(), board.centeredX(), 200);
				textSize(15);
				fill(0, 102, 153, 255);
				text(playerType, 5, 15);
				if (board.getMarkers().size() > 0) {
					for (Marker marker : board.getMarkers()) {
						fill(marker.getColor().getRGB());
						if (marker.getRow() != -1) {
							circle(board.centeredX() + 36 + 70 * (marker.getColumn() - 1),
									238 + 70 * (marker.getRow() - 1), 56);
						}
					}
				}

				if(me.myTurn) {
					textSize(25);
					fill(0, 102, 153, 255);
					text("Your turn!", 220, 100);
					currentPlayer = me;
				}
				else if(player.myTurn) {
					textSize(25);
					fill(0, 102, 153, 255);
					text("Their turn!", 220, 100);
					if (player instanceof SmartPlayer) {
						player.takeTurn(0, board);
						me.toggleTurn();
						player.toggleTurn();
					}
					currentPlayer = player;
				}

			// INDICATOR TO SHOW WHERE MARKER WILL BE PLACED

				if (mouseX >= board.centeredX() && mouseX < board.centeredX() + 491) {
					int col = ((mouseX - board.centeredX()) / 70) + 1;
					int row = board.lowestRow(col);
					if (row != -1) {
						fill(currentPlayer.markerColor.getRGB());
						triangle(board.centeredX() + 11 + (col - 1) * 70, 185,
								board.centeredX() + 36 + (col - 1) * 70, 195,
								board.centeredX() + 60 + (col - 1) * 70, 185);
						circle(board.centeredX() + 36 + (col - 1) * 70, 238 + (row - 1) * 70, 56);
					}
				}
				break;
		}
	}

  	public void mousePressed() {
		switch (screen) {
			case "start":
				screen = "selection";
				break;

			case "selection":
				if (mouseX > 20 && mouseX < 150) {
					if (mouseY > 49 && mouseY < 70) {
						screen = "gameOn";
						playerType = "idk";
					}
					else if (mouseY > 69 && mouseY < 90) {
						screen = "gameOn";
						player = new SmartPlayer(0, Color.RED, this);
						playerType = "Smart Player";
					}
					else if (mouseY > 89 && mouseY < 110) {
						player = new HumanPlayer(0, Color.RED, this, false);
						screen = "gameOn";
						playerType = "Human Player";
					}
				}
				break;

			case "gameOn":
				if (mouseX >= board.centeredX() && mouseX < board.centeredX() + 491) {
					int col = ((mouseX - board.centeredX()) / 70) + 1;
					if (board.lowestRow(col) != -1) {
						if (me.myTurn) {
							me.takeTurn(col, board);
							me.toggleTurn();
							player.toggleTurn();
						}
						else if (player.myTurn && player instanceof HumanPlayer){
							player.takeTurn(col, board);
							me.toggleTurn();
							player.toggleTurn();
						}
					}
				}
				break;
		}

	}

  	public static void main(String args[]) {
      PApplet.main("Connect4");
   }
}
