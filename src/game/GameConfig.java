package game;

public class GameConfig {
	
    public static final String MAJOR_VERSION = "0";
    public static final String MINOR_VERSION = "5";
    public static final String PATCH_VERSION = "3";
    
    public static final String TITLE = "College IHM Game Title";
    
    /**
     * public static final int JAVA_VERSION = 8 \\
     * The Java version in which this game is being coded with. 
     * I have chosen version 8 (or 1.8) due to its stability.
     * When coding with other versions, like 17 or 21, sometimes,
     * the application might just not run in other systems.
     * With Java 8, I never have a problem. Keep this is mind.
     */
    public static final int JAVA_VERSION = 8;
    
    /** 
     * public static final String \\
     * The stage in which the game is currently on. \\
     * Stages: Pre-Alpha, Alpha, Beta, Pre-Release, and Release
     */
    public static final String STAGE = "pre-alpha";

    public static String getVersion() {
        return "v" + MAJOR_VERSION + "." + MINOR_VERSION + "." + PATCH_VERSION + "-" + STAGE;
    }
    
    public static String getWindowTitle() {
        return TITLE + " (" + getVersion() + ")";
    }
}
