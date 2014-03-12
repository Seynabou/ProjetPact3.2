package moduleDESCRIPTEUR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import moduleClassif.ClassifDEMO;

class Descripteur 
{
	public static void main(String[] argv) throws IOException, InterruptedException
	{
		BufferedReader lecteurAvecBuffer=null;
		String ligne;
		String filename = "src/moduleDESCRIPTEUR/direction2.txt";
		String direction1 = "1";

		ClassifDEMO classifieur = new ClassifDEMO();
		int[] feature= new int[10];

		try
		{
			lecteurAvecBuffer = new BufferedReader
					(new FileReader(filename));
		}
		catch(FileNotFoundException exc)
		{
			System.out.println("Erreur d'ouverture");
		}

		while ((ligne = lecteurAvecBuffer.readLine())!=null)
			//System.out.println(ligne);
			if(ligne.equalsIgnoreCase(direction1)) {
				for(int i=0;i<10;i++){
			
					feature[i]=1;
				}
				//System.out.println("right");
				classifieur.giveMatrix(feature);
				Thread.sleep(500);
			}
			else{
				for(int i=0;i<10;i++){
					feature[i]=0;
				}
				//System.out.println("right");
				classifieur.giveMatrix(feature);
				Thread.sleep(500);
			}


		lecteurAvecBuffer.close();

	}
}