package entity;

public abstract class Block extends Entity{
	public Block(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}


	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
