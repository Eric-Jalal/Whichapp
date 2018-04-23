package net.teslaa.whichapptest;

/**
 * Created by teslaa on 4/23/18.
 */

interface UseCase<P, Q> {
    P execute(Q param);
}
