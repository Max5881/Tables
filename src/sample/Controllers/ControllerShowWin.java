package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.ControllerTables.TableCourses;
import sample.ControllerTables.TableLessons;
import sample.ControllerTables.TableTeachers;
import sample.ControllerTables.TableUsers;
import sample.ControllerUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerShowWin {

    Connection conn;

    public ControllerShowWin(){
        conn = ControllerUtil.conDB();
    }

    ObservableList <TableCourses> listCourses = FXCollections.observableArrayList();
    ObservableList <TableLessons> listLessons = FXCollections.observableArrayList();
    ObservableList <TableTeachers> listTeachers = FXCollections.observableArrayList();
    ObservableList <TableUsers> listUsers = FXCollections.observableArrayList();


    @FXML
    private TableView<TableCourses> tableCourses;

    @FXML
    private TableColumn<TableCourses, String> coursesColumnId;
    @FXML
    private TableColumn<TableCourses, String> coursesColumnTitlle;
    @FXML
    private TableColumn<TableCourses, String> coursesColumnLength;
    @FXML
    private TableColumn<TableCourses, String> coursesColumnDescription;


    @FXML
    private TableView<TableLessons> tableLessons;

    @FXML
    private TableColumn<TableLessons, String> lessonsColumnId;
    @FXML
    private TableColumn<TableLessons, String> lessonsColumnTeacher;
    @FXML
    private TableColumn<TableLessons, String> lessonsColumnCourse;
    @FXML
    private TableColumn<TableLessons, String> lessonsColumnRoom;
    @FXML
    private TableColumn<TableLessons, String> lessonsColumnLessonDate;


    @FXML
    private TableView<TableTeachers> tableTeachers;

    @FXML
    private TableColumn<TableTeachers, String> teachersColumnId;
    @FXML
    private TableColumn<TableTeachers, String> teachersColumnName;
    @FXML
    private TableColumn<TableTeachers, String> teachersColumnAddress;
    @FXML
    private TableColumn<TableTeachers, String> teachersColumnPhone;



    @FXML
    private TableView<TableUsers> tableUsers;

    @FXML
    private TableColumn<TableUsers, String> usersColumnId;
    @FXML
    private TableColumn<TableUsers, String> usersColumnFirstName;
    @FXML
    private TableColumn<TableUsers, String> usersColumnLastName;
    @FXML
    private TableColumn<TableUsers, String> usersColumnEmail;
    @FXML
    private TableColumn<TableUsers, String> usersColumnLogin;
    @FXML
    private TableColumn<TableUsers, String> usersColumnPassword;


    @FXML
    public void initialize() throws SQLException {
        try {
            String coursesSQL = "SELECT * FROM courses";
            PreparedStatement coursesStatement = conn.prepareStatement(coursesSQL);
            ResultSet resultCourses = coursesStatement.executeQuery();
            while (resultCourses.next()){
                listCourses.add(new TableCourses(
                        resultCourses.getString(1),
                        resultCourses.getString(2),
                        resultCourses.getString(3),
                        resultCourses.getString(4)));

            }
            coursesColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            coursesColumnTitlle.setCellValueFactory(new PropertyValueFactory<>("title"));
            coursesColumnLength.setCellValueFactory(new PropertyValueFactory<>("length"));
            coursesColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

            tableCourses.setItems(listCourses);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


        try {
            String lessonsSQL = "SELECT * FROM lessons";
            PreparedStatement lessonsStatement = conn.prepareStatement(lessonsSQL);
            ResultSet resultLessons = lessonsStatement.executeQuery();
            while (resultLessons.next()) {
                listLessons.add(new TableLessons(
                        resultLessons.getString(1),
                        resultLessons.getString(2),
                        resultLessons.getString(3),
                        resultLessons.getString(4),
                        resultLessons.getString(5)));
            }
            lessonsColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            lessonsColumnTeacher.setCellValueFactory(new PropertyValueFactory<>("teacher"));
            lessonsColumnCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
            lessonsColumnRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
            lessonsColumnLessonDate.setCellValueFactory(new PropertyValueFactory<>("lesson_date"));

            tableLessons.setItems(listLessons);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }



        try {
            String teachersSQL = "SELECT * FROM teachers";
            PreparedStatement teachersStatement = conn.prepareStatement(teachersSQL);
            ResultSet resultTeachers = teachersStatement.executeQuery();
            while (resultTeachers.next()) {
                listTeachers.add(new TableTeachers(
                        resultTeachers.getString(1),
                        resultTeachers.getString(2),
                        resultTeachers.getString(3),
                        resultTeachers.getString(4)));
            }
            teachersColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            teachersColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            teachersColumnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            teachersColumnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

            tableTeachers.setItems(listTeachers);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        try {
            String usersSQL = "SELECT * FROM users";
            PreparedStatement usersStatement = conn.prepareStatement(usersSQL);
            ResultSet resultUsers = usersStatement.executeQuery();
            while (resultUsers.next()) {
                listUsers.add(new TableUsers(
                        resultUsers.getString(1),
                        resultUsers.getString(2),
                        resultUsers.getString(3),
                        resultUsers.getString(4),
                        resultUsers.getString(5),
                        resultUsers.getString(6)));
            }
            usersColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            usersColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            usersColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            usersColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            usersColumnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            usersColumnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

            tableUsers.setItems(listUsers);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
}
