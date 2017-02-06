package xyz.codingmentor.webdto;

/**
 *
 * @author Péter
 */
public class ErrorDTO {

    private String errorMessage;

    public ErrorDTO() {
        //generated
    }

    public ErrorDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
