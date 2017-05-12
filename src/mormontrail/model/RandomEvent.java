/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Andrew
 */
public class RandomEvent implements Serializable {
    
    private String negativeEvent;
    private String positiveEvent;
    private String nothingHappens;

    public RandomEvent() {
    }

    
    
    public String getNegativeEvent() {
        return negativeEvent;
    }

    public String getPositiveEvent() {
        return positiveEvent;
    }

    public String getNothingHappens() {
        return nothingHappens;
    }

    public void setNegativeEvent(String negativeEvent) {
        this.negativeEvent = negativeEvent;
    }

    public void setPositiveEvent(String positiveEvent) {
        this.positiveEvent = positiveEvent;
    }

    public void setNothingHappens(String nothingHappens) {
        this.nothingHappens = nothingHappens;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.negativeEvent);
        hash = 19 * hash + Objects.hashCode(this.positiveEvent);
        hash = 19 * hash + Objects.hashCode(this.nothingHappens);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RandomEvent other = (RandomEvent) obj;
        if (!Objects.equals(this.negativeEvent, other.negativeEvent)) {
            return false;
        }
        if (!Objects.equals(this.positiveEvent, other.positiveEvent)) {
            return false;
        }
        if (!Objects.equals(this.nothingHappens, other.nothingHappens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RandomEvent{" + "negativeEvent=" + negativeEvent + ", positiveEvent=" + positiveEvent + ", nothingHappens=" + nothingHappens + '}';
    }
    
    
    
    
    
}
