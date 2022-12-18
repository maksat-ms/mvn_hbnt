package hbnte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fio_list")
public class FIOList {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="fio")
    private String fio;

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public FIOList() {
    }

    public FIOList(int id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "FIOList{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                '}';
    }


}
