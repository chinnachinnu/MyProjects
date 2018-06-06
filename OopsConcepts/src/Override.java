
public class Override {
void run() {
	System.out.println("hello");
}
}
class Ride extends Override{
	void run() {
		System.out.println("world");
	}
	public static void main(String[] args) {
		Ride r=new Ride();
		r.run();
	}
}
