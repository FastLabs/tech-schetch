package tech.sketch.canvas;

/**
 * Generic canvas exception
 */
public class CanvasException extends Exception {

    public CanvasException() {
        super("Canvas Exception");
    }

    public CanvasException(String message) {
        super(message);
    }
}
