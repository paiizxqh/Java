
public class InventoryCart {
	
	private Product[] productArr;
	private int productIndex = 0;
	
	public void addProduct(Product num){
		productArr[productIndex++] = num;
	}
	public InventoryCart(int a){
		productArr = new Product[a];
	}
	//ออกทีละชิ้น
	public Product getProduct(int index) {
		return productArr[index];
	}
	//ออกทั้งหมด
	public Product[] getAllProduct() {
		return productArr;
	}

}
