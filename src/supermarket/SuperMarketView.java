package supermarket;

import java.util.Observable;

import simulator.View;
import supermarketevents.StartEvent;
import supermarketevents.StopEvent;

public class SuperMarketView extends View {

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof StartEvent) {
			printStart((StartEvent) arg);
		} else if (arg instanceof StopEvent) {
			printStop((StopEvent) arg);
		}
	}

	private void printStart(StartEvent arg) {
		// TODO Print start stuff
	}

	private void printStop(StopEvent arg) {
		// TODO Print stop stuff
	}

}
