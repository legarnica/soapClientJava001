package webservicesserver;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberToDollarsResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numberToDollarsResult"
})
@XmlRootElement(name = "NumberToDollarsResponse")
public class NumberToDollarsResponse {

    @XmlElement(name = "NumberToDollarsResult", required = true)
    protected String numberToDollarsResult;

    /**
     * Obtiene el valor de la propiedad numberToDollarsResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberToDollarsResult() {
        return numberToDollarsResult;
    }

    /**
     * Define el valor de la propiedad numberToDollarsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberToDollarsResult(String value) {
        this.numberToDollarsResult = value;
    }

}
