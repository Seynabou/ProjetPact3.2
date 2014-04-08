package moduleClassif;


public class ClassifieurFaible {

	int[] labels;
	// private static final String String = null;
	static int l = 3, d = 3; // représente le nombre de lignes et de colonnes
	private static int[] newlabels = new int[l];
	double[][] matrixOfFeatures = new double[l][d]; // représente la matrice des features les
	// colonnes sont les
	// features. Je veux
	// faire une
	// concaténation des
	// colonnes
	double[] weight; // représente les poids en entree 
	double[] errorI = new double[l];
	private double error_best;
	private String labelshape_best;  //labelshape lié au seuil du meilleur feature
	private int index_threshold_best; //indice du seuil liée au meilleur feature
	private String[] labelshapes;
	private double[] coords;
	private int[] index_threshold_features;
	private double[] error_features;
	private String[] labelshape_features;

	public ClassifieurFaible(double[] weight, double[][] matrixOfFeatures,
			int[] labels) {
		this.matrixOfFeatures = matrixOfFeatures;
		this.weight = weight;
		this.labels = labels;
		
//		for(int i =0; i<3; i++){
//			System.out.println("matrixOfFeatures = " + matrixOfFeatures[i][i]);
//		}
		
		int i, j, p;
		labelshapes = new String[80];
		index_threshold_features = new int[l];
		error_features = new double[l];
		labelshape_features = new String[80];


		for (j = 0; j < d; j++) {   //parcours les colonnes

			coords = new double[l];

			for (i = 0; i < l; i++) {  
				coords[i] = matrixOfFeatures[i][j];
																	///////TU EN ES LA :)
				for(int k =0; k<3; k++){
					System.out.println("coords = " + coords[i]);
				}
			}

			Vector vector = new Vector(coords, labels);

			for (i = 0; i < l; i++) {    //parcours les lignes

				vector.counter1(i);
				vector.counter2(i);

				if (vector.counter1(i) > vector.counter2(i)) {

					for (p = 0; p < i; p++) {
						newlabels[p] = -1;
					}
					;
					for (p = i; p < l; p++) {
						newlabels[p] = 1;
					}
					;
					labelshapes[i] = "right1";
				} else {
					for (p = 0; p < i; p++) {
						newlabels[p] = 1;
					}
					;
					for (p = i; p < l; p++) {
						newlabels[p] = -1;
					}
					;
					labelshapes[i] = "left1";
				}


				errorI[i] = vector.error(weight, newlabels, labels);
				//System.out.println(vector.error(weight, newlabels, labels));

				if (i!=0 && errorI[i] < errorI[i-1]) {

					index_threshold_features[j] = i; 
					
					System.out.println("index_threshold_features["+j+"] = " + index_threshold_features[j]);
					// renvoie l'indice du seuil
					// correspondant à l'erreur
					// minimum et le stocke dans
					// le tableau
					// index_threshold_feature

					error_features[j] = errorI[i]; // renvoie l'erreur minimum de
					// la ligne i et le stocke
					// dans le tableau
					// Error_feature[p]

					labelshape_features[j] = labelshapes[i]; // renvoie le
					// labelshape
					// associé et le
					// stocke dans le
					// tableau
					// labelfeature[]

				}


			}

			error_best = error_features[0];
			setLabelshape_best(labelshape_features[j]);
			index_threshold_best = index_threshold_features[0];

			if(j!=0 && error_features[j]<error_features[j-1]) {


				error_best = error_features[j];
				setLabelshape_best(labelshape_features[j]);
				index_threshold_best = index_threshold_features[j];

			}


		}
	}

	public double getError_best() {
		return error_best;
	}

	public void setError_best(double error_best) {
		this.error_best = error_best;
	}

	public int getIndex_threshold_best() {
		return index_threshold_best;
	}

	public void setIndex_threshold_best(int index_threshold_best) {
		this.index_threshold_best = index_threshold_best;

	}

	public void setLabelshape_best(String labelshape_best) {
		this.labelshape_best = labelshape_best;
	}

	public String getLabelshape_best() {
		return labelshape_best;
	}






}