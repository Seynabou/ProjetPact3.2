package moduleClassif;

public class WeakClassifiers {

	int rows =4; 
	int columns = 4;
	double[][] MatrixOfFeatures = new double[rows][columns];
	int[] labels = new int[rows];
	int[] newLabels = new int[rows]; //-1 ou 1 on va convertir des clarinettes et autres
	double[] weight;
	double[] errorFeatures = new double[rows];
	double[] errorThreshold = new double[rows];
	double error1, error2, error;
	int labelShape1, labelShape2, labelShape;
	int featureSelect;
	double[] modelh = new double[3]; 
	//featureSelect , Error , labelShape
	
	double errorCalculated;

	public WeakClassifiers(double[][] matrixOfFeatures, int[] labels, double[] weight){
		this.MatrixOfFeatures = matrixOfFeatures;
		this.labels = labels;
		this.weight = weight;
	}

	public void Classifiers() {
//		for(int i=0; i<newLabels.length;i++){
//			System.out.println(newLabels[i]);
//		}
		
		//for each feature
		for(int p = 0; p<columns;p++){ //voir si <= ou < seulement

			for(int i =0; i<rows; i++){

				//We assume in first time that to the right of threshold
				//it is +1 and to his left, -1

				for(int j=0 ; j<=i;j++){
					if(MatrixOfFeatures[p][i] >= MatrixOfFeatures[p][j])
						newLabels[j] = -1;
					if(MatrixOfFeatures[p][i] < MatrixOfFeatures[p][j])
						newLabels[j] = 1;
				}
				for(int j=i+1 ; j<rows;j++){
					if(MatrixOfFeatures[p][i] >= MatrixOfFeatures[p][j]) //attention au i et p
						newLabels[j] = -1;
					if(MatrixOfFeatures[p][i] < MatrixOfFeatures[p][j])
						newLabels[j] = 1;
				}
//				for(int h=0; h<newLabels.length;h++){
//					System.out.println(newLabels[h]);
//				}
				
				error1 = error(labels,newLabels,weight);
				System.out.println("error1 tour "+p +i+" " + error1);

				//In second time, +1 at left and -1 at right
//				for(int j=0 ; j<=i;j++){
//					newLabels[j] = 1;
//				}
//				for(int j=i+1 ; j<rows;j++){
//					newLabels[j] = -1;
//				}
				
				for(int j=0 ; j<=i;j++){
					if(MatrixOfFeatures[p][i] >= MatrixOfFeatures[p][j])
						newLabels[j] = 1;
					if(MatrixOfFeatures[p][i] < MatrixOfFeatures[p][j])
						newLabels[j] = -1;
				}
				for(int j=i+1 ; j<rows;j++){
					if(MatrixOfFeatures[p][i] >= MatrixOfFeatures[p][j])
						newLabels[j] = 1;
					if(MatrixOfFeatures[p][i] < MatrixOfFeatures[p][j])
						newLabels[j] = +1;
				}
				
				error2 = error(labels,newLabels,weight);
				System.out.println("error2 tour "+p+i+" "+ error2);

				if(error1 < error2){
					errorThreshold[i] = error1;
					labelShape1 = +1;				
				}
				else{
					errorThreshold[i] = error2;
					labelShape1 = -1;
				}

				// determinate the best threshold of the feature
				//which minimize the weighted error rate
				if((i!=0) && (errorThreshold[i] < errorThreshold[i-1])){ //à revoir
					errorFeatures[i] = errorThreshold[i];
					labelShape2 = labelShape1;
				}
			}

			if((p!=0) && (errorThreshold[p] < errorThreshold[p-1])){ //à revoir
				featureSelect = p;
				error = errorThreshold[p];
				labelShape = labelShape2;
			}
		}
		modelh[0] = featureSelect;
		modelh[1] = error;
		modelh[2] = labelShape;
		
		System.out.println("feature "+modelh[0]+" error "+modelh[1]+" labelshape "+modelh[2]);
	}
	
	public double error(int[] labels2, int[] newLabels2, double[] weight){
		
		double errorCalculated = 0;
		
		
		for(int i=0;i< rows;i++){
			if(newLabels2[i]!=labels2[i]){
				errorCalculated = errorCalculated + (weight[i]/rows);
			}
		}
		
		return errorCalculated;		
	}
	
}
