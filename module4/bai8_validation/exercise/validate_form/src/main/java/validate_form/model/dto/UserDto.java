package validate_form.model.dto;


import javax.validation.constraints.*;

public class UserDto {
    private Integer id;
    @Size(min = 5,max = 45,message = "họ phải trên 5 kí tự")
    private String firstName;
    @Size(min = 5,max = 45,message = "họ phải trên 5 kí tự")
    private String lastName;
    @Pattern(regexp = "^\\d{10}$",message = "số điện thoại phải 10 số")
    private String phoneNumber;
    @Min(value = 18,message = "tuổi phải trên 18")
    private int age;
    @Email(message = "email không hợp lệ")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
