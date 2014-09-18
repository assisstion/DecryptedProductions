package elevatorEscape.Common;

/**
 * A class for dispatching Runnables at a fixed pace
 * @author markusfeng
 *
 */
public class RunnableDispatcher implements Runnable{
	
	protected Runnable run;
	protected int delay;
	protected boolean looping;
	protected boolean active;
	
	/**
	 * Creates a RunnableDispatcher
	 * @param run the runnable to dispatch
	 * @param delay delay in milliseconds to perform the runnable
	 * @param looping if true, runnable runs until stop() is called or program ends
	 */
	public RunnableDispatcher(Runnable run, int delay, boolean looping){
		this.run = run;
		this.delay = delay;
		this.looping = looping;
	}
	
	/**
	 * Stops the RunnableDispatcher
	 * Start run() again if continuation is desired
	 */
	public void stop(){
		active = false;
	}
	
	/**
	 * Runs the dispatcher, dispatching Runnables at a fixed pace.
	 */
	@Override
	public void run(){
		active = true;
		// TODO Auto-generated method stub
		while(active){
			try{
				new Thread(run).start();
				Thread.sleep(delay);
			}
			catch(InterruptedException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
