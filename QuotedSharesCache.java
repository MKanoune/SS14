
public interface QuotedSharesCache {
	public boolean isShareListed(String name);
	
	public String getCurrentShareRate(String shareName);
	
	public Share getShare(String name);
}
