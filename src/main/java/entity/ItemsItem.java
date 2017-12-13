package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "ItemsItem")
@Generated("com.robohorse.robopojogenerator")

public class ItemsItem{
    public ItemsItem() {
    }

    @ManyToOne
    @JoinColumn(name="StashID")
    private StashesItem stashesItem;

    @JsonProperty("verified")
    @Column(name = "verified")
    private String verified;

    @JsonProperty("w")
    @Column(name = "w")
    private String w;

    @JsonProperty("h")
    @Column(name = "h")
    private String h;

    @JsonProperty("ilvl")
    @Column(name = "ilvl")
    private String ilvl;

    @JsonProperty("icon")
    @Column(name = "icon")
    private String icon;

    @JsonProperty("league")
    @Column(name = "league")
    private String league;

    @JsonProperty("id")
    @Id
    @Column(name = "itemID")
    private String id;

    @JsonProperty("sockets")
    @Transient
    private List<Object> sockets;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("typeLine")
    @Column(name = "typeLine")
    private String typeLine;

    @JsonProperty("identified")
    @Column(name = "identified")
    private String identified;

    @JsonProperty("corrupted")
    @Column(name = "corrupted")
    private String corrupted;

    @JsonProperty("lockedToCharacter")
    @Column(name = "lockedToCharacter")
    private String lockedToCharacter;

    @JsonProperty("note")
    @Column(name = "note")
    private String note;

    @JsonProperty("properties")
    @Transient
    private List<Object> properties;

    @JsonProperty("requirements")
    @Transient
    private List<Object> requirements;

    @JsonProperty("explicitMods")
    @Transient
    private ArrayList explicitMods;

    @JsonProperty("implicitMods")
    @Transient
    private ArrayList implicitMods;

    @JsonProperty("enchantMods")
    @Transient
    private ArrayList enchantMods;

    @JsonProperty("craftedMods")
    @Transient
    private ArrayList craftedMods;

    @JsonProperty("flavourText")
    @Transient
    private ArrayList flavourText;

    @JsonProperty("frameType")
    @Column(name = "frameType")
    private int frameType;

    @JsonProperty("x")
    @Column(name = "x")
    private int x;

    @JsonProperty("y")
    @Column(name = "y")
    private int y;

    @JsonProperty("elder")
    @Transient
    private List<Object> elder;

    @JsonProperty("inventoryId")
    @Column(name = "inventoryId")
    private String inventoryId;

    @JsonProperty("abyssJewel")
    @Transient
    private List<Object> abyssJewel;

    @JsonProperty("socketedItems")
    @Transient
    private List<Object> socketedItems;

    @JsonProperty("additionalProperties")
    @Transient
    private List<Object> additionalProperties;

    @JsonProperty("secDescrText")
    @Column(name = "secDescrText")
    private String secDescrText;

    @JsonProperty("descrText")
    @Column(name = "descrText")
    private String descrText;

    @JsonProperty("artFilename")
    @Column(name = "artFilename")
    private String artFilename;

    @JsonProperty("duplicated")
    @Column(name = "duplicated")
    private String duplicated;

    @JsonProperty("category")
    @Transient
    private List<Object> category;

    @JsonProperty("maxStackSize")
    @Column(name = "maxStackSize")
    private String maxStackSize;

    @JsonProperty("nextLevelRequirements")
    @Transient
    private List<Object> nextLevelRequirements;

    @JsonProperty("stackSize")
    @Column(name = "stackSize")
    private int stackSize;

    @JsonProperty("talismanTier")
    @Column(name = "talismanTier")
    private int talismanTier;

    @JsonProperty("shaper")
    @Transient
    private ArrayList shaper;

    @JsonProperty("utilityMods")
    @Transient
    private ArrayList utilityMods;

    @JsonProperty("support")
    @Column(name = "support")
    private boolean support;

    @JsonProperty("cosmeticMods")
    @Transient
    private ArrayList cosmeticMods;


    @JsonProperty("prophecyDiffText")
    @Column(name = "prophecyDiffText")
    private String prophecyDiffText;

    @JsonProperty("prophecyText")
    @Column(name = "prophecyText")
    private String prophecyText;

    @JsonProperty("isRelic")
    @Column(name = "isRelic")
    private boolean isRelic;

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public StashesItem getStashesItem() {
        return stashesItem;
    }

    public void setStashesItem(StashesItem stashesItem) {
        this.stashesItem = stashesItem;
    }

