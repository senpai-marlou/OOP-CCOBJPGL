package Portfolio;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class socialsButton extends hobbiesButton {

	public socialsButton() {
		super();
	}

	void onFacebook() {
		try {
			Desktop.getDesktop().browse(new URI("https://www.facebook.com/jmtobello"));
		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
	}

	void onInstagram() {
		try {
			Desktop.getDesktop().browse(new URI("https://www.instagram.com/senpai_marlou/"));
		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
	}

	void onDiscord() {
		try {
			Desktop.getDesktop().browse(new URI("https://dsc.bio/marlou"));
		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
	}

	void onLinkedin() {
		try {
			Desktop.getDesktop().browse(new URI("https://linkedin.com/in/jhon-marlou-tobello-062b2925a"));
		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
	}

	void onGithub() {
		try {
			Desktop.getDesktop().browse(new URI("https://github.com/senpai-marlou"));
		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
	}
}
