package ivwg.tennis.controllers;

import ivwg.tennis.models.Referee;
import ivwg.tennis.types.Error;

import java.util.Objects;

public class RefereeController extends GenericController<Referee> {


    public RefereeController() {
    }

    public Error login(String name, String password) {
        boolean existReferee = this.existEntity(
                r -> Objects.equals(r.getName(), name) && Objects.equals(r.getPassword(), password)
        );
        if (existReferee) {
            return Error.NULL_ERROR;
        }
        return Error.NOT_LOGIN;
    }

    public Error addReferee(Referee referee) {
        Referee addedReferee = this.addEntity(referee);
        if (addedReferee == null) {
            return Error.DUPLICATE_REFEREE;
        }
        return Error.NULL_ERROR;
    }
}
