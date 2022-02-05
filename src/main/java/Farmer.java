package main.java;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity

@Table(name="farmer")

@NamedQuery(name="findfarmer", query="Select f from Farmer f where f.id =:id")

public class Farmer
{

    @Id

    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "id")

    private int id;

    @Column (name = "name")

    private String name;

    @ManyToOne (fetch = FetchType.EAGER)

    @JoinColumn (name = "village", referencedColumnName = "idVillage")

    private Village vila;

    @OneToMany(mappedBy = "farmer",fetch = FetchType.EAGER,cascade={ CascadeType.ALL,CascadeType.PERSIST,
            CascadeType.MERGE })
    private final Collection<Tractor> tractors =new ArrayList();

    public void addTractor(Tractor tractor){

        if (!tractors.contains(tractor)){
            tractors.add(tractor);
        }
    }


    public int getId ()
    {

        return id;

    }

    public void setId (int id)
    {

        this.id = id;

    }

    public String getName ()
    {

        return name;

    }

    public void setName (String name)
    {

        this.name = name;

    }

    public Village getVillage ()
    {

        return vila;

    }

    public void setVillage (Village village)
    {


        this.vila = village;

    }

    @Override

    public String toString ()
    {

        return "Farmer [id" + id + ",name" + name + "]";

    }
}


