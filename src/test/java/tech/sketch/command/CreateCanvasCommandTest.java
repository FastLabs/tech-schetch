package tech.sketch.command;


import org.junit.Test;
import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.utils.BufferedRendererAsserter;

import static org.junit.Assert.*;

public class CreateCanvasCommandTest {


    @Test
    public void testCreateCommand() {
        final CreateCanvasCommand cmd = new CreateCanvasCommand(new String[]{"C", "10", "20"});
        assertEquals("C", cmd.getCommandName());
        assertEquals(10, cmd.getWidth());
        assertEquals(20, cmd.getHeight());
        assertEquals("C %W %H", cmd.getCommandFormat());
        assertTrue(cmd.isValidCommand());

    }

    @Test
    public void testNegativeBoundaries() {
        final CreateCanvasCommand cmd = new CreateCanvasCommand(new String[]{"C", "-1", "-20"});
        assertFalse(cmd.isValidCommand());
    }

    @Test
    public void testNoNumberBoundaries() {
        final CreateCanvasCommand cmd = new CreateCanvasCommand(new String[]{"C", "a", "10"});
        assertFalse(cmd.isValidCommand());
    }

    @Test
    public void testRendered() {
        final SketchCanvas canvas = new SketchCanvas(20, 12);
        final CreateCanvasCommand cmd = new CreateCanvasCommand(new String[]{"C", "20", "12"});

        BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        final String[] emptyCanvas = new String[]{
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "----------------------"
        };

        cmd.execute(canvas, asserter);
        asserter.getContent();

    }
}
