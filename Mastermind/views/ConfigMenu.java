package Mastermind.views;

import Mastermind.controllers.BoardController;
import Mastermind.models.Difficulty;
import Mastermind.models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class ConfigMenu extends RawPanel {
    public ConfigMenu(BoardController boardController, Home home) {
        super("Config the game");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // choose player name
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(20, 20));
        this.add(new JLabel("Enter your username:"));
        this.add(usernameField);

        // choose turn nb
        JSlider nbOfAttemptsSlider;
        this.add(new JLabel("Number of attempts"));
        nbOfAttemptsSlider = new JSlider(4, 12, 10);
        nbOfAttemptsSlider.setMajorTickSpacing(1);
        nbOfAttemptsSlider.setPaintTicks(true);
        nbOfAttemptsSlider.setPaintLabels(true);
        this.add(nbOfAttemptsSlider);

        // choose nb of different colors (size of the palette)
        JSlider paletteSizeSlider;
        this.add(new JLabel("Palette size (nb of different colors)"));
        paletteSizeSlider = new JSlider(4, 8, 8);
        paletteSizeSlider.setMajorTickSpacing(1);
        paletteSizeSlider.setPaintTicks(true);
        paletteSizeSlider.setPaintLabels(true);
        this.add(paletteSizeSlider);

        // choose size of the secret code
        JSlider sizeOfCodeSlider;
        this.add(new JLabel("Size of the secret code"));
        sizeOfCodeSlider = new JSlider(4, 6, 4);
        sizeOfCodeSlider.setMajorTickSpacing(1);
        sizeOfCodeSlider.setPaintTicks(true);
        sizeOfCodeSlider.setPaintLabels(true);
        this.add(sizeOfCodeSlider);

        // choose maximum number of turn
        JSlider maxTurn;
        this.add(new JLabel("Max turn's number"));
        maxTurn = new JSlider(3, 5, 3);
        maxTurn.setMajorTickSpacing(1);
        maxTurn.setPaintTicks(true);
        maxTurn.setPaintLabels(true);
        this.add(maxTurn);

        // choose difficulty / correction format
        AtomicReference<Difficulty> difficulty = new AtomicReference<>();   // AtomicReference allow to get/set the value into buttons' event
        ButtonGroup difficultyGroup = new ButtonGroup();
        JRadioButton easyButton = new JRadioButton("Easy");
        JRadioButton classicButton = new JRadioButton("Classic");
        JRadioButton numericButton = new JRadioButton("Numeric");
        difficultyGroup.add(easyButton);
        difficultyGroup.add(classicButton);
        difficultyGroup.add(numericButton);
        easyButton.addActionListener(e -> difficulty.set(Difficulty.Easy));
        classicButton.addActionListener(e -> difficulty.set(Difficulty.Classic));
        numericButton.addActionListener(e -> difficulty.set(Difficulty.Numeric));
        easyButton.setSelected(true);
        easyButton.setVisible(true);
        classicButton.setVisible(true);
        numericButton.setVisible(true);
        this.add(easyButton);
        this.add(classicButton);
        this.add(numericButton);

        // extract the new config for board
        JButton playButton = new JButton("save");
        playButton.addActionListener(e -> {
            boardController.modifyBoardConfig(new Player(usernameField.getText()), difficulty.get(), sizeOfCodeSlider.getValue(), nbOfAttemptsSlider.getValue(), paletteSizeSlider.getValue(), maxTurn.getValue());
            this.setVisible(false);
            home.setVisible(true);
        });
        this.add(playButton);
    }
}
