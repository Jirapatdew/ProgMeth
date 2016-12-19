package app;

import java.util.LinkedList;
import java.util.Queue;

import twitterlib.SharedData;
import twitterlib.Tweet;

public class TweetQueue implements SharedData<Tweet> {
	
	private Queue<Tweet> queue;

	public TweetQueue() {
		queue = new LinkedList<Tweet>();
	}
	
	synchronized public void put(Tweet a) {
		queue.add(a);
	}
	
	synchronized public Tweet take() {
		if(queue.isEmpty()) return null;
		else return queue.remove();
	}
	
	
}
