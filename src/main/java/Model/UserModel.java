package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String permision;
    private String codeId;
    public UserModel(String name, String permision, String codeId) {

        this.name = name;
        this.permision = permision;
        this.codeId = codeId;
    }

    public UserModel(int id,String name, String permision, String codeId) {
        this.id=id;
        this.name = name;
        this.permision = permision;
        this.codeId = codeId;
    }

    public UserModel() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermision() {
        return permision;
    }

    public void setPermision(String permision) {
        this.permision = permision;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
}
