package com.nace.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Nace contains all attributes.
 */
@Entity
@Table(name = "nace")
public class Nace {

  @Id
  @Column(name = "orderId")
  private long orderId;

  @Column(name = "level")
  private String level;

  @Column(name = "code")
  private String code;

  @Column(name = "parent")
  private String parent;

  @Column(name = "description", length = 2000)
  private String description;

  @Column(name = "itemIncludeContent", length = 2000)
  private String itemIncludeContent;

  @Column(name = "itemAdditionalContent", length = 2000)
  private String itemAdditionalContent;

  @Column(name = "rulling")
  private String rulling;

  @Column(name = "itemExcludes")
  private String itemExcludes;

  @Column(name = "referenceToISIC")
  private String referenceToISIC;

  public Nace() {
  }

  public Nace(long orderId, String level, String code, String parent, String description, String itemIncludeContent, String itemAdditionalContent, String rulling, String itemExcludes,
      String referenceToISIC) {
  }

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getItemIncludeContent() {
    return itemIncludeContent;
  }

  public void setItemIncludeContent(String itemIncludeContent) {this.itemIncludeContent = itemIncludeContent; }

  public String getItemAdditionalContent() {
    return itemAdditionalContent;
  }

  public void setItemAdditionalContent(String itemAdditionalContent) {this.itemAdditionalContent = itemAdditionalContent; }

  public String getRulling() {
    return rulling;
  }

  public void setRulling(String rulling) {
    this.rulling = rulling;
  }

  public String getItemExcludes() {
    return itemExcludes;
  }

  public void setItemExcludes(String itemExcludes) {this.itemExcludes = itemExcludes; }

  public String getReferenceToISIC() { return referenceToISIC; }

  public void setReferenceToISIC(String referenceToISIC) {this.referenceToISIC = referenceToISIC; }

  @Override
  public String toString() {
    return "Nace{" +
        "OrderId=" + orderId +
        ", level=" + level +
        ", code=" + code +
        ", parent='" + parent + '\'' +
        ", description='" + description + '\'' +
        ", itemIncludeContent='" + itemIncludeContent + '\'' +
        ", itemAdditionalContent='" + itemAdditionalContent + '\'' +
        ", rulling='" + rulling + '\'' +
        ", itemExcludes='" + itemExcludes + '\'' +
        ", referenceToISIC='" + referenceToISIC + '\'' +
        '}';
  }

}

