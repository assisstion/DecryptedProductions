package elevatorEscape.Menu;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import elevatorEscape.Common.RunnableDispatcher;
import elevatorEscape.GameMechanics.GenericFloor;


public class MainEntry extends GraphicsProgram{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8547142870312209053L;
	
	private RunnableDispatcher disp;
	
	public static void main(String[] args){
		new MainEntry().start();
		
	}
	
	@Override
	public void run(){
		GRect rect = new GRect(10, 10, 20, 20);
		add(rect);
		
		System.out.println(GenericFloor.generateRandomFloor(3));
		
		RunnableDispatcher disp = new RunnableDispatcher(new MainEntryLoop(this), 1000, true);
		new Thread(disp).start();
	}
	
	@Override
	public void update(Graphics g){
		System.out.println("Hi");
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		System.out.println("o");
		if(e.getKeyCode() == KeyEvent.VK_UP){
			
			disp.stop();
			//go up
		}
	}
	
	public static class MainEntryLoop implements Runnable{
		
		public MainEntry entry;
		
		public MainEntryLoop(MainEntry entry){
			this.entry = entry;
		}
		
		@Override
		public void run(){
			// TODO Auto-generated method stub
			System.out.println("hi");
		}
		
	}
}
