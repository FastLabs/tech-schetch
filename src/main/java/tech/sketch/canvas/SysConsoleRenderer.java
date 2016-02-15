package tech.sketch.canvas;

/**
 * Renders the string content to the system console
 */
public class SysConsoleRenderer implements  SketchRenderer {

    @Override
    public void render(String content) {
        System.out.println(content);
    }
}
