import com.test.dto.BookDto;
import com.test.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class testMapper {

//    @Autowired
//    ModelMapper modelMapper;

    @Test
    public void 모델_매퍼_테스트 () {
        ModelMapper modelMapper = new ModelMapper();
        Book book = new Book();

        book.setTitle("타이틀");

        BookDto bookDto = modelMapper.map(book, BookDto.class);

        Assertions.assertThat(bookDto.getTitle()).isEqualTo("타이틀");
    }

}
