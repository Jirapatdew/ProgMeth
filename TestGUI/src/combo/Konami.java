package combo;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

public class Konami {

    private static final int LEFT = KeyEvent.VK_LEFT;
	private static final int B = KeyEvent.VK_B;
	private static final int UP = KeyEvent.VK_UP;
	private static final int RIGHT = KeyEvent.VK_RIGHT;
	private static final int DOWN = KeyEvent.VK_DOWN;
	static private int[] code = 
        {UP, UP, DOWN, DOWN, LEFT, RIGHT, LEFT, RIGHT, B};
    static private Map<Integer, Integer>[] graph;
    static private int currentNode = 0;

    public static void main(String args[]) {
        //Create graph
        graph = generateSequenceMap(code);

        //Call checkKonami(key) whenever a key is pressed
        Frame f = new JFrame();
        f.setSize(new Dimension(400, 400));
        f.setVisible(true);
        f.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				boolean a = checkKonami(e.getKeyCode());
				System.out.println(a);
			}
		});
    }


    static public boolean checkKonami(int keyPressed) {
        Integer nextNode = graph[currentNode].get(keyPressed);

        //Set currentNode to nextNode or to 0 if no matching sub-sequence exists
        currentNode = (nextNode==null ? 0 : nextNode);

        return currentNode == code.length-1;
    }


    static private Map<Integer, Integer>[] generateSequenceMap(int[] sequence) {

        //Create map
        Map<Integer, Integer>[] graph = new Map[sequence.length];
        for(int i=0 ; i<sequence.length ; i++) {
            graph[i] = new TreeMap<Integer,Integer>();
        }

        //i is delta
        for(int i=0 ; i<sequence.length ; i++) {
            loop: for(int j=i ; j<sequence.length-1 ; j++) {
            if(sequence[j-i] == sequence[j]) {
                System.out.println("If at Node "+j+" you give me seq["+(j-i+1) 
                        + "] OR " + (sequence[j-i+1]) + " , goto Node " + (j-i+1));

                //Ensure that the longest possible sub-sequence is recognized
                Integer value = graph[j].get(sequence[j-i+1]);
                if(value == null || value < j-i+1)
                    graph[j].put(sequence[j-i+1], j-i+1);
            }
            else
                break loop;
            }
        }
        return graph;
    }
}