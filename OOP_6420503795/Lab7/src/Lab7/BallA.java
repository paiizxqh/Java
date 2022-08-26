package Lab7;

public class BallA extends Ball implements RollAble{

	public BallA(String tradeMark) {
		super(tradeMark);
	}

	public void roll() {
		System.out.println(this.getTradeMark()+" rolls rather smoothly.");
	}
	
	public void show(){
		System.out.println(this.getTradeMark()+" is a trademark of "+getClass().getSimpleName()+".");
	}
}
