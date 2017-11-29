package stash.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("stashes")
	private List<StashesItem> stashes;

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
			"stashes = '" + stashes + '\'' + 
			",next_change_id = '" + nextChangeId + '\'' + 
			"}";
		}
}