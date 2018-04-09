package entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="getAllEmployees", query = "SELECT ma FROM Mitarbeiter ma"),
        @NamedQuery(name="getEmpById", query = "Select m from Mitarbeiter m where m.id = :id")
})
@Table(name = "ER_MITARBEITER")
public class Mitarbeiter {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "MA_ID", updatable = false, nullable = false)
    private Long id;

    @Version
    @Column(name = "MA_VERSION")
    private int version;

    @Column(name = "MA_FIRST_NAME")
    private String firstName;

    @Column(name = "MA_LAST_NAME")
    private String lastName;

    @Column(name = "MA_EMAIL", unique = true)
    private String email;

    @Column(name = "MA_POSITION")
    private String position;

    @Column(name = "MA_BESCHAEFTIGT")
    private Boolean beschaeftigt;

    public Mitarbeiter() {
    }

    public Mitarbeiter(String firstName, String lastName, String email, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        beschaeftigt = false;
    }

    public Boolean getBeschaeftigt() {
        return beschaeftigt;
    }

    public void setBeschaeftigt(Boolean beschaeftigt) {
        this.beschaeftigt = beschaeftigt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
