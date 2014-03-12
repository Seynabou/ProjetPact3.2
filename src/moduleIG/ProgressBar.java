package moduleIG;


import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * Afficher une barre de progression dans un JFrame
 */
public class ProgressBar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JProgressBar progressbar;

	public ProgressBar() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		progressbar = new JProgressBar(0, 100);
		progressbar.setValue(0);
		progressbar.setStringPainted(true);
		pane.add(progressbar);
		setContentPane(pane);
	}

	/**
	 * Afficher la progression de tache
	 */

	 public void loop() {
		 int position = 0;
		 while (position < 105) {
			 progressbar.setValue(position);
			 System.out.println("position : " + position);
			 
//			 progressbar.
//			 Sys.out
			 try {
				 Thread.sleep(500);
			 } catch (InterruptedException e) {
			 }
			 position += 20;
		 }
	 }

	 public static void main(String[] arguments) {
		 ProgressBar frame = new ProgressBar();
		 frame.pack();
		 frame.setVisible(true);
		 frame.loop();
		 frame.setVisible(false);
	 }
}

