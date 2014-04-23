package moduleClassif;

public class WeakClassifiers {

	int rows =20;  //probleme de disposition des colonnes/lignes
	int columns = 2;
	double[][] MatrixOfFeatures = new double[columns+1][rows+1]; //+1
	int[] labels = new int[rows+1];
	int[] newLabels = new int[rows+1]; //-1 ou 1 on va convertir des clarinettes et autres
	double[] weight;
	double[] errorFeatures = new double[rows+1];
	double[] errorThreshold = new double[rows+1];
	double error1, error2, error;
	int labelShape1, labelShape2, labelShape;
	int featureSelect;
	double[] modelh = new double[3]; 
	double errorCalculated;

	public WeakClassifiers(double[][] matrixOfFeatures, int[] labels, double[] weight){
		this.MatrixOfFeatures = matrixOfFeatures;
		this.labels = labels;
		this.weight = weight;
	}

	public void Classifiers() { //changer le retour après pour predict

		//for each feature
		for(int p = 0; p<=columns;p++){ //voir si <= ou < seulement

			for(int i =0; i<=rows; i++){

				//We assume in first time that to the right of threshold
				//it is +1 and to his left, -1

				for(int j=0 ; j<=MatrixOfFeatures.length;j++){ //<= 

					if(MatrixOfFeatures[p][j] >= MatrixOfFeatures[p][i]){
						newLabels[j] = 1;
					}
					if(MatrixOfFeatures[p][j] < MatrixOfFeatures[p][i]){
						newLabels[j] = -1;
					}

					error1 = error(labels,newLabels,weight);
					//System.out.println("error1 tour "+p +i+" " + error1);

					//In second time, +1 at left and -1 at right

					for(int h=0 ; h<=MatrixOfFeatures.length;h++){ //<=
						if(MatrixOfFeatures[p][h] >= MatrixOfFeatures[p][i])
							newLabels[h] = -1;
						if(MatrixOfFeatures[p][h] < MatrixOfFeatures[p][i])
							newLabels[h] = 1;
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
