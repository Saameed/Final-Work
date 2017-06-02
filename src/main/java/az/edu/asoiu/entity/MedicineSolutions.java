package az.edu.asoiu.entity;
// Generated May 25, 2017 2:55:45 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import javax.validation.constraints.NotNull;

/**
 * MedicineSolutions generated by hbm2java
 */
@Entity
@Table(name = "medicine_solutions", catalog = "diplom")
public class MedicineSolutions implements java.io.Serializable {

    private Long id;
    private String solution;
    private String description;
    private Integer status;
    private Date dateCreated;
    private String icon;
    private Disease diseaseId;

    public MedicineSolutions() {
    }


    public MedicineSolutions(String solution, String description) {
        this.solution = solution;
        this.description = description;
    }

    public MedicineSolutions(String solution, String description, Integer status, Date dateCreated, String icon, Disease diseaseId) {
        this.solution = solution;
        this.description = description;
        this.status = status;
        this.dateCreated = dateCreated;
        this.icon = icon;
        this.diseaseId = diseaseId;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "solution", nullable = false, length = 1500)
    public String getSolution() {
        return this.solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }


    @Column(name = "description", nullable = false, length = 5000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "status")
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", length = 19)
    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Column(name = "icon", length = 15000)
    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    @NotNull
    @ManyToOne
    @JoinColumn(name = "disease_id", referencedColumnName = "id")
    public Disease getDiseaseId() {
        return this.diseaseId;
    }

    public void setDiseaseId(Disease diseaseId) {
        this.diseaseId = diseaseId;
    }


}


