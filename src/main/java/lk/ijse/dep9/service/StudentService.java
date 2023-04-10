package lk.ijse.dep9.service;

import lk.ijse.dep9.dto.StudentDTO;
import lk.ijse.dep9.entity.Student;
import lk.ijse.dep9.repo.StudentRepo;
import lk.ijse.dep9.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveStudent(StudentDTO studentDTO){
        if (studentRepo.existsById(studentDTO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateStudent(StudentDTO studentDTO){
        if (studentRepo.existsById(studentDTO.getId())){
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<StudentDTO> getAllStudent(){
        List<Student> studentList = studentRepo.findAll();
        return modelMapper.map(studentList,new TypeToken<ArrayList<StudentDTO>>(){
        }.getType());
    }
}
