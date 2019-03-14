//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.26 at 10:34:34 PM CET 
//


package se.krogrannet.xsd.IOF;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.orienteering.org/datastandard/3.0}Id" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartTime" type="{http://www.orienteering.org/datastandard/3.0}DateAndOptionalTime" minOccurs="0"/>
 *         &lt;element name="EndTime" type="{http://www.orienteering.org/datastandard/3.0}DateAndOptionalTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.orienteering.org/datastandard/3.0}EventStatus" minOccurs="0"/>
 *         &lt;element name="Classification" type="{http://www.orienteering.org/datastandard/3.0}EventClassification" minOccurs="0"/>
 *         &lt;element name="Form" type="{http://www.orienteering.org/datastandard/3.0}EventForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Organiser" type="{http://www.orienteering.org/datastandard/3.0}Organisation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Official" type="{http://www.orienteering.org/datastandard/3.0}Role" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Class" type="{http://www.orienteering.org/datastandard/3.0}Class" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Race" type="{http://www.orienteering.org/datastandard/3.0}Race" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EntryReceiver" type="{http://www.orienteering.org/datastandard/3.0}EntryReceiver" minOccurs="0"/>
 *         &lt;element name="Service" type="{http://www.orienteering.org/datastandard/3.0}Service" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Account" type="{http://www.orienteering.org/datastandard/3.0}Account" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="URL" type="{http://www.orienteering.org/datastandard/3.0}EventURL" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Information" type="{http://www.orienteering.org/datastandard/3.0}InformationItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Schedule" type="{http://www.orienteering.org/datastandard/3.0}Schedule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="News" type="{http://www.orienteering.org/datastandard/3.0}InformationItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.orienteering.org/datastandard/3.0}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="modifyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event", propOrder = {
    "id",
    "name",
    "startTime",
    "endTime",
    "status",
    "classification",
    "form",
    "organiser",
    "official",
    "clazz",
    "race",
    "entryReceiver",
    "service",
    "account",
    "url",
    "information",
    "schedule",
    "news",
    "extensions"
})
public class Event {

    @XmlElement(name = "Id")
    protected Id id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "StartTime")
    protected DateAndOptionalTime startTime;
    @XmlElement(name = "EndTime")
    protected DateAndOptionalTime endTime;
    @XmlElement(name = "Status")
    protected EventStatus status;
    @XmlElement(name = "Classification")
    protected EventClassification classification;
    @XmlElement(name = "Form")
    protected List<EventForm> form;
    @XmlElement(name = "Organiser")
    protected List<Organisation> organiser;
    @XmlElement(name = "Official")
    protected List<Role> official;
    @XmlElement(name = "Class")
    protected List<Class> clazz;
    @XmlElement(name = "Race")
    protected List<Race> race;
    @XmlElement(name = "EntryReceiver")
    protected EntryReceiver entryReceiver;
    @XmlElement(name = "Service")
    protected List<Service> service;
    @XmlElement(name = "Account")
    protected List<Account> account;
    @XmlElement(name = "URL")
    protected List<EventURL> url;
    @XmlElement(name = "Information")
    protected List<InformationItem> information;
    @XmlElement(name = "Schedule")
    protected List<Schedule> schedule;
    @XmlElement(name = "News")
    protected List<InformationItem> news;
    @XmlElement(name = "Extensions")
    protected Extensions extensions;
    @XmlAttribute(name = "modifyTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifyTime;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setId(Id value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateAndOptionalTime }
     *     
     */
    public DateAndOptionalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndOptionalTime }
     *     
     */
    public void setStartTime(DateAndOptionalTime value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateAndOptionalTime }
     *     
     */
    public DateAndOptionalTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndOptionalTime }
     *     
     */
    public void setEndTime(DateAndOptionalTime value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link EventStatus }
     *     
     */
    public EventStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventStatus }
     *     
     */
    public void setStatus(EventStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the classification property.
     * 
     * @return
     *     possible object is
     *     {@link EventClassification }
     *     
     */
    public EventClassification getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventClassification }
     *     
     */
    public void setClassification(EventClassification value) {
        this.classification = value;
    }

    /**
     * Gets the value of the form property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the form property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventForm }
     * 
     * 
     */
    public List<EventForm> getForm() {
        if (form == null) {
            form = new ArrayList<EventForm>();
        }
        return this.form;
    }

    /**
     * Gets the value of the organiser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organiser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganiser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Organisation }
     * 
     * 
     */
    public List<Organisation> getOrganiser() {
        if (organiser == null) {
            organiser = new ArrayList<Organisation>();
        }
        return this.organiser;
    }

    /**
     * Gets the value of the official property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the official property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfficial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Role }
     * 
     * 
     */
    public List<Role> getOfficial() {
        if (official == null) {
            official = new ArrayList<Role>();
        }
        return this.official;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clazz property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClazz().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Class }
     * 
     * 
     */
    public List<Class> getClazz() {
        if (clazz == null) {
            clazz = new ArrayList<Class>();
        }
        return this.clazz;
    }

    /**
     * Gets the value of the race property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the race property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Race }
     * 
     * 
     */
    public List<Race> getRace() {
        if (race == null) {
            race = new ArrayList<Race>();
        }
        return this.race;
    }

    /**
     * Gets the value of the entryReceiver property.
     * 
     * @return
     *     possible object is
     *     {@link EntryReceiver }
     *     
     */
    public EntryReceiver getEntryReceiver() {
        return entryReceiver;
    }

    /**
     * Sets the value of the entryReceiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntryReceiver }
     *     
     */
    public void setEntryReceiver(EntryReceiver value) {
        this.entryReceiver = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Service }
     * 
     * 
     */
    public List<Service> getService() {
        if (service == null) {
            service = new ArrayList<Service>();
        }
        return this.service;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Account }
     * 
     * 
     */
    public List<Account> getAccount() {
        if (account == null) {
            account = new ArrayList<Account>();
        }
        return this.account;
    }

    /**
     * Gets the value of the url property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the url property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getURL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventURL }
     * 
     * 
     */
    public List<EventURL> getURL() {
        if (url == null) {
            url = new ArrayList<EventURL>();
        }
        return this.url;
    }

    /**
     * Gets the value of the information property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the information property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformationItem }
     * 
     * 
     */
    public List<InformationItem> getInformation() {
        if (information == null) {
            information = new ArrayList<InformationItem>();
        }
        return this.information;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schedule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchedule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Schedule }
     * 
     * 
     */
    public List<Schedule> getSchedule() {
        if (schedule == null) {
            schedule = new ArrayList<Schedule>();
        }
        return this.schedule;
    }

    /**
     * Gets the value of the news property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the news property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNews().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformationItem }
     * 
     * 
     */
    public List<InformationItem> getNews() {
        if (news == null) {
            news = new ArrayList<InformationItem>();
        }
        return this.news;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link Extensions }
     *     
     */
    public Extensions getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extensions }
     *     
     */
    public void setExtensions(Extensions value) {
        this.extensions = value;
    }

    /**
     * Gets the value of the modifyTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModifyTime() {
        return modifyTime;
    }

    /**
     * Sets the value of the modifyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModifyTime(XMLGregorianCalendar value) {
        this.modifyTime = value;
    }

}
