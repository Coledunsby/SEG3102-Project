/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Cole
 */
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
    
    /**
     *
     * @param context
     * @param component
     * @param value
     */
    @Override
    public void validate(FacesContext context,
                        UIComponent component,
                        Object value) throws ValidatorException {
        String email = (String)value;

        if (email.length() - email.replace("@", "").length() != 1) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Email is not valid.");
            message.setDetail("Email is not valid. Must contain one \"@\" character.");
            context.addMessage("", message);
            throw new ValidatorException(message);
        }
            
    }
    
}
