package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "StashesItem")
@Generated("com.robohorse.robopojogenerator")
public class StashesItem{
	public StashesItem() {
	}

	@ManyToOne
	@JoinColumn(name="ResponseID",nullable = false)
	private Response response;

	@Column(name = "public")
	@JsonProperty("public")
	private boolean jsonMemberPublic;

	@Column(name = "lastCharacterName")
    @JsonProperty("lastCharacterName")
	private String lastCharacterName;

	@Column(name = "accountName")
    @JsonProperty("accountName")
	private String accountName;

	@Id
	@Column(name = "ID")
    @JsonProperty("id")
	private String id;

	@OneToMany(mappedBy="stashesItem")
    @JsonProperty("items")
	private List<ItemsItem> items;


	@Column(name = "stashType")
    @JsonProperty("stashType")
	private String stashType;


	@Column(name = "stash")
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
			",items = '" + "alot" + '\'' +
			",stashType = '" + stashType + '\'' + 
			",stash = '" + stash + '\'' + 
			"}";
		}
}