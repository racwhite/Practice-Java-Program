import java.util.ArrayList;
import java.util.Observable;

public class Source extends Observable {
    private ArrayList<Integer> _values = new ArrayList<Integer>();

    public void work() {
        int temp = (int) (Math.random() * 200) + 1;
        _values.add(temp);
        if (_values.size() > 20) {
            _values.remove(0);
        }
        this.setChanged();
        this.notifyObservers(temp);
    }

    public ArrayList<Integer> getValues() {
        return _values;
    }
}