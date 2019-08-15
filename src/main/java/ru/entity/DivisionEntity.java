package ru.entity;


import javax.persistence.*;

@Entity
@Table(name = "division", schema = "public", catalog = "chel")
public class DivisionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddivision", length = 6, nullable = false, columnDefinition = "serial")
    private long iddivision;
    @Column(name = "namedivision", length = 150)
    private String namedivision ;
    @Column(name = "idcity", length = 8)
    private Integer idcity;
    public DivisionEntity() {} // Конструктор
    public long getIddevision() {        return iddivision;    }
    public void setIddevision(long idDevision) {        this.iddivision = idDevision;    }
    public String getNamedevision() {        return namedivision;    }
    public void setNamedevision(String namedivision) {        this.namedivision = namedivision;    }
    public Integer getIdcity() {        return idcity;    }
    public void setIdcity(Integer idcity) {        this.idcity = idcity;    }
}

