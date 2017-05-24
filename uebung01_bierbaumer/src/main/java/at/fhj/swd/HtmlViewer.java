package at.fhj.swd;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * A class to display html files
 * @author Helmut Bierbaumer
 *         Created on 2017/05/24.
 */
public class HtmlViewer {

    /**
     * Displays the file stored at fileLocation in a swing frame
     * @param protocol use "file" for locally stored files
     * @param fileLocation
     */
    public static void displayHtml(String protocol, String fileLocation) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("SWD-Quiz");

            JEditorPane htmlView = new JEditorPane();
            htmlView.setEditable(false);
            try {
                htmlView.setPage(new URL(protocol, "localhost", fileLocation));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            frame.add(new JScrollPane(htmlView));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(800, 700));
            frame.setVisible(true);
            frame.pack();
        });
    }
}
