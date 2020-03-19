package simulator;
import java.util.Observable;

public abstract class State extends Observable {
	
	public double time = 0.0;
	public boolean running = true;
	
	public void stop() {
		running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void updateObservers(Event<?> event) {
		setChanged();
		notifyObservers(event);
	}
}