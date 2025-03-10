package Observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ProductUpdate {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private List<PropertyChangeListener> listeners = new ArrayList<>();

    public ProductUpdate() {
        this.support = new PropertyChangeSupport(this);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.add(listener);
        support.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        listeners.remove(listener);
        support.removePropertyChangeListener(listener);
    }

    public void notifyPropertyChange(String propertyName, Object oldValue, Object newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }
}
