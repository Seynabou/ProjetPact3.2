package moduleClassif;

public class AdaboostTraining {

	int rows =12;  
	int columns = 20;
	int nbrWClassifier = 100;
	double[][] MatrixOfFeatures = new double[rows][columns]; // I= columns
	int[] labels = new int[rows];
	double[] modelh = new double[5];
	double[][] modelH = new double[6][nbrWClassifier];//contient les valeurs de modelh + alphar ; chaque colonne pour un classifieur faible
	double[] weight1 = new double[rows];
	
	double error;
	double betar, alphar;
	int valeur;

	public AdaboostTraining(double[][]MatrixOfFeatures, int[] labels){ //, double[] modelh
		this.MatrixOfFeatures= MatrixOfFeatures;
		this.labels = labels;
	}

	public double[][] adaboostTraining(){

		//Initialisation des poids
		for(int i=0;i<rows;i++){ //I
			this.weight1[i] = 1.0/columns;
		}

		
		
		for(int r=0;r<nbrWClassifier;r++){
			//faire la somme des poids
			double sommePoids= weight1[0];
			for(int j=1; j<rows;j++){ //I
				sommePoids+= weight1[j];
			}

			//normalisation
			for(int i=0;i<rows;i++){
				this.weight1[i]=weight1[i]/sommePoids;
			}

			//entrainer le classifieur hr
			WeakClassifiers weakClassifier = new WeakClassifiers(MatrixOfFeatures, labels, weight1);
			this.modelh= weakClassifier.Classifiers(); // sauvegarder ces 100 modèles h ? 
			for(int i=0;i<modelH.length-1;i++){
				this.modelH[i][r] = modelh[i]; 
			}

			error =modelh[1];
			betar= error/(1-error);

			//coef associé à hr
			alphar=Math.log(1/betar);
			this.modelH[5][r] = alphar;

			// modifier les poids

			int retourI = indicatrice(MatrixOfFeatures,labels,modelh);

			if(retourI == 1){
				for(int i =0; i<weight1.length;i++){
					this.weight1[i] = weight1[i]*betar;		//on n'a pas besoin de sauver les anciens poids ==> tableau a n dimensions
				}
			}
		}

		return modelH;
	}

	public int indicatrice(double[][] Xi, int[] labels, double[] modelh){

		int indiceFeature=(int)modelh[0];
		int indiceThreshold = (int)modelh[4];
		double threshold = Xi[indiceThreshold][indiceFeature];
		int label;

		if(threshold <= modelh[3]){
			label = -(int)modelh[2];
		}
		else 
			label = (int)modelh[2];

		if(label==labels[indiceThreshold]){
			return 1;
		}
		else 
			return 0;
	}

	public int predictWeakClassifier(double[][] MatrixOfFeatures, int labels){


		return 1; //ou 0
	}

}
