package Mastermind.views;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final BoardView game;
    private final ConfigMenu config;
    private final Home home;

    public MainWindow(Home home, BoardView game, ConfigMenu config) {
        super("Mastermind");
        this.home = home;
        this.game = game;
        this.config = config;
        JButton playButton = new JButton("Play");
        playButton.addActionListener(e -> {
            this.home.setVisible(false);
            this.showGame();
        });
        JButton configButton = new JButton("Config");
        configButton.addActionListener(e -> {
            this.home.setVisible(false);
            this.showConfig();
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        this.home.add(playButton);
        this.home.add(configButton);
        this.add(home, BorderLayout.CENTER);
        showHome();

        this.setVisible(true);
    }

    public void showHome() {
        this.home.setVisible(true);
    }

    public void showConfig() {
        this.add(config, BorderLayout.CENTER);
        this.config.setVisible(true);
    }

    public void showGame() {
        this.add(game, BorderLayout.CENTER);
        this.game.setVisible(true);
    }
}
