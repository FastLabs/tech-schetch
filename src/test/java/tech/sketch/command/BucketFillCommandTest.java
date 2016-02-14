package tech.sketch.command;


import org.junit.Test;
import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.utils.BufferedRendererAsserter;
import tech.sketch.canvas.utils.CanvasFactory;
import tech.sketch.shape.Rectangle;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class BucketFillCommandTest {

    public static String fillLine(final int length) {
        final char[] x = new char[length];
        Arrays.fill(x, '-');
        return new String(x);
    }

    public static String padLine(final int length, char fillChar) {
        final char[] x = new char[length];
        Arrays.fill(x, fillChar);
        x[0] = '|';
        x[length - 1] = '|';
        return new String(x);
    }

    public static Function<String[], Boolean> emptyCanvasAsserter(int width, int height, char fill) {
        return (String[] lines) -> {

            assertEquals("Total lines including borders", height, lines.length);
            final String horizontalLine = fillLine(width);
            final String contentLine = padLine(width, fill);
            assertEquals("First Line", horizontalLine, lines[0]);
            assertEquals("Last Line", horizontalLine, lines[lines.length - 1]);
            for (int i = 1; i < lines.length - 1; i++) {
                assertEquals("Empty screen line " + i, contentLine, lines[i]);
            }
            return true;
        };
    }

    //TODO: make this configurable or better passed from config
    private final boolean showOnScreen = true;

    @Test
    public void testFullFill() {
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        asserter.render(canvas.printCanvas());
        asserter.assertContent(emptyCanvasAsserter(22, 14, ' ')); // empty canvas

        BucketFillCommand cmd = new BucketFillCommand(new String[]{"B", "2", "2", "@"});
        cmd.execute(canvas, asserter);
        if (showOnScreen) {
            System.out.println(canvas.printCanvas());
        }
        asserter.assertContent(emptyCanvasAsserter(22, 14, '@')); //full fill canvas
    }

    @Test
    public void testAreaFillIn() {
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        asserter.render(canvas.printCanvas());
        asserter.assertContent(emptyCanvasAsserter(22, 14, ' ')); // empty canvas
        Rectangle r = new Rectangle(3, 3, 5, 5);
        canvas.draw(r);

        final String[] expect = new String[]{
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|   ******           |",
                "|   *@@@@*           |",
                "|   *@@@@*           |",
                "|   *@@@@*           |",
                "|   *@@@@*           |",
                "|   ******           |",
                "|                    |",
                "|                    |",
                "|                    |",
                "----------------------"
        };

        final BucketFillCommand cmd = new BucketFillCommand(new String[]{"B", "4", "4", "@"});
        cmd.execute(canvas, asserter);
        asserter.assertContent(expect);
    }

    @Test
    public void testAreaFillOut() {
        final SketchCanvas canvas = CanvasFactory.defaultCanvas();
        final BufferedRendererAsserter asserter = new BufferedRendererAsserter();
        asserter.render(canvas.printCanvas());
        asserter.assertContent(emptyCanvasAsserter(22, 14, ' ')); // empty canvas
        final Rectangle r = new Rectangle(3, 3, 5, 5);
        canvas.draw(r);
        final String[] expect = new String[]{
                "----------------------",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@******@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@*    *@@@@@@@@@@@|",
                "|@@@******@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "|@@@@@@@@@@@@@@@@@@@@|",
                "----------------------",};

        BucketFillCommand cmd = new BucketFillCommand(new String[]{"B", "2", "2", "@"});
        cmd.execute(canvas, asserter);
        if (showOnScreen) {
            System.out.println(asserter.getContent());
        }

        asserter.assertContent(expect);
    }
}
