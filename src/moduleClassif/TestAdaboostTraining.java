package moduleClassif;

public class TestAdaboostTraining {

	public static void main(String[] args) {
		
		double[][] matrixOfFeatures = {
				{-0.794871,-1.185328,-1.293813,1.114022,1.248878,-1.208099,-0.368484,-0.585281,0.124653,-0.877516,1.593584,0.980337,0.428802,1.009955,1.036754,0.697781,-0.453936,-0.303638,-0.605695,-0.526331},
				{-0.763307,-1.223780,-1.102099,1.381122,1.323485,-1.156637,-1.366052,-0.668638,0.209986,-1.099095,1.315252,1.373387,0.176939,0.316593,-0.070460,-0.274959,-0.592207,-0.514760,-0.556530,-0.743369},
				{-0.990026,-0.805453,-0.003826,0.290809,0.262934,-0.254662,-0.379359,-0.270615,-0.175976,-1.202145,-0.052269,0.620231,0.347131,-0.050203,0.175899,1.383524,0.115682,-1.623128,-2.206879,-2.256889},	
				{-1.272916,-1.417264,-0.574585,1.401585,1.270023,-0.738277,0.194547,1.474232,-1.962150,-1.603461,0.561820,1.686156,1.170453,0.343258,-0.201429,0.813465,-0.516391,-0.720986,-1.397320,-1.290588},
				{-0.258109,-0.351108,-0.342917,0.489328,0.196454,-0.681423,-0.374083,-1.392900,1.125817,-0.795811,-0.908412,-0.411808,-1.362156,-1.511173,-1.038142,0.734258,0.547297,1.928656,2.569895,2.235217},
				{0.038017,0.096045,0.074111,-0.413458,-0.426290,0.065476,-0.154905,-0.787713,0.751136,0.071209,-0.320814,-0.373383,-0.144877,0.648378,0.332232,-0.222507,0.074588,-0.822975,-1.490888,-0.371697},
				{-1.310250,-1.457794,-0.782189,1.304809,1.226393,-0.956994,-1.706266,1.947922,-2.425098,-1.584661,0.798773,1.534656,1.462098,0.981727,0.751653,1.375705,0.176920,0.479957,-0.414445,-0.407814},
				{-0.712736,-0.313003,0.590198,-0.160223,-0.110922,0.605036,0.836565,0.753334,-1.056450,-0.840905,-0.478640,0.508486,0.689509,0.131822,-0.175312,-0.073033,-1.212786,-1.292321,-0.086674,-0.294583},
				{-0.920449,-1.435833,-1.474554,2.318597,2.636607,-1.392814,-0.155344,-0.281832,-0.199648,-1.256215,1.654382,1.613714,0.198664,0.971447,0.205484,0.276914,-0.853840,-0.023138,-0.713646,-0.358919},
				{-0.908910,-1.336174,-1.213869,1.480884,1.632322,-1.248220,0.026271,-0.150533,-0.326049,-0.852920,1.624218,1.467520,-0.055312,2.209889,3.098047,0.726094,-0.193285,0.481415,-0.471000,-0.644058},
				{-0.524369,-0.612501,-0.557961,0.440984,0.661399,-0.074647,-1.515740,0.305462,-0.644608,-0.187335,1.324839,0.739207,0.592862,1.656397,-0.173114,0.483547,0.195122,0.078162,-0.458776,-0.232230},
				{-0.668444,-1.136180,-1.257027,1.055236,1.104039,-1.279025,-3.030614,-0.816392,0.384561,-0.857656,1.447106,0.884350,0.465165,0.644309,0.105657,0.160679,-0.574796,-0.400274,-0.326891,-0.312649}
		};


		int[] labels = {1,-1,-1,-1,1,-1,-1,-1,1,1,1,1};//pcccpcccpppp
		
		double[][] modelH;
		
		AdaboostTraining adaboostTraining = new AdaboostTraining(matrixOfFeatures, labels);
		modelH = adaboostTraining.adaboostTraining();
		//double[] a = adaboostTraining.
		
		for(int i=0; i<100; i++){
			System.out.println("modelH "+i);
			
			System.out.println("feature select "+modelH[0][1]+" error "+modelH[1][i]+" labelshape "+modelH[2][i]+" valeur du seuil "+modelH[3][i]+" alphar "+modelH[4][i]);
			
		}
		System.out.println("oki");
	}

}
