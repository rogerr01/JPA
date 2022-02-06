package main.java;

import java.util.ArrayList;

import java.util.Collection;


import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity

@Table (name = "village")


public class Village
{

    @Id

    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "idVillage")

    private int id;

    @Column (name = "dscVillage")

    private String dscVila;

    @Column (name = "nHab")

    private int habitants;

    @Column (name = "Ext")

    private int extensio;

    @OneToMany (mappedBy = "vila", fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Farmer> farmers = new ArrayList();

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getDscVila ()
    {
        return dscVila;
    }

    public void setDscVila (String dscVila)
    {
        this.dscVila = dscVila;
    }

    public int getHabitants ()
    {
        return habitants;
    }

    public void setHabitants (int habitants)
    {
        this.habitants = habitants;
    }

    public int getExtensio ()
    {
        return extensio;
    }

    public void setExtensio (int extensio)
    {
        this.extensio = extensio;
    }

    public void addFarmer (Farmer farmer)
    {
        if (!farmers.contains(farmer))
        {
            farmers.add(farmer);
        }
    }

    public Collection<Farmer> getFarmers ()
    {
        return farmers;
    }

    @Override

    public String toString ()
    {
        return "Village  [id=" + id + ", name:" + dscVila + "]";
    }

}