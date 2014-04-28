package moduleClassif;

public class TestPredict {

	public static void main(String[] args) {
	
		double [] X = {-0.524369,-0.612501,-0.557961,0.440984,0.661399,-0.074647,-1.515740,0.305462,-0.644608,-0.187335,1.324839,0.739207,0.592862,1.656397,-0.173114,0.483547,0.195122,0.078162,-0.458776,-0.232230}; ///c est un piano
		
		Predict decision = new Predict(X);
		int label = decision.predict();
		System.out.println("label = "+label);
	}

}
