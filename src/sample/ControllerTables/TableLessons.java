package sample.ControllerTables;

public class TableLessons {

    private String id;
    private String teacher;
    private String course;
    private String room;
    private String lessonDate;

    public TableLessons(String id,String teacher, String course, String room, String lessonDate){
        this.id = id;
        this.teacher = teacher;
        this.course = course;
        this.room = room;
        this.lessonDate = lessonDate;
    }

    public String getId() {
        return id;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getCourse() {
        return course;
    }

    public String getRoom() {
        return room;
    }

    public String getLessonDate() {
        return lessonDate;
    }
}
