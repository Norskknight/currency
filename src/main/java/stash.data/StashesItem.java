package stash.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class StashesItem{

	@JsonProperty("public")
	private boolean jsonMemberPublic;

	@JsonProperty("lastCharacterName")
	private String lastCharacterName;

	@JsonProperty("accountName")
	private String accountName;

	@JsonProperty("id")
	private String id;

	@JsonProperty("items")
	private List<ItemsItem> items;

	@JsonProperty("stashType")
	private String stashType;

	@JsonProperty("stash")
	private String stash;

	public void setJsonMemberPublic(boolean jsonMemberPublic){
		this.jsonMemberPublic = jsonMemberPublic;
	}

	public boolean isJsonMemberPublic(){
		return jsonMemberPublic;
	}

	public void setLastCharacterName(String lastCharacterName){
		this.lastCharacterName = lastCharacterName;
	}

	public String getLastCharacterName(){
		return lastCharacterName;
	}

	public void setAccountName(String accountName){
		this.accountName = accountName;
	}

	public String getAccountName(){
		return accountName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	public void setStashType(String stashType){
		this.stashType = stashType;
	}

	public String getStashType(){
		return stashType;
	}

	public void setStash(String stash){
		this.stash = stash;
	}

	public String getStash(){
		return stash;
	}

	@Override
 	public String toString(){
		return 
			"StashesItem{" + 
			"public = '" + jsonMemberPublic + '\'' + 
			",lastCharacterName = '" + lastCharacterName + '\'' + 
			",accountName = '" + accountName + '\'' + 
			",id = '" + id + '\'' + 
			",items = '" + items + '\'' + 
			",stashType = '" + stashType + '\'' + 
			",stash = '" + stash + '\'' + 
			"}";
		}
}