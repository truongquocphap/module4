package furama_resort.model.dto;

import furama_resort.model.entity.RentType;
import furama_resort.model.entity.ServiceType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
public class ServiceDto {
    private Integer serviceId;
    @NotBlank(message = "Trường không được để trống")
    private String serviceName;
    @NotNull(message = "Không được để trống")
    @Min(value = 1,message = "Area Phải lớn hơn 0")
    private int serviceArea;
    @NotNull(message="Không được để trống")
    @Min(value=1,message="Lớn hơn 1")
    private Double serviceCost;
    @NotNull(message="Không được để trống")
    @Min(value=1,message="Lớn hơn 1")
    private int maxPeople;
    @NotBlank(message = "Trường không được để trống")
    private String standardRoom;
    @NotBlank(message = "Trường không được để trống")
    private String description;
    @NotNull(message="Không được để trống")
    @Min(value=1,message="Lớn hơn 1")
    private Double poolArea;
    @NotNull(message="Không được để trống")
    @Min(value=1,message="Lớn hơn 1")
    private int numberFloors;
    @Pattern(regexp = "^(DV-)[0-9]{4}$",message = "Nhập phải đúng định dạng: DV-XXXX")
    private String serviceCode;
    private int deleteFlag;
    private ServiceType serviceType;
    private RentType rentType;
    private List<ContractDto> contractList;

    public ServiceDto() {
    }

    public ServiceDto(String serviceName, int serviceArea, Double serviceCost, int maxPeople, String standardRoom,
                      String description, Double poolArea, int numberFloors, String serviceCode, ServiceType serviceType, RentType rentType) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.serviceCode = serviceCode;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public ServiceDto(String serviceName, int serviceArea, Double serviceCost, int maxPeople, String standardRoom, String description, Double poolArea,
                      int numberFloors, String serviceCode, int deleteFlag, ServiceType serviceType, RentType rentType) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.serviceCode = serviceCode;
        this.deleteFlag = deleteFlag;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

}
