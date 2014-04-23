package moduleClassif;

public class ClassifierPredict {
	
	int rows =20;  //probleme de disposition des colonnes/lignes
	int columns = 2;
	double[][] MatrixOfFeatures = new double[columns+1][rows+1]; //+1
	
	//comment tirer ce hr
	WeakClassifiers weakClassifier = new WeakClassifiers(matrixOfFeatures, labels, weight);
	if()
}
