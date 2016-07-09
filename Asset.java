
public abstract class Asset {
	private final String name;
	protected long value;
	
	public Asset(String name){
		this.name = name;
	}
	
	public abstract long getValue();
	
	@Override
	public String toString(){
		String s = name + " " + value;
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
