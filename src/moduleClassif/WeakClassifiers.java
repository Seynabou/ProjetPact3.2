package moduleClassif;

public class WeakClassifiers {

	int rows =4;  
	int columns = 20;
	double[][] MatrixOfFeatures = new double[rows][columns]; 
	int[] labels = new int[rows];
	int[] newLabels = new int[rows]; 
	double[] weight = new double[rows];
	
	double[] errorFeatures = new double[columns];
	double[] errorThreshold = new double[rows]; 
	double error1, error2, error;
	
	int[] labelShape1= new int[rows];
	int[] labelShape2= new int[columns];
	int labelShape;
	
	int featureSelect;
	double[] modelh = new double[3]; 
	double errorCalculated;

	public WeakClassifiers(double[][] matrixOfFeatures, int[] labels, double[] weight){
		this.MatrixOfFeatures = matrixOfFeatures;
		this.labels = labels;
		this.weight = weight;
	}


	public void Classifiers() { //changer le retour après pour predict: modelh[i]

		//for each feature
		//		for(int k =0; k<MatrixOfFeatures.length;k++){
		//			for(int j =0; j<MatrixOfFeatures[0].length;j++){
		//				System.out.println(k+" "+j+" ="+MatrixOfFeatures[k][j] + "/"+MatrixOfFeatures.length); 
		//			}
		//		}
		
		for(int p = 0; p<MatrixOfFeatures[0].length;p++){ 
			for(int i =0; i<MatrixOfFeatures.length; i++){

				//We assume in first time that to the right of threshold
				//it is +1 and to his left, -1

				//if(i==0){
				for(int j=0 ; j<MatrixOfFeatures.length;j++){ 

					if(MatrixOfFeatures[i][p] > MatrixOfFeatures[j][p]){
						newLabels[j] = -1;
					}

					if(MatrixOfFeatures[i][p] <= MatrixOfFeatures[j][p]){
						newLabels[j] = 1;
					}
					
				}
				error1 = error(labels,newLabels,weight);
				//}
				//				else{
				//					for(int j=0 ; j<MatrixOfFeatures.length;j++){ 
				//
				//						if(MatrixOfFeatures[i][p] > MatrixOfFeatures[j][p]){
				//							newLabels[j] = -1;
				//						}
				//
				//						if(MatrixOfFeatures[i][p] <= MatrixOfFeatures[j][p]){
				//							newLabels[j] = 1;
				//						}
				//						error1 = error(labels,newLabels,weight);
				//					}	
				//				}


				//In second time, +1 at left and -1 at right


				//if(i==0){
				for(int j=0 ; j<MatrixOfFeatures.length;j++){ 

					if(MatrixOfFeatures[i][p] > MatrixOfFeatures[j][p]){
						newLabels[j] = 1;
					}

					if(MatrixOfFeatures[i][p] <= MatrixOfFeatures[j][p]){
						newLabels[j] = -1;
					}
					
				}
				error2 = error(labels,newLabels,weight);
				//				}
				//				else{
				//					for(int j=0 ; j<MatrixOfFeatures.length;j++){ 
				//
				//						if(MatrixOfFeatures[i][p] > MatrixOfFeatures[j][p]){
				//							newLabels[j] = 1;
				//						}
				//
				//						if(MatrixOfFeatures[i][p] <= MatrixOfFeatures[j][p]){
				//							newLabels[j] = -1;
				//						}
				//						error2 = error(labels,newLabels,weight);
				//					}	
				//				}

				if(error1 < error2){
					errorThreshold[i] = error1;
					labelShape1[i] = +1;				
				}
				else{
					errorThreshold[i] = error2;
					labelShape1[i] = -1;
				}
			}

			// determinate the best threshold of the feature
			//which minimize the weighted error rate
			double valeur=errorThreshold[0];
			for(int j =1; j<errorThreshold.length;j++){	
				if(valeur > errorThreshold[j]){ //attention
					valeur = errorThreshold[j];
					labelShape2[p] = labelShape1[j];
				}
			}
			errorFeatures[p]=valeur;
		}
		double valeur2=errorFeatures[0];
		for(int j =1; j<errorFeatures.length;j++){	
			if(valeur2 > errorFeatures[j]){ 
				valeur2 = errorFeatures[j];
				labelShape = labelShape2[j];
				featureSelect = j;
			}
		}
		error = valeur2;

		modelh[0] = featureSelect;
		modelh[1] = error;
		modelh[2] = labelShape;

		System.out.println("feature "+modelh[0]+" error "+modelh[1]+" labelshape "+modelh[2]);
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

}
