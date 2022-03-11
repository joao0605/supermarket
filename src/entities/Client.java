package entities;

public class Client {
    protected String name;
    protected String cpf;
    protected Boolean clubMember;

    public Client() {
    }

    public Client(String name, String cpf, Boolean clubMember) {
        this.name = name;
        this.cpf = cpf;
        this.clubMember = clubMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getClubMember() {
        return clubMember;
    }

    public void setClubMember(Boolean partner) {
        this.clubMember = clubMember;
    }

    public String welcome() {
        return "Perfeito, " + name + ", seja bem vindo(a)!!";
    }
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", partner=" + clubMember +
                '}';
    }
}
