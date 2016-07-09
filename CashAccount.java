
public class CashAccount extends Asset{
	private static long balance;
	
	
	public CashAccount(String name) {
		super(name);
		
	}

	@Override
	public long getValue() {
		return value;
	}
	
	public void deposit(long value){
		if(value < 0){
			throw new NotEnoghMoneyException("Übergabewert darf nicht 0 sein!");
		}
		this.value+=value;
	}
	
	public void withdraw(long value)throws NotEnoghMoneyException{
		if(value < 0){
			throw new NotEnoghMoneyException("Übergabewert darf nicht 0 sein!");
		}
		else if(this.value - value < 0){
			throw new NotEnoghMoneyException("NotEnoughMoneyException: Kosten: "+value+" > Kontostand: "+balance);
		}
		this.value -= value;
		
		
		
		
	}
	
	

}
