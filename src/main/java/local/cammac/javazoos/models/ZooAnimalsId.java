package local.cammac.javazoos.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZooAnimalsId implements Serializable {

    private long zoo;
    private long animal;

    public ZooAnimalsId() {
    }

    public ZooAnimalsId(long zoo, long animal) {
        this.zoo = zoo;
        this.animal = animal;
    }

    public long getZoo() {
        return zoo;
    }

    public void setZoo(long zoo) {
        this.zoo = zoo;
    }

    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
            // compare the object to itself
        if (this == o) return true;
            // compare to null or compare the types
        if (o == null || getClass() != o.getClass()) return false;
            // cast the generic object passed in as a UserRolesId object
            // makes sure it has the right methods and fields
        ZooAnimalsId that = (ZooAnimalsId) o;
            // if they share the same userid and role id, they are the same
        return this.zoo == that.zoo && this.animal == that.animal;
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
