package tech.sketch.shape;

/**
 * Simple shape represented by a set of paths
 */
public interface Shape {


    Path[] getPaths();
    Rectangle getBounds();
}
