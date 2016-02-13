package tech.sketch.command;


import org.junit.Test;
import tech.sketch.canvas.TextGraphicShell;
import tech.sketch.command.CommandResult.CommandStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SketchCommandProcessorTest {
    private final SketchCommandProcessor cp = new SketchCommandProcessor(new TextGraphicShell());

    @Test
    public void testExitCommand() {
        final CommandResult result = cp.processCommand("Q");
        assertNotNull(result);
        assertEquals(CommandStatus.EXIT, result.getStatus());
    }
    @Test
    public void testUnknownCommand() {

        final CommandResult result = cp.processCommand("A 1 2 3");

        assertNotNull(result);

        assertEquals(CommandStatus.UNKNOWN, result.getStatus());
    }
}
