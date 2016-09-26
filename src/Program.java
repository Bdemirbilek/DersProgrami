
public class Program {
	String name;
	dersSaati[] dersler;
	int saatSayisi;
	String [][] kord;
	public Program(String n){
		name=n;
		saatSayisi=0;
		this.dersler=new dersSaati[120];
	}
	public void dersEkle(Sube sube){
		for(int i=0;i<sube.saatSayisi;i++){
			dersler[saatSayisi]=sube.saatler[i];
			saatSayisi++;
		}
		
		
	}
	public void arrayAktar(){
		kord= new String[12][];
		for(int i=0;i<12;i++){
			kord[i]= new String[6];
			for(int j=0;j<6;j++){
				kord[i][j]= new String("");
			}
		}
		
		for(int a=0;a<saatSayisi;a++){
			
			
			//Dersliğin olduğu versiyon: kord[dersler[a].gun-2][dersler[a].saat]=dersler[a].isim+" Sube:"+ dersler[a].sube+" "+dersler[a].sinif;
			if(kord[dersler[a].gun-2][dersler[a].saat].equals("")){
				kord[dersler[a].gun-2][dersler[a].saat]=dersler[a].isim+" -"+ dersler[a].sube;
				
			}
			else{
			kord[dersler[a].gun-2][dersler[a].saat]=kord[dersler[a].gun-2][dersler[a].saat]+" "+dersler[a].isim+" -"+ dersler[a].sube;
			}
		}
		
		
	}



}
