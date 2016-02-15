package tech.sketch.command;


import org.junit.Test;
import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.utils.BufferedRendererAsserter;
import tech.sketch.canvas.utils.CanvasFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleShapeCommandTest {
    @Test
    public void testRectangleCreation() {
        RectangleShapeCommand cmd = new RectangleShapeCommand(new String[]{"R", "10", "10", "10", "20"});
        assertTrue(cmd.isValidCommand());
    }

    @Test
    public void notEnoughArguments() {
        final RectangleShapeCommand cmd = new RectangleShapeCommand(new String[]{"R", "0", "10", "20"});
        assertFalse("Not enough arguments", cmd.isValidCommand());
    }

    @Test
    public void notValidValues() {
        final RectangleShapeCommand cmd = new RectangleShapeCommand(new String[]{"R", "-1", "10", "20", "20"});
        assertFalse("No negative coordinates supported", cmd.isValidCommand());
    }

    @Test
    public void testVertical() {
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        final RectangleShapeCommand lCmd = new RectangleShapeCommand("R 2 2 5  4"); // tests the multiple spaces command as well
        final String[] expected = new String[]{
                "----------------------",
                "|                    |",
                "|                    |",
                "|  ******            |",
                "|  *    *            |",
                "|  *    *            |",
                "|  *    *            |",
                "|  ******            |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "----------------------"
        };
        lCmd.execute(canvas, asserter);
        asserter.assertContent(expected);
    }

}
