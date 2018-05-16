import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;



public class Paneel extends JPanel {
  private Verkeerslicht verkeerslicht;
  private JButton btnRood, btnOranje, btnGroen, btnReset;
      
  public Paneel() {
    setBackground( Color.WHITE );
    
    verkeerslicht = new Verkeerslicht( 200 );
    
    btnRood = new JButton( "Rood" );
    btnRood.setBackground( Color.RED );
    
    btnOranje = new JButton( "Oranje" );
    btnOranje.setBackground( Color.ORANGE );

    btnGroen = new JButton( "Groen" );
    btnGroen.setBackground( Color.GREEN );
    
    btnReset = new JButton( "Reset" );
    btnReset.setBackground(Color.WHITE);
    
    KnopHandler kh = new KnopHandler();
    btnRood.addActionListener( kh );
    btnOranje.addActionListener( kh );
    btnGroen.addActionListener( kh );
    btnReset.addActionListener(kh);
    
    add( btnRood );
    add( btnOranje );
    add( btnGroen );
    add( btnReset );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    verkeerslicht.teken( g );
  }
  
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( e.getSource() == btnRood ) {
      	verkeerslicht.setRood();
      }
      else
      if( e.getSource() == btnOranje ) {
      	verkeerslicht.setOranje();
      }
      else
      if( e.getSource() == btnGroen ) {
      	verkeerslicht.setGroen();
      }
      else
      if(e.getSource() == btnReset) {
        verkeerslicht.setReset();
      }
      repaint();
    }
  }
}
class Verkeerslicht {
  private boolean rood, oranje, groen;
  private int positie;

  public Verkeerslicht( int positie ) {
    this.positie = positie;
    rood = true;
    oranje = true;
    groen = true;
  }    
    
  public void reset() {
    rood   = false;
    oranje = false;
    groen  = false;
  }

  public void setRood() {
    reset();
    rood = true;
  }

  public void setOranje() {
    reset();
    oranje = true;
  }

  public void setGroen() {
    reset();
    groen = true;
  }
  
  public void setReset(){
  reset();
  rood = true;
  oranje = true;
  groen = true;
  }

  public void teken( Graphics pen ) {
    pen.setColor( Color.gray );
    // Verkeerslicht frame
    pen.fillRect( positie - 100, 50, 150, 300 ); 
    
    //Paal
    pen.fillRect( positie - 45, 300, 45, 300 );
    
    // Lampen
    if( rood ) {           
      pen.setColor( Color.red );
      pen.fillOval( positie - 65, 60, 80, 80 );
    }
    if( oranje ) {
      pen.setColor( Color.orange );
      pen.fillOval( positie - 65, 150, 80, 80 );
    }
    if( groen ) {
      pen.setColor( Color.green );
      pen.fillOval( positie - 65, 240, 80, 80 );
    }
  }
}
