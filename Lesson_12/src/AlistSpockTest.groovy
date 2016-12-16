/**
 * Created by java on 16.12.2016.
 */
class AlistSpockTest extends spock.lang.Specification {



    def "check is add element correct"() {
        given: "initialize Alist"
        Alist list = new Alist();

        when: "Try to add one element"
        list.add(num);

        then: "check list size"
        list.size() == 0;

        where:
        num << [0, 5, 7, 256]
    }
}
