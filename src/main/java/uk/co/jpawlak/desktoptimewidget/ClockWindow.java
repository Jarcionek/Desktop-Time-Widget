package uk.co.jpawlak.desktoptimewidget;

import javax.swing.JLabel;
import javax.swing.JWindow;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClockWindow {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE dd.MM.yyyy HH:mm:ss");
    private static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();

    private final JWindow window = new JWindow();
    private final JLabel textLabel = new JLabel("");

    public ClockWindow() {
        window.setContentPane(textLabel);

        window.setSize(130, 15);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        EXECUTOR.scheduleAtFixedRate(this::updateTime, 0, 1, TimeUnit.SECONDS);
    }

    private void updateTime() {
        textLabel.setText(DATE_FORMAT.format(new Date()));
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
