package uk.co.jpawlak.desktoptimewidget;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.UIManager;
import java.awt.AWTException;
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
        JWindow window = new JWindow();

        JButton button = new JButton("Hello!");

//        button.addActionListener(e -> window.dispose()); // tray icon is still there so it doesn't terminate the process
        button.addActionListener(e -> System.exit(0));

        window.setContentPane(button);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
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
