package logic;

public interface Rentable {
	void rent(String renterName, int rentOption);
	double giveBack();
}
