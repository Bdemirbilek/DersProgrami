
public class dersSaati {
	int gun;
	int saat;
	int sube;
	String isim;
	String sinif;
	//sinif daha kullanilmiyor
	public dersSaati(int gun, int saat, String isim, String sinif, int sube){
		this.gun=gun;
		this.saat=saat;
		this.isim=isim;
		this.sinif=sinif;
		this.sube=sube+1;
	}
}
