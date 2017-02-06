package xyz.codingmentor.services;

import javax.servlet.http.HttpSession;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.exception.NotLoggedInException;
import static xyz.codingmentor.services.UserRESTService.USER_KEY;

/**
 *
 * @author Péter
 */
public class IsLoggedInUtility {

    private IsLoggedInUtility() {
        //generated
    }

    public static UserEntity isLoggedIn(HttpSession session) {
        if (null != session.getAttribute(UserRESTService.USER_KEY)) {
            return (UserEntity) session.getAttribute(USER_KEY);
        } else {
            throw new NotLoggedInException();
        }
    }

}
