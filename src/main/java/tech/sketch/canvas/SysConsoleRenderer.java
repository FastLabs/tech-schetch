package tech.sketch.canvas;

public class SysConsoleRenderer implements  SketchRenderer {

    @Override
    public void render(String content) {
        System.out.println(content);
    }
}
