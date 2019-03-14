//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.26 at 10:34:34 PM CET 
//


package se.krogrannet.xsd.IOF;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EventStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Planned"/>
 *     &lt;enumeration value="Applied"/>
 *     &lt;enumeration value="Proposed"/>
 *     &lt;enumeration value="Sanctioned"/>
 *     &lt;enumeration value="Canceled"/>
 *     &lt;enumeration value="Rescheduled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EventStatus")
@XmlEnum
public enum EventStatus {


    /**
     * 
     *             The event or race is on a planning stadium and has not been submitted to any sanctioning body.
     *           
     * 
     */
    @XmlEnumValue("Planned")
    PLANNED("Planned"),

    /**
     * 
     *             The organiser has submitted the event to the relevant sanctioning body.
     *           
     * 
     */
    @XmlEnumValue("Applied")
    APPLIED("Applied"),

    /**
     * 
     *             The organiser has bid on hosting the event or race as e.g. a championship.
     *           
     * 
     */
    @XmlEnumValue("Proposed")
    PROPOSED("Proposed"),

    /**
     * 
     *             The event oc race meets the relevant requirements and will happen.
     *           
     * 
     */
    @XmlEnumValue("Sanctioned")
    SANCTIONED("Sanctioned"),

    /**
     * 
     *             The event or race has been canceled, e.g. due to weather conditions.
     *           
     * 
     */
    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),

    /**
     * 
     *             The date of the event or race has changed. A new Event or Race element should be created in addition to the already existing element.
     *           
     * 
     */
    @XmlEnumValue("Rescheduled")
    RESCHEDULED("Rescheduled");
    private final String value;

    EventStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventStatus fromValue(String v) {
        for (EventStatus c: EventStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
