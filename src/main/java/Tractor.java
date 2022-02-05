package main.java;

import javax.persistence.*;

@Entity

@Table (name = "tractor")

@NamedQuery (name = "findtractor", query = "Select t from Tractor t where t.id =:id")

public class Tractor
{

    @Id

    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private int id;

    @Column (name = "model")
    private String model;

    @Column (name = "power")
    private int power;

    @ManyToOne (fetch = FetchType.EAGER)

    @JoinColumn (name = "farmerID", referencedColumnName = "id")
    private Farmer farmer;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public Farmer getFarmer ()
    {
        return farmer;
    }

    public void setFarmer (Farmer farmer)
    {
        this.farmer = farmer;
    }

    public String getModel ()
    {
        return model;
    }

    public void setModel (String model)
    {
        this.model = model;
    }

    public int getPower ()
    {
        return power;
    }

    public void setPower (int power)
    {
        this.power = power;
    }

    @Override
    public String toString ()
    {
        return "tractor [id" + id + ",model" + model + "]";
    }
}


