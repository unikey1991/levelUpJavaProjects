import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by java on 13.12.2016.
 */
public class AlistTest {

    Alist list;

    @Before
    public void setUp(){
        list = new Alist();
    }

    @Test
    public void shouldAddElementAndReturnSizeOne() throws Exception {
        //given
        int expected = 1;

        //when
        list.add(5);
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);

    }

    @Test
    public void shouldCheckThatListEmpty() throws Exception {
        //given
        int expected = 0;

        //when
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);

    }

    @Test
    public void shouldAddElementsAndReturnTwo() throws Exception {
        //given
        int expected = 2;

        //when
        list.add(5);
        list.add(5);
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);

    }

    @Test
    public void shouldAddMoreElementsThanInitialSizeWithoutTroubles() throws Exception {
        //given
        int expected = 11;

        //when
        for (int i = 0; i < 11; i++){
            list.add(i+1);
        }
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);

    }

    @Test
    public void shouldReturnLastAddedElement(){
        //given
        int expected = 11;


        //when
        for (int i = 0; i < 11; i++){
            list.add(i+1);
        }
        int lastAddedIndex = list.size() - 1;
        int actual = list.get(lastAddedIndex);

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldTryToGetNotExistingElementAndThrowException(){
        //when
        list.get(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldTryToGetZeroElementAndThrowException(){
        //when
        list.get(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldTryToGetElevenElementAndThrowException(){
        //when
        list.get(11);
    }



    @Test
    public void shouldRemoveElementFromEmptyList() throws Exception {
        //given
        int expected = 0;

        //when
        list.remove();
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);

    }


    @Test
    public void shouldRemoveFirstElementFromListAndReturnZero() throws Exception {
        //given
        int expected = 0;

        //when
        list.add(1);
        list.remove();
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldRemoveSecondElementFromListAndReturnOne() throws Exception {
        //given
        int expected = 1;

        //when
        list.add(1);
        list.add(2);
        list.remove();
        int actual = list.size();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldIncreaseArrayLength() throws Exception {
        //given
        int expected = (int)(12);

        //when
        for (int i = 0; i < 9; i++){
            list.add(i+1);
        }
        list.remove();
        int actual = list.getArrayLength();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldDecreaseArrayLength() throws Exception {
        //given
        int expected = (10);

        //when
        for (int i = 0; i < 9; i++){
            list.add(i+1);
        }
        list.remove();
        list.remove();
        int actual = list.getArrayLength();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }

    @Test
    public void shouldDecreaseArrayLengthToTen() throws Exception {
        //given
        int expected = (10);

        //when
        for (int i = 0; i < 9; i++){
            list.add(i+1);
        }
        list.remove();
        list.remove();
        list.remove();
        list.remove();
        list.remove();
        list.remove();
        list.remove();
        int actual = list.getArrayLength();

        //then
        assertEquals("ERROR!!!111 ACHTUNG PADLO!!!!1", expected, actual);
    }
}