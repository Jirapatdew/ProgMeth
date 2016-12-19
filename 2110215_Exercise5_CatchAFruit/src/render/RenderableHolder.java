package render;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities = new CopyOnWriteArrayList<IRenderable>();
	
	public static RenderableHolder getInstance() {
		return instance;
	}
	public RenderableHolder() {
		entities = new CopyOnWriteArrayList<IRenderable>();
	}
	
	public void add(IRenderable a) {
		entities.add(a);
		
		Collections.sort(entities, new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if(o1.getZ() > o2.getZ()) return 1;
				return -1;
			}
		});
	}
	public List<IRenderable> getRenderableList() {
		return entities;
	}
	
	
	
}
