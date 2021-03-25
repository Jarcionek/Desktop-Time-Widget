package uk.co.jpawlak.desktoptimewidget;

import javax.imageio.ImageIO;
import javax.swing.UIManager;
import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        createAndDisplayWindow();
        createAndSetSystemTray();
    }

    private static void createAndDisplayWindow() {
        ClockWindow clockWindow = new ClockWindow();

        GraphicsDevice primaryScreen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = primaryScreen.getDisplayMode().getWidth();

        clockWindow.setLocation(screenWidth - clockWindow.getWidth(), 0); // top right corner
    }

    private static void createAndSetSystemTray() {
        Image image;
        try {
            image = ImageIO.read(Main.class.getResource("Icon.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PopupMenu popupMenu = new PopupMenu();
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        popupMenu.add(exitMenuItem);

        TrayIcon trayIcon = new TrayIcon(image, "Desktop Time Widget", popupMenu);
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) { // LEFT MOUSE BUTTON
                    System.out.println("Hello!");
                }
            }
        });

        try {
            SystemTray.getSystemTray().add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

}
