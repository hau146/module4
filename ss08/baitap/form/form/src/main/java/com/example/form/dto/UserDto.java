package com.example.form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserDto implements Validator {

    private int id;
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên phải có ít nhất 4-45 kí tự")
    private String firstName;
    @NotBlank(message = "Họ không được để trống")
    @Size(min = 5, max = 45, message = "Họ phải có ít nhất 4-45 kí tự")
    private String lastName;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 11, message = "số điện thoại phải đầy đủ 11 số")
    @Pattern(regexp = "^0[0-9]{9}$", message = "kí tự nhập phải là số")
    private String phoneNumber;
    private int age;
    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "email phải đúng định dạng xxx@gmail.com")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.getAge() < 18) {
            errors.rejectValue("age", null, "tuổi phải lớn hơn hoặc bằng 18");
        } else if (String.valueOf(userDto.getAge()) == ""){
            errors.rejectValue("age", null, "Tuổi không được để trống");
        }

    }
}
