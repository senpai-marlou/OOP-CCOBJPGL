package Portfolio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class hobbiesButton extends downloadCV {

	private static JLabel gaming = new JLabel(gamingImage);
	private static JLabel coding = new JLabel(codingImage);
	private static JLabel movies = new JLabel(moviesImage);

	private static CustomButton showClose = new CustomButton();

	public hobbiesButton() {
		super();

		showClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.layeredPane.remove(showClose);
				Main.layeredPane.remove(coding);
				Main.layeredPane.remove(gaming);
				Main.layeredPane.remove(movies);

				enableUI();
				Main.layeredPane.repaint(); // Repainting the Layered Pane
			}
		});
	}

	void onGaming() {
		disableUI();
		showClose();
		gaming.setBounds(0, 0, gamingImage.getIconWidth(), gamingImage.getIconHeight());
		Main.layeredPane.add(gaming, new Integer(3));
		Main.layeredPane.add(showClose, new Integer(4));
	}

	void onCoding() {
		disableUI();
		showClose();
		coding.setBounds(0, 0, codingImage.getIconWidth(), codingImage.getIconHeight());
		Main.layeredPane.add(coding, new Integer(3));
		Main.layeredPane.add(showClose, new Integer(4));
	}

	void onMovies() {
		disableUI();
		showClose();
		movies.setBounds(0, 0, moviesImage.getIconWidth(), moviesImage.getIconHeight());
		Main.layeredPane.add(movies, new Integer(3));
		Main.layeredPane.add(showClose, new Integer(4));
	}

	void showClose() {
		showClose.setBounds(741, 74, 25, 25);
	}

	void disableUI() {
		Main.scrollPane.setWheelScrollingEnabled(false);

		Main.gaming.setEnabled(false);
		Main.coding.setEnabled(false);
		Main.movies.setEnabled(false);

		Main.toHome.setEnabled(false);
		Main.toAbout.setEnabled(false);
		Main.toSkills.setEnabled(false);
		Main.toHobbies.setEnabled(false);
		Main.toEducation.setEnabled(false);
		Main.toContact.setEnabled(false);
		Main.movies.setEnabled(false);
		Main.upButton.setEnabled(false);
	}

	void enableUI() {
		Main.scrollPane.setWheelScrollingEnabled(true);

		Main.gaming.setEnabled(true);
		Main.coding.setEnabled(true);
		Main.movies.setEnabled(true);

		Main.toHome.setEnabled(true);
		Main.toAbout.setEnabled(true);
		Main.toSkills.setEnabled(true);
		Main.toHobbies.setEnabled(true);
		Main.toEducation.setEnabled(true);
		Main.toContact.setEnabled(true);
		Main.movies.setEnabled(true);
		Main.upButton.setEnabled(true);
	}
}
