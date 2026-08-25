package kr.ac.kopo.kim.bookmarket2.repository;
import kr.ac.kopo.kim.bookmarket2.domain.Book;
import kr.ac.kopo.kim.bookmarket2.exception.BookIdException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository{
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        book1.setBookId("isbn1001");
        book1.setName("스프링 부트 완전정복");
        book1.setDescription("스프링 부트는 스프링을 기반으로 쉽고 빠르게 웹 애플리케이션을 개발할 수 있는 도구이다. 이 책에서는 스프링 부트의 기본 개념을 쉽게 이해하고 다양한 실습 예제로 빠르게 익힐 수 있다. 그리고 단계별 실습을 따라 하다 보면 도서 쇼핑몰 구축 프로젝트를 완성할 수 있다. 개념-실습-프로젝트의 3단계 학습으로 스프링 부트를 제대로 익힌다면 개발 시간을 단축하고 생산성을 높일 수 있는 개발자로 성장할 수 있다.");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT전문서");
        book1.setAuthor("송미영");
        book1.setUnitPrice(new BigDecimal(35000));
        book1.setReleaseDate("2024/12/31");
        book1.setFileName("스프링부트완전정복.png");

        Book book2 = new Book();
        book2.setBookId("isbn1002");
        book2.setName("차라투스트라는 이렇게 말했다");
        book2.setDescription("서양 철학사상 가장 독창적인 철학자의 가장 위대한 서사시\n" +
                "니체의 핵심 철학이 장쾌하고 시적인 언어로 집약된 대표작\n" +
                "\n" +
                "“그대들에게 말하거니와, 춤추는 별을 낳으려면\n" +
                "인간은 자신 속에 혼돈을 간직하고 있어야 한다.”\n" +
                "\n" +
                "모든 이를 위한, 그러나 그 누구의 것도 아닌 책\n" +
                "\n" +
                "니체의 『차라투스트라는 이렇게 말했다』가 민음사에서 출간되었다. “또?”라고 묻는 사람이 있다면, “얼마든지.”라고 답할 수밖에 없다. “왜?”라고 묻는다면, “그래야만 한다.”라고 대답할 테고, “그럴 만한가?”라는 물음에도 역시 “얼마든지.”라고 할 것이다. 이 책은 낡은 고전을 단순히 재생산해 낸 것이 아니다. 그렇다고 새로운 논쟁거리를 내세워 주목을 받으려는 전략이나 오래전부터 두꺼운 해석의 외투에 겹겹이 둘러싸인 작품의 아우라를 변질시키려는 그 어떤 의도도 없다. 다만 니체의 『차라투스트라는 이렇게 말했다』를 가장 원문에 가깝게, 충실하게 번역해 냄으로써, 니체에 관한 현란한 해석들로 어지럼증에 휩싸인 독자들에게 하나의 정본(正本)을 마련해 주고자 했을 뿐이다. ");
        book2.setPublisher("민음사");
        book2.setAuthor("프리드리히 니체");
        book2.setCategory("소설/시/희곡");
        book2.setUnitPrice(new BigDecimal(14400));
        book2.setReleaseDate("2004/01/02");
        book2.setFileName("차라투스트라는이렇게말했다.png");

        Book book3 = new Book();
        book3.setBookId("isbn1003");
        book3.setName("인생을 위한 최소한의 생각");
        book3.setDescription("생각이 사라진 생각 멸종의 시대, 다시 사유의 힘을 회복하다\n" +
                "\n" +
                "오늘날은 깊은 사유가 사라진 생각의 멸종 시대다. 우리는 스마트폰에서 접하는 짧은 영상과 여기서 받는 즉각적인 자극 속에 허우적거린다. 그 탓에 깊은 사유는 자취를 감추고, 현대인은 복잡한 맥락을 이해하지 못하는 ‘실질적 문맹’이 되어가고 있다. 인류 역사상 가장 풍요로운 시대임에도 불안과 공허가 끊이지 않는 이유가 바로 이런 현상 때문이다. 문해력이 떨어지고 생각하지 않으면서 삶을 해석하고 의미를 부여할 사유의 힘을 잃었기 때문이다.\n" +
                "\n" +
                "그래서 이 책은 시대를 초월해 검증된 거인들의 통찰을 빌려와 삶의 중심을 바로 세워줄 ‘최소한의 생각’을 제안한다. 화면을 내려놓고 스스로에게 근본적인 질문을 던지는 시간 속에서 우리는 멸종 위기에 처한 생각을 되살리고 삶의 중심을 되찾을 수 있다. 그리고 잃어버렸던 진정한 행복과 마주하게 될 것이다.");
        book3.setPublisher("상상스퀘어");
        book1.setAuthor("신영준, 고영성 ");
        book3.setCategory("철학");
        book3.setUnitPrice(new BigDecimal(17820));
        book3.setReleaseDate("2026/02/25");
        book3.setFileName("인생을위한최소한의생각.png");
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);

    }
    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }

    @Override
    public Book getBookById(String bookId) {
        Book book = null;
        for (Book searchBook: listOfBooks){
            if (searchBook != null && searchBook.getBookId() != null && searchBook.getBookId().equals(bookId)){
                book = searchBook;
                break;
            }
        }

//        if (book == null){
//            throw new IllegalArgumentException("도서ID가 " + bookId + "인 도서는 찾을 수가 없습니다.");
//        }
        if (book == null){
            throw new BookIdException(bookId);
        }

        return book;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<Book>();
        for (Book searchBook : listOfBooks){
            if (category.equalsIgnoreCase(searchBook.getCategory()))
                booksByCategory.add(searchBook);
        }

        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if (booksByFilter.contains("publisher")) {
            for (String publisherName : filter.get("publisher")) {
                for (Book searchBook : listOfBooks) {
                    if (publisherName.equalsIgnoreCase(searchBook.getPublisher()))
                        booksByPublisher.add(searchBook);
                }
            }
        }

        if (booksByFilter.contains("category")) {
            for (String category : filter.get("category")) {
                List<Book> list = getBookListByCategory(category);
                booksByCategory.addAll(list);
            }
        }

        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }

    @Override
    public void setNewBook(Book book) {
        listOfBooks.add(book);
    }
}