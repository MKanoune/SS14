

public class Share {
	private final String name;
	private Performance performance;
	private long price;
	
	public Share(String name,int price){
		this.name=name;
		this.price=price;
		this.performance=Performance.CONSTANT;
	}
	
	public void setPrice(long newPrice)throws IllegalArgumentException{
		if(newPrice < 0){
			throw new IllegalArgumentException("Aktien Preis kann nicht negativ sein!");
		}
		if(price > newPrice){
			performance=Performance.DECREASING;
		}else if(price < newPrice){
			performance = Performance.INCREASING;
		}else if(price == newPrice){
			performance = Performance.CONSTANT;
		}
		price = newPrice;
	}
	
	public Performance getPerformance(){
		return performance;
	}
	
	public String getName(){
		return name;
	}
	
	public long getPrice(){
		return price;
	}
	
	@Override
	public String toString(){
		String out = name + " @ " + price + " " + performance;
		return out;
	}
	
	public enum Performance{
		INCREASING,CONSTANT,DECREASING
	}
	
}
