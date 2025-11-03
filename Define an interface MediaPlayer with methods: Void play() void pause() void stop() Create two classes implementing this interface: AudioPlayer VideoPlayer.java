Define an interface MediaPlayer with methods:
Void play()
void pause()
void stop()
Create two classes implementing this interface:
AudioPlayer
VideoPlayer
Each class should implement the methods with appropriate print statements indicating the action
and type of player (e.g., "AudioPlayer playing..."). Write a driver program to demonstrate
polymorphic behavior by invoking these methods objects referenced by the interface type.



// MediaPlayer.java
interface MediaPlayer {
    void play();
    void pause();
    void stop();
}

// AudioPlayer.java
class AudioPlayer implements MediaPlayer {

    @Override
    public void play() {
        System.out.println("AudioPlayer playing...");
    }

    @Override
    public void pause() {
        System.out.println("AudioPlayer paused...");
    }

    @Override
    public void stop() {
        System.out.println("AudioPlayer stopped...");
    }
}

// VideoPlayer.java
class VideoPlayer implements MediaPlayer {

    @Override
    public void play() {
        System.out.println("VideoPlayer playing...");
    }

    @Override
    public void pause() {
        System.out.println("VideoPlayer paused...");
    }

    @Override
    public void stop() {
        System.out.println("VideoPlayer stopped...");
    }
}

// Main.java (Driver class)
public class Main {
    public static void main(String[] args) {
        // Interface reference pointing to AudioPlayer object
        MediaPlayer player1 = new AudioPlayer();
        player1.play();
        player1.pause();
        player1.stop();

        System.out.println("--------------------");

        // Interface reference pointing to VideoPlayer object
        MediaPlayer player2 = new VideoPlayer();
        player2.play();
        player2.pause();
        player2.stop();
    }
}
