package com.example.form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class UserDto implements Validator {

    private int id;

    private String firstName;
    private String lastName;

    private String phoneNumber;
    private int age;
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
        if (userDto.getFirstName().equals("")) {
            errors.rejectValue("firstName", null, "Tên không được để trống");
        } else if (userDto.getFirstName().length() < 4 || userDto.getFirstName().length() > 45) {
            errors.rejectValue("firstName", null, "Tên phải có ít nhất 4-45 kí tự");
        }

        if (userDto.getLastName().equals("")) {
            errors.rejectValue("lastName", null, "Họ không được để trống");
        } else if (userDto.getLastName().length() < 4 || userDto.getLastName().length() > 45) {
            errors.rejectValue("lastName", null, "Họ phải có ít nhất 4-45 kí tự");
        }

        if (userDto.getPhoneNumber().equals("")) {
            errors.rejectValue("phoneNumber", null, "Số điện thoại không được để trống");
        } else if (userDto.getPhoneNumber().length() > 11 || userDto.getPhoneNumber().length() < 10) {
            errors.rejectValue("phoneNumber", null, "số điện thoại phải đầy đủ 11 số");
        } else if (!userDto.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", null, "kí tự nhập phải là số");
        }

        if (userDto.getAge() < 18) {
            errors.rejectValue("age", null, "tuổi phải lớn hơn hoặc bằng 18");
        }

        if (!userDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", null, "email phải đúng định dạng xxx@gmail.com");
        } else if (userDto.getEmail().equals("")){
            errors.rejectValue("phoneNumber", null, "Email không được để trống");

        }
    }
}
