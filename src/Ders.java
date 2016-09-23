import org.jsoup.select.Elements;

public class Ders {
	String dersAdi;
	Sube[] sube;
	public Ders(String d,  int subeSayisi){
		sube= new Sube[subeSayisi];
		dersAdi=d;
		}
	public void subeEkle(Elements row,int subeNo){
		sube[subeNo]=new Sube(row);
	}
	public void subeyeYaz(int subeNo, Sube tmpSube){
		sube[subeNo]=tmpSube;
	}


	
}
