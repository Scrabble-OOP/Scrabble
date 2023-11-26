import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Scores extends JFrame implements ActionListener {

    private JLabel name = new JLabel();
    private JLabel score = new JLabel();

    Font font = new Font("Roboto", Font.BOLD, 100);

    private HashMap<String, Integer> data;

    public Scores(Archive archive) throws InterruptedException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        data = archive.getData();
        name.setBounds(300, 100, 600, 400);
        this.add(name);
        name.setVisible(true);
        score.setBounds(400, 350, 600, 200);
        this.add(score);
        score.setFont(font);
        name.setFont(font);
        score.setVisible(true);
        this.setVisible(true);
        while(true){
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                name.setText(key);
                score.setText("" + value);

                Thread.sleep(1000);
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
