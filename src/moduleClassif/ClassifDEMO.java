package moduleClassif;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.GregorianCalendar;

import Jeu.Manitou;
import moduleIntegration.*;

public class ClassifDEMO implements DescripteurClassificationInterface {

        int[] matrice ;
        private String chemin = "data\\ReproductionEXEC" ;
        private String message = "";
        Manitou manitou = new Manitou();
        private int counter0 = 0;
        private int counter1 = 0;

        GregorianCalendar calendar = new GregorianCalendar();

        public ClassifDEMO(){
                super();
        }

        @Override
        public void giveMatrix(int[] matrix) {
                this.matrice = matrix;

                Date time  = calendar.getTime();
                message = message+"matrice du descripteur envoyee a Classif  " + time;
                sendPosition();
        }

        public void sendPosition(){

                Robot robot ;
                try {
                        robot = new Robot();

                for(int i =0; i<matrice.length;i++){
                        if(matrice[i]==0) counter0++;
                        else counter1++;
                }
                if(counter0>=counter1){
                        robot.keyPress(KeyEvent.VK_LEFT);
                                                       /*manitou.setDirectionP1(0); */
                        message=message+"\n DirectionP1 envoyee : 0\n";
                        System.out.println("direction LEFT");
                }
                else {
                        robot.keyPress(KeyEvent.VK_RIGHT);
                                         /*manitou.setDirectionP1(1); //on envoie la commande touche droite*/
                        message=message+"\n DirectionP1 envoyee : 1\n";
                        System.out.println("direction RIGHT");
                }
                ReproduireExec.ecrire(chemin, message);
        } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        }

}