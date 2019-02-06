import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lesson8  extends JFrame {
    public Lesson8() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        //JButton[] jbs = new JButton[5];
        //for (int i = 0; i < 5; i++) {
        //    jbs[i] = new JButton("#" + i);
        //}
        //setLayout(new BorderLayout()); // выбор компоновщика элементов
        //add(jbs[0], BorderLayout.EAST); // добавление кнопки на форму
        //add(jbs[1], BorderLayout.WEST);
        //add(jbs[2], BorderLayout.SOUTH);
        //add(jbs[3], BorderLayout.NORTH);
        //add(jbs[4], BorderLayout.CENTER);

        //JButton[] jbs = new JButton[10];
        //setLayout(new FlowLayout());
        //for (int i = 0; i < jbs.length; i++) {
        //    jbs[i] = new JButton("#" + i);
        //    add(jbs[i]);
        //}


        setLayout(new BorderLayout()); // выбор компоновщика элементов
        JPanel pan = new JPanel();
        pan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("MousePos: " + e.getX() + " " + e.getY());
            }
        });
        add(pan, BorderLayout.NORTH);


        JTextField field = new JTextField();
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: " + field.getText());
            }
        });
        add(field, BorderLayout.SOUTH);


        JPanel panMain = new JPanel();
        panMain.setLayout(new GridLayout(4,3));
        JButton[] jbs = new JButton[10];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("#" + i);
            panMain.add(jbs[i]);
            jbs[i].addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button pressed...");
                }
            });
        }
        add(panMain, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        Lesson8 myWindow = new Lesson8();
    }
}
