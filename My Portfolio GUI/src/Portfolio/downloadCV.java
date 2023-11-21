package Portfolio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class downloadCV extends CustomButton {

	JButton okButton = new JButton("OK");
	String sourceFolderPath = "D:/PROJECT OOP/Portfolio-2.zip_expanded/Portfolio"; // File path of the CV file
	String fileName = "CV.pdf"; // File name
	String destinationPath = System.getProperty("user.home") + "/Downloads/" + fileName;

	public downloadCV() {
		super();
	}

	@Override
	void onClick() {
		// Very special button
		okButton.setFont(new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));
		okButton.setBackground(Color.WHITE);
		okButton.setFocusable(false);
		okButton.setBorderPainted(true);

		onDownload();

		try {
			Path sourceFilePath = Path.of(sourceFolderPath, fileName);
			Path destinationFilePath = Path.of(destinationPath);
			Files.copy(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	void onDownload() {
		Object[] options = { okButton };

		UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));
		JOptionPane pane = new JOptionPane("Downloaded Successfully", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.OK_OPTION, null, options);

		JDialog dialog = pane.createDialog("Success");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		dialog.setVisible(true);
	}
}
