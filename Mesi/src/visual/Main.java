package visual;
import javax.swing.*;
public class Main {
	/**
	 * @param args
	 */
	static public void main(String argv[]) {
		JFrame pantalla = new JFrame("Tetris");
		Principal principal = new Principal();
		principal.init();
		principal.setup();
		pantalla.getContentPane().setSize(principal.getSize());
		pantalla.setResizable(false);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.getContentPane().add(principal);
		pantalla.pack();
		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(true);
		principal.requestFocus();
		principal.start();
	}


}
