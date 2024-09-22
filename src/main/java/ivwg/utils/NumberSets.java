package ivwg.utils;

import ivwg.tennis.types.Error;

public class NumberSets {

    public Error verifyNumberOfSets(int numberSet) {
        if(!(numberSet == 3 || numberSet == 5)){
            return Error.WRONG_NUMBER_OF_SETS;
        }
         return Error.NULL_ERROR;
    }
}

