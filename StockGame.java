
public interface StockGame {
	
	public void buyShare(String playerName, String shareName, int count) throws NotEnoghMoneyException ,IllegalArgumentException;
	
	
}
