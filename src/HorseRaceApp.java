import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class HorseRaceApp extends GraphicsApp {

    private Horse[] horses;
    private StadiumSpeaker speaker;

    @Override
    public void initialize() {
        setupCanvas();
        initSpeaker();
        initHorses();
    }

    private void setupCanvas() {
        setCanvasSize(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
        setFrameRate(Config.FRAME_RATE);
    }

    private void initSpeaker() {
        speaker = new StadiumSpeaker();
    }

    private void initHorses() {
        horses = new Horse[Config.NUM_HORSES];
        for (int i = 0; i < horses.length; i++) {
            float yPos = Config.HORSE_RADIUS + i * (Config.HORSE_RADIUS * 2);
            horses[i] = new Horse(yPos, speaker);
        }
    }

    @Override
    public void draw() {
        drawHorses();
        drawSpeakerAnnouncements();
    }

    private void drawSpeakerAnnouncements() {
        speaker.draw();
    }

    private void drawHorses() {
        for (Horse hors : horses) {
            hors.draw();
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }

}
