package uk.co.jpawlak.desktoptimewidget;

import javax.swing.JLabel;
import javax.swing.JWindow;

public class ClockWindow {

    private final JWindow window = new JWindow();
    private final JLabel textLabel;

    public ClockWindow() {
        textLabel = new JLabel("Thu 25/03/2021 21:08:32");

        window.setContentPane(textLabel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public int getWidth() {
        return window.getWidth();
    }

    public int getHeight() {
        return window.getHeight();
    }

    public void setLocation(int x, int y) {
        window.setLocation(x, y);
    }

}
