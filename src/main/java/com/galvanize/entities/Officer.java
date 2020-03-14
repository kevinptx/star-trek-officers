package com.galvanize.entities;
import javax.persistence.*;


public class Officer {
//    Create an entity named Officer with the following attributes
//    id : Long
//    rank : Rank (enum from above)
//    first : String
//    last : String

    private Long id;
    private Rank rank;
    private String firstName;
    private String lastName;

    public Officer(){}

    public Officer(Rank rank, String firstName, String lastName){
        this.id = id;
        this.rank = rank;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Rank getRank(){
        return rank;
    }

    public void setRank(Rank rank){
        this.rank = rank;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Officer{" +
                "id=" + id +
                ", rank=" + rank +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
