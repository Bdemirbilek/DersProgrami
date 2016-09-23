
public class Program {
	String name;
	Ders[] dersler;
	int dersSayisi;
	public Program(String n){
		name=n;
		dersSayisi=0;
		this.dersler=new Ders[20];
	}
	public void dersEkle(String d, Sube sube){
		dersler[dersSayisi]=new Ders(d, 1);
		dersler[dersSayisi].subeyeYaz(0, sube);
	}


}
