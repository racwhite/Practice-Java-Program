import java.awt.*;
import java.util.*;

public abstract class Drawable {
    ArrayList<Integer> data = new ArrayList<Integer>();

    public abstract void draw(Graphics g);

    public abstract void setData(ArrayList<Integer> newData);
}