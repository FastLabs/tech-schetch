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
    public void notEnoughArguments() {
        final CreateCanvasCommand cmd = new CreateCanvasCommand(new String[]{"C", "0"});
        assertFalse("Not enough arguments", cmd.isValidCommand());
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

        final CreateCanvasCommand cmd = new CreateCanvasCommand(new String[]{"C", "22", "14"});
        final SketchCanvas canvas = new SketchCanvas(cmd.getWidth()-2, cmd.getHeight()-2);
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
        asserter.assertContent(emptyCanvas);

    }
}
