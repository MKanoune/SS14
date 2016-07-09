
public class StockGameImpl implements StockGame{
	
	private QuotedSharesCache quotedShare = new QuotedSharesCacheImpl();
	
	public StockGameImpl(){
		
	}
	
	private Player getPlayerOrException(String playerName){
		return null;
	}

	@Override
	public void buyShare(String playerName, String shareName, int count) throws NotEnoghMoneyException, IllegalArgumentException{
		Player player = getPlayerOrException(playerName);
		if(quotedShare.isShareListed(shareName)){
			Share share = quotedShare.getShare(shareName);
			long cost = share.getPrice()*count;
			player.portfolio.buy(share, count);
			player.cashAccount.withdraw(cost);
		}else{
			throw new IllegalArgumentException("ShareName nicht vorhanden");
		}
		
		
	}
	
	
}
