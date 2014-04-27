package moduleClassif;

public class test {

	
	public static void main(String[] args){
		
		double[][] matrixOfFeatures = {
			{-1.272916,-1.417264,-0.574585,1.401585,1.270023,-0.738277,0.194547,1.474232,-1.962150,-1.603461,0.561820,1.686156,1.170453,0.343258,-0.201429,0.813465,-0.516391,-0.720986,-1.397320,-1.290588},
			{-0.763307,-1.223780,-1.102099,1.381122,1.323485,-1.156637,-1.366052,-0.668638,0.209986,-1.099095,1.315252,1.373387,0.176939,0.316593,-0.070460,-0.274959,-0.592207,-0.514760,-0.556530,-0.743369},
			{-0.258109,-0.351108,-0.342917,0.489328,0.196454,-0.681423,-0.374083,-1.392900,1.125817,-0.795811,-0.908412,-0.411808,-1.362156,-1.511173,-1.038142,0.734258,0.547297,1.928656,2.569895,2.235217},
			{-0.794871,-1.185328,-1.293813,1.114022,1.248878,-1.208099,-0.368484,-0.585281,0.124653,-0.877516,1.593584,0.980337,0.428802,1.009955,1.036754,0.697781,-0.453936,-0.303638,-0.605695,-0.526331}
		};
//		for(int h=0; h<matrixOfFeatures.length;h++){
//			for(int j=0;j<=matrixOfFeatures.length;j++){
//				System.out.println(matrixOfFeatures[h][j]);
//			}
//			
//		}
		double[] weight = {1.0,2.0,3.6,4.9};
		int[] labels = {1,-1,-1,1};
		WeakClassifiers weakClassif = new WeakClassifiers(matrixOfFeatures, labels, weight);
		weakClassif.Classifiers();
		System.out.println("oki");
		
		
		
		
		
//		ClassifieurFaible classif;
//		double[] weight = {1.0,2.0,3.0};
//		double[][] matrixOfFeatures = {{2.3,2.6,3.8},{6.4,6.0,6.8},{1.0,6.0,5.7}};
//		int[] labels = {1,-1,-1};
//		classif = new ClassifieurFaible(weight, matrixOfFeatures, labels);
//		String test = classif.getLabelshape_best();
//		System.out.println(test);
		
		
		
	}
}
