import org.junit.Before;
import org.junit.Test;
import ru.innopolis.stc9.pojo.Lesson;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class LessonTest {

    private Lesson lesson;
    private Date testDate;

    @Before
    public void before(){
        testDate = Calendar.getInstance().getTime();
        lesson = new Lesson(1,2,3,4, testDate);
    }

    @Test
    public void testGetters(){
        assertTrue("error id",lesson.getLsn_id() == 1);
        assertTrue("error subj_id",lesson.getSubj_id() == 2);
        assertTrue("error tutor_id",lesson.getTutor_id() == 3);
        assertTrue("error adm_id",lesson.getAdm_id() == 4);
        assertTrue("error date",lesson.getLsn_date().equals(testDate));
    }

}
