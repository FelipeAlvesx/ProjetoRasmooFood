package br.com.rasmoo.restaurant.entity;


import net.bytebuddy.implementation.bytecode.ShiftRight;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    private String cpf;

    private String name;

    private String cep;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Client(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public Client(){

    }

    public void addAdress(Address address){
        address.setClient(this);
        this.addressList.add(address);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}
