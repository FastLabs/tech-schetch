package tech.sketch.canvas;


import org.junit.Assert;
import org.junit.Test;
import tech.sketch.command.CommandResult;
import tech.sketch.command.CreateCanvasCommand;
import tech.sketch.command.LineShapeCommand;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static tech.sketch.command.CommandResult.CommandStatus.SUCCESS;

public class TextGraphicShellTest {


    @Test
    public void testCanvasCreation() {
        final TextGraphicShell shell = new TextGraphicShell();
        final CommandResult r1 = shell.newSketchCanvas(new CreateCanvasCommand(new String[]{"C", "10", "10"}));
        assertEquals(SUCCESS, r1.getStatus());
        final CommandResult r2 = shell.execute(new LineShapeCommand(new String[]{"L", "1", "1", "3", "1"}));
        assertEquals(SUCCESS, r2.getStatus());

    }
}
