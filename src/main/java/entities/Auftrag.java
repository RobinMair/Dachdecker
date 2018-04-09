package entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="getAllAssignments", query = "SELECT a FROM Auftrag a"),
})
@Table(name = "ER_AUFTRAG")
public class Auftrag {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "AU_ID", updatable = false, nullable = false)
    private Long id;

    @Version
    @Column(name = "AU_VERSION")
    private int version;

    @Column(name = "AU_FIRST_NAME")
    private String kundenName;

    @Column(name = "AU_ADRESSE")
    private String adresse;

    @Column(name = "AU_AUFTRAGSSTATUS")
    private Auftragsstatus auftragsstatus;

    public Auftrag() {
    }

    public Auftrag(String kundenName, String adresse) {
        this.kundenName = kundenName;
        this.adresse = adresse;
        this.auftragsstatus = Auftragsstatus.ANGEFRAGT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKundenName() {
        return kundenName;
    }

    public void setKundenName(String kundenName) {
        this.kundenName = kundenName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Auftragsstatus getAuftragsstatus() {
        return auftragsstatus;
    }

    public void setAuftragsstatus(Auftragsstatus auftragsstatus) {
        this.auftragsstatus = auftragsstatus;
    }
}
