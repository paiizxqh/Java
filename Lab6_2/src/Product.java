public class Product {
	
	private String code;
	private String name;
	protected int price;
	protected int weight;
	protected int volumn;
	
	public Product(String code, String name, int price){
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	  }
	
	public void setVoumn(int volumn) {
		this.volumn = volumn;
	  }
	
	//Getter
	public String getCode(){
		return code;
	}
	public String getName(){
		return name;
	}
	public int getPrice(){
		return price;
	}
	
	//Setter
	public void setCode(String code){
		this.code = code;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrice(int price){
		this.price = price;
	}
}