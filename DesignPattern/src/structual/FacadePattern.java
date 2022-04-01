package structual;

public class FacadePattern {
	public static void main(String[] args) {
		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		Dvdplayer dvd = new Dvdplayer();
		CdPlayer cd = new CdPlayer();
		Projector projector = new Projector();
		Screen screen = new Screen();
		TheaterLights lights = new TheaterLights();
		PopcornPopper popper = new PopcornPopper();

		// instantiate components here
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
		homeTheater.watchMovie("Ÿ¥");
		homeTheater.endMovie();
	}

}

class HomeTheaterFacade {
	Amplifier amp;
	Tuner tunner;
	Dvdplayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;

	public HomeTheaterFacade(Amplifier amp, Tuner tuner, Dvdplayer dvd, CdPlayer cd, Projector projector, Screen screen,
			TheaterLights lights, PopcornPopper popper) {
		this.amp = amp;
		this.tunner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.screen = screen;
		this.lights = lights;
		this.popper = popper;
	}

	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie...");
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amp.on();
		amp.setDvd(dvd);
		amp.setsurroundSound();
		amp.setVolume(5);
		dvd.on();
		dvd.play(movie);
	}

	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		popper.off();
		lights.on();
		screen.up();
		projector.off();
		amp.off();
		dvd.stop();
		dvd.eject();
		dvd.off();
	}
}

class Amplifier {

	public void on() {
		// ... ����
	}

	public void off() {
		// ... ����
	}

	public void setVolume(int i) {
		// ... ����
	}

	public void setsurroundSound() {
		// ... ����
	}

	public void setDvd(Dvdplayer dvd) {
		// ... ����
	}
}

class Tuner {
}

class Dvdplayer {

	public void on() {
		// ... ����
	}

	public void off() {
		// ... ����
	}

	public void eject() {
		// ... ����
	}

	public void stop() {
		// ... ����
	}

	public void play(String movie) {
		// ... ����
	}
}

class CdPlayer {
}

class Projector {

	public void on() {
		// ... ����
	}

	public void off() {
		// ... ����
	}

	public void wideScreenMode() {
		// ... ����
	}
}

class TheaterLights {

	public void dim(int i) {
		// ... ����
	}

	public void on() {
		// ... ����
	}
}

class Screen {

	public void down() {
		// ... ����
	}

	public void up() {
		// ... ����
	}
}

class PopcornPopper {

	public void on() {
		// ... ����
	}

	public void off() {
		// ... ����
	}

	public void pop() {
		// ... ����
	}
}
