package Project;

public class b {
	int a;
	String name;
	
	
public b(int a, String name) {
		this.a = a;
		this.name = name;
	}





@Override
public String toString() {
	return "b [a=" + a + ", name=" + name + "]";
}





public static void main(String[] args) {
	b b1=new b(1,"vignesh");
	
	System.out.println(b1);
}
}
