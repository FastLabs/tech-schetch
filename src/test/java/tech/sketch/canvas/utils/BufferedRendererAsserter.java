package tech.sketch.canvas.utils;

import org.junit.Assert;
import tech.sketch.canvas.SketchRenderer;

import java.util.function.Function;

/**
 * Stub renderer that holds the last rendered canvas. Exposes an assertion function for validating the rendered content
 */
public class BufferedRendererAsserter implements SketchRenderer {
    private String content;

    @Override
    public void render(String content) {
        this.content = content;
    }

    public void assertContent(Function<String [], Boolean> assertFn) {
        final String [] lines = content.split("\n");
        Assert.assertTrue(assertFn.apply(lines));
    }

    public void assertContent(String [] expect) {
        final String [] content = this.content.split("\n");
        for(int i = 0; i< content.length;i++) {
            Assert.assertEquals("Lne: " + i, expect[i], content[i] );
        }
    }

    public String getContent() {
        return content;
    }
}
