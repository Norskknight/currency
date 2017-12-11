package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Response")
@Generated("com.robohorse.robopojogenerator")
public class Response{

    public Response() {
    }
    @OneToMany(mappedBy="response")
    @JsonProperty("stashes")
	private List<StashesItem> stashes;
    @Id
    @Column(name = "changeID")
	@JsonProperty("next_change_id")
	private String nextChangeId;

	public void setStashes(List<StashesItem> stashes){
		this.stashes = stashes;
	}

	public List<StashesItem> getStashes(){
		return stashes;
	}

	public void setNextChangeId(String nextChangeId){
		this.nextChangeId = nextChangeId;
	}

	public String getNextChangeId(){
		return nextChangeId;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"stashes = '" + "alot" + '\'' +
			",next_change_id = '" + nextChangeId + '\'' + 
			"}";
		}
}