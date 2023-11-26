import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Starter extends JFrame implements ActionListener {

    ImageIcon image = new ImageIcon("res/logo.png");
    JLabel logo = new JLabel();

    JTextField inp = new JTextField();

    JButton conf = new JButton();

    private boolean open = true;

    private int players = 0;

    public Starter(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        logo.setBounds(100,20, 800, 500);
        logo.setVisible(true);
        logo.setIcon(image);
        this.add(logo);
        inp.setText("Inserte la cantidad de jugadores que van a jugar!");
        inp.setBounds(100, 520, 800, 40);
        this.add(inp);
        conf.setBounds(400, 600, 200, 100);
        conf.setText("Confirmar");
        this.add(conf);
        conf.addActionListener(this);
        this.setVisible(true);
    }

    public int getPlayers(){
        return players;
    }

    public boolean getOpen(){
        return open;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == conf){
            if(!inp.getText().equals("1") && !inp.getText().equals("2") && !inp.getText().equals("3") && !inp.getText().equals("4")){
                JOptionPane.showMessageDialog(null, "entrada invalida");
            }
            else{
                players = Integer.parseInt(inp.getText());
                open = false;
                this.dispose();
                this.setVisible(false);
            }
        }

    }

}
