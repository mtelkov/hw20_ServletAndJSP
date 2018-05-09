import org.junit.Test;
import ru.innopolis.stc9.pojo.Lesson;
import ru.innopolis.stc9.service.LessonService;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LessonServiceTest {

    @Test
    public void getAllLessonsTest(){
        ArrayList<Lesson> arrayList = new LessonService().getAllLessons();
        assertTrue("error date",arrayList.size() > 0);
    }

}
