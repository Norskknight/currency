package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="userItems")
public class Useritems {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long Itemid;
    @Column(name = "userid")
    private Long userid;
    @Column(name = "itemName")
    private String itemname;

    public Useritems() {
    }

    public Useritems(Long userid, String itemname) {
        this.userid = userid;
        this.itemname = itemname;
    }

    public Long getUserid() {
        return userid;
      }

    public void setUserid(Long userid) {
        this.userid = userid;
      }

    public String getItemname() {
        return itemname;
      }

    public void setItemname(String itemname) {
        this.itemname = itemname;
      }

    public Long getItemid() {
        return Itemid;
    }

    public void setItemid(Long itemid) {
        Itemid = itemid;
    }
}
