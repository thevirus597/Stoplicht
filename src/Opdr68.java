import javax.swing.*;

   
public class Opdr68 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Opdr68();
    frame.setSize( 400, 600 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Opdracht 6.8" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
    frame.setLocationRelativeTo(null);
  }
}


