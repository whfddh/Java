import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FootballMatchApp extends JFrame {
    private int MadridScore = 0;
    private int MilanScore = 0;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    JButton button1 = new JButton("AC Milan");
    JButton button2 = new JButton("Real Madrid");

    public FootballMatchApp() {
        JFrame frame = new JFrame( "Football Match");
        frame.setSize(400, 400);
        JPanel pnl = new JPanel();
        pnl.setLayout(new GridLayout(3, 1));

        resultLabel =  new JLabel("Result: 0 X 0 ");
        lastScorerLabel = new JLabel("Last Scorer: N/A");
        winnerLabel = new JLabel("WInner: Draw");


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MilanScore++;
                updateScores("AC Milan");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MadridScore++;
                updateScores("Real Madrid");
            }
        });
        pnl.add(button1);
        pnl.add(button2);
        pnl.add(resultLabel);
        pnl.add(lastScorerLabel);
        pnl.add(winnerLabel);
        frame.add(pnl);
        frame.setVisible(true);


    }

    private void updateScores(String lastScorer) {
        resultLabel.setText("Result: " + MilanScore + " X " + MadridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        if (MilanScore > MadridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (MadridScore > MilanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        new FootballMatchApp();
    }
}
