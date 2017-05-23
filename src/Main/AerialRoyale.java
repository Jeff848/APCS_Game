package Main;
import java.awt.Dimension;

import javax.swing.JFrame;

import GUI.DrawingSurface;
import processing.awt.PSurfaceAWT;
/**
 * Creates the window that hosts the game
 * @author jeffrey_ma, yash_bengali, neeraj_senthil
 *
 */
public class AerialRoyale {
	public static void main (String[] args)
	{
		DrawingSurface drawing = new DrawingSurface();
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();
		window.setTitle("Aerial Royale");
		window.setLocation(0,0);
		window.setSize(drawing.displayWidth, drawing.displayHeight);
		
		
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
	}
}