    public List<Object> getCategory() {
        return category;
    }

    public void setCategory(List<Object> category) {
        this.category = category;
    }
    public String getIlvl() {
        return ilvl;
    }

    public void setIlvl(String ilvl) {
        this.ilvl = ilvl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getSockets() {
        return sockets;
    }

    public void setSockets(List<Object> sockets) {
        this.sockets = sockets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
    }

    public String getCorrupted() {
        return corrupted;
    }

    public void setCorrupted(String corrupted) {
        this.corrupted = corrupted;
    }

    public String getLockedToCharacter() {
        return lockedToCharacter;
    }

    public void setLockedToCharacter(String lockedToCharacter) {
        this.lockedToCharacter = lockedToCharacter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Object> getProperties() {
        return properties;
    }

    public void setProperties(List<Object> properties) {
        this.properties = properties;
    }

    public List<Object> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Object> requirements) {
        this.requirements = requirements;
    }

    public ArrayList getExplicitMods() {
        return explicitMods;
    }

    public void setExplicitMods(ArrayList explicitMods) {
        this.explicitMods = explicitMods;
    }

    public ArrayList getImplicitMods() {
        return implicitMods;
    }

    public void setImplicitMods(ArrayList implicitMods) {
        this.implicitMods = implicitMods;
    }

    public ArrayList getEnchantMods() {
        return enchantMods;
    }

    public void setEnchantMods(ArrayList enchantMods) {
        this.enchantMods = enchantMods;
    }

    public ArrayList getCraftedMods() {
        return craftedMods;
    }

    public void setCraftedMods(ArrayList craftedMods) {
        this.craftedMods = craftedMods;
    }

    public ArrayList getFlavourText() {
        return flavourText;
    }

    public void setFlavourText(ArrayList flavourText) {
        this.flavourText = flavourText;
    }

    public int getFrameType() {
        return frameType;
    }

    public void setFrameType(int frameType) {
        this.frameType = frameType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public List<Object> getSocketedItems() {
        return socketedItems;
    }

    public void setSocketedItems(List<Object> socketedItems) {
        this.socketedItems = socketedItems;
    }

    public List<Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(List<Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public String getSecDescrText() {
        return secDescrText;
    }

    public void setSecDescrText(String secDescrText) {
        this.secDescrText = secDescrText;
    }

    public String getDescrText() {
        return descrText;
    }

    public void setDescrText(String descrText) {
        this.descrText = descrText;
    }

    public String getArtFilename() {
        return artFilename;
    }

    public void setArtFilename(String artFilename) {
        this.artFilename = artFilename;
    }

    public String getDuplicated() {
        return duplicated;
    }

    public void setDuplicated(String duplicated) {
        this.duplicated = duplicated;
    }

    public String getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(String maxStackSize) {
        this.maxStackSize = maxStackSize;
    }

    public List<Object> getNextLevelRequirements() {
        return nextLevelRequirements;
    }

    public void setNextLevelRequirements(List<Object> nextLevelRequirements) {
        this.nextLevelRequirements = nextLevelRequirements;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public int getTalismanTier() {
        return talismanTier;
    }

    public void setTalismanTier(int talismanTier) {
        this.talismanTier = talismanTier;
    }

    public ArrayList getUtilityMods() {
        return utilityMods;
    }

    public void setUtilityMods(ArrayList utilityMods) {
        this.utilityMods = utilityMods;
    }

    public boolean isSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }

    public ArrayList getCosmeticMods() {
        return cosmeticMods;
    }

    public void setCosmeticMods(ArrayList cosmeticMods) {
        this.cosmeticMods = cosmeticMods;
    }

    public String getProphecyDiffText() {
        return prophecyDiffText;
    }

    public void setProphecyDiffText(String prophecyDiffText) {
        this.prophecyDiffText = prophecyDiffText;
    }

    public String getProphecyText() {
        return prophecyText;
    }

    public void setProphecyText(String prophecyText) {
        this.prophecyText = prophecyText;
    }

    public boolean isRelic() {
        return isRelic;
    }

    public void setRelic(boolean relic) {
        isRelic = relic;
    }

    public ArrayList getShaper() {
        return shaper;
    }

    public void setShaper(ArrayList shaper) {
        this.shaper = shaper;
    }

    @Override
    public String toString() {
        return "ItemsItem{" +
                "typeLine='" + typeLine + '\'' +
                ", note='" + note + '\'' +
                ", frameType=" + frameType +
                '}';
    }
}