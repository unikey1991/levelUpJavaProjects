import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by unike on 15.12.2016.
 */
public class AlistTestHW12 {

    Alist list;

    @Before
    public void setUp(){
        list = new Alist();
    }


    @Test
    public void shouldAddElementInStartAndReturnSizeOne() throws Exception {
        //given
        int expected = 1;

        //when
        list.addToArrayStarting(5);
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);

    }

    @Test
    public void shouldAdd2ElementsInstartAndAddToIndex1AndReturnSizeThree() throws Exception {
        //given
        int expected = 3;

        //when
        list.addToArrayStarting(1);
        list.addToArrayStarting(2);
        list.addToArrayIndex(3, 1);
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);

    }

    @Test
    public void shouldReturnLastAddedElementToStart(){
        //given
        int expected = 11;


        //when
        for (int i = 0; i < 11; i++){
            list.addToArrayStarting(i+1);
        }

        int actual = list.get(0);

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldReturnAllAddedElementsToStringWithSeparator(){
        //given
        String expected = "1, 2, 3, 4, 5, 6";
        String separator = ",";


        //when
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        String actual = list.outAllElementsThroughtSeparator(separator);

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldAddTwoElementAndAddToStartTwoElementAndAddOnIndex2OneElementAndReturnTrueeString(){
        //given
        String expected = "4, 3, 5, 1, 2";
        String seprator = ",";


        //when
        list.add(1);
        list.add(2);
        list.addToArrayStarting(3);
        list.addToArrayStarting(4);
        list.addToArrayIndex(5,2);

        String actual = list.outAllElementsThroughtSeparator(seprator);

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldAddFiveElementsAndSortFromMaxToMinAndCorrectOutToSpring(){
        //given
        String expected = "5, 4, 3, 2, 1";
        String seprator = ",";


        //when
        list.add(1);
        list.add(2);
        list.addToArrayStarting(3);
        list.addToArrayStarting(4);
        list.addToArrayIndex(5,2);
        list.insertionSortFromMaxToMin();

        String actual = list.outAllElementsThroughtSeparator(seprator);

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldAddFiveElementsAndSortFromMinToMaxAndCorrectOutToSpring(){
        //given
        String expected = "1, 2, 3, 4, 5";
        String seprator = ",";


        //when
        list.add(1);
        list.add(2);
        list.addToArrayStarting(3);
        list.addToArrayStarting(4);
        list.addToArrayIndex(5,2);
        list.insertionSortFromMinToMax();

        String actual = list.outAllElementsThroughtSeparator(seprator);

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldAddFiveElementsAndSortFromMaxToMinAndRemoveFromIndex2AndCorrectOutToSpring(){
        //given
        String expected = "4, 3, 2, 1";
        String seprator = ",";


        //when
        list.add(1);
        list.add(2);
        list.addToArrayStarting(3);
        list.addToArrayStarting(4);
        list.addToArrayIndex(5,2);
        list.removeFromArrayIndex(2);
        list.insertionSortFromMaxToMin();

        String actual = list.outAllElementsThroughtSeparator(seprator);

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }





}
