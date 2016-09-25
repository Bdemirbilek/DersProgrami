import java.io.ByteArrayInputStream;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Hashtable;

public class jsoup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable e=dersListele();
		System.out.println("");
		//int[] dersler = {2015608};
		//int[] dersler = {2016831,2015608};
		int[] dersler = {2015318,2015319,2016771,2015322,2015325,2015324};
		//int[] dersler = {2015319,2015322,2015325,2015324};
		Ders[] ders=dersleriOlustur(dersler);
		Program[] tmp= programOlustur(ders);
		Program[] tmp2=sifirCakisma(tmp);
		printProgram(tmp2[0],e);

	}
	public static Program[] programOlustur(Ders[] ders){
		int[] tmpDers=new int[15];
		int olasilik=1;
		for(int a=0;a<15;a++){
			if(a<ders.length){
				tmpDers[a]=ders[a].sube.length;
				olasilik=olasilik*tmpDers[a];
			}
			else{
				tmpDers[a]=1;
			}
		}
		Program[] tmpProgram= new Program[olasilik];
		int tmpsayac=0;
		for(int b0=0;b0<tmpDers[0];b0++){
			for(int b1=0;b1<tmpDers[1];b1++){
				for(int b2=0;b2<tmpDers[2];b2++){
					for(int b3=0;b3<tmpDers[3];b3++){
						for(int b4=0;b4<tmpDers[4];b4++){
							for(int b5=0;b5<tmpDers[5];b5++){
								for(int b6=0;b6<tmpDers[6];b6++){
									for(int b7=0;b7<tmpDers[7];b7++){
										for(int b8=0;b8<tmpDers[8];b8++){
											for(int b9=0;b9<tmpDers[9];b9++){
												for(int b10=0;b10<tmpDers[10];b10++){
													for(int b11=0;b11<tmpDers[11];b11++){
														for(int b12=0;b12<tmpDers[12];b12++){
															for(int b13=0;b13<tmpDers[13];b13++){
																for(int b14=0;b14<tmpDers[14];b14++){
																	tmpProgram[tmpsayac] = new Program(tmpsayac+"");
																	if(14<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[14].sube[b14]);
																	if(13<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[13].sube[b13]);
																	if(12<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[12].sube[b12]);
																	if(11<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[11].sube[b11]);
																	if(10<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[10].sube[b10]);
																	if(9<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[9].sube[b9]);
																	if(8<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[8].sube[b8]);
																	if(7<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[7].sube[b7]);
																	if(6<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[6].sube[b6]);
																	if(5<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[5].sube[b5]);
																	if(4<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[4].sube[b4]);
																	if(3<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[3].sube[b3]);
																	if(2<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[2].sube[b2]);
																	if(1<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[1].sube[b1]);
																	if(0<ders.length)
																		tmpProgram[tmpsayac].dersEkle(ders[0].sube[b0]);
																	tmpsayac++;
																	
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return tmpProgram;
		
	}
	
	public static Program[] sifirCakisma(Program[] program){
		int hatasayisi=0;
		int[] uygunlar= new int[program.length];
		
		for(int i=0;i<program.length;i++){
			for(int a=0;a<program[i].saatSayisi;a++){
				for(int b=a;b<program[i].saatSayisi;b++){
					if(a==b) continue;
					if(program[i].dersler[a].gun==program[i].dersler[b].gun){
						if(program[i].dersler[a].saat==program[i].dersler[b].saat){
							uygunlar[i]++;
							
						}
					}
				}
			}
		}
		for(int x=0;x<uygunlar.length;x++){
			if(uygunlar[x]!=0)
				hatasayisi++;
		}
		int tmp=0;
		if(program.length==1 && hatasayisi==1){
			Program[] tmpp= new Program[1];
			tmpp[0]= new Program("bos");
			return tmpp;
		}
		else{
			Program[] newProgram= new Program[program.length-hatasayisi];
			for(int c=0;c<program.length;c++){
				if(uygunlar[c]==0){
					newProgram[tmp]=program[c];
					tmp++;
				}
			}
			return newProgram;
		}
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

			a[b]= new Ders(dersler[b]+"",subesayisi);
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

	public static Hashtable<Integer, String> dersListele() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
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
			hashtable.put(Integer.parseInt(option.val()), option.text().toString());
		}
		return hashtable;
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
	public static void printProgram(Program program,Hashtable<Integer, String> e){
		program.arrayAktar();
		System.out.println("           | Pazartesi |   Sali    | Carsamba  | Persembe  |   Cuma    | Cumartesi |");
		String[] saatler={"8.30-9.20  ","9.30-10.20 ","10.30-11.20","11.30-12.20","12.30-13.20","13.30-14.20","14.30-15.20","15.30-16.20","16.30-17.20","17.30-18.20","18.30-19.20","19.30-20.20"};
		for(int i=0;i<12;i++){
			System.out.print(saatler[i]+"|");
			for(int j=0;j<6;j++){
				if(program.kord[i][j].equals(""))
					System.out.print("     -     ");
				else{
					String tmp= new String(program.kord[i][j]);
					String tmp2;
					tmp2=tmp.split(" ")[0];
					// Ders adi e.get(Integer.parseInt(tmp2));
					//Sinif     tmp.substring(tmp.indexOf(" "));
					String tmp3=e.get(Integer.parseInt(tmp2)).toString().split(" ")[0] +" "+e.get(Integer.parseInt(tmp2)).toString().split(" ")[1];
					
					tmp3=tmp3.concat(tmp.substring(tmp.indexOf(" ")));
					System.out.print(tmp3);
					if(tmp3.length()<11)
						for(int x=0;x<11-tmp3.length();x++)
							System.out.print(" ");


				}
				System.out.print("|");
			}
			System.out.println();
		}
		
		
		
		
	}

}