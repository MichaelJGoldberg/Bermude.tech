


import javax.swing.*;

public class MainWindow extends JFrame{
    public MainWindow() {
        setTitle("Soldier snake v.0.1." );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(320, 350);
        setLocation(320, 320);

        add(new GameField());
        setVisible(true);
    }
    public static void main(String[] args){
        MainWindow mw = new MainWindow();


    }
}