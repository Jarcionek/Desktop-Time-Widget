package uk.co.jpawlak.desktoptimewidget;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingWorker;

public class ClockWindow {

    private final JWindow window = new JWindow();
    private final JLabel textLabel = new JLabel("");
    private final SwingWorker<?, ?> swingWorker = new SwingWorker<>() {
        @Override
        protected Object doInBackground() throws Exception {
            int i = 1;
            while (!isCancelled()) {
                textLabel.setText("" + i++);
                Thread.sleep(1000);
            }
            return null;
        }
    };

    public ClockWindow() {
        window.setContentPane(textLabel);

        window.setSize(100, 15);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        swingWorker.execute();
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
