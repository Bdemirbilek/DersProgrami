import java.io.ByteArrayInputStream;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dersListele();
		System.out.println("");
		int[] dersler = {2016831,2015608};
		Ders[] ders=dersleriOlustur(dersler);
		//programOlustur(ders);

	}
	/*
	public static void programBirlestir(Ders[] ders){
		Ders tmpDers = new Ders("Program", 1);
		int sayac;
		for(int c=0;c<ders.length;c++){
			if(!(2*c+1>ders.length)){
				int[] tmp=kontrol(ders[c], ders[ders.length-c-1]);
				for(int b=0;b<tmp.length;b++){
					if(tmp[b]!=-1){
						int tmpsube1=tmp[b]/10;
						int tmpsube2=tmp[b]%10;
						
					}
				}
			}
			else{
				
			}
			

		}
		
		for(int i=1;i<ders.length;i++){
			//ders[i].
		}

		tmpDers.sube[0].saatEkle(saat, gun);
		for(int a=0;a<tmp.length;a++){
			System.out.println(tmp[a]);
		}
		
	}
	
	
	*/

	public static Ders[] dersleriOlustur(int[] dersler) {
		Ders a[]= new Ders[dersler.length];
		for (int b = 0; b < dersler.length; b++) {
			Document document = null;
			try {
				// doc =
				// Jsoup.connect("http://kayit.etu.edu.tr/Ders/Ders_prg.php")
				// .data("dd_ders", "2015355")
				// .data("sube", "0")
				// .data("btn_ders", "1")
				// .post();
				String requestUrl = "http://kayit.etu.edu.tr/Ders/Ders_prg.php";
//TODO:tek şube olduğunda hata verdi, sonradan unutma
				Connection connection = Jsoup.connect(requestUrl).data("dd_ders", dersler[b]+"").data("sube", "0")
						.data("btn_ders", "1").method(Connection.Method.POST);
				Connection.Response response = connection.execute();
				document = Jsoup.parse(new ByteArrayInputStream(response.bodyAsBytes()), "ISO8859-9", requestUrl);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(document);
			// System.out.println(doc);
			int subesayisi = document.select("table").size();
			//System.out.println(subesayisi);

			a[b]= new Ders("",subesayisi);
			for(int c=0;c<subesayisi;c++){
				Element tab1 = document.select("table").get(c);
				Elements rows = tab1.select("tr");
				a[b].subeEkle(rows, c);
				a[b].sube[c].print();
				System.out.println();
			}
			
			// System.out.println(document.select("table").get(1));
			
		}
		return a;
		
	}
	//TODO:recursiondan çıkış yerini ayarla, tek o kaldı gibi
	public void programYap(Ders[] ders){
		//Program[] program= new Program[100];
		int[] tmpkontrol = kontrol(ders[0], ders[1]);
		for(int i=0;i<tmpkontrol.length;i++){
			if(tmpkontrol[i]!=-1){
				int tmpsube1=tmpkontrol[i]/10;
				int tmpsube2=tmpkontrol[i]%10;
				programYap(dersBirlestir(ders[0].sube[tmpsube1],ders[1].sube[tmpsube2], ders, 2));
			}
		}
		
	}
	public Ders[] dersBirlestir(Sube s1, Sube s2, Ders[] d, int yer){
		Ders tmp= new Ders("", 1);
		for(int a=0;a<s2.saatler.length;a++){
			s1.saatEkle(s2.saatler[a].saat, s2.saatler[a].gun);
		}
		tmp.subeyeYaz(0, s1);
		Ders[] tmpd= new Ders[d.length-1];
		tmpd[0]=tmp;
		for(int i=1;i<tmpd.length;i++){
			tmpd[i]=d[i+1];
		}
		return tmpd;
	}

	public static void dersListele() {
		Document doc = null;
		try {
			// doc =
			// Jsoup.connect("http://kayit.etu.edu.tr/Ders/_Ders_prg_start.php").get();
			String requestUrl = "http://kayit.etu.edu.tr/Ders/_Ders_prg_start.php";
			Connection connection = Jsoup.connect(requestUrl).method(Connection.Method.GET);
			Connection.Response response = connection.execute();
			doc = Jsoup.parse(new ByteArrayInputStream(response.bodyAsBytes()), "ISO8859-9", requestUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String title = doc.title();
		// System.out.println(title);
		Elements options = doc.getElementsByAttributeValue("name", "dd_ders").get(0).children();
		for (Element option : options) {
			System.out.println(option.val() + "   " + option.text().toString());
		}
	}
	public static int[] kontrol(Ders ders1, Ders ders2){
		int sayac=0;
		int[] tmp=new int[ders1.sube.length*ders2.sube.length];
		for(int a=0;a<tmp.length;a++)
			tmp[a]=-1;
		for(int i=0;i<ders1.sube.length;i++){
			for(int j=0;j<ders2.sube.length;j++){
				boolean hata=false;
				for(int k=0;k<ders1.sube[i].saatSayisi;k++){
					for(int l=0;l<ders2.sube[j].saatSayisi;l++){
						if((ders1.sube[i].saatler[k].gun==ders2.sube[j].saatler[l].gun && ders1.sube[i].saatler[k].saat==ders2.sube[j].saatler[l].saat)){
							hata=true;
						}
					}
				}
				if(!hata){
					tmp[sayac]=i*10+j;
					sayac++;
				}
			}
		}
		return tmp;
	}

}