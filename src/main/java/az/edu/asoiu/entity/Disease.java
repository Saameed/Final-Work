package az.edu.asoiu.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Hp on 25.05.2017.
 */
@Entity
@Table(name = "disease", catalog = "diplom")
public class Disease {
    private long id;
    private String name;
    private Integer status;
    private Timestamp dateCreated;
    private Integer type;
    private String icon;
    private String description;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date_created")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disease disease = (Disease) o;

        if (id != disease.id) return false;
        if (name != null ? !name.equals(disease.name) : disease.name != null) return false;
        if (status != null ? !status.equals(disease.status) : disease.status != null) return false;
        if (dateCreated != null ? !dateCreated.equals(disease.dateCreated) : disease.dateCreated != null) return false;
        if (type != null ? !type.equals(disease.type) : disease.type != null) return false;
        if (icon != null ? !icon.equals(disease.icon) : disease.icon != null) return false;
        if (description != null ? !description.equals(disease.description) : disease.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

}
