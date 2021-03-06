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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.orienteering.org/datastandard/3.0}BaseElement">
 *       &lt;sequence>
 *         &lt;element name="Event" type="{http://www.orienteering.org/datastandard/3.0}Event"/>
 *         &lt;element name="TeamEntry" type="{http://www.orienteering.org/datastandard/3.0}TeamEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PersonEntry" type="{http://www.orienteering.org/datastandard/3.0}PersonEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.orienteering.org/datastandard/3.0}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "event",
    "teamEntry",
    "personEntry",
    "extensions"
})
@XmlRootElement(name = "EntryList")
public class EntryList
    extends BaseElement
{

    @XmlElement(name = "Event", required = true)
    protected Event event;
    @XmlElement(name = "TeamEntry")
    protected List<TeamEntry> teamEntry;
    @XmlElement(name = "PersonEntry")
    protected List<PersonEntry> personEntry;
    @XmlElement(name = "Extensions")
    protected Extensions extensions;

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link Event }
     *     
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link Event }
     *     
     */
    public void setEvent(Event value) {
        this.event = value;
    }

    /**
     * Gets the value of the teamEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the teamEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTeamEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TeamEntry }
     * 
     * 
     */
    public List<TeamEntry> getTeamEntry() {
        if (teamEntry == null) {
            teamEntry = new ArrayList<TeamEntry>();
        }
        return this.teamEntry;
    }

    /**
     * Gets the value of the personEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonEntry }
     * 
     * 
     */
    public List<PersonEntry> getPersonEntry() {
        if (personEntry == null) {
            personEntry = new ArrayList<PersonEntry>();
        }
        return this.personEntry;
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

}
