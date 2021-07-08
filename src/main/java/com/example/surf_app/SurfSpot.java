package com.example.surf_app;

import lombok.Data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "surf_spots")
public class SurfSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String locals;
    @Column(nullable = false)
    private String conditions;
    @Column(nullable = false)
    private String beach_or_reef_break;

    
    public SurfSpot() {
        // super();
        // this.name = name;
    }

    public SurfSpot(String name) {
        super();
        this.name = name;
    }

    public SurfSpot(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocals() {
        return this.locals;
    }

    public void setLocals(String locals) {
        this.locals = locals;
    }

    public String getConditions() {
        return this.conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getBeach_or_reef_break() {
        return this.beach_or_reef_break;
    }

    public void setBeach_or_reef_break(String beach_or_reef_break) {
        this.beach_or_reef_break = beach_or_reef_break;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SurfSpot)) {
            return false;
        }
        SurfSpot surfSpot = (SurfSpot) o;
        return Objects.equals(id, surfSpot.id) && Objects.equals(name, surfSpot.name)
                && Objects.equals(link, surfSpot.link) && Objects.equals(description, surfSpot.description)
                && Objects.equals(image, surfSpot.image) && Objects.equals(locals, surfSpot.locals)
                && Objects.equals(conditions, surfSpot.conditions)
                && Objects.equals(beach_or_reef_break, surfSpot.beach_or_reef_break);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, link, description, image, locals, conditions, beach_or_reef_break);
    }

}
