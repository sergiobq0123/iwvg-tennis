package ivwg.tennis.controllers;

import ivwg.tennis.database.RefereeDAO;
import ivwg.tennis.models.Referee;
import ivwg.tennis.types.Error;

public class RefereeController {
    private RefereeDAO refereeDAO;

    public RefereeController() {
        refereeDAO = new RefereeDAO();
    }

    public Error addReferee (Referee referee) {
        boolean si = refereeDAO.exists(referee);
        if (!refereeDAO.exists(referee)) {
            refereeDAO.addReferee(referee);
            return Error.NULL_ERROR;
        }
        return Error.DUPLICATE_REFEREE;
    }

    public Error login (String name, String password) {
        if (refereeDAO.login(new Referee(name, password))){
            return Error.NULL_ERROR;
        }
        return Error.NOT_LOGIN;
    }
}
