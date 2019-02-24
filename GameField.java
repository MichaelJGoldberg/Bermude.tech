
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int size = 320;
    private final int dot_size = 16;
    private final int all_dots = 320;
    private Image dot;
    private Image apple;
    public int score;
    private int appleX;
    private int appleY;
    private int [] x = new int[all_dots];
    private int [] y = new int[all_dots];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;


    public GameField(){
        setBackground(Color.BLACK);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);


    }
    public void initGame() {
        score = 0;
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * dot_size;
            y[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();


    }

       public void createApple(){
            appleX = new Random().nextInt(18) * dot_size;
            appleY = new Random().nextInt(18) * dot_size;

        }

    public void loadImages(){
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon ("dot.png");
        dot = iid.getImage();

    }
    @Override
    protected void paintComponent(Graphics g){
        System.lineSeparator();
        super.paintComponent(g);
        if (inGame){
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < dots; i ++){
                g.drawImage(dot, x[i], y[i], this);
            }
             if(inGame = true){
                 String str = "Score: "+score;
                 Font h = new Font("Arrial",Font.BOLD, 14 );
                 g.setColor(Color.white);
                 g.setFont(h);
                 g.drawString(str, 220, 300);

                 switch (score){
                     case 150:
                         String Str ="My grandmother does this better soldier!";


                         Font j = new Font("Arrial",Font.BOLD, 14 );
                         g.setColor(Color.white);
                         g.setFont(j);
                         g.drawString(Str, 10, 10);


                         break;
                     case 300:
                         String _Str = "Harry up! Why are you so slow soldier?!";
                         Font k = new Font("Arrial",Font.BOLD, 14 );
                         g.setColor(Color.white);
                         g.setFont(k);
                         g.drawString(_Str, 10, 10);
                         break;
                     case 400:
                         String sStr = "You think you play good?! I don\'t think so!";
                         Font l = new Font("Arrial",Font.BOLD, 14 );
                         g.setColor(Color.white);
                         g.setFont(l);
                         g.drawString(sStr, 10, 10);
                         break;
                     case 500:
                         String dStr = "I see you learns quik soldier!Dont miss the temp!";
                         Font z = new Font("Arrial",Font.BOLD, 14 );
                         g.setColor(Color.white);
                         g.setFont(z);
                         g.drawString(dStr, 10, 10);
                         break;
                     case 600:
                         String aStr = "Nice work, soldier!You dont even need my help!";
                         Font x = new Font("Arrial",Font.BOLD, 14 );
                         g.setColor(Color.white);
                         g.setFont(x);
                         g.drawString(aStr, 10, 10);
                         break;



                 }

             }
        }else{
            String str = "GameOver";
            Font f = new Font("Arial",  Font.BOLD, 20);
            g.setColor(Color.red);
            g.setFont(f);
            g.drawString(str, 110, size/2 );

            String _str = "Your record is: "+score;
            Font h = new Font("Arrial",Font.BOLD, 14 );
            g.setColor(Color.white);
            g.setFont(h);
            g.drawString(_str, 110, 180);


        }
    }

    public void move(){
        for(int i = dots; i > 0; i --){
            x[i] = x[i - 1];
            y[i] = y[i -1];
        }
        if (left){
            x[0] -= dot_size;

        }
        if (right){
            x[0] += dot_size;
        }
        if (up) {
            y[0] -=dot_size;

        }
        if (down){
            y[0] +=dot_size;
        }
    }
    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){

            dots++;
            score+=50;

            createApple();

        }


        }

    public void checkWalls(){
        for (int i = dots; i > 0; i--){
            if (i > 4 && x[0] == x[i] && y[0] == y[i]){
                inGame = false;
            }

        }
        if (x[0]>size){
            inGame = false;
        }
        if (x[0]<0){
            inGame = false;
        }
        if (y[0] >size){
            inGame = false;
        }
        if (y[0] <0){
            inGame = false;
        }
    }
    @Override
public void actionPerformed(ActionEvent e){
    if (inGame){
        checkApple();
        checkWalls();
        move();



}
    repaint();
}
class FieldKeyListener extends KeyAdapter {
        @Override
    public void keyPressed(KeyEvent e){
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ESCAPE){
                inGame = false;
            }
            if(key == KeyEvent.VK_LEFT && !right ){
                left = true;
                up = false;
                down = false;



            }
            if(key == KeyEvent.VK_RIGHT && !left ){
                right = true;
                up = false;
                down = false;



            }
            if(key == KeyEvent.VK_UP && !down ){
                left = false;
                up =true;
                right = false;



            }
            if(key == KeyEvent.VK_DOWN && !up ){
                left = false;
                right = false;
                down = true;



            }

        }


}
}
