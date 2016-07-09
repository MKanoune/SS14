import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SharePortfolio extends Asset {
	private Map <Share,Integer> shareNumbers = new HashMap<Share,Integer>();
	
	public SharePortfolio(String name){
		super(name);
	}

	@Override
	public long getValue() {
		long value = 0;
		for(Entry<Share, Integer> s : shareNumbers.entrySet()){
			value += s.getValue()*s.getKey().getPrice();
		}
		return value;
	}
	
	public void buy(Share share, int count){
		if(shareNumbers.containsKey(share)){
			Integer value = shareNumbers.get(share);
			value+=count;
			shareNumbers.put(share, value);
		}else{
			shareNumbers.put(share, count);
		}
	}
	
	public int getNumber(Share share){
		return shareNumbers.get(share);
	}
}
