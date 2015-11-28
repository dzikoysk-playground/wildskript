package net.dzikoysk.wildskript.util;

import java.util.LinkedList;

public class WildSkriptTimer implements Runnable {
	
	private transient long lastPoll = System.nanoTime();
	private final LinkedList<Double> history = new LinkedList<>();
	  
	public WildSkriptTimer(){
		this.history.add(Double.valueOf(20.0D));
	}

	public void run(){
		long startTime = System.nanoTime();
	    long timeSpent = (startTime - this.lastPoll) / 1000L;
	    if (timeSpent == 0L) timeSpent = 1L;
	    if (this.history.size() > 10) this.history.remove();
	    double tps = 50000000.0D / timeSpent;
	    if (tps <= 21.0D) this.history.add(Double.valueOf(tps));
	    this.lastPoll = startTime;
	}
	
	public double getTPS(){
		double avg = 0.0D;
	    for (Double f : this.history) if (f != null) avg += f.doubleValue();
	    return avg / this.history.size();
	}
}
