import spock.lang.Specification

import static org.junit.Assert.assertArrayEquals

/**
 * Created by java on 20.12.2016.
 */
class SorterTest extends Specification {


    def "BubbleSort test"() {
        int[] expected = []
        int[] actual = []

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }

    def "BubbleSort test1"() {
        int[] expected = [1]
        int[] actual = [1]

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }

    def "BubbleSort test2"() {
        int[] expected = [1]
        int[] actual = [1]

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }

    def "BubbleSort test3"() {
        int[] expected = [0, 2, 4]
        int[] actual = [4, 0, 2]

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }

    def "BubbleSort test4"() {
        int[] expected = [-2, 0, 4]
        int[] actual = [4, 0, -2]

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }

    def "BubbleSort test5"() {
        int[] expected = [0, 1, 3, 5, 6, 8]
        int[] actual = [8, 5, 3, 6, 1, 0]

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }

    def "BubbleSort test6"() {
        int[] expected = [0, 1, 3, 5, 6, 8]
        int[] actual = [0, 1, 3, 5, 6, 8]

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }

    def "BubbleSort test 2"() {
        int[] actual = [1, 3, 4, 6, 8, 9];
        int[] expected = [1, 3, 4, 6, 8, 9];

        when:
        Sorter.bubbleSort(actual)

        then:
        assertArrayEquals(expected, actual)
    }
}
