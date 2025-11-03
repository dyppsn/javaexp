Create Stop Watch with Swing GUI and Multithreading. Provide Facility for Lap
Counting.



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StopWatch extends JFrame implements ActionListener, Runnable {

    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton, lapButton;
    private JTextArea lapArea;
    private JScrollPane scrollPane;

    private Thread timerThread;
    private boolean running = false;

    private int hours = 0, minutes = 0, seconds = 0;

    private ArrayList<String> laps = new ArrayList<>();

    public StopWatch() {
        setTitle("Stop Watch with Lap Functionality");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Time display label
        timeLabel = new JLabel("00:00:00");
        timeLabel.setBounds(100, 30, 200, 50);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel);

        // Buttons
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        lapButton = new JButton("Lap");

        startButton.setBounds(50, 100, 80, 40);
        stopButton.setBounds(150, 100, 80, 40);
        resetButton.setBounds(250, 100, 80, 40);
        lapButton.setBounds(150, 160, 80, 40);

        add(startButton);
        add(stopButton);
        add(resetButton);
        add(lapButton);

        // Add action listeners
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
        lapButton.addActionListener(this);

        // Lap display area
        lapArea = new JTextArea();
        lapArea.setEditable(false);
        scrollPane = new JScrollPane(lapArea);
        scrollPane.setBounds(50, 220, 300, 200);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!running) {
                running = true;
                timerThread = new Thread(this);
                timerThread.start();
            }
        } else if (e.getSource() == stopButton) {
            running = false;
        } else if (e.getSource() == resetButton) {
            running = false;
            hours = minutes = seconds = 0;
            timeLabel.setText("00:00:00");
            laps.clear();
            lapArea.setText("");
        } else if (e.getSource() == lapButton) {
            if (running) {
                String lapTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                laps.add(lapTime);
                lapArea.append("Lap " + laps.size() + ": " + lapTime + "\n");
            }
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000); // 1 second
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }
                timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new StopWatch();
    }
}
