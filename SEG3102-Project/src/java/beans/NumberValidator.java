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
@FacesValidator("numberValidator")
public class NumberValidator implements Validator {
    
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
        if (value instanceof Integer){
            int number = (int) value;
            if (number < 0) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("Field is not valid.");
                message.setDetail("Field is not valid. Must be >= 0.");
                context.addMessage("", message);
                throw new ValidatorException(message);
            }
        } else if (value instanceof Double){
            double number = (double) value;
            if (number < 0) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("Field is not valid.");
                message.setDetail("Field is not valid. Must be >= 0.");
                context.addMessage("", message);
                throw new ValidatorException(message);
            }
        }  else {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Field is not valid.");
            message.setDetail("Field is not valid. Must be a number");
            context.addMessage("", message);
            throw new ValidatorException(message);
        }
    }
    
}
