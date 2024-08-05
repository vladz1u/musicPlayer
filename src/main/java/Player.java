import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.InputStream;

public class Player {

    public void playMusic(String filePath) {
        try {
            if ("error.mp3".equalsIgnoreCase(filePath)) {
                throw new MyOwnError("Файл не может называться 'error': " + filePath);
            }

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
            System.out.println(filePath);
            if (inputStream == null) {
                throw new IllegalArgumentException("Файл не знайдено: " + filePath);
            }

            AdvancedPlayer player = new AdvancedPlayer(inputStream);
            player.play();
        } catch (MyOwnError e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

}
