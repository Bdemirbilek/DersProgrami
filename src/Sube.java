import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Sube {
	String name;
	int saatSayisi;
	dersSaati[] saatler;
	public Sube(Elements row, String name, int subeNo){
		this.name=name;
		dersSaati[] saatler= new dersSaati[100];
		saatSayisi= cevir(row,saatler,name, subeNo);
		this.saatler=saatler;
	}
	public void saatEkle(int saat, int gun){
		saatler[saatSayisi].saat=saat;
		saatler[saatSayisi].gun=gun;
		saatSayisi++;
	}

	public int cevir(Elements ro, dersSaati[] saatler, String isim, int subeNo) {
		int kacinci = 0;
		for (int i = 2; i < ro.size(); i++) {
			Element row = ro.get(i);
			Elements cols = row.select("td");
			// System.out.println(i + ":" + cols.size());
			// if (cols.get(0).text().length()>1){
			// System.out.println(i + ":" + cols.get(0).text() + ":" +
			// cols.get(1).text() + ":" + cols.get(2).text() + ":"
			// + cols.get(3).text() + ":" + cols.get(4).text() + ":" +
			// cols.get(5).text());
			// }
			for (int j = 0; j < 6; j++) {
				if (!cols.get(j).text().equals("-")) {
					saatler[kacinci] = new dersSaati(i, j,isim,cols.get(j).text(),subeNo);
					kacinci++;
				}
			}

		}
		return kacinci;
	}
	public void print(){
		for(int i=0;i<saatSayisi;i++)
		System.out.println(saatler[i].gun+" "+saatler[i].saat);
	}
}