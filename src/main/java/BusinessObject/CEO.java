package BusinessObject;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class CEO extends BusinessObject implements PropertyChangeListener {

    public CEO() {
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();
        if ("NewOrder".equals(propertyName)) {
            System.out.println("\n*****************************************************");
            System.out.println("Message to CEO " +this.getName() + ": New "+evt.getNewValue()+" Order Created\n");
        } else if ("OrderReady".equals(propertyName)) {
            System.out.println("\n*****************************************************");
            System.out.println("Message to CEO " +this.getName() + ": "+evt.getNewValue()+" Order Completed\n");
        }
    }
}

