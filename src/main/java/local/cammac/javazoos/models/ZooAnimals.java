package local.cammac.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Animal animal;

    public ZooAnimals() {
    }

    public ZooAnimals(Zoo zoo, Animal animal) {
        this.zoo = zoo;
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
            // compare the object to itself
        if (this == o) return true;
            // compare to null or compare the types
        if (o == null || getClass() != o.getClass()) return false;
            // cast the generic object passed in as a ZooAnimalsId object
            // makes sure it has the right methods and fields
        ZooAnimals that = (ZooAnimals) o;
            // if they share the same zooid and animalid, they are the same
        return (((this.zoo == null) ? 0 : this.zoo.getZooid())
                    == ((that.zoo == null) ? 0 : that.zoo.getZooid()))
                && (((this.animal == null) ? 0 : this.animal.getAnimalid())
                    == ((that.animal == null) ? 0 : that.animal.getAnimalid()));
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
