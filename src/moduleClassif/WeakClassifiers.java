package moduleClassif;

public class WeakClassifiers {

	int rows =12;  
	int columns = 20;
	double[][] MatrixOfFeatures = new double[rows][columns]; 
	int[] labels = new int[rows];
	int[] newLabels = new int[rows]; 
	double[] weight = new double[rows];

	double[] errorFeatures = new double[columns];
	double[] errorThreshold = new double[rows]; 
	double[] tabValeur1= new double[rows];
	double[] tabValeur2= new double[columns];
	double error1, error2, error;
	int indiceThreshold;

	int[] labelShape1= new int[rows];
	int[] labelShape2= new int[columns];
	int labelShape;

	int featureSelect;
	double[] modelh = new double[5]; 
	double errorCalculated;

	public WeakClassifiers(double[][] matrixOfFeatures, int[] labels, double[] weight){
		this.MatrixOfFeatures = matrixOfFeatures;
		this.labels = labels;
		this.weight = weight;
	}


	public double[] Classifiers() { //changer le retour apr�s pour adaboost: modelh[i]

		//for each feature
//				for(int k =0; k<MatrixOfFeatures.length;k++){
//					for(int j =0; j<MatrixOfFeatures[0].length;j++){
//						System.out.println(k+" "+j+" ="+MatrixOfFeatures[k][j] + "/"+MatrixOfFeatures.length); 
//					}
//				}
		
		for(int p = 0; p<MatrixOfFeatures[0].length;p++){ 
			for(int i =0; i<MatrixOfFeatures.length; i++){

				//We assume in first time that to the right of threshold
				//it is +1 and to his left, -1

				newLabels=boubleForPourError1(MatrixOfFeatures, p, i);
				error1 = error(labels,newLabels,weight);

				//In second time, +1 at left and -1 at right

				newLabels=boubleForPourError2(MatrixOfFeatures, p, i);
				error2 = error(labels,newLabels,weight);

				if(error1 < error2){
					this.errorThreshold[i] = error1;
					this.labelShape1[i] = +1;				
				}
				else{
					this.errorThreshold[i] = error2;
					this.labelShape1[i] = -1;
				}
			}

			// determinate the best threshold of the feature
			//which minimize the weighted error rate

			//select the best errorThreshold
			errorFeatures[p]=boucleForPourErrorThreshold(p);
			
			tabValeur2[p]=MatrixOfFeatures[indiceThreshold][p];
		}
		//select the best errorFeatures
		error = boucleForPourErrorFeatures();

		modelh[0] = featureSelect;
		modelh[1] = error;
		modelh[2] = labelShape;
		modelh[3] = tabValeur2[indiceThreshold]; //correspond � la valeur du threshold choisi
		modelh[4] = indiceThreshold;
		//System.out.println("feature select "+modelh[0]+" error "+modelh[1]+" labelshape "+modelh[2]+" valeur du seuil "+ tabValeur2[indiceThreshold]);

//				for(int i=0; i<tabValeur2.length;i++){
//					System.out.println(tabValeur2[i]);
//				}
//				for(int i=0; i<errorFeatures.length;i++){
//					System.out.println(errorFeatures[i]);
//				}
//				
		return modelh;
	}


	public double error(int[] labels2, int[] newLabels2, double[] weight){

		double errorCalculated = 0;


		for(int i=0;i<newLabels2.length;i++){
			if(newLabels2[i]!=labels2[i]){
				errorCalculated = errorCalculated + (weight[i]/rows);
			}
		}

		return errorCalculated;		
	}

	public int[] boubleForPourError1(double[][]MatrixOfFeatures, int p, int i){
		for(int j=0 ; j<MatrixOfFeatures.length;j++){ 

			if(MatrixOfFeatures[i][p] > MatrixOfFeatures[j][p]){
				newLabels[j] = -1;
			}

			if(MatrixOfFeatures[i][p] <= MatrixOfFeatures[j][p]){
				newLabels[j] = 1;
			}

		}
		return newLabels;
	}

	public int[] boubleForPourError2(double[][]MatrixOfFeatures, int p, int i){

		for(int j=0 ; j<MatrixOfFeatures.length;j++){ 

			if(MatrixOfFeatures[i][p] > MatrixOfFeatures[j][p]){
				newLabels[j] = 1;
			}

			if(MatrixOfFeatures[i][p] <= MatrixOfFeatures[j][p]){
				newLabels[j] = -1;
			}

		}
		return newLabels;
	}

	public double boucleForPourErrorThreshold(int p){

		double valeur=errorThreshold[0];

		for(int j =1; j<errorThreshold.length;j++){	
			if(valeur > errorThreshold[j]){ //attention
				valeur = errorThreshold[j];
				labelShape2[p] = labelShape1[j];
				this.indiceThreshold = j; // donne le numero de la ligne de l'element choisi, va servir pour la comparaison after
			}

		}
		return valeur;
	}

	public double boucleForPourErrorFeatures(){
		double valeur2=errorFeatures[0];
		for(int j =1; j<errorFeatures.length;j++){	//j va jusqu'� 20 
			if(valeur2 > errorFeatures[j]){ 
				valeur2 = errorFeatures[j];
				labelShape = labelShape2[j];
				featureSelect = j; // attention les tableaux en java commence par 0 donc featureSelect+1 pour matrice
			}
		}
		return valeur2;
	}

}
