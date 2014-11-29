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
@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator {
    
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
        String username = (String)value;

        if (!username.matches("[a-zA-Z0-9]*")) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Username is not valid.");
            message.setDetail("Username is not valid. Can only contain letters and numbers.");
            context.addMessage("", message);
            throw new ValidatorException(message);
        }
            
    }
    
}
