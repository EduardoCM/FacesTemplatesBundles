package com.oracle;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


@ManagedBean
@SessionScoped
public class LocalidadBean {
    
    private String localidad;
    private static Map<String, Object> lstPaises;
    
    private String uno = "uno";
    private String dos = "dos";

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Map<String, Object> getLstPaises() {
        return lstPaises;
    }

    public static void setLstPaises(Map<String, Object> lstPaises) {
        LocalidadBean.lstPaises = lstPaises;
    }
    
    static {
        lstPaises = new LinkedHashMap<String, Object>();
        
        lstPaises.put("English", Locale.ENGLISH);
        lstPaises.put("Frances", Locale.FRENCH);
        
        Locale esnol = new Locale("ES");
        lstPaises.put("Español", esnol);
    }
    
    
    public void localidadChanged(ValueChangeEvent e){
        String newLocaleValue = e.getNewValue().toString();
        
        for (Map.Entry<String, Object> entry : lstPaises.entrySet()) {
            
            if(entry.getValue().toString().equals(newLocaleValue)){
                FacesContext.getCurrentInstance().getViewRoot()
                        .setLocale((Locale)entry.getValue());
            }
            
        }
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }
    
    
    
    
}
