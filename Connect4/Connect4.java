import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class Connect4 extends PApplet {

	public void settings() {
    size(700, 700);
	}

	private boolean start = true;
	private boolean selection = false;
	private boolean redraw = false;
	PImage img;
	public void setup() {
    	background(0);
    	//noLoop();

		img = loadImage("connect4.png");
		GameFrame board = new GameFrame(700, 700, img);
  	}

  	public void draw() {

		if (start)
		{
			textSize(30);
			text("Welcome to Connect 4!", 170, 250);
			fill(0, 102, 153);
			text("Click to start playing", 190, 300);
			fill(0, 102, 153, 51);
			start= false;
		}

		if(redraw)
		{

			background(0);//reset background to gray
			image(img,100,200);


//			//you can comment the next 3 lines out after you are done!
			textSize(18);
			fill(0, 102, 153, 255);
			text("Choose your Opponent:", 10, 30);

			text("Random Player", 40, 70);
			text("Smart Player", 40, 90);
			text("Unbeatable Player", 40, 110);
			text("Human Player (Friend)", 40, 130);
			//this will create a red line 10 pixel under the mouseclick
			Color red = new Color(255,0,0);
			stroke(red.getRed(),red.getBlue(),red.getGreen());
			line(mouseX,mouseY+10,mouseX+100,mouseY+10);
//
//			//this will create a green rectangle
			stroke(0,255,0);
			fill(0,255,0);
			rect(100, 250, 100, 50);
//
//			//this will create a blue dot at the place you clicked
//			// for better visualization you can make this spot several pixels large
			stroke(0,0,255);
			point(mouseX,mouseY);

			redraw = false;
		}



  	}
  	public void mousePressed()
	{
		redraw= true;

	}

  	public static void main(String args[]) {
      PApplet.main("Connect4");
   }
}
