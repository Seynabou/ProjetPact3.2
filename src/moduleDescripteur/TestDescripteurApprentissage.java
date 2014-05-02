package moduleDescripteur;

import Jama.Matrix;
import java.util.Random;

public class TestDescripteurApprentissage {

	private static double[][] MatrixOfVectorOfFeatures;

	public static void main(String[] args) {

		double[][] C = { { 4.1, 2, 8, 8.5, 1.2 }, { 3.1, 2, 7, 2.1, 6.4 },
				{ 5.5, 6.5, 0.2, 4.2, 7.2 }, { 6, 4, 2, 8, 8 },
				{ 6.8, 3.8, 6.8, 6.4, 7.8 } };

		int k = 5;

		Matrix[] tableau = new Matrix[k];
		tableau[0] = new Matrix(C);

		Random r = new Random();

		for (int i = 0; i < tableau.length; i++) {
			for (int m = 0; m < tableau[0].getRowDimension(); m++) {
				for (int l = 0; l < tableau[0].getColumnDimension(); l++) {
					C[m][l] = 10 * r.nextDouble();

				}
			}
			tableau[i] = new Matrix(C);
		}

		MatrixOfVectorOfFeatures = new double[tableau[0].getRowDimension()][tableau.length];
		Projection tableauDescripteur = new Projection(tableau);
		MatrixOfVectorOfFeatures = tableauDescripteur.TableauDescripteur();

		for (int i = 0; i < MatrixOfVectorOfFeatures.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				//System.out.println(MatrixOfVectorOfFeatures[i][j]);
			}
		}
	}
}
