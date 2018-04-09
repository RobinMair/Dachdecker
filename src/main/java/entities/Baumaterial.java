package entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="getAllBMs", query = "SELECT bm FROM Baumaterial bm"),
})
@Table(name = "ER_BAUMATERIAL")
public class Baumaterial {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "BM_ID", updatable = false, nullable = false)
    private Long id;

    @Version
    @Column(name = "BM_VERSION")
    private int version;

    @Column(name = "BM_MATERIAL")
    private String material;

    @Column(name = "BM_PREISPROKILO")
    private double preisprokilo;

    public Long getId() {
        return id;
    }

    public Baumaterial() {
    }

    public Baumaterial(String material, double preisprokilo) {
        this.material = material;
        this.preisprokilo = preisprokilo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPreisprokilo() {
        return preisprokilo;
    }

    public void setPreisprokilo(double preisprokilo) {
        this.preisprokilo = preisprokilo;
    }
}
