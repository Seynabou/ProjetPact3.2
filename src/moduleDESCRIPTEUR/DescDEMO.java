package moduleDESCRIPTEUR;
import java.util.Random;

import moduleClassif.*;


public class DescDEMO{
	public DescDEMO(){
		super();
	}
	
	public void descripteur() throws InterruptedException{
		

		int[] feature = new int[10];

		Random r = new Random();
		while(true){
			for (int i = 1; i <= 10; i++) {
				float x;
				x = r.nextFloat();

				if (x >= 0.5) {
					feature[i - 1] = 0;
				} else {
					feature[i - 1] = 1;
				}
//				System.out.println(descripteur[i-1]);	
			}
			ClassifDEMO classifieur = new ClassifDEMO();
			classifieur.giveMatrix(feature);
			Thread.sleep(3000);
		}
	}
}

