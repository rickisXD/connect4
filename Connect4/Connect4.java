import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class Connect4 extends PApplet {

	public void settings() {
    size(700, 700);
	}

	private boolean mouseClicked = false;
	private String screen = "start";
	private HumanPlayer me = new HumanPlayer(0, true, Color.WHITE);
	private Player player;
	private Player currentPlayer;
	private GameFrame board;
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
				background(0);//reset background to gray
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
//				if (!board.isRendered()) {
					background(0);//reset background to gray
					image(board.getGameBoard(), board.centeredX(), 200);
					board.setRendered();
//				}
				if (board.getMarkers().size() > 0) {
					for (Marker marker : board.getMarkers()) {
						fill(marker.getColor().getRGB());
						circle(board.centeredX() + 36 + 70 * (marker.getColumn() - 1), 238 + 70 * (marker.getRow() - 1), 56);
					}
				}

				textSize(25);
				fill(0, 102, 153, 255);
				text("Your turn!", 220, 100);

			// INDICATOR TO SHOW WHERE MARKER WILL BE PLACED
				if (mouseX >= board.centeredX() + 0 && mouseX < board.centeredX() + 71) {
					fill(me.markerColor.getRGB());
					triangle(board.centeredX() + 11, 185, board.centeredX() + 36, 195, board.centeredX() + 60, 185);
					circle(board.centeredX() + 36, 200+388 /* 238 + (board.lowestRow(1) - 1) * 70 */, 56);
				}
				//col 2
				if (mouseX >= board.centeredX() + 71 && mouseX < board.centeredX() + 142) {
					fill(me.markerColor.getRGB());
					triangle(board.centeredX() + 81, 185, board.centeredX() + 106, 195, board.centeredX() + 130, 185);
					circle(board.centeredX() + 106, 200+388 /* 200 + (board.lowestRow(2) - 1) * 70 + 38 */, 56);
				}
				//col 3
				if (mouseX >= board.centeredX() + 142 && mouseX < board.centeredX() + 213) {
					fill(me.markerColor.getRGB());
					triangle(board.centeredX() + 151, 185, board.centeredX() + 176, 195, board.centeredX() + 200, 185);
					circle(board.centeredX() + 176, 200+388 /* 200 + (board.lowestRow(3) - 1) * 70 + 38 */, 56);
				}
				//col 4
				if (mouseX >= board.centeredX() + 213 && mouseX < board.centeredX() + 284) {
					fill(me.markerColor.getRGB());
					triangle(board.centeredX() + 221, 185, board.centeredX() + 246, 195, board.centeredX() + 270, 185);
					circle(board.centeredX() + 246, 200+388 /* 200 + (board.lowestRow(4) - 1) * 70 + 38 */, 56);
				}
				//col 5
				if (mouseX >= board.centeredX() + 284 && mouseX < board.centeredX() + 355) {
					fill(me.markerColor.getRGB());
					triangle(board.centeredX() + 291, 185, board.centeredX() + 316, 195, board.centeredX() + 340, 185);
					circle(board.centeredX() + 316, 200+388 /* 200 + (board.lowestRow(5) - 1) * 70 + 38 */, 56);
				}
				//col 6
				if (mouseX >= board.centeredX() + 355 && mouseX < board.centeredX() + 426) {
					fill(me.markerColor.getRGB());
					triangle(board.centeredX() + 361, 185, board.centeredX() + 386, 195, board.centeredX() + 410, 185);
					circle(board.centeredX() + 386, 200+388 /* 200 + (board.lowestRow(6) - 1) * 70 + 38 */, 56);
				}
				//col 7
				if (mouseX >= board.centeredX() + 426 && mouseX < board.centeredX() + 487) {
					fill(me.markerColor.getRGB());
					triangle(board.centeredX() + 431, 185, board.centeredX() + 456, 195, board.centeredX() + 480, 185);
					circle(board.centeredX() + 456, 200+388 /* 200 + (board.lowestRow(7) - 1) * 70 + 38 */, 56);
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
				mouseClicked = true;
				if (mouseX > 20 && mouseX < 150) {
					if (mouseY > 49 && mouseY < 70) {
						screen = "gameOn";
					}
					else if (mouseY > 69 && mouseY < 90) {
						screen = "gameOn";
						player = new SmartPlayer(0, false, Color.RED);
					}
					else if (mouseY > 89 && mouseY < 110) {
						player = new HumanPlayer(0, false, Color.RED);
						screen = "gameOn";
					}
				}
				break;

			case "gameOn":
				//col 1
				if (mouseX >= board.centeredX() + 0 && mouseX < board.centeredX() + 71) {
					fill(me.markerColor.getRGB());
					circle(board.centeredX() + 36, 200+388 /* 200 + (board.lowestRow(1) - 1) * 70 + 38 */, 56);
					board.addMarker(new Marker(me.markerColor, board.lowestRow(1), 1));

				}
				//col 2
				if (mouseX >= board.centeredX() + 71 && mouseX < board.centeredX() + 142) {
					fill(me.markerColor.getRGB());
					circle(board.centeredX() + 106, 200+388 /* 200 + (board.lowestRow(2) - 1) * 70 + 38 */, 56);
					board.addMarker(new Marker(me.markerColor, board.lowestRow(2), 2));
				}
				//col 3
				if (mouseX >= board.centeredX() + 142 && mouseX < board.centeredX() + 213) {
					fill(me.markerColor.getRGB());
					circle(board.centeredX() + 176, 200+388 /* 200 + (board.lowestRow(3) - 1) * 70 + 38 */, 56);
					board.addMarker(new Marker(me.markerColor, board.lowestRow(3), 3));
				}
				//col 4
				if (mouseX >= board.centeredX() + 213 && mouseX < board.centeredX() + 284) {
					fill(me.markerColor.getRGB());
					circle(board.centeredX() + 246, 200+388 /* 200 + (board.lowestRow(4) - 1) * 70 + 38 */, 56);
					board.addMarker(new Marker(me.markerColor, board.lowestRow(4), 4));
				}
				//col 5
				if (mouseX >= board.centeredX() + 284 && mouseX < board.centeredX() + 355) {
					fill(me.markerColor.getRGB());
					circle(board.centeredX() + 316, 200+388 /* 200 + (board.lowestRow(5) - 1) * 70 + 38 */, 56);
					board.addMarker(new Marker(me.markerColor, board.lowestRow(5), 5));
				}
				//col 6
				if (mouseX >= board.centeredX() + 355 && mouseX < board.centeredX() + 426) {
					fill(me.markerColor.getRGB());
					circle(board.centeredX() + 386, 200+388 /* 200 + (board.lowestRow(6) - 1) * 70 + 38 */, 56);
					board.addMarker(new Marker(me.markerColor, board.lowestRow(6), 6));
				}
				//col 7
				if (mouseX >= board.centeredX() + 426 && mouseX < board.centeredX() + 487) {
					fill(me.markerColor.getRGB());
					circle(board.centeredX() + 456, 200+388 /* 200 + (board.lowestRow(7) - 1) * 70 + 38 */, 56);
					board.addMarker(new Marker(me.markerColor, board.lowestRow(7), 7));
				}
				break;
		}

	}

	public void mouseMoved() {
		switch (screen) {
			case "start":
				break;

			case "selection":
//				if (mouseX > 20 && mouseX < 150) {
//					if (mouseY > 49 && mouseY < 70) {
//						triangle(25, 50, 35, 60, 25, 70);
//						fill(255, 255, 0);
//					}
//					else if (mouseY > 69 && mouseY < 90) {
//						triangle(25, 70, 35, 80, 25, 90);
//						fill(255, 255, 0);
//					}
//					else if (mouseY > 89 && mouseY < 110) {
//						triangle(25, 90, 35, 100, 25, 110);
//						fill(255, 255, 0);
//					}
//				}
				//
				break;

			case "gameOn":
				//logic for game sequence
				break;
		}
	}

	public void dropMarker(Player player, int row, int column) {

	}

  	public static void main(String args[]) {
      PApplet.main("Connect4");
   }
}
