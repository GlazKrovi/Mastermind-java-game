package Mastermind.views;

import javax.swing.*;
import java.awt.*;

public class ColorChooser extends JPanel {
    private IColorMediator mediator;

    public ColorChooser(Color[] availableColors) {
        setLayout(new GridLayout(1, availableColors.length, 10, 10));

        // create buttons
        for (int i = 0; i < availableColors.length; i++) {
            BlockButton button = new BlockButton("", null);
            button.setBackground(availableColors[i]);
            button.setBorder(BorderFactory.createRaisedBevelBorder());
            button.setButtonSize(35, 35);
            button.setActionCommand(String.valueOf(i));
            int finalI = i;
            button.addActionListener(e -> {
                update(availableColors[finalI]);
            });

            add(button);
        }
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
    }

    public void setMediator(IColorMediator mediator) {
        this.mediator = mediator;
    }

    public void update(Color color) {
        mediator.update(color);
    }
}
