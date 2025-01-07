package com.bugrahan.cruddemo;

import com.bugrahan.cruddemo.dao.StudentDAO;
import com.bugrahan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);


		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// TÜM SINIFI SİLER

		System.out.println("SINIFTAKİ TÜM ÖĞRENCİLER SİLİNİYOR");
		int numRowsDeleted =studentDAO.deleteAll();
		System.out.println("DELETED ROW COUNT = "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// BURADA İD GİRİLEN ÖĞRENCİ SİLİNMEKTEDİR
		int studentİD = 3 ;
		System.out.println("SİLİNECEK ÖĞRENCİNİN İD Sİ = "+ studentİD);
		studentDAO.delete(studentİD);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// RETRİEVE STUDENT BASED ON THE İD : PRİMARY KEY
		int studentId=1;
		System.out.println("ÖĞRENCİNİN İD Sİ : "+studentId);
		Student theStudent = studentDAO.findById(studentId);

		// CHANCE FİRST NAME "UNİCORN"
		System.out.println("ÖĞRENCİ GÜNCELLENİYOR");
		theStudent.setFirstName("BUĞRAHAN");;
		// UPDATE THE STUDENT
		studentDAO.update(theStudent);

		// DİSPLAY THE UPDETE STUDENT
		System.out.println("ÖĞRENCİ GÜNCELLENDİ : "+ theStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// BU FONKSİYON SOYADI DUCK OLANI DİSPLAY EDER
		// GET A LİST OF STUDENTS
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		//DİSPLAY LİST OF STUDENTS
		for(int i = 0 ; i<theStudents.size() ; i++){
			System.out.println(theStudents.get(i));
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// BU METOD BİZİM DATABASE DEKİ VERİLEİRİN TAMAMINI DİSPLAY ETMEMİZİ SAĞLAR

		//GET A LİST FOR STUDENTS
		List<Student> tempStudents =studentDAO.findAll();

		// DİSPLAY LİST OF STUDENT
		//System.out.println("ÖĞRENCİLERİN LİSTESİ"+tempStudents); TO STRİNG METODUMUZ OLDUĞU İÇİN DOĞRU BİR ŞEKİLDE ÇALIŞTI
		for(int i = 0 ; i<tempStudents.size(); i++){
			System.out.println(tempStudents.get(i));
		}


	}

	private void readStudent(StudentDAO studentDAO) {

		// BU METOD HEM KAYIT HEM DİSPLAY EDER

		//CREAT NEW STUDENT OBJECT
		System.out.println("CREATİNG NEW STUDENT OBJECT");
		Student student1 = new Student("KADİR","BATMACA","kadirbatmaca@gmail.com");

		// SAVE THE NEW STUDENT
		studentDAO.save(student1);

		// DİSPLAY İD OF THE SAVED STUDENT
		System.out.println("YENİ KAYDEDİLEN İLK ÖĞRNECİNİN İD : "+student1.getId());

		// RETRİEVE STUDENT BASED ON THE İD : PRİMARY KEY "ENTİTY.FİND(NAME_CLASS,PRİMARY_KEY"
		System.out.println("RETRİEVİNG STUDENT ONES WİTH İD : "+student1.getId());
		studentDAO.findById(student1.getId());

		//DİSPLAY STUDENT
		System.out.println("FOUND THE BİRİNCİ STUDENT : "+student1);


	}

	private void createStudent(StudentDAO studentDAO) {

		// CREAT THE STUDENT OBJECKT
		System.out.println("YENİ BİR ÖĞRECİ OBJESİ OLŞTURULUYOR");
		Student tempStudent = new Student("BUĞRAHAN","ERTAŞ","bugrahanert@gmail.com");
		Student tempStudent1 = new Student("AYŞENUR ","ERTAŞ","ayşenurert@gmail.com");
		Student tempstudent2= new Student("AYHAN","İNCEKARA","ayhanmath@gmail.com");
		Student tempstudent3 = new Student ("ÇİĞDEM","ERTAŞ","mamosteccigdem@gmail.com");


		// SAVE THE STUDENT OBJECT
		System.out.println("ÖĞRENCİ KAYDEDİLİYOR...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);


		//DİSPLAY İD OD THE SAVED STUDENT
		System.out.println("ÖĞRENCİ KAYDEDİLDİ. GENERATED İD :"+tempStudent.getId()); // ALT TARAFA DİĞER ÖĞRENCİLER İÇİNDE YAZILABİLİR


	}
}
