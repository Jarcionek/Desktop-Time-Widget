package uk.co.jpawlak.desktoptimewidget;

import javax.swing.JLabel;
import javax.swing.JWindow;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClockWindow {

    private static final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    private final JWindow window = new JWindow();
    private final JLabel textLabel = new JLabel("");

    private int i = 1;

    public ClockWindow() {
        window.setContentPane(textLabel);

        window.setSize(100, 15);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        service.scheduleAtFixedRate(() -> textLabel.setText("" + i++), 0, 1, TimeUnit.SECONDS);
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
