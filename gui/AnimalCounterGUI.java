package gui;

import model.Alligator;
import model.Sheep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalCounterGUI extends JFrame {
    private Alligator alligator;
    private Sheep sheep;

    private JLabel alligatorCountLabel;
    private JLabel sheepCountLabel;
    private JRadioButton alligatorRadioButton;
    private JRadioButton sheepRadioButton;

    public AnimalCounterGUI() {
        alligator = new Alligator();
        sheep = new Sheep();

        setTitle("Animal Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel welcomeLabel = new JLabel("Welcome to Animal Counter");
        add(welcomeLabel);

        alligatorCountLabel = new JLabel("Alligators: 0");
        add(alligatorCountLabel);

        sheepCountLabel = new JLabel("Sheep: 0");
        add(sheepCountLabel);

        JButton addAlligatorButton = new JButton("Add Alligator");
        add(addAlligatorButton);

        JButton addSheepButton = new JButton("Add Sheep");
        add(addSheepButton);

        JButton displayCountsButton = new JButton("Display Counts");
        add(displayCountsButton);

        JButton resetCountsButton = new JButton("Reset Counts");
        add(resetCountsButton);

        alligatorRadioButton = new JRadioButton("Alligator");
        sheepRadioButton = new JRadioButton("Sheep");
        ButtonGroup group = new ButtonGroup();
        group.add(alligatorRadioButton);
        group.add(sheepRadioButton);
        add(alligatorRadioButton);
        add(sheepRadioButton);

        JButton exitButton = new JButton("Exit");
        add(exitButton);

        ButtonHandler handler = new ButtonHandler();
        addAlligatorButton.addActionListener(handler);
        addSheepButton.addActionListener(handler);
        displayCountsButton.addActionListener(handler);
        resetCountsButton.addActionListener(handler);
        exitButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Add Alligator")) {
                alligator.incrementCount();
                if (alligator.getCount() > sheep.getCount()) {
                    JOptionPane.showMessageDialog(null, "Please add more sheep for the hungry alligators");
                }
            } else if (command.equals("Add Sheep")) {
                sheep.incrementCount();
            } else if (command.equals("Display Counts")) {
                alligatorCountLabel.setText("Alligators: " + alligator.getCount());
                sheepCountLabel.setText("Sheep: " + sheep.getCount());
            } else if (command.equals("Reset Counts")) {
                if (alligatorRadioButton.isSelected()) {
                    alligator.resetCount();
                    JOptionPane.showMessageDialog(null, "Alligator count reset to zero. No alligators now so the sheep are safe");
                } else if (sheepRadioButton.isSelected()) {
                    sheep.resetCount();
                }
            } else if (command.equals("Exit")) {
                System.exit(0);
            }

            alligatorCountLabel.setText("Alligators: " + alligator.getCount());
            sheepCountLabel.setText("Sheep: " + sheep.getCount());
        }
    }
}
