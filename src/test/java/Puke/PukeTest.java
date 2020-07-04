package Puke;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PukeTest {

    @Test
    public void GetValueByString1() {
        Puke puke = new Puke();
        int eResult = puke.GetValueByString("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH");
        assertEquals(0,eResult);
    }
    @Test
    public void GetValueByString2() {
        Puke puke = new Puke();
        int eResult = puke.GetValueByString("Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S");
        assertEquals(0,eResult);
    }
    @Test
    public void GetValueByString3() {
        Puke puke = new Puke();
        int eResult = puke.GetValueByString("Black: 2H 3H 5H 9H KH White: 2C 3H 4S 5C 6H");
        assertEquals(1,eResult);
    }
    @Test
    public void GetValueByString4() {
        Puke puke = new Puke();
        int eResult = puke.GetValueByString("Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH");
        assertEquals(-1,eResult);
    }

}