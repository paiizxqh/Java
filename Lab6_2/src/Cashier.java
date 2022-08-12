public class Cashier {
	
	private String name;
	
	public Cashier(String name) {
		this.name = name;
	}

	public void printReceipt(InventoryCart ic){ 
		int i,total = 0;
		System.out.println("---------------\n");
		System.out.println("Pumpkin Shop "+name);
		System.out.print("\n");
		
		
		

		System.out.println("---------------");
		System.out.println("\tTotal\t"+total);
	}
}