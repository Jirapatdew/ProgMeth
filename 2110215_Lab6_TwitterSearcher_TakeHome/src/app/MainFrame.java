package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import twitter4j.TwitterException;
import twitterlib.Tweet;
import twitterlib.TwitterConnector;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TweetQueue tweetQueue;
	private TwitterConnector twitterConnector;
	private JPanel displayPanel;
	private JScrollPane scrollPane;
	
	public MainFrame() {
		
		tweetQueue = new TweetQueue();
		try {
			twitterConnector = new TwitterConnector();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			System.out.println("TwitterConnector Exception");
			e2.printStackTrace();
		}
		setTitle("Twitter Searcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		
		JPanel panal = new JPanel();
		JLabel label = new JLabel("Query string : ");
		JTextField textField = new JTextField();
		JButton button = new JButton("Search");
		
		add(panal,BorderLayout.NORTH);
		panal.setLayout(new BorderLayout(5,0));
		panal.add(label,BorderLayout.WEST);
		panal.add(textField,BorderLayout.CENTER);
		panal.add(button,BorderLayout.EAST);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String keyword = textField.getText();
				Thread thread;
				
				if(!keyword.isEmpty()) {
					thread = new Thread(new Runnable() {
						
						@Override
						public void run() {
							System.out.println("Run....");
							button.setEnabled(false);
							
							try {
								displayPanel.removeAll();
								twitterConnector.searchAndProcess(keyword, tweetQueue);
							} catch (TwitterException e) {
								// TODO Auto-generated catch block
								System.out.println("TwitterException.");
								e.printStackTrace();
							} 
							finally {
								System.out.println("End.");
								button.setEnabled(true);
							}
						}
						
					});
					thread.start();
				}
				else {
					System.out.println("keyword is invalid");
				}
			}
		});
		
		displayPanel = new JPanel();
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
		
		scrollPane = new JScrollPane(displayPanel);
		scrollPane.setPreferredSize(new Dimension(600, 400));
		
		add(scrollPane,BorderLayout.CENTER);
		pack();
	}
	
	public void update() {
		while(true) {
			
			Tweet tweet = tweetQueue.take();
			if(tweet == null) {
				try {
					synchronized (tweetQueue) {
						tweetQueue.wait();
					}
				} catch(InterruptedException e) {}
				continue;
			}
			
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					displayPanel.add(new TweetDisplay(tweet));
				}
			});
			this.validate();
		}
	}
}
