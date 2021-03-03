import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GuiStart extends JFrame implements KeyListener {
    JButton b1,b2,b3,b4;
    boolean white=true;
  GuiStart(){
   JPanel panel = new JPanel();
   panel.setLayout(new BorderLayout());
   addKeyListener(this);
      Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN,18);
      Font font2 = new Font(Font.SANS_SERIF, Font.BOLD ,18);
      Font font3 = new Font(Font.SANS_SERIF, Font.ITALIC,18);
      Font font = new Font(Font.SANS_SERIF, Font.PLAIN,18);
       b1= new JButton("normal");
       b2= new JButton("bold");
       b3= new JButton("italic");

       b4= new JButton("night mode");

      b1.setFont(font1);
      b2.setFont(font2);
      b3.setFont(font3);



   JPanel panelTop = new JPanel(new FlowLayout());
   JPanel panelBottom = new JPanel(new FlowLayout());

   add(panelTop,BorderLayout.PAGE_START);
   add(panelBottom,BorderLayout.PAGE_END);

   panelTop.add(b1);
   panelTop.add(b2);
   panelTop.add(b3);
   panelTop.add(b4);
   panelBottom.add(new TextField("szukaj"));
   panelBottom.add(new JButton("@-"));

   JTextArea jTextArea = new JTextArea();
   JScrollPane jScrollPane = new JScrollPane(jTextArea);
   jTextArea.setLineWrap(true);
     add(panel);
     add(jScrollPane);

     jTextArea.setFont(font);
     b1.addActionListener(new ActionListener() {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                  jTextArea.setFont(font1);   }
     });
      b2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              jTextArea.setFont(font2);   }
      });
      b3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              jTextArea.setFont(font3);   }
      });
      b4.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

              if(white) {
                  jTextArea.setBackground(Color.BLACK);
                  jTextArea.setForeground(Color.WHITE);
                  b4.setText("day mode");
                  white=false;
              }else{
                  jTextArea.setBackground(Color.WHITE);
                  jTextArea.setForeground(Color.BLACK);
                  b4.setText("night mode");
                  white=true;
              }
              
          }
      });


             setSize(640, 500);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);

 }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            System.out.println("w lewo");

        }

        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("w prawo");
        }

        if (key == KeyEvent.VK_UP) {
            b4.setBackground(Color.RED);
        }

        if (key == KeyEvent.VK_DOWN) {
            b4.setBackground(Color.BLUE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
public class Main {
  //  Napisz program, który będzie symulował prosty edytor tekstów.
  //  W oknieJFrameumieśćkomponentJTextAreai stwórz prostą metodę,
  //  która będzie ustalała jego wartości charakterystyczne według
  //  przekazanych do niej argumentów:
    //  •Kolor tła   •Kolor pisma   •Rodzaj pisma (np. Dialog)
  //  •Rozmiar pisma (np. 14)  •Typ pisma (np. wytłuszczona kursywa)

    public static void main(String[] args) {

       SwingUtilities.invokeLater(GuiStart::new);


    }
}
