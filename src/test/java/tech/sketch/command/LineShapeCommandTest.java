package tech.sketch.command;


import org.junit.Test;
import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.utils.BufferedRendererAsserter;
import tech.sketch.canvas.utils.CanvasFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LineShapeCommandTest {

    @Test
    public void testLineCreation() {
        LineShapeCommand cmd = new LineShapeCommand(new String[]{"L", "10", "10", "10", "20"});
        assertTrue(cmd.isValidCommand());
    }

    @Test
    public void notEnoughArguments() {
        final LineShapeCommand cmd = new LineShapeCommand(new String[]{"L", "0", "10", "20"});
        assertFalse("Not enough arguments", cmd.isValidCommand());
    }

    @Test
    public void notValidDiagonal() {
        final LineShapeCommand cmd = new LineShapeCommand(new String[]{"L", "10", "10", "20", "20"});
        assertFalse("Only horizontal and vertical supported", cmd.isValidCommand());
    }

    @Test

    public void testVertical() {
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        final LineShapeCommand lCmd = new LineShapeCommand("L 2 3 2 10");
        final String[] expected = new String[]{
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|  *                 |",
                "|  *                 |",
                "|  *                 |",
                "|  *                 |",
                "|  *                 |",
                "|  *                 |",
                "|  *                 |",
                "|  *                 |",
                "|                    |",
                "----------------------"
        };
        lCmd.execute(canvas, asserter);
        asserter.assertContent(expected);
    }

    @Test

    public void testHorizontal() {
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        final LineShapeCommand lCmd = new LineShapeCommand("L 2 3 10 3");
        final String[] expected = new String[]{
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|  *********         |",
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
        lCmd.execute(canvas, asserter);
        asserter.assertContent(expected);
    }
}
